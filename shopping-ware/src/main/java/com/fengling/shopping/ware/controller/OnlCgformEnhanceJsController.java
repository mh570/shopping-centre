package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.OnlCgformEnhanceJsEntity;
import com.fengling.shopping.ware.service.OnlCgformEnhanceJsService;
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
@RequestMapping("ware/onlcgformenhancejs")
public class OnlCgformEnhanceJsController {
    @Autowired
    private OnlCgformEnhanceJsService onlCgformEnhanceJsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:onlcgformenhancejs:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = onlCgformEnhanceJsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:onlcgformenhancejs:info")
    public R info(@PathVariable("id") String id){
		OnlCgformEnhanceJsEntity onlCgformEnhanceJs = onlCgformEnhanceJsService.getById(id);

        return R.ok().put("onlCgformEnhanceJs", onlCgformEnhanceJs);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:onlcgformenhancejs:save")
    public R save(@RequestBody OnlCgformEnhanceJsEntity onlCgformEnhanceJs){
		onlCgformEnhanceJsService.save(onlCgformEnhanceJs);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:onlcgformenhancejs:update")
    public R update(@RequestBody OnlCgformEnhanceJsEntity onlCgformEnhanceJs){
		onlCgformEnhanceJsService.updateById(onlCgformEnhanceJs);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:onlcgformenhancejs:delete")
    public R delete(@RequestBody String[] ids){
		onlCgformEnhanceJsService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
