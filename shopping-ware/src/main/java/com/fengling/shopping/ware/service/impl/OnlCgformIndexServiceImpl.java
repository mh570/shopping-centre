package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.OnlCgformIndexDao;
import com.fengling.shopping.ware.entity.OnlCgformIndexEntity;
import com.fengling.shopping.ware.service.OnlCgformIndexService;


@Service("onlCgformIndexService")
public class OnlCgformIndexServiceImpl extends ServiceImpl<OnlCgformIndexDao, OnlCgformIndexEntity> implements OnlCgformIndexService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OnlCgformIndexEntity> page = this.page(
                new Query<OnlCgformIndexEntity>().getPage(params),
                new QueryWrapper<OnlCgformIndexEntity>()
        );

        return new PageUtils(page);
    }

}