package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.SysPermissionEntity;
import com.fengling.shopping.ware.service.SysPermissionService;
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
@RequestMapping("ware/syspermission")
public class SysPermissionController {
    @Autowired
    private SysPermissionService sysPermissionService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:syspermission:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysPermissionService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:syspermission:info")
    public R info(@PathVariable("id") String id){
		SysPermissionEntity sysPermission = sysPermissionService.getById(id);

        return R.ok().put("sysPermission", sysPermission);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:syspermission:save")
    public R save(@RequestBody SysPermissionEntity sysPermission){
		sysPermissionService.save(sysPermission);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:syspermission:update")
    public R update(@RequestBody SysPermissionEntity sysPermission){
		sysPermissionService.updateById(sysPermission);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:syspermission:delete")
    public R delete(@RequestBody String[] ids){
		sysPermissionService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
