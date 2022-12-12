package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.CesOrderGoodsDao;
import com.fengling.shopping.ware.entity.CesOrderGoodsEntity;
import com.fengling.shopping.ware.service.CesOrderGoodsService;


@Service("cesOrderGoodsService")
public class CesOrderGoodsServiceImpl extends ServiceImpl<CesOrderGoodsDao, CesOrderGoodsEntity> implements CesOrderGoodsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CesOrderGoodsEntity> page = this.page(
                new Query<CesOrderGoodsEntity>().getPage(params),
                new QueryWrapper<CesOrderGoodsEntity>()
        );

        return new PageUtils(page);
    }

}