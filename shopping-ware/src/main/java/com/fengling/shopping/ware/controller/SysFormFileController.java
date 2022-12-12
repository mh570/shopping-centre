package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.SysFormFileEntity;
import com.fengling.shopping.ware.service.SysFormFileService;
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
@RequestMapping("ware/sysformfile")
public class SysFormFileController {
    @Autowired
    private SysFormFileService sysFormFileService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:sysformfile:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysFormFileService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:sysformfile:info")
    public R info(@PathVariable("id") String id){
		SysFormFileEntity sysFormFile = sysFormFileService.getById(id);

        return R.ok().put("sysFormFile", sysFormFile);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:sysformfile:save")
    public R save(@RequestBody SysFormFileEntity sysFormFile){
		sysFormFileService.save(sysFormFile);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:sysformfile:update")
    public R update(@RequestBody SysFormFileEntity sysFormFile){
		sysFormFileService.updateById(sysFormFile);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:sysformfile:delete")
    public R delete(@RequestBody String[] ids){
		sysFormFileService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
