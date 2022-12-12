package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.CesShopTypeDao;
import com.fengling.shopping.ware.entity.CesShopTypeEntity;
import com.fengling.shopping.ware.service.CesShopTypeService;


@Service("cesShopTypeService")
public class CesShopTypeServiceImpl extends ServiceImpl<CesShopTypeDao, CesShopTypeEntity> implements CesShopTypeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CesShopTypeEntity> page = this.page(
                new Query<CesShopTypeEntity>().getPage(params),
                new QueryWrapper<CesShopTypeEntity>()
        );

        return new PageUtils(page);
    }

}