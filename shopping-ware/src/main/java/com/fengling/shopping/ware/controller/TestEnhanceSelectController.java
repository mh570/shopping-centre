package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.TestEnhanceSelectEntity;
import com.fengling.shopping.ware.service.TestEnhanceSelectService;
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
@RequestMapping("ware/testenhanceselect")
public class TestEnhanceSelectController {
    @Autowired
    private TestEnhanceSelectService testEnhanceSelectService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:testenhanceselect:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = testEnhanceSelectService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:testenhanceselect:info")
    public R info(@PathVariable("id") String id){
		TestEnhanceSelectEntity testEnhanceSelect = testEnhanceSelectService.getById(id);

        return R.ok().put("testEnhanceSelect", testEnhanceSelect);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:testenhanceselect:save")
    public R save(@RequestBody TestEnhanceSelectEntity testEnhanceSelect){
		testEnhanceSelectService.save(testEnhanceSelect);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:testenhanceselect:update")
    public R update(@RequestBody TestEnhanceSelectEntity testEnhanceSelect){
		testEnhanceSelectService.updateById(testEnhanceSelect);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:testenhanceselect:delete")
    public R delete(@RequestBody String[] ids){
		testEnhanceSelectService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
