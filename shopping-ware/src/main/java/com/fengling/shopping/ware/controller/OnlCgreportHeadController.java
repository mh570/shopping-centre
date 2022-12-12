package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.OnlCgreportHeadEntity;
import com.fengling.shopping.ware.service.OnlCgreportHeadService;
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
@RequestMapping("ware/onlcgreporthead")
public class OnlCgreportHeadController {
    @Autowired
    private OnlCgreportHeadService onlCgreportHeadService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:onlcgreporthead:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = onlCgreportHeadService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:onlcgreporthead:info")
    public R info(@PathVariable("id") String id){
		OnlCgreportHeadEntity onlCgreportHead = onlCgreportHeadService.getById(id);

        return R.ok().put("onlCgreportHead", onlCgreportHead);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:onlcgreporthead:save")
    public R save(@RequestBody OnlCgreportHeadEntity onlCgreportHead){
		onlCgreportHeadService.save(onlCgreportHead);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:onlcgreporthead:update")
    public R update(@RequestBody OnlCgreportHeadEntity onlCgreportHead){
		onlCgreportHeadService.updateById(onlCgreportHead);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:onlcgreporthead:delete")
    public R delete(@RequestBody String[] ids){
		onlCgreportHeadService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
