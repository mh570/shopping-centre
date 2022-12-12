package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.SysDictItemEntity;
import com.fengling.shopping.ware.service.SysDictItemService;
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
@RequestMapping("ware/sysdictitem")
public class SysDictItemController {
    @Autowired
    private SysDictItemService sysDictItemService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:sysdictitem:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysDictItemService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:sysdictitem:info")
    public R info(@PathVariable("id") String id){
		SysDictItemEntity sysDictItem = sysDictItemService.getById(id);

        return R.ok().put("sysDictItem", sysDictItem);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:sysdictitem:save")
    public R save(@RequestBody SysDictItemEntity sysDictItem){
		sysDictItemService.save(sysDictItem);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:sysdictitem:update")
    public R update(@RequestBody SysDictItemEntity sysDictItem){
		sysDictItemService.updateById(sysDictItem);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:sysdictitem:delete")
    public R delete(@RequestBody String[] ids){
		sysDictItemService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
