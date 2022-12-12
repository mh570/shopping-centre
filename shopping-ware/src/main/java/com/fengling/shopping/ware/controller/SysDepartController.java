package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.SysDepartEntity;
import com.fengling.shopping.ware.service.SysDepartService;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.R;



/**
 * 组织机构表
 *
 * @author mh570
 * @email 2317295126@qq.com
 * @date 2022-12-12 22:19:34
 */
@RestController
@RequestMapping("ware/sysdepart")
public class SysDepartController {
    @Autowired
    private SysDepartService sysDepartService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:sysdepart:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysDepartService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:sysdepart:info")
    public R info(@PathVariable("id") String id){
		SysDepartEntity sysDepart = sysDepartService.getById(id);

        return R.ok().put("sysDepart", sysDepart);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:sysdepart:save")
    public R save(@RequestBody SysDepartEntity sysDepart){
		sysDepartService.save(sysDepart);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:sysdepart:update")
    public R update(@RequestBody SysDepartEntity sysDepart){
		sysDepartService.updateById(sysDepart);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:sysdepart:delete")
    public R delete(@RequestBody String[] ids){
		sysDepartService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
