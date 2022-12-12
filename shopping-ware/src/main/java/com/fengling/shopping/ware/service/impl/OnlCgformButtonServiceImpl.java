package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.OnlCgformButtonDao;
import com.fengling.shopping.ware.entity.OnlCgformButtonEntity;
import com.fengling.shopping.ware.service.OnlCgformButtonService;


@Service("onlCgformButtonService")
public class OnlCgformButtonServiceImpl extends ServiceImpl<OnlCgformButtonDao, OnlCgformButtonEntity> implements OnlCgformButtonService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OnlCgformButtonEntity> page = this.page(
                new Query<OnlCgformButtonEntity>().getPage(params),
                new QueryWrapper<OnlCgformButtonEntity>()
        );

        return new PageUtils(page);
    }

}