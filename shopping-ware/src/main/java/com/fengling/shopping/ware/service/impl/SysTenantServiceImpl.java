package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.SysTenantDao;
import com.fengling.shopping.ware.entity.SysTenantEntity;
import com.fengling.shopping.ware.service.SysTenantService;


@Service("sysTenantService")
public class SysTenantServiceImpl extends ServiceImpl<SysTenantDao, SysTenantEntity> implements SysTenantService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysTenantEntity> page = this.page(
                new Query<SysTenantEntity>().getPage(params),
                new QueryWrapper<SysTenantEntity>()
        );

        return new PageUtils(page);
    }

}