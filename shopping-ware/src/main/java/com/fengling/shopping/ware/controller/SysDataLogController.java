package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.SysDataLogEntity;
import com.fengling.shopping.ware.service.SysDataLogService;
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
@RequestMapping("ware/sysdatalog")
public class SysDataLogController {
    @Autowired
    private SysDataLogService sysDataLogService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:sysdatalog:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysDataLogService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:sysdatalog:info")
    public R info(@PathVariable("id") String id){
		SysDataLogEntity sysDataLog = sysDataLogService.getById(id);

        return R.ok().put("sysDataLog", sysDataLog);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:sysdatalog:save")
    public R save(@RequestBody SysDataLogEntity sysDataLog){
		sysDataLogService.save(sysDataLog);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:sysdatalog:update")
    public R update(@RequestBody SysDataLogEntity sysDataLog){
		sysDataLogService.updateById(sysDataLog);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:sysdatalog:delete")
    public R delete(@RequestBody String[] ids){
		sysDataLogService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
