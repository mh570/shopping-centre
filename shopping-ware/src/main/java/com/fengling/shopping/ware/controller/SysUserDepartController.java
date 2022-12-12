package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.SysUserDepartEntity;
import com.fengling.shopping.ware.service.SysUserDepartService;
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
@RequestMapping("ware/sysuserdepart")
public class SysUserDepartController {
    @Autowired
    private SysUserDepartService sysUserDepartService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:sysuserdepart:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysUserDepartService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:sysuserdepart:info")
    public R info(@PathVariable("id") String id){
		SysUserDepartEntity sysUserDepart = sysUserDepartService.getById(id);

        return R.ok().put("sysUserDepart", sysUserDepart);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:sysuserdepart:save")
    public R save(@RequestBody SysUserDepartEntity sysUserDepart){
		sysUserDepartService.save(sysUserDepart);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:sysuserdepart:update")
    public R update(@RequestBody SysUserDepartEntity sysUserDepart){
		sysUserDepartService.updateById(sysUserDepart);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:sysuserdepart:delete")
    public R delete(@RequestBody String[] ids){
		sysUserDepartService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
