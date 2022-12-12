package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.DemoFieldDefValSubDao;
import com.fengling.shopping.ware.entity.DemoFieldDefValSubEntity;
import com.fengling.shopping.ware.service.DemoFieldDefValSubService;


@Service("demoFieldDefValSubService")
public class DemoFieldDefValSubServiceImpl extends ServiceImpl<DemoFieldDefValSubDao, DemoFieldDefValSubEntity> implements DemoFieldDefValSubService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DemoFieldDefValSubEntity> page = this.page(
                new Query<DemoFieldDefValSubEntity>().getPage(params),
                new QueryWrapper<DemoFieldDefValSubEntity>()
        );

        return new PageUtils(page);
    }

}