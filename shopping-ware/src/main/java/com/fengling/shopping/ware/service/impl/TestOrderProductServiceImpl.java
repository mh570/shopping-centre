package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.TestOrderProductDao;
import com.fengling.shopping.ware.entity.TestOrderProductEntity;
import com.fengling.shopping.ware.service.TestOrderProductService;


@Service("testOrderProductService")
public class TestOrderProductServiceImpl extends ServiceImpl<TestOrderProductDao, TestOrderProductEntity> implements TestOrderProductService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<TestOrderProductEntity> page = this.page(
                new Query<TestOrderProductEntity>().getPage(params),
                new QueryWrapper<TestOrderProductEntity>()
        );

        return new PageUtils(page);
    }

}