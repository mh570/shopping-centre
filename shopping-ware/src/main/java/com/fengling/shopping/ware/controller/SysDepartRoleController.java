package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.SysDepartRoleEntity;
import com.fengling.shopping.ware.service.SysDepartRoleService;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.R;



/**
 * 部门角色表
 *
 * @author mh570
 * @email 2317295126@qq.com
 * @date 2022-12-12 22:19:34
 */
@RestController
@RequestMapping("ware/sysdepartrole")
public class SysDepartRoleController {
    @Autowired
    private SysDepartRoleService sysDepartRoleService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:sysdepartrole:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysDepartRoleService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:sysdepartrole:info")
    public R info(@PathVariable("id") String id){
		SysDepartRoleEntity sysDepartRole = sysDepartRoleService.getById(id);

        return R.ok().put("sysDepartRole", sysDepartRole);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:sysdepartrole:save")
    public R save(@RequestBody SysDepartRoleEntity sysDepartRole){
		sysDepartRoleService.save(sysDepartRole);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:sysdepartrole:update")
    public R update(@RequestBody SysDepartRoleEntity sysDepartRole){
		sysDepartRoleService.updateById(sysDepartRole);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:sysdepartrole:delete")
    public R delete(@RequestBody String[] ids){
		sysDepartRoleService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
