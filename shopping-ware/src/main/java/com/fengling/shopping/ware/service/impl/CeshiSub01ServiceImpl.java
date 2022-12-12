package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.CeshiSub01Dao;
import com.fengling.shopping.ware.entity.CeshiSub01Entity;
import com.fengling.shopping.ware.service.CeshiSub01Service;


@Service("ceshiSub01Service")
public class CeshiSub01ServiceImpl extends ServiceImpl<CeshiSub01Dao, CeshiSub01Entity> implements CeshiSub01Service {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CeshiSub01Entity> page = this.page(
                new Query<CeshiSub01Entity>().getPage(params),
                new QueryWrapper<CeshiSub01Entity>()
        );

        return new PageUtils(page);
    }

}