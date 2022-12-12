package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.V3Demo1Dao;
import com.fengling.shopping.ware.entity.V3Demo1Entity;
import com.fengling.shopping.ware.service.V3Demo1Service;


@Service("v3Demo1Service")
public class V3Demo1ServiceImpl extends ServiceImpl<V3Demo1Dao, V3Demo1Entity> implements V3Demo1Service {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<V3Demo1Entity> page = this.page(
                new Query<V3Demo1Entity>().getPage(params),
                new QueryWrapper<V3Demo1Entity>()
        );

        return new PageUtils(page);
    }

}