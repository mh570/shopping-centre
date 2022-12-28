package com.fengling.shopping.product.service.impl;

import com.fengling.shopping.product.service.CategoryBrandRelationService;
import org.springframework.beans.factory.annotation.Autowired;
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


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Autowired
    private CategoryBrandRelationService categoryBrandRelationService;
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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateCascade(CategoryEntity category) {
        this.updateById(category);
        categoryBrandRelationService.updateCategory(category.getCatId(),category.getName());

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
        List<CategoryEntity> childrenCollect = all.stream().filter(categoryEntity -> categoryEntity.getParentCid() == root.getCatId())
                .peek(categoryEntity -> categoryEntity.setChildren(getChildren(categoryEntity, all)))
                .sorted(Comparator.comparingInt(a -> (a.getSort() == null ? 0 : a.getSort())))
                .collect(Collectors.toList());
        return childrenCollect;
    }

}