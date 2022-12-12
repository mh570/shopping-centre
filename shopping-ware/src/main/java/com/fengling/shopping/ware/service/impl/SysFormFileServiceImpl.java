package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.SysFormFileDao;
import com.fengling.shopping.ware.entity.SysFormFileEntity;
import com.fengling.shopping.ware.service.SysFormFileService;


@Service("sysFormFileService")
public class SysFormFileServiceImpl extends ServiceImpl<SysFormFileDao, SysFormFileEntity> implements SysFormFileService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysFormFileEntity> page = this.page(
                new Query<SysFormFileEntity>().getPage(params),
                new QueryWrapper<SysFormFileEntity>()
        );

        return new PageUtils(page);
    }

}