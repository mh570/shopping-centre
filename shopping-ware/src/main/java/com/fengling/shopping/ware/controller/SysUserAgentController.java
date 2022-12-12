package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.SysUserAgentEntity;
import com.fengling.shopping.ware.service.SysUserAgentService;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.R;



/**
 * 用户代理人设置
 *
 * @author mh570
 * @email 2317295126@qq.com
 * @date 2022-12-12 22:19:34
 */
@RestController
@RequestMapping("ware/sysuseragent")
public class SysUserAgentController {
    @Autowired
    private SysUserAgentService sysUserAgentService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:sysuseragent:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysUserAgentService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:sysuseragent:info")
    public R info(@PathVariable("id") String id){
		SysUserAgentEntity sysUserAgent = sysUserAgentService.getById(id);

        return R.ok().put("sysUserAgent", sysUserAgent);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:sysuseragent:save")
    public R save(@RequestBody SysUserAgentEntity sysUserAgent){
		sysUserAgentService.save(sysUserAgent);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:sysuseragent:update")
    public R update(@RequestBody SysUserAgentEntity sysUserAgent){
		sysUserAgentService.updateById(sysUserAgent);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:sysuseragent:delete")
    public R delete(@RequestBody String[] ids){
		sysUserAgentService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
