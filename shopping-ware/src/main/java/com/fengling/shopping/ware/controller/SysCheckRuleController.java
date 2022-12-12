package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.SysCheckRuleEntity;
import com.fengling.shopping.ware.service.SysCheckRuleService;
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
@RequestMapping("ware/syscheckrule")
public class SysCheckRuleController {
    @Autowired
    private SysCheckRuleService sysCheckRuleService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:syscheckrule:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysCheckRuleService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:syscheckrule:info")
    public R info(@PathVariable("id") String id){
		SysCheckRuleEntity sysCheckRule = sysCheckRuleService.getById(id);

        return R.ok().put("sysCheckRule", sysCheckRule);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:syscheckrule:save")
    public R save(@RequestBody SysCheckRuleEntity sysCheckRule){
		sysCheckRuleService.save(sysCheckRule);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:syscheckrule:update")
    public R update(@RequestBody SysCheckRuleEntity sysCheckRule){
		sysCheckRuleService.updateById(sysCheckRule);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:syscheckrule:delete")
    public R delete(@RequestBody String[] ids){
		sysCheckRuleService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
