package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.CesShopGoodsDao;
import com.fengling.shopping.ware.entity.CesShopGoodsEntity;
import com.fengling.shopping.ware.service.CesShopGoodsService;


@Service("cesShopGoodsService")
public class CesShopGoodsServiceImpl extends ServiceImpl<CesShopGoodsDao, CesShopGoodsEntity> implements CesShopGoodsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CesShopGoodsEntity> page = this.page(
                new Query<CesShopGoodsEntity>().getPage(params),
                new QueryWrapper<CesShopGoodsEntity>()
        );

        return new PageUtils(page);
    }

}