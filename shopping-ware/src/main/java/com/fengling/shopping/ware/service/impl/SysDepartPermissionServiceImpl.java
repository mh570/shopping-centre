package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.SysDepartPermissionDao;
import com.fengling.shopping.ware.entity.SysDepartPermissionEntity;
import com.fengling.shopping.ware.service.SysDepartPermissionService;


@Service("sysDepartPermissionService")
public class SysDepartPermissionServiceImpl extends ServiceImpl<SysDepartPermissionDao, SysDepartPermissionEntity> implements SysDepartPermissionService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysDepartPermissionEntity> page = this.page(
                new Query<SysDepartPermissionEntity>().getPage(params),
                new QueryWrapper<SysDepartPermissionEntity>()
        );

        return new PageUtils(page);
    }

}