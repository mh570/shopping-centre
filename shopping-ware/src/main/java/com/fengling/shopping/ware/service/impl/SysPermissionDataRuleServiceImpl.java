package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.SysPermissionDataRuleDao;
import com.fengling.shopping.ware.entity.SysPermissionDataRuleEntity;
import com.fengling.shopping.ware.service.SysPermissionDataRuleService;


@Service("sysPermissionDataRuleService")
public class SysPermissionDataRuleServiceImpl extends ServiceImpl<SysPermissionDataRuleDao, SysPermissionDataRuleEntity> implements SysPermissionDataRuleService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysPermissionDataRuleEntity> page = this.page(
                new Query<SysPermissionDataRuleEntity>().getPage(params),
                new QueryWrapper<SysPermissionDataRuleEntity>()
        );

        return new PageUtils(page);
    }

}