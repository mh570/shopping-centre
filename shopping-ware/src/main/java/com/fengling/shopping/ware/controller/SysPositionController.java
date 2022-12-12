package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.SysPositionEntity;
import com.fengling.shopping.ware.service.SysPositionService;
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
@RequestMapping("ware/sysposition")
public class SysPositionController {
    @Autowired
    private SysPositionService sysPositionService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:sysposition:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysPositionService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:sysposition:info")
    public R info(@PathVariable("id") String id){
		SysPositionEntity sysPosition = sysPositionService.getById(id);

        return R.ok().put("sysPosition", sysPosition);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:sysposition:save")
    public R save(@RequestBody SysPositionEntity sysPosition){
		sysPositionService.save(sysPosition);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:sysposition:update")
    public R update(@RequestBody SysPositionEntity sysPosition){
		sysPositionService.updateById(sysPosition);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:sysposition:delete")
    public R delete(@RequestBody String[] ids){
		sysPositionService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
