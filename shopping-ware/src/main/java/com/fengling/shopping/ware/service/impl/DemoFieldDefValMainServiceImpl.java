package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.DemoFieldDefValMainDao;
import com.fengling.shopping.ware.entity.DemoFieldDefValMainEntity;
import com.fengling.shopping.ware.service.DemoFieldDefValMainService;


@Service("demoFieldDefValMainService")
public class DemoFieldDefValMainServiceImpl extends ServiceImpl<DemoFieldDefValMainDao, DemoFieldDefValMainEntity> implements DemoFieldDefValMainService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DemoFieldDefValMainEntity> page = this.page(
                new Query<DemoFieldDefValMainEntity>().getPage(params),
                new QueryWrapper<DemoFieldDefValMainEntity>()
        );

        return new PageUtils(page);
    }

}