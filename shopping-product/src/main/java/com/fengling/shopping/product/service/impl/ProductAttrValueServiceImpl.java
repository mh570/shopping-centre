package com.fengling.shopping.product.service.impl;

import com.fengling.shopping.product.dao.AttrDao;
import com.fengling.shopping.product.entity.AttrEntity;
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

import com.fengling.shopping.product.dao.ProductAttrValueDao;
import com.fengling.shopping.product.entity.ProductAttrValueEntity;
import com.fengling.shopping.product.service.ProductAttrValueService;
import org.springframework.transaction.annotation.Transactional;


@Service("productAttrValueService")
public class ProductAttrValueServiceImpl extends ServiceImpl<ProductAttrValueDao, ProductAttrValueEntity> implements ProductAttrValueService {

   
    @Autowired
    AttrDao attrDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ProductAttrValueEntity> page = this.page(
                new Query<ProductAttrValueEntity>().getPage(params),
                new QueryWrapper<ProductAttrValueEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void saveProductAttr(List<ProductAttrValueEntity> collect) {
        this.saveBatch(collect);
    }

    @Override
    public List<ProductAttrValueEntity> baseAttrList(Long spuId) {
        List<ProductAttrValueEntity> selectList = this.baseMapper.selectList(new QueryWrapper<ProductAttrValueEntity>().eq("spu_id", spuId));
        if (selectList != null && selectList.size() > 0) {
            selectList = selectList.stream().map(item -> {
//                ProductAttrValueEntity valueEntity = this.baseMapper.selectById(item.getAttrId());
                Long attrId = item.getAttrId();
                AttrEntity attrEntity = attrDao.selectById(attrId);
                item.setValueType(attrEntity.getValueType());
                return item;
            }).collect(Collectors.toList());
        }
        return selectList;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateAttrList(Long spuId, List<ProductAttrValueEntity> entityList) {
        this.baseMapper.delete(new QueryWrapper<ProductAttrValueEntity>().eq("spu_id", spuId));
        List<ProductAttrValueEntity> collect = entityList.stream().map(item -> {
            item.setSpuId(spuId);
            return item;
        }).collect(Collectors.toList());
        this.saveBatch(collect);
    }

}