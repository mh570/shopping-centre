package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.TestOnlineLinkDao;
import com.fengling.shopping.ware.entity.TestOnlineLinkEntity;
import com.fengling.shopping.ware.service.TestOnlineLinkService;


@Service("testOnlineLinkService")
public class TestOnlineLinkServiceImpl extends ServiceImpl<TestOnlineLinkDao, TestOnlineLinkEntity> implements TestOnlineLinkService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<TestOnlineLinkEntity> page = this.page(
                new Query<TestOnlineLinkEntity>().getPage(params),
                new QueryWrapper<TestOnlineLinkEntity>()
        );

        return new PageUtils(page);
    }

}