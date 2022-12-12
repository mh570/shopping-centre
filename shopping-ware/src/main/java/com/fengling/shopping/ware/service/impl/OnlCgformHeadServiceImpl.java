package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.OnlCgformHeadDao;
import com.fengling.shopping.ware.entity.OnlCgformHeadEntity;
import com.fengling.shopping.ware.service.OnlCgformHeadService;


@Service("onlCgformHeadService")
public class OnlCgformHeadServiceImpl extends ServiceImpl<OnlCgformHeadDao, OnlCgformHeadEntity> implements OnlCgformHeadService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OnlCgformHeadEntity> page = this.page(
                new Query<OnlCgformHeadEntity>().getPage(params),
                new QueryWrapper<OnlCgformHeadEntity>()
        );

        return new PageUtils(page);
    }

}