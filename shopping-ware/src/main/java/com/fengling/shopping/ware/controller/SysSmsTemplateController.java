package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.SysSmsTemplateEntity;
import com.fengling.shopping.ware.service.SysSmsTemplateService;
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
@RequestMapping("ware/syssmstemplate")
public class SysSmsTemplateController {
    @Autowired
    private SysSmsTemplateService sysSmsTemplateService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:syssmstemplate:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysSmsTemplateService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:syssmstemplate:info")
    public R info(@PathVariable("id") String id){
		SysSmsTemplateEntity sysSmsTemplate = sysSmsTemplateService.getById(id);

        return R.ok().put("sysSmsTemplate", sysSmsTemplate);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:syssmstemplate:save")
    public R save(@RequestBody SysSmsTemplateEntity sysSmsTemplate){
		sysSmsTemplateService.save(sysSmsTemplate);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:syssmstemplate:update")
    public R update(@RequestBody SysSmsTemplateEntity sysSmsTemplate){
		sysSmsTemplateService.updateById(sysSmsTemplate);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:syssmstemplate:delete")
    public R delete(@RequestBody String[] ids){
		sysSmsTemplateService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
