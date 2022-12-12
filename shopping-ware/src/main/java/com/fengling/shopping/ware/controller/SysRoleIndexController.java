package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.SysRoleIndexEntity;
import com.fengling.shopping.ware.service.SysRoleIndexService;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.R;



/**
 * 角色首页表
 *
 * @author mh570
 * @email 2317295126@qq.com
 * @date 2022-12-12 22:19:33
 */
@RestController
@RequestMapping("ware/sysroleindex")
public class SysRoleIndexController {
    @Autowired
    private SysRoleIndexService sysRoleIndexService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:sysroleindex:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysRoleIndexService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:sysroleindex:info")
    public R info(@PathVariable("id") String id){
		SysRoleIndexEntity sysRoleIndex = sysRoleIndexService.getById(id);

        return R.ok().put("sysRoleIndex", sysRoleIndex);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:sysroleindex:save")
    public R save(@RequestBody SysRoleIndexEntity sysRoleIndex){
		sysRoleIndexService.save(sysRoleIndex);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:sysroleindex:update")
    public R update(@RequestBody SysRoleIndexEntity sysRoleIndex){
		sysRoleIndexService.updateById(sysRoleIndex);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:sysroleindex:delete")
    public R delete(@RequestBody String[] ids){
		sysRoleIndexService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
