package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.CesOrderMainDao;
import com.fengling.shopping.ware.entity.CesOrderMainEntity;
import com.fengling.shopping.ware.service.CesOrderMainService;


@Service("cesOrderMainService")
public class CesOrderMainServiceImpl extends ServiceImpl<CesOrderMainDao, CesOrderMainEntity> implements CesOrderMainService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CesOrderMainEntity> page = this.page(
                new Query<CesOrderMainEntity>().getPage(params),
                new QueryWrapper<CesOrderMainEntity>()
        );

        return new PageUtils(page);
    }

}