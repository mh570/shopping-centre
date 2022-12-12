package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.Ceshi001Entity;
import com.fengling.shopping.ware.service.Ceshi001Service;
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
@RequestMapping("ware/ceshi001")
public class Ceshi001Controller {
    @Autowired
    private Ceshi001Service ceshi001Service;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:ceshi001:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = ceshi001Service.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:ceshi001:info")
    public R info(@PathVariable("id") String id){
		Ceshi001Entity ceshi001 = ceshi001Service.getById(id);

        return R.ok().put("ceshi001", ceshi001);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:ceshi001:save")
    public R save(@RequestBody Ceshi001Entity ceshi001){
		ceshi001Service.save(ceshi001);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:ceshi001:update")
    public R update(@RequestBody Ceshi001Entity ceshi001){
		ceshi001Service.updateById(ceshi001);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:ceshi001:delete")
    public R delete(@RequestBody String[] ids){
		ceshi001Service.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
