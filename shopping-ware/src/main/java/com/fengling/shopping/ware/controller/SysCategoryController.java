package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.SysCategoryEntity;
import com.fengling.shopping.ware.service.SysCategoryService;
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
@RequestMapping("ware/syscategory")
public class SysCategoryController {
    @Autowired
    private SysCategoryService sysCategoryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:syscategory:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysCategoryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:syscategory:info")
    public R info(@PathVariable("id") String id){
		SysCategoryEntity sysCategory = sysCategoryService.getById(id);

        return R.ok().put("sysCategory", sysCategory);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:syscategory:save")
    public R save(@RequestBody SysCategoryEntity sysCategory){
		sysCategoryService.save(sysCategory);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:syscategory:update")
    public R update(@RequestBody SysCategoryEntity sysCategory){
		sysCategoryService.updateById(sysCategory);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:syscategory:delete")
    public R delete(@RequestBody String[] ids){
		sysCategoryService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
