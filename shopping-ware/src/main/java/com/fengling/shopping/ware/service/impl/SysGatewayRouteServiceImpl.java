package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.SysGatewayRouteDao;
import com.fengling.shopping.ware.entity.SysGatewayRouteEntity;
import com.fengling.shopping.ware.service.SysGatewayRouteService;


@Service("sysGatewayRouteService")
public class SysGatewayRouteServiceImpl extends ServiceImpl<SysGatewayRouteDao, SysGatewayRouteEntity> implements SysGatewayRouteService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysGatewayRouteEntity> page = this.page(
                new Query<SysGatewayRouteEntity>().getPage(params),
                new QueryWrapper<SysGatewayRouteEntity>()
        );

        return new PageUtils(page);
    }

}