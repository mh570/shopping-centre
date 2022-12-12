package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.OnlCgformEnhanceSqlEntity;
import com.fengling.shopping.ware.service.OnlCgformEnhanceSqlService;
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
@RequestMapping("ware/onlcgformenhancesql")
public class OnlCgformEnhanceSqlController {
    @Autowired
    private OnlCgformEnhanceSqlService onlCgformEnhanceSqlService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:onlcgformenhancesql:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = onlCgformEnhanceSqlService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:onlcgformenhancesql:info")
    public R info(@PathVariable("id") String id){
		OnlCgformEnhanceSqlEntity onlCgformEnhanceSql = onlCgformEnhanceSqlService.getById(id);

        return R.ok().put("onlCgformEnhanceSql", onlCgformEnhanceSql);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:onlcgformenhancesql:save")
    public R save(@RequestBody OnlCgformEnhanceSqlEntity onlCgformEnhanceSql){
		onlCgformEnhanceSqlService.save(onlCgformEnhanceSql);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:onlcgformenhancesql:update")
    public R update(@RequestBody OnlCgformEnhanceSqlEntity onlCgformEnhanceSql){
		onlCgformEnhanceSqlService.updateById(onlCgformEnhanceSql);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:onlcgformenhancesql:delete")
    public R delete(@RequestBody String[] ids){
		onlCgformEnhanceSqlService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
