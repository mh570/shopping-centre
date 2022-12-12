package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.SysFillRuleEntity;
import com.fengling.shopping.ware.service.SysFillRuleService;
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
@RequestMapping("ware/sysfillrule")
public class SysFillRuleController {
    @Autowired
    private SysFillRuleService sysFillRuleService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:sysfillrule:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysFillRuleService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:sysfillrule:info")
    public R info(@PathVariable("id") String id){
		SysFillRuleEntity sysFillRule = sysFillRuleService.getById(id);

        return R.ok().put("sysFillRule", sysFillRule);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:sysfillrule:save")
    public R save(@RequestBody SysFillRuleEntity sysFillRule){
		sysFillRuleService.save(sysFillRule);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:sysfillrule:update")
    public R update(@RequestBody SysFillRuleEntity sysFillRule){
		sysFillRuleService.updateById(sysFillRule);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:sysfillrule:delete")
    public R delete(@RequestBody String[] ids){
		sysFillRuleService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
