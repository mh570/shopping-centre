package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.SysFilesDao;
import com.fengling.shopping.ware.entity.SysFilesEntity;
import com.fengling.shopping.ware.service.SysFilesService;


@Service("sysFilesService")
public class SysFilesServiceImpl extends ServiceImpl<SysFilesDao, SysFilesEntity> implements SysFilesService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysFilesEntity> page = this.page(
                new Query<SysFilesEntity>().getPage(params),
                new QueryWrapper<SysFilesEntity>()
        );

        return new PageUtils(page);
    }

}