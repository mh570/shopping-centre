package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.Ceshi001Dao;
import com.fengling.shopping.ware.entity.Ceshi001Entity;
import com.fengling.shopping.ware.service.Ceshi001Service;


@Service("ceshi001Service")
public class Ceshi001ServiceImpl extends ServiceImpl<Ceshi001Dao, Ceshi001Entity> implements Ceshi001Service {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<Ceshi001Entity> page = this.page(
                new Query<Ceshi001Entity>().getPage(params),
                new QueryWrapper<Ceshi001Entity>()
        );

        return new PageUtils(page);
    }

}