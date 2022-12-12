package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.OnlCgreportItemEntity;
import com.fengling.shopping.ware.service.OnlCgreportItemService;
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
@RequestMapping("ware/onlcgreportitem")
public class OnlCgreportItemController {
    @Autowired
    private OnlCgreportItemService onlCgreportItemService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:onlcgreportitem:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = onlCgreportItemService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:onlcgreportitem:info")
    public R info(@PathVariable("id") String id){
		OnlCgreportItemEntity onlCgreportItem = onlCgreportItemService.getById(id);

        return R.ok().put("onlCgreportItem", onlCgreportItem);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:onlcgreportitem:save")
    public R save(@RequestBody OnlCgreportItemEntity onlCgreportItem){
		onlCgreportItemService.save(onlCgreportItem);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:onlcgreportitem:update")
    public R update(@RequestBody OnlCgreportItemEntity onlCgreportItem){
		onlCgreportItemService.updateById(onlCgreportItem);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:onlcgreportitem:delete")
    public R delete(@RequestBody String[] ids){
		onlCgreportItemService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
