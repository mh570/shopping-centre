package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.SysRoleIndexDao;
import com.fengling.shopping.ware.entity.SysRoleIndexEntity;
import com.fengling.shopping.ware.service.SysRoleIndexService;


@Service("sysRoleIndexService")
public class SysRoleIndexServiceImpl extends ServiceImpl<SysRoleIndexDao, SysRoleIndexEntity> implements SysRoleIndexService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysRoleIndexEntity> page = this.page(
                new Query<SysRoleIndexEntity>().getPage(params),
                new QueryWrapper<SysRoleIndexEntity>()
        );

        return new PageUtils(page);
    }

}