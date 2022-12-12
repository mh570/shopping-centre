package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.SysDataSourceEntity;
import com.fengling.shopping.ware.service.SysDataSourceService;
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
@RequestMapping("ware/sysdatasource")
public class SysDataSourceController {
    @Autowired
    private SysDataSourceService sysDataSourceService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:sysdatasource:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysDataSourceService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:sysdatasource:info")
    public R info(@PathVariable("id") String id){
		SysDataSourceEntity sysDataSource = sysDataSourceService.getById(id);

        return R.ok().put("sysDataSource", sysDataSource);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:sysdatasource:save")
    public R save(@RequestBody SysDataSourceEntity sysDataSource){
		sysDataSourceService.save(sysDataSource);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:sysdatasource:update")
    public R update(@RequestBody SysDataSourceEntity sysDataSource){
		sysDataSourceService.updateById(sysDataSource);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:sysdatasource:delete")
    public R delete(@RequestBody String[] ids){
		sysDataSourceService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
