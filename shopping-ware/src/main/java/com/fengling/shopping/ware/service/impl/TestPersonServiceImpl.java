package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.TestPersonDao;
import com.fengling.shopping.ware.entity.TestPersonEntity;
import com.fengling.shopping.ware.service.TestPersonService;


@Service("testPersonService")
public class TestPersonServiceImpl extends ServiceImpl<TestPersonDao, TestPersonEntity> implements TestPersonService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<TestPersonEntity> page = this.page(
                new Query<TestPersonEntity>().getPage(params),
                new QueryWrapper<TestPersonEntity>()
        );

        return new PageUtils(page);
    }

}