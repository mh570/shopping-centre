package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.OnlCgformFieldEntity;
import com.fengling.shopping.ware.service.OnlCgformFieldService;
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
@RequestMapping("ware/onlcgformfield")
public class OnlCgformFieldController {
    @Autowired
    private OnlCgformFieldService onlCgformFieldService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:onlcgformfield:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = onlCgformFieldService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:onlcgformfield:info")
    public R info(@PathVariable("id") String id){
		OnlCgformFieldEntity onlCgformField = onlCgformFieldService.getById(id);

        return R.ok().put("onlCgformField", onlCgformField);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:onlcgformfield:save")
    public R save(@RequestBody OnlCgformFieldEntity onlCgformField){
		onlCgformFieldService.save(onlCgformField);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:onlcgformfield:update")
    public R update(@RequestBody OnlCgformFieldEntity onlCgformField){
		onlCgformFieldService.updateById(onlCgformField);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:onlcgformfield:delete")
    public R delete(@RequestBody String[] ids){
		onlCgformFieldService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
