package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.SysQuartzJobEntity;
import com.fengling.shopping.ware.service.SysQuartzJobService;
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
@RequestMapping("ware/sysquartzjob")
public class SysQuartzJobController {
    @Autowired
    private SysQuartzJobService sysQuartzJobService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:sysquartzjob:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysQuartzJobService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:sysquartzjob:info")
    public R info(@PathVariable("id") String id){
		SysQuartzJobEntity sysQuartzJob = sysQuartzJobService.getById(id);

        return R.ok().put("sysQuartzJob", sysQuartzJob);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:sysquartzjob:save")
    public R save(@RequestBody SysQuartzJobEntity sysQuartzJob){
		sysQuartzJobService.save(sysQuartzJob);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:sysquartzjob:update")
    public R update(@RequestBody SysQuartzJobEntity sysQuartzJob){
		sysQuartzJobService.updateById(sysQuartzJob);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:sysquartzjob:delete")
    public R delete(@RequestBody String[] ids){
		sysQuartzJobService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
