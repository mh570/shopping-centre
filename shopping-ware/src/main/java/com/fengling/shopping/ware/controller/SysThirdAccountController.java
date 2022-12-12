package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.SysThirdAccountEntity;
import com.fengling.shopping.ware.service.SysThirdAccountService;
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
@RequestMapping("ware/systhirdaccount")
public class SysThirdAccountController {
    @Autowired
    private SysThirdAccountService sysThirdAccountService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:systhirdaccount:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysThirdAccountService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:systhirdaccount:info")
    public R info(@PathVariable("id") String id){
		SysThirdAccountEntity sysThirdAccount = sysThirdAccountService.getById(id);

        return R.ok().put("sysThirdAccount", sysThirdAccount);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:systhirdaccount:save")
    public R save(@RequestBody SysThirdAccountEntity sysThirdAccount){
		sysThirdAccountService.save(sysThirdAccount);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:systhirdaccount:update")
    public R update(@RequestBody SysThirdAccountEntity sysThirdAccount){
		sysThirdAccountService.updateById(sysThirdAccount);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:systhirdaccount:delete")
    public R delete(@RequestBody String[] ids){
		sysThirdAccountService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
