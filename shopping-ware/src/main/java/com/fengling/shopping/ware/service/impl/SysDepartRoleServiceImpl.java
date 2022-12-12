package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.SysDepartRoleDao;
import com.fengling.shopping.ware.entity.SysDepartRoleEntity;
import com.fengling.shopping.ware.service.SysDepartRoleService;


@Service("sysDepartRoleService")
public class SysDepartRoleServiceImpl extends ServiceImpl<SysDepartRoleDao, SysDepartRoleEntity> implements SysDepartRoleService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysDepartRoleEntity> page = this.page(
                new Query<SysDepartRoleEntity>().getPage(params),
                new QueryWrapper<SysDepartRoleEntity>()
        );

        return new PageUtils(page);
    }

}