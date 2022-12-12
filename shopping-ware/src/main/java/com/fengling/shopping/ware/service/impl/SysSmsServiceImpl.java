package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.SysSmsDao;
import com.fengling.shopping.ware.entity.SysSmsEntity;
import com.fengling.shopping.ware.service.SysSmsService;


@Service("sysSmsService")
public class SysSmsServiceImpl extends ServiceImpl<SysSmsDao, SysSmsEntity> implements SysSmsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysSmsEntity> page = this.page(
                new Query<SysSmsEntity>().getPage(params),
                new QueryWrapper<SysSmsEntity>()
        );

        return new PageUtils(page);
    }

}