package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.SysDepartRoleUserDao;
import com.fengling.shopping.ware.entity.SysDepartRoleUserEntity;
import com.fengling.shopping.ware.service.SysDepartRoleUserService;


@Service("sysDepartRoleUserService")
public class SysDepartRoleUserServiceImpl extends ServiceImpl<SysDepartRoleUserDao, SysDepartRoleUserEntity> implements SysDepartRoleUserService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysDepartRoleUserEntity> page = this.page(
                new Query<SysDepartRoleUserEntity>().getPage(params),
                new QueryWrapper<SysDepartRoleUserEntity>()
        );

        return new PageUtils(page);
    }

}