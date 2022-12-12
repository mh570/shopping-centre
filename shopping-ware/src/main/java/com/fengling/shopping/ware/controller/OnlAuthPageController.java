package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.OnlAuthPageEntity;
import com.fengling.shopping.ware.service.OnlAuthPageService;
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
@RequestMapping("ware/onlauthpage")
public class OnlAuthPageController {
    @Autowired
    private OnlAuthPageService onlAuthPageService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:onlauthpage:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = onlAuthPageService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:onlauthpage:info")
    public R info(@PathVariable("id") String id){
		OnlAuthPageEntity onlAuthPage = onlAuthPageService.getById(id);

        return R.ok().put("onlAuthPage", onlAuthPage);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:onlauthpage:save")
    public R save(@RequestBody OnlAuthPageEntity onlAuthPage){
		onlAuthPageService.save(onlAuthPage);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:onlauthpage:update")
    public R update(@RequestBody OnlAuthPageEntity onlAuthPage){
		onlAuthPageService.updateById(onlAuthPage);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:onlauthpage:delete")
    public R delete(@RequestBody String[] ids){
		onlAuthPageService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
