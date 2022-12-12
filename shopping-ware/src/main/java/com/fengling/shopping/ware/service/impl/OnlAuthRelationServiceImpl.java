package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.OnlAuthRelationDao;
import com.fengling.shopping.ware.entity.OnlAuthRelationEntity;
import com.fengling.shopping.ware.service.OnlAuthRelationService;


@Service("onlAuthRelationService")
public class OnlAuthRelationServiceImpl extends ServiceImpl<OnlAuthRelationDao, OnlAuthRelationEntity> implements OnlAuthRelationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OnlAuthRelationEntity> page = this.page(
                new Query<OnlAuthRelationEntity>().getPage(params),
                new QueryWrapper<OnlAuthRelationEntity>()
        );

        return new PageUtils(page);
    }

}