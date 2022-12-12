package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.OnlCgreportHeadDao;
import com.fengling.shopping.ware.entity.OnlCgreportHeadEntity;
import com.fengling.shopping.ware.service.OnlCgreportHeadService;


@Service("onlCgreportHeadService")
public class OnlCgreportHeadServiceImpl extends ServiceImpl<OnlCgreportHeadDao, OnlCgreportHeadEntity> implements OnlCgreportHeadService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OnlCgreportHeadEntity> page = this.page(
                new Query<OnlCgreportHeadEntity>().getPage(params),
                new QueryWrapper<OnlCgreportHeadEntity>()
        );

        return new PageUtils(page);
    }

}