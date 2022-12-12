package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.OnlCgformEnhanceJavaEntity;
import com.fengling.shopping.ware.service.OnlCgformEnhanceJavaService;
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
@RequestMapping("ware/onlcgformenhancejava")
public class OnlCgformEnhanceJavaController {
    @Autowired
    private OnlCgformEnhanceJavaService onlCgformEnhanceJavaService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:onlcgformenhancejava:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = onlCgformEnhanceJavaService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:onlcgformenhancejava:info")
    public R info(@PathVariable("id") String id){
		OnlCgformEnhanceJavaEntity onlCgformEnhanceJava = onlCgformEnhanceJavaService.getById(id);

        return R.ok().put("onlCgformEnhanceJava", onlCgformEnhanceJava);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:onlcgformenhancejava:save")
    public R save(@RequestBody OnlCgformEnhanceJavaEntity onlCgformEnhanceJava){
		onlCgformEnhanceJavaService.save(onlCgformEnhanceJava);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:onlcgformenhancejava:update")
    public R update(@RequestBody OnlCgformEnhanceJavaEntity onlCgformEnhanceJava){
		onlCgformEnhanceJavaService.updateById(onlCgformEnhanceJava);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:onlcgformenhancejava:delete")
    public R delete(@RequestBody String[] ids){
		onlCgformEnhanceJavaService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
