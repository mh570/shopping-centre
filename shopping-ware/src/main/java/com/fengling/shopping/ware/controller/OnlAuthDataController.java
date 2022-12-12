package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.OnlAuthDataEntity;
import com.fengling.shopping.ware.service.OnlAuthDataService;
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
@RequestMapping("ware/onlauthdata")
public class OnlAuthDataController {
    @Autowired
    private OnlAuthDataService onlAuthDataService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:onlauthdata:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = onlAuthDataService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:onlauthdata:info")
    public R info(@PathVariable("id") String id){
		OnlAuthDataEntity onlAuthData = onlAuthDataService.getById(id);

        return R.ok().put("onlAuthData", onlAuthData);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:onlauthdata:save")
    public R save(@RequestBody OnlAuthDataEntity onlAuthData){
		onlAuthDataService.save(onlAuthData);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:onlauthdata:update")
    public R update(@RequestBody OnlAuthDataEntity onlAuthData){
		onlAuthDataService.updateById(onlAuthData);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:onlauthdata:delete")
    public R delete(@RequestBody String[] ids){
		onlAuthDataService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
