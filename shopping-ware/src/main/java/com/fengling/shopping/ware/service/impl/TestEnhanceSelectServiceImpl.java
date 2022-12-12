package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.TestEnhanceSelectDao;
import com.fengling.shopping.ware.entity.TestEnhanceSelectEntity;
import com.fengling.shopping.ware.service.TestEnhanceSelectService;


@Service("testEnhanceSelectService")
public class TestEnhanceSelectServiceImpl extends ServiceImpl<TestEnhanceSelectDao, TestEnhanceSelectEntity> implements TestEnhanceSelectService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<TestEnhanceSelectEntity> page = this.page(
                new Query<TestEnhanceSelectEntity>().getPage(params),
                new QueryWrapper<TestEnhanceSelectEntity>()
        );

        return new PageUtils(page);
    }

}