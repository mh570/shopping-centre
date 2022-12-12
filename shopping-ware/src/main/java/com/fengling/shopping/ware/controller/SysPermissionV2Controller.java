package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.SysPermissionV2Entity;
import com.fengling.shopping.ware.service.SysPermissionV2Service;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.R;



/**
 * 菜单权限表
 *
 * @author mh570
 * @email 2317295126@qq.com
 * @date 2022-12-12 22:19:34
 */
@RestController
@RequestMapping("ware/syspermissionv2")
public class SysPermissionV2Controller {
    @Autowired
    private SysPermissionV2Service sysPermissionV2Service;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:syspermissionv2:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysPermissionV2Service.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:syspermissionv2:info")
    public R info(@PathVariable("id") String id){
		SysPermissionV2Entity sysPermissionV2 = sysPermissionV2Service.getById(id);

        return R.ok().put("sysPermissionV2", sysPermissionV2);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:syspermissionv2:save")
    public R save(@RequestBody SysPermissionV2Entity sysPermissionV2){
		sysPermissionV2Service.save(sysPermissionV2);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:syspermissionv2:update")
    public R update(@RequestBody SysPermissionV2Entity sysPermissionV2){
		sysPermissionV2Service.updateById(sysPermissionV2);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:syspermissionv2:delete")
    public R delete(@RequestBody String[] ids){
		sysPermissionV2Service.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
