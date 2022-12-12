package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.CeshiMain001Entity;
import com.fengling.shopping.ware.service.CeshiMain001Service;
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
@RequestMapping("ware/ceshimain001")
public class CeshiMain001Controller {
    @Autowired
    private CeshiMain001Service ceshiMain001Service;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:ceshimain001:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = ceshiMain001Service.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:ceshimain001:info")
    public R info(@PathVariable("id") String id){
		CeshiMain001Entity ceshiMain001 = ceshiMain001Service.getById(id);

        return R.ok().put("ceshiMain001", ceshiMain001);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:ceshimain001:save")
    public R save(@RequestBody CeshiMain001Entity ceshiMain001){
		ceshiMain001Service.save(ceshiMain001);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:ceshimain001:update")
    public R update(@RequestBody CeshiMain001Entity ceshiMain001){
		ceshiMain001Service.updateById(ceshiMain001);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:ceshimain001:delete")
    public R delete(@RequestBody String[] ids){
		ceshiMain001Service.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
