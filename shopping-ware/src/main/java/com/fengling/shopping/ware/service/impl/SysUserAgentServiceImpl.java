package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.SysUserAgentDao;
import com.fengling.shopping.ware.entity.SysUserAgentEntity;
import com.fengling.shopping.ware.service.SysUserAgentService;


@Service("sysUserAgentService")
public class SysUserAgentServiceImpl extends ServiceImpl<SysUserAgentDao, SysUserAgentEntity> implements SysUserAgentService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysUserAgentEntity> page = this.page(
                new Query<SysUserAgentEntity>().getPage(params),
                new QueryWrapper<SysUserAgentEntity>()
        );

        return new PageUtils(page);
    }

}