package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.OnlAuthDataDao;
import com.fengling.shopping.ware.entity.OnlAuthDataEntity;
import com.fengling.shopping.ware.service.OnlAuthDataService;


@Service("onlAuthDataService")
public class OnlAuthDataServiceImpl extends ServiceImpl<OnlAuthDataDao, OnlAuthDataEntity> implements OnlAuthDataService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OnlAuthDataEntity> page = this.page(
                new Query<OnlAuthDataEntity>().getPage(params),
                new QueryWrapper<OnlAuthDataEntity>()
        );

        return new PageUtils(page);
    }

}