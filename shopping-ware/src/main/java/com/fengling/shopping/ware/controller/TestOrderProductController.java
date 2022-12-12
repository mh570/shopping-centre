package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.TestOrderProductEntity;
import com.fengling.shopping.ware.service.TestOrderProductService;
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
@RequestMapping("ware/testorderproduct")
public class TestOrderProductController {
    @Autowired
    private TestOrderProductService testOrderProductService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:testorderproduct:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = testOrderProductService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:testorderproduct:info")
    public R info(@PathVariable("id") String id){
		TestOrderProductEntity testOrderProduct = testOrderProductService.getById(id);

        return R.ok().put("testOrderProduct", testOrderProduct);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:testorderproduct:save")
    public R save(@RequestBody TestOrderProductEntity testOrderProduct){
		testOrderProductService.save(testOrderProduct);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:testorderproduct:update")
    public R update(@RequestBody TestOrderProductEntity testOrderProduct){
		testOrderProductService.updateById(testOrderProduct);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:testorderproduct:delete")
    public R delete(@RequestBody String[] ids){
		testOrderProductService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
