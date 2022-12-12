package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.OnlCgformEnhanceSqlDao;
import com.fengling.shopping.ware.entity.OnlCgformEnhanceSqlEntity;
import com.fengling.shopping.ware.service.OnlCgformEnhanceSqlService;


@Service("onlCgformEnhanceSqlService")
public class OnlCgformEnhanceSqlServiceImpl extends ServiceImpl<OnlCgformEnhanceSqlDao, OnlCgformEnhanceSqlEntity> implements OnlCgformEnhanceSqlService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OnlCgformEnhanceSqlEntity> page = this.page(
                new Query<OnlCgformEnhanceSqlEntity>().getPage(params),
                new QueryWrapper<OnlCgformEnhanceSqlEntity>()
        );

        return new PageUtils(page);
    }

}