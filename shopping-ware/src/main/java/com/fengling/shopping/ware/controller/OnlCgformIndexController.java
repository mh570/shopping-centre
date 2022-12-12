package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.OnlCgformIndexEntity;
import com.fengling.shopping.ware.service.OnlCgformIndexService;
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
@RequestMapping("ware/onlcgformindex")
public class OnlCgformIndexController {
    @Autowired
    private OnlCgformIndexService onlCgformIndexService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:onlcgformindex:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = onlCgformIndexService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:onlcgformindex:info")
    public R info(@PathVariable("id") String id){
		OnlCgformIndexEntity onlCgformIndex = onlCgformIndexService.getById(id);

        return R.ok().put("onlCgformIndex", onlCgformIndex);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:onlcgformindex:save")
    public R save(@RequestBody OnlCgformIndexEntity onlCgformIndex){
		onlCgformIndexService.save(onlCgformIndex);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:onlcgformindex:update")
    public R update(@RequestBody OnlCgformIndexEntity onlCgformIndex){
		onlCgformIndexService.updateById(onlCgformIndex);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:onlcgformindex:delete")
    public R delete(@RequestBody String[] ids){
		onlCgformIndexService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
