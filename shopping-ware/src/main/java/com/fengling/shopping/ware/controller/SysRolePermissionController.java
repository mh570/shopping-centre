package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.SysRolePermissionEntity;
import com.fengling.shopping.ware.service.SysRolePermissionService;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.R;



/**
 * 角色权限表
 *
 * @author mh570
 * @email 2317295126@qq.com
 * @date 2022-12-12 22:19:33
 */
@RestController
@RequestMapping("ware/sysrolepermission")
public class SysRolePermissionController {
    @Autowired
    private SysRolePermissionService sysRolePermissionService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:sysrolepermission:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysRolePermissionService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:sysrolepermission:info")
    public R info(@PathVariable("id") String id){
		SysRolePermissionEntity sysRolePermission = sysRolePermissionService.getById(id);

        return R.ok().put("sysRolePermission", sysRolePermission);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:sysrolepermission:save")
    public R save(@RequestBody SysRolePermissionEntity sysRolePermission){
		sysRolePermissionService.save(sysRolePermission);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:sysrolepermission:update")
    public R update(@RequestBody SysRolePermissionEntity sysRolePermission){
		sysRolePermissionService.updateById(sysRolePermission);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:sysrolepermission:delete")
    public R delete(@RequestBody String[] ids){
		sysRolePermissionService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
