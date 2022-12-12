package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.SysGatewayRouteEntity;
import com.fengling.shopping.ware.service.SysGatewayRouteService;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.R;



/**
 * 
 *
 * @author mh570
 * @email 2317295126@qq.com
 * @date 2022-12-12 22:19:34
 */
@RestController
@RequestMapping("ware/sysgatewayroute")
public class SysGatewayRouteController {
    @Autowired
    private SysGatewayRouteService sysGatewayRouteService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:sysgatewayroute:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysGatewayRouteService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:sysgatewayroute:info")
    public R info(@PathVariable("id") String id){
		SysGatewayRouteEntity sysGatewayRoute = sysGatewayRouteService.getById(id);

        return R.ok().put("sysGatewayRoute", sysGatewayRoute);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:sysgatewayroute:save")
    public R save(@RequestBody SysGatewayRouteEntity sysGatewayRoute){
		sysGatewayRouteService.save(sysGatewayRoute);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:sysgatewayroute:update")
    public R update(@RequestBody SysGatewayRouteEntity sysGatewayRoute){
		sysGatewayRouteService.updateById(sysGatewayRoute);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:sysgatewayroute:delete")
    public R delete(@RequestBody String[] ids){
		sysGatewayRouteService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
