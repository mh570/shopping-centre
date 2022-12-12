package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.SysPermissionV2Dao;
import com.fengling.shopping.ware.entity.SysPermissionV2Entity;
import com.fengling.shopping.ware.service.SysPermissionV2Service;


@Service("sysPermissionV2Service")
public class SysPermissionV2ServiceImpl extends ServiceImpl<SysPermissionV2Dao, SysPermissionV2Entity> implements SysPermissionV2Service {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysPermissionV2Entity> page = this.page(
                new Query<SysPermissionV2Entity>().getPage(params),
                new QueryWrapper<SysPermissionV2Entity>()
        );

        return new PageUtils(page);
    }

}