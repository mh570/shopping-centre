package com.fengling.shopping.product.service.impl;

import com.fengling.common.constant.ProductConstant;
import com.fengling.shopping.product.dao.AttrAttrgroupRelationDao;
import com.fengling.shopping.product.dao.AttrGroupDao;
import com.fengling.shopping.product.dao.CategoryDao;
import com.fengling.shopping.product.entity.AttrAttrgroupRelationEntity;
import com.fengling.shopping.product.entity.AttrGroupEntity;
import com.fengling.shopping.product.entity.CategoryEntity;
import com.fengling.shopping.product.service.CategoryService;
import com.fengling.shopping.product.vo.AttrRespVo;
import com.fengling.shopping.product.vo.AttrVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.product.dao.AttrDao;
import com.fengling.shopping.product.entity.AttrEntity;
import com.fengling.shopping.product.service.AttrService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;


@Service("attrService")
public class AttrServiceImpl extends ServiceImpl<AttrDao, AttrEntity> implements AttrService {

    @Autowired
    private AttrAttrgroupRelationDao attrAttrgroupRelationDao;
    @Autowired
    private AttrGroupDao attrGroupDao;
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private CategoryService categoryService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttrEntity> page = this.page(
                new Query<AttrEntity>().getPage(params),
                new QueryWrapper<AttrEntity>()
        );

        return new PageUtils(page);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveAttr(AttrVo attr) {
        AttrEntity attrEntity = new AttrEntity();

        BeanUtils.copyProperties(attr, attrEntity);
        this.save(attrEntity);
        if (attr.getAttrType() == ProductConstant.AttrEnum.ATTR_TYPE_BASE.getCode()) {
            AttrAttrgroupRelationEntity relationEntity = new AttrAttrgroupRelationEntity();
            relationEntity.setAttrGroupId(attr.getAttrGroupId());
            relationEntity.setAttrId(attrEntity.getAttrId());
            attrAttrgroupRelationDao.insert(relationEntity);
        }

    }

    //desc sort
    @Override
    public PageUtils queryBaseAttrList(Long catelogId, Map<String, Object> params, String attrType) {
        QueryWrapper<AttrEntity> queryWrapper = new QueryWrapper<AttrEntity>().eq("attr_type", "base".equalsIgnoreCase(attrType) ? ProductConstant.AttrEnum.ATTR_TYPE_BASE.getCode() : ProductConstant.AttrEnum.ATTR_TYPE_SALE.getCode());
        String key = (String) params.get("key");

//        个人建议》0
        if (catelogId != 0) {
            queryWrapper.eq("catelog_id", catelogId);
        }
        if (StringUtils.hasText(key)) {
            queryWrapper.and((wrapper -> {
                wrapper.eq("attr_id", key).or().like("attr_name", key);
            }));
        }
        IPage<AttrEntity> page = this.page(
                new Query<AttrEntity>().getPage(params),
                queryWrapper
        );


        List<AttrEntity> records = page.getRecords();

        List<AttrRespVo> collect = records.stream().map(record -> {
            AttrRespVo attrRespVo = new AttrRespVo();
            BeanUtils.copyProperties(record, attrRespVo);
            if ("base".equalsIgnoreCase(attrType)) {
                AttrAttrgroupRelationEntity attrAttrgroupRelationEntity = attrAttrgroupRelationDao.selectOne(new QueryWrapper<AttrAttrgroupRelationEntity>().eq("attr_id", record.getAttrId()));
                if (attrAttrgroupRelationEntity != null && attrAttrgroupRelationEntity.getAttrGroupId() != null) {
                    AttrGroupEntity attrGroupEntity = attrGroupDao.selectById(attrAttrgroupRelationEntity.getAttrGroupId());
                    attrRespVo.setGroupName(attrGroupEntity.getAttrGroupName());
//防止空指针
                    if (attrGroupEntity == null) {
                        attrRespVo.setGroupName("防止空指针");
                        AttrGroupEntity attrGroup = new AttrGroupEntity();
                        attrGroup.setAttrGroupId(attrAttrgroupRelationEntity.getAttrGroupId());
                        attrGroup.setAttrGroupName(attrRespVo.getGroupName());
                        attrGroupDao.insert(attrGroup);
                    } else {
                        attrRespVo.setGroupName(attrGroupEntity.getAttrGroupName());
                    }
                }
            }


            CategoryEntity categoryEntity = categoryDao.selectById(record.getCatelogId());
            if (categoryEntity != null) {
                attrRespVo.setCatelogName(categoryEntity.getName());
            }
            return attrRespVo;
        }).collect(Collectors.toList());

        PageUtils pageUtils = new PageUtils(page);
        pageUtils.setList(collect);
        return pageUtils;
    }

    @Override
    public AttrRespVo getAttrInfo(Long attrId) {
        AttrEntity attrEntity = this.baseMapper.selectById(attrId);
        AttrRespVo attrRespVo = new AttrRespVo();
        BeanUtils.copyProperties(attrEntity, attrRespVo);

        if (attrEntity.getAttrType() == ProductConstant.AttrEnum.ATTR_TYPE_BASE.getCode()) {
            AttrAttrgroupRelationEntity relationEntity = attrAttrgroupRelationDao.selectOne(new QueryWrapper<AttrAttrgroupRelationEntity>().eq("attr_id", attrId));
            if (relationEntity != null && relationEntity.getAttrGroupId() != null) {
                attrRespVo.setAttrGroupId(relationEntity.getAttrGroupId());
                AttrGroupEntity attrGroupEntity = attrGroupDao.selectById(relationEntity.getAttrGroupId());
                if (attrGroupEntity != null && attrGroupEntity.getAttrGroupName() != null) {
                    attrRespVo.setGroupName(attrGroupEntity.getAttrGroupName());
                }
            }
        }
        Long catelogId = attrEntity.getCatelogId();
        Long[] categoryPath = categoryService.findCategoryPath(catelogId);
        attrRespVo.setCatelogPath(categoryPath);
        CategoryEntity categoryEntity = categoryDao.selectById(catelogId);
        if (categoryEntity != null && categoryEntity.getName() != null) {
            attrRespVo.setCatelogName(categoryEntity.getName());
        }
        return attrRespVo;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateAttrById(AttrVo attr) {
        AttrEntity attrEntity = new AttrEntity();
        BeanUtils.copyProperties(attr, attrEntity);
        this.baseMapper.updateById(attrEntity);
        if (attrEntity.getAttrType() == ProductConstant.AttrEnum.ATTR_TYPE_BASE.getCode()) {

            AttrAttrgroupRelationEntity attrgroupRelationEntity = new AttrAttrgroupRelationEntity();
            attrgroupRelationEntity.setAttrGroupId(attr.getAttrGroupId());
            attrgroupRelationEntity.setAttrId(attr.getAttrId());
            Integer integer = attrAttrgroupRelationDao.selectCount(new QueryWrapper<AttrAttrgroupRelationEntity>().eq("attr_id", attr.getAttrId()));
            if (integer > 0) {
                attrAttrgroupRelationDao.update(attrgroupRelationEntity, new QueryWrapper<AttrAttrgroupRelationEntity>().eq("attr_id", attr.getAttrId()));
            } else {
                attrAttrgroupRelationDao.insert(attrgroupRelationEntity);
            }
        }
    }
}