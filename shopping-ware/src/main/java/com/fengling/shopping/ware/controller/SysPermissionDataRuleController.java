package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.SysPermissionDataRuleEntity;
import com.fengling.shopping.ware.service.SysPermissionDataRuleService;
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
@RequestMapping("ware/syspermissiondatarule")
public class SysPermissionDataRuleController {
    @Autowired
    private SysPermissionDataRuleService sysPermissionDataRuleService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:syspermissiondatarule:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysPermissionDataRuleService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:syspermissiondatarule:info")
    public R info(@PathVariable("id") String id){
		SysPermissionDataRuleEntity sysPermissionDataRule = sysPermissionDataRuleService.getById(id);

        return R.ok().put("sysPermissionDataRule", sysPermissionDataRule);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:syspermissiondatarule:save")
    public R save(@RequestBody SysPermissionDataRuleEntity sysPermissionDataRule){
		sysPermissionDataRuleService.save(sysPermissionDataRule);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:syspermissiondatarule:update")
    public R update(@RequestBody SysPermissionDataRuleEntity sysPermissionDataRule){
		sysPermissionDataRuleService.updateById(sysPermissionDataRule);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:syspermissiondatarule:delete")
    public R delete(@RequestBody String[] ids){
		sysPermissionDataRuleService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
