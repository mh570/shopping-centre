package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.SysPositionDao;
import com.fengling.shopping.ware.entity.SysPositionEntity;
import com.fengling.shopping.ware.service.SysPositionService;


@Service("sysPositionService")
public class SysPositionServiceImpl extends ServiceImpl<SysPositionDao, SysPositionEntity> implements SysPositionService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysPositionEntity> page = this.page(
                new Query<SysPositionEntity>().getPage(params),
                new QueryWrapper<SysPositionEntity>()
        );

        return new PageUtils(page);
    }

}