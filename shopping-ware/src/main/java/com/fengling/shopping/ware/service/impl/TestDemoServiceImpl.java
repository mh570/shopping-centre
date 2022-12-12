package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.TestDemoDao;
import com.fengling.shopping.ware.entity.TestDemoEntity;
import com.fengling.shopping.ware.service.TestDemoService;


@Service("testDemoService")
public class TestDemoServiceImpl extends ServiceImpl<TestDemoDao, TestDemoEntity> implements TestDemoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<TestDemoEntity> page = this.page(
                new Query<TestDemoEntity>().getPage(params),
                new QueryWrapper<TestDemoEntity>()
        );

        return new PageUtils(page);
    }

}