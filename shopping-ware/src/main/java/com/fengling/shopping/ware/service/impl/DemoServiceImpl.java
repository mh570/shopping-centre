package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.DemoDao;
import com.fengling.shopping.ware.entity.DemoEntity;
import com.fengling.shopping.ware.service.DemoService;


@Service("demoService")
public class DemoServiceImpl extends ServiceImpl<DemoDao, DemoEntity> implements DemoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DemoEntity> page = this.page(
                new Query<DemoEntity>().getPage(params),
                new QueryWrapper<DemoEntity>()
        );

        return new PageUtils(page);
    }

}