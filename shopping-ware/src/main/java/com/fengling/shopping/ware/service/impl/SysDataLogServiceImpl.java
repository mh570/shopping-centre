package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.SysDataLogDao;
import com.fengling.shopping.ware.entity.SysDataLogEntity;
import com.fengling.shopping.ware.service.SysDataLogService;


@Service("sysDataLogService")
public class SysDataLogServiceImpl extends ServiceImpl<SysDataLogDao, SysDataLogEntity> implements SysDataLogService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysDataLogEntity> page = this.page(
                new Query<SysDataLogEntity>().getPage(params),
                new QueryWrapper<SysDataLogEntity>()
        );

        return new PageUtils(page);
    }

}