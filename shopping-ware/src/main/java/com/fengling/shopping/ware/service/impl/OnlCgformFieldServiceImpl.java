package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.OnlCgformFieldDao;
import com.fengling.shopping.ware.entity.OnlCgformFieldEntity;
import com.fengling.shopping.ware.service.OnlCgformFieldService;


@Service("onlCgformFieldService")
public class OnlCgformFieldServiceImpl extends ServiceImpl<OnlCgformFieldDao, OnlCgformFieldEntity> implements OnlCgformFieldService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OnlCgformFieldEntity> page = this.page(
                new Query<OnlCgformFieldEntity>().getPage(params),
                new QueryWrapper<OnlCgformFieldEntity>()
        );

        return new PageUtils(page);
    }

}