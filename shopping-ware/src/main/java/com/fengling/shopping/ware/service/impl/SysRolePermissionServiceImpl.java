package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.SysRolePermissionDao;
import com.fengling.shopping.ware.entity.SysRolePermissionEntity;
import com.fengling.shopping.ware.service.SysRolePermissionService;


@Service("sysRolePermissionService")
public class SysRolePermissionServiceImpl extends ServiceImpl<SysRolePermissionDao, SysRolePermissionEntity> implements SysRolePermissionService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysRolePermissionEntity> page = this.page(
                new Query<SysRolePermissionEntity>().getPage(params),
                new QueryWrapper<SysRolePermissionEntity>()
        );

        return new PageUtils(page);
    }

}