package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.SysUserDepartDao;
import com.fengling.shopping.ware.entity.SysUserDepartEntity;
import com.fengling.shopping.ware.service.SysUserDepartService;


@Service("sysUserDepartService")
public class SysUserDepartServiceImpl extends ServiceImpl<SysUserDepartDao, SysUserDepartEntity> implements SysUserDepartService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysUserDepartEntity> page = this.page(
                new Query<SysUserDepartEntity>().getPage(params),
                new QueryWrapper<SysUserDepartEntity>()
        );

        return new PageUtils(page);
    }

}