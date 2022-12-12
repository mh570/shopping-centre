package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.SysTenantEntity;
import com.fengling.shopping.ware.service.SysTenantService;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.R;



/**
 * 多租户信息表
 *
 * @author mh570
 * @email 2317295126@qq.com
 * @date 2022-12-12 22:19:34
 */
@RestController
@RequestMapping("ware/systenant")
public class SysTenantController {
    @Autowired
    private SysTenantService sysTenantService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:systenant:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysTenantService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:systenant:info")
    public R info(@PathVariable("id") Integer id){
		SysTenantEntity sysTenant = sysTenantService.getById(id);

        return R.ok().put("sysTenant", sysTenant);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:systenant:save")
    public R save(@RequestBody SysTenantEntity sysTenant){
		sysTenantService.save(sysTenant);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:systenant:update")
    public R update(@RequestBody SysTenantEntity sysTenant){
		sysTenantService.updateById(sysTenant);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:systenant:delete")
    public R delete(@RequestBody Integer[] ids){
		sysTenantService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
