package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.OnlCgreportParamDao;
import com.fengling.shopping.ware.entity.OnlCgreportParamEntity;
import com.fengling.shopping.ware.service.OnlCgreportParamService;


@Service("onlCgreportParamService")
public class OnlCgreportParamServiceImpl extends ServiceImpl<OnlCgreportParamDao, OnlCgreportParamEntity> implements OnlCgreportParamService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OnlCgreportParamEntity> page = this.page(
                new Query<OnlCgreportParamEntity>().getPage(params),
                new QueryWrapper<OnlCgreportParamEntity>()
        );

        return new PageUtils(page);
    }

}