package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.SysDepartRolePermissionDao;
import com.fengling.shopping.ware.entity.SysDepartRolePermissionEntity;
import com.fengling.shopping.ware.service.SysDepartRolePermissionService;


@Service("sysDepartRolePermissionService")
public class SysDepartRolePermissionServiceImpl extends ServiceImpl<SysDepartRolePermissionDao, SysDepartRolePermissionEntity> implements SysDepartRolePermissionService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysDepartRolePermissionEntity> page = this.page(
                new Query<SysDepartRolePermissionEntity>().getPage(params),
                new QueryWrapper<SysDepartRolePermissionEntity>()
        );

        return new PageUtils(page);
    }

}