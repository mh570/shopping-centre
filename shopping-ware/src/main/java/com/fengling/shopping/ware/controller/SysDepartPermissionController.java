package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.SysDepartPermissionEntity;
import com.fengling.shopping.ware.service.SysDepartPermissionService;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.R;



/**
 * 部门权限表
 *
 * @author mh570
 * @email 2317295126@qq.com
 * @date 2022-12-12 22:19:34
 */
@RestController
@RequestMapping("ware/sysdepartpermission")
public class SysDepartPermissionController {
    @Autowired
    private SysDepartPermissionService sysDepartPermissionService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:sysdepartpermission:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysDepartPermissionService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:sysdepartpermission:info")
    public R info(@PathVariable("id") String id){
		SysDepartPermissionEntity sysDepartPermission = sysDepartPermissionService.getById(id);

        return R.ok().put("sysDepartPermission", sysDepartPermission);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:sysdepartpermission:save")
    public R save(@RequestBody SysDepartPermissionEntity sysDepartPermission){
		sysDepartPermissionService.save(sysDepartPermission);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:sysdepartpermission:update")
    public R update(@RequestBody SysDepartPermissionEntity sysDepartPermission){
		sysDepartPermissionService.updateById(sysDepartPermission);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:sysdepartpermission:delete")
    public R delete(@RequestBody String[] ids){
		sysDepartPermissionService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
