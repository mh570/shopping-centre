package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.SysDepartRoleUserEntity;
import com.fengling.shopping.ware.service.SysDepartRoleUserService;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.R;



/**
 * 部门角色用户表
 *
 * @author mh570
 * @email 2317295126@qq.com
 * @date 2022-12-12 22:19:33
 */
@RestController
@RequestMapping("ware/sysdepartroleuser")
public class SysDepartRoleUserController {
    @Autowired
    private SysDepartRoleUserService sysDepartRoleUserService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:sysdepartroleuser:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysDepartRoleUserService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:sysdepartroleuser:info")
    public R info(@PathVariable("id") String id){
		SysDepartRoleUserEntity sysDepartRoleUser = sysDepartRoleUserService.getById(id);

        return R.ok().put("sysDepartRoleUser", sysDepartRoleUser);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:sysdepartroleuser:save")
    public R save(@RequestBody SysDepartRoleUserEntity sysDepartRoleUser){
		sysDepartRoleUserService.save(sysDepartRoleUser);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:sysdepartroleuser:update")
    public R update(@RequestBody SysDepartRoleUserEntity sysDepartRoleUser){
		sysDepartRoleUserService.updateById(sysDepartRoleUser);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:sysdepartroleuser:delete")
    public R delete(@RequestBody String[] ids){
		sysDepartRoleUserService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
