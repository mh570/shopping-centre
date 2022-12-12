package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.OnlCgformButtonEntity;
import com.fengling.shopping.ware.service.OnlCgformButtonService;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.R;



/**
 * Online表单自定义按钮
 *
 * @author mh570
 * @email 2317295126@qq.com
 * @date 2022-12-12 22:19:34
 */
@RestController
@RequestMapping("ware/onlcgformbutton")
public class OnlCgformButtonController {
    @Autowired
    private OnlCgformButtonService onlCgformButtonService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:onlcgformbutton:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = onlCgformButtonService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:onlcgformbutton:info")
    public R info(@PathVariable("id") String id){
		OnlCgformButtonEntity onlCgformButton = onlCgformButtonService.getById(id);

        return R.ok().put("onlCgformButton", onlCgformButton);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:onlcgformbutton:save")
    public R save(@RequestBody OnlCgformButtonEntity onlCgformButton){
		onlCgformButtonService.save(onlCgformButton);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:onlcgformbutton:update")
    public R update(@RequestBody OnlCgformButtonEntity onlCgformButton){
		onlCgformButtonService.updateById(onlCgformButton);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:onlcgformbutton:delete")
    public R delete(@RequestBody String[] ids){
		onlCgformButtonService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
