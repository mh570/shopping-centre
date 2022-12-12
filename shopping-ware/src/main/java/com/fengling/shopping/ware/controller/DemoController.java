package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.DemoEntity;
import com.fengling.shopping.ware.service.DemoService;
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
@RequestMapping("ware/demo")
public class DemoController {
    @Autowired
    private DemoService demoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:demo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = demoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:demo:info")
    public R info(@PathVariable("id") String id){
		DemoEntity demo = demoService.getById(id);

        return R.ok().put("demo", demo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:demo:save")
    public R save(@RequestBody DemoEntity demo){
		demoService.save(demo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:demo:update")
    public R update(@RequestBody DemoEntity demo){
		demoService.updateById(demo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:demo:delete")
    public R delete(@RequestBody String[] ids){
		demoService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
