package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.TestOrderMainDao;
import com.fengling.shopping.ware.entity.TestOrderMainEntity;
import com.fengling.shopping.ware.service.TestOrderMainService;


@Service("testOrderMainService")
public class TestOrderMainServiceImpl extends ServiceImpl<TestOrderMainDao, TestOrderMainEntity> implements TestOrderMainService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<TestOrderMainEntity> page = this.page(
                new Query<TestOrderMainEntity>().getPage(params),
                new QueryWrapper<TestOrderMainEntity>()
        );

        return new PageUtils(page);
    }

}