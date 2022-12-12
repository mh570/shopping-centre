package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.V3Demo1Entity;
import com.fengling.shopping.ware.service.V3Demo1Service;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.R;



/**
 * 
 *
 * @author mh570
 * @email 2317295126@qq.com
 * @date 2022-12-12 22:19:33
 */
@RestController
@RequestMapping("ware/v3demo1")
public class V3Demo1Controller {
    @Autowired
    private V3Demo1Service v3Demo1Service;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:v3demo1:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = v3Demo1Service.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:v3demo1:info")
    public R info(@PathVariable("id") String id){
		V3Demo1Entity v3Demo1 = v3Demo1Service.getById(id);

        return R.ok().put("v3Demo1", v3Demo1);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:v3demo1:save")
    public R save(@RequestBody V3Demo1Entity v3Demo1){
		v3Demo1Service.save(v3Demo1);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:v3demo1:update")
    public R update(@RequestBody V3Demo1Entity v3Demo1){
		v3Demo1Service.updateById(v3Demo1);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:v3demo1:delete")
    public R delete(@RequestBody String[] ids){
		v3Demo1Service.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
