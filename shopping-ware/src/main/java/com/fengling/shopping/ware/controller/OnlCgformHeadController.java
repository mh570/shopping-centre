package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.OnlCgformHeadEntity;
import com.fengling.shopping.ware.service.OnlCgformHeadService;
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
@RequestMapping("ware/onlcgformhead")
public class OnlCgformHeadController {
    @Autowired
    private OnlCgformHeadService onlCgformHeadService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:onlcgformhead:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = onlCgformHeadService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:onlcgformhead:info")
    public R info(@PathVariable("id") String id){
		OnlCgformHeadEntity onlCgformHead = onlCgformHeadService.getById(id);

        return R.ok().put("onlCgformHead", onlCgformHead);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:onlcgformhead:save")
    public R save(@RequestBody OnlCgformHeadEntity onlCgformHead){
		onlCgformHeadService.save(onlCgformHead);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:onlcgformhead:update")
    public R update(@RequestBody OnlCgformHeadEntity onlCgformHead){
		onlCgformHeadService.updateById(onlCgformHead);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:onlcgformhead:delete")
    public R delete(@RequestBody String[] ids){
		onlCgformHeadService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
