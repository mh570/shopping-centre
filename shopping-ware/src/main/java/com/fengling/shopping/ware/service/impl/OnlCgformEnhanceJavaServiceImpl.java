package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.OnlCgformEnhanceJavaDao;
import com.fengling.shopping.ware.entity.OnlCgformEnhanceJavaEntity;
import com.fengling.shopping.ware.service.OnlCgformEnhanceJavaService;


@Service("onlCgformEnhanceJavaService")
public class OnlCgformEnhanceJavaServiceImpl extends ServiceImpl<OnlCgformEnhanceJavaDao, OnlCgformEnhanceJavaEntity> implements OnlCgformEnhanceJavaService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OnlCgformEnhanceJavaEntity> page = this.page(
                new Query<OnlCgformEnhanceJavaEntity>().getPage(params),
                new QueryWrapper<OnlCgformEnhanceJavaEntity>()
        );

        return new PageUtils(page);
    }

}