package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.SysFilesEntity;
import com.fengling.shopping.ware.service.SysFilesService;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.R;



/**
 * 知识库-文档管理
 *
 * @author mh570
 * @email 2317295126@qq.com
 * @date 2022-12-12 22:19:34
 */
@RestController
@RequestMapping("ware/sysfiles")
public class SysFilesController {
    @Autowired
    private SysFilesService sysFilesService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:sysfiles:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysFilesService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:sysfiles:info")
    public R info(@PathVariable("id") String id){
		SysFilesEntity sysFiles = sysFilesService.getById(id);

        return R.ok().put("sysFiles", sysFiles);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:sysfiles:save")
    public R save(@RequestBody SysFilesEntity sysFiles){
		sysFilesService.save(sysFiles);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:sysfiles:update")
    public R update(@RequestBody SysFilesEntity sysFiles){
		sysFilesService.updateById(sysFiles);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:sysfiles:delete")
    public R delete(@RequestBody String[] ids){
		sysFilesService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
