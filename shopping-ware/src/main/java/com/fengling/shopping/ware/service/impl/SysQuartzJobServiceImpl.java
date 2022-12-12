package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.SysQuartzJobDao;
import com.fengling.shopping.ware.entity.SysQuartzJobEntity;
import com.fengling.shopping.ware.service.SysQuartzJobService;


@Service("sysQuartzJobService")
public class SysQuartzJobServiceImpl extends ServiceImpl<SysQuartzJobDao, SysQuartzJobEntity> implements SysQuartzJobService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysQuartzJobEntity> page = this.page(
                new Query<SysQuartzJobEntity>().getPage(params),
                new QueryWrapper<SysQuartzJobEntity>()
        );

        return new PageUtils(page);
    }

}