package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.TestDemoEntity;
import com.fengling.shopping.ware.service.TestDemoService;
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
@RequestMapping("ware/testdemo")
public class TestDemoController {
    @Autowired
    private TestDemoService testDemoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:testdemo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = testDemoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:testdemo:info")
    public R info(@PathVariable("id") String id){
		TestDemoEntity testDemo = testDemoService.getById(id);

        return R.ok().put("testDemo", testDemo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:testdemo:save")
    public R save(@RequestBody TestDemoEntity testDemo){
		testDemoService.save(testDemo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:testdemo:update")
    public R update(@RequestBody TestDemoEntity testDemo){
		testDemoService.updateById(testDemo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:testdemo:delete")
    public R delete(@RequestBody String[] ids){
		testDemoService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
