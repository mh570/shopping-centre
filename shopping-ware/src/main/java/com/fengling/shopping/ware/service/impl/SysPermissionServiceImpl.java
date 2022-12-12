package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.SysPermissionDao;
import com.fengling.shopping.ware.entity.SysPermissionEntity;
import com.fengling.shopping.ware.service.SysPermissionService;


@Service("sysPermissionService")
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionDao, SysPermissionEntity> implements SysPermissionService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysPermissionEntity> page = this.page(
                new Query<SysPermissionEntity>().getPage(params),
                new QueryWrapper<SysPermissionEntity>()
        );

        return new PageUtils(page);
    }

}