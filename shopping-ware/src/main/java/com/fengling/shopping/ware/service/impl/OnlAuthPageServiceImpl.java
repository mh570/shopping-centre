package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.OnlAuthPageDao;
import com.fengling.shopping.ware.entity.OnlAuthPageEntity;
import com.fengling.shopping.ware.service.OnlAuthPageService;


@Service("onlAuthPageService")
public class OnlAuthPageServiceImpl extends ServiceImpl<OnlAuthPageDao, OnlAuthPageEntity> implements OnlAuthPageService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OnlAuthPageEntity> page = this.page(
                new Query<OnlAuthPageEntity>().getPage(params),
                new QueryWrapper<OnlAuthPageEntity>()
        );

        return new PageUtils(page);
    }

}