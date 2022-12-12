package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.CeshiSub01Entity;
import com.fengling.shopping.ware.service.CeshiSub01Service;
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
@RequestMapping("ware/ceshisub01")
public class CeshiSub01Controller {
    @Autowired
    private CeshiSub01Service ceshiSub01Service;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:ceshisub01:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = ceshiSub01Service.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:ceshisub01:info")
    public R info(@PathVariable("id") String id){
		CeshiSub01Entity ceshiSub01 = ceshiSub01Service.getById(id);

        return R.ok().put("ceshiSub01", ceshiSub01);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:ceshisub01:save")
    public R save(@RequestBody CeshiSub01Entity ceshiSub01){
		ceshiSub01Service.save(ceshiSub01);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:ceshisub01:update")
    public R update(@RequestBody CeshiSub01Entity ceshiSub01){
		ceshiSub01Service.updateById(ceshiSub01);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:ceshisub01:delete")
    public R delete(@RequestBody String[] ids){
		ceshiSub01Service.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
