package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.CeshiMain001Dao;
import com.fengling.shopping.ware.entity.CeshiMain001Entity;
import com.fengling.shopping.ware.service.CeshiMain001Service;


@Service("ceshiMain001Service")
public class CeshiMain001ServiceImpl extends ServiceImpl<CeshiMain001Dao, CeshiMain001Entity> implements CeshiMain001Service {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CeshiMain001Entity> page = this.page(
                new Query<CeshiMain001Entity>().getPage(params),
                new QueryWrapper<CeshiMain001Entity>()
        );

        return new PageUtils(page);
    }

}