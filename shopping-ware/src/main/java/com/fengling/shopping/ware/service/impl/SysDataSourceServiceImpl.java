package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.SysDataSourceDao;
import com.fengling.shopping.ware.entity.SysDataSourceEntity;
import com.fengling.shopping.ware.service.SysDataSourceService;


@Service("sysDataSourceService")
public class SysDataSourceServiceImpl extends ServiceImpl<SysDataSourceDao, SysDataSourceEntity> implements SysDataSourceService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysDataSourceEntity> page = this.page(
                new Query<SysDataSourceEntity>().getPage(params),
                new QueryWrapper<SysDataSourceEntity>()
        );

        return new PageUtils(page);
    }

}