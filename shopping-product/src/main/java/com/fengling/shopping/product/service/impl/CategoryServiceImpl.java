package com.fengling.shopping.product.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.fengling.shopping.product.service.CategoryBrandRelationService;
import com.fengling.shopping.product.vo.CateLog2Vo;
import lombok.Synchronized;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.product.dao.CategoryDao;
import com.fengling.shopping.product.entity.CategoryEntity;
import com.fengling.shopping.product.service.CategoryService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Autowired
    private CategoryBrandRelationService categoryBrandRelationService;
    @Resource
    private StringRedisTemplate redisDao;
    @Autowired
    private RedissonClient redisson;


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    /**、
     * 注意map和peek，sorted的非空
     * 小bug注意==和equals
     * 警告:(66, 116) 使用 '==' 而不是 ''equals()'' 来比较数字对象
     * 经典回调思想
     * @return 所以1级/子级内容
     */
    @Override
    public List<CategoryEntity> listWithTree() {
        List<CategoryEntity> categoryEntities = baseMapper.selectList(null);

        //1级
        List<CategoryEntity> oneCollect = categoryEntities.stream()
                .filter(categoryEntitie -> categoryEntitie.getParentCid() == 0)
                .peek(a -> a.setChildren(getChildren(a, categoryEntities)))
//                .map(a -> {
//                    a.setChildren(getChildren(a, categoryEntities));
//                    return a;
//                })
//                .sorted((a1, a2) -> (a1.getSort() == null ? 0 : a1.getSort()) - (a2.getSort() == null ? 0 : a2.getSort()))
                .sorted(Comparator.comparingInt(a -> (a.getSort() == null ? 0 : a.getSort())))
                .collect(Collectors.toList());

        return oneCollect;
    }

    @Override
    public void removeMenuByIds(List<Long> asList) {

        baseMapper.deleteBatchIds(asList);
    }

    @Override
    public Long[] findCategoryPath(Long catelogId) {
        List<Long> paths = new ArrayList<>();
        List<Long> path = findParentPath(catelogId, paths);
        Collections.reverse(path);
        return path.toArray(new Long[path.size()]);
    }

    @Caching(evict = {
            @CacheEvict(value = "category",key = "'getLevel1Category'"),
            @CacheEvict(value = "category",key = "'catalogJSON'")
    })
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateCascade(CategoryEntity category) {
        this.updateById(category);
        categoryBrandRelationService.updateCategory(category.getCatId(), category.getName());

    }
//sync = true本地锁，不是分布式锁
    @Cacheable(value = {"category"},key = "'getLevel1Category'",sync = true)
    @Override
    public List<CategoryEntity> getLevel1Category() {
        System.out.println("测试");
        List<CategoryEntity> categoryEntityList = this.baseMapper.selectList(new QueryWrapper<CategoryEntity>().eq("parent_cid", 0));
        return categoryEntityList;
    }
//    TODO 没有处理雪崩，穿透处理
//    if 1级判断
    @Override
    public Map<String, List<CateLog2Vo>> getCatalogJson() {
        String catalogJSON = redisDao.opsForValue().get("catalogJSON");
        if (!StringUtils.hasText(catalogJSON) || catalogJSON.equals("null")) {
            Map<String, List<CateLog2Vo>> catalogJsonDB = getCatalogJsonDB();
            String s = JSON.toJSONString(catalogJsonDB);
            redisDao.opsForValue().set("catalogJSON", s);
            return catalogJsonDB;
        }
        Map<String, List<CateLog2Vo>> stringListMap = JSON.parseObject(catalogJSON, new TypeReference<Map<String, List<CateLog2Vo>>>() {
        });
        return stringListMap;
    }

    //          +锁{},等待
    public Map<String, List<CateLog2Vo>> getCatalogJsonDB() {
        RLock lock = redisson.getLock("catalogJson-lock");
        lock.lock();
        Map<String, List<CateLog2Vo>> database;
        try {
            database = getDatabaseFromListMapDb();
        } finally {
            lock.unlock();
        }
        return database;
    }
// if2级判断
    private Map<String, List<CateLog2Vo>> getDatabaseFromListMapDb() {
        String catalogJSON = redisDao.opsForValue().get("catalogJSON");
        if (StringUtils.hasText(catalogJSON)) {
            Map<String, List<CateLog2Vo>> stringList = JSON.parseObject(catalogJSON, new TypeReference<Map<String, List<CateLog2Vo>>>() {
            });
            return stringList;
        }
        List<CategoryEntity> categoryEntities = this.baseMapper.selectList(null);
        //所有1级 parent_cid =0 cat_id = add   cat_level = 深度，默认1表示1级
        List<CategoryEntity> level1Category = getParent_cid(categoryEntities, 0L);
        //                                  parent_cid=1级的id
        //map k->1级id，v->2级vo对象     {所有1级的id找所有2级}if封装vo对象(1级的id,3级list，2级的id，2级名字)
        Map<String, List<CateLog2Vo>> parent_cid = level1Category.stream().collect(Collectors.toMap(k -> k.getCatId().toString(), v -> {
            List<CategoryEntity> categoryEntityList = getParent_cid(categoryEntities, v.getCatId());
            List<CateLog2Vo> collect = null;
            if (categoryEntityList != null) {
                collect = categoryEntityList.stream().map(l2 -> {
                    CateLog2Vo cateLog2Vo = new CateLog2Vo(v.getCatId().toString(), null, l2.getCatId().toString(), l2.getName());
                    List<CategoryEntity> selectList = getParent_cid(categoryEntities, l2.getCatId());
                    if (selectList != null) {
                        List<CateLog2Vo.CateLog3Vo> collect1 = selectList.stream().map(l3 -> {
                            CateLog2Vo.CateLog3Vo cateLog3Vo = new CateLog2Vo.CateLog3Vo(l2.getCatId().toString(), l3.getCatId().toString(), l3.getName());
                            return cateLog3Vo;
                        }).collect(Collectors.toList());
                        cateLog2Vo.setCatalog3List(collect1);
                    }
                    return cateLog2Vo;
                }).collect(Collectors.toList());
            }
            return collect;
        }));
//        String s = JSON.toJSONString(parent_cid);
//        redisDao.opsForValue().set("catalogJSON", s);
        return parent_cid;
    }

    private List<CategoryEntity> getParent_cid(List<CategoryEntity> categoryEntities, Long getCatId) {
//        return this.baseMapper.selectList(new QueryWrapper<CategoryEntity>().eq("parent_cid", v.getCatId()));
        List<CategoryEntity> collect = categoryEntities.stream().filter(item -> item.getParentCid() == getCatId).collect(Collectors.toList());
        return collect;
    }


    private List<Long> findParentPath(Long catelogId, List<Long> paths) {
        paths.add(catelogId);
        CategoryEntity categoryEntity = baseMapper.selectById(catelogId);
        if (categoryEntity.getParentCid() != 0) {
            findParentPath(categoryEntity.getParentCid(), paths);
        }
        return paths;
    }

    /**
     * 回调getChildren
     *
     * @param root 1级分类
     * @param all  全部数据
     * @return childrenCollect子类
     */
    private List<CategoryEntity> getChildren(CategoryEntity root, List<CategoryEntity> all) {
        List<CategoryEntity> childrenCollect = all.stream()
                .filter(categoryEntity -> categoryEntity.getParentCid() == root.getCatId())
                .peek(categoryEntity -> categoryEntity.setChildren(getChildren(categoryEntity, all)))
                .sorted(Comparator.comparingInt(a -> (a.getSort() == null ? 0 : a.getSort())))
                .collect(Collectors.toList());
        return childrenCollect;
    }

}