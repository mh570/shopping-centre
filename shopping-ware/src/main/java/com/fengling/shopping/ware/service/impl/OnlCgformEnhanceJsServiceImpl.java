package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.OnlCgformEnhanceJsDao;
import com.fengling.shopping.ware.entity.OnlCgformEnhanceJsEntity;
import com.fengling.shopping.ware.service.OnlCgformEnhanceJsService;


@Service("onlCgformEnhanceJsService")
public class OnlCgformEnhanceJsServiceImpl extends ServiceImpl<OnlCgformEnhanceJsDao, OnlCgformEnhanceJsEntity> implements OnlCgformEnhanceJsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OnlCgformEnhanceJsEntity> page = this.page(
                new Query<OnlCgformEnhanceJsEntity>().getPage(params),
                new QueryWrapper<OnlCgformEnhanceJsEntity>()
        );

        return new PageUtils(page);
    }

}