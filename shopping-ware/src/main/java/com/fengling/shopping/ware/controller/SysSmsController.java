package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.SysSmsEntity;
import com.fengling.shopping.ware.service.SysSmsService;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.R;



/**
 * 
 *
 * @author mh570
 * @email 2317295126@qq.com
 * @date 2022-12-12 22:19:33
 */
@RestController
@RequestMapping("ware/syssms")
public class SysSmsController {
    @Autowired
    private SysSmsService sysSmsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:syssms:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysSmsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:syssms:info")
    public R info(@PathVariable("id") String id){
		SysSmsEntity sysSms = sysSmsService.getById(id);

        return R.ok().put("sysSms", sysSms);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:syssms:save")
    public R save(@RequestBody SysSmsEntity sysSms){
		sysSmsService.save(sysSms);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:syssms:update")
    public R update(@RequestBody SysSmsEntity sysSms){
		sysSmsService.updateById(sysSms);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:syssms:delete")
    public R delete(@RequestBody String[] ids){
		sysSmsService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
