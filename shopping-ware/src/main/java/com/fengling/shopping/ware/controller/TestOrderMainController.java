package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.TestOrderMainEntity;
import com.fengling.shopping.ware.service.TestOrderMainService;
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
@RequestMapping("ware/testordermain")
public class TestOrderMainController {
    @Autowired
    private TestOrderMainService testOrderMainService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:testordermain:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = testOrderMainService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:testordermain:info")
    public R info(@PathVariable("id") String id){
		TestOrderMainEntity testOrderMain = testOrderMainService.getById(id);

        return R.ok().put("testOrderMain", testOrderMain);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:testordermain:save")
    public R save(@RequestBody TestOrderMainEntity testOrderMain){
		testOrderMainService.save(testOrderMain);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:testordermain:update")
    public R update(@RequestBody TestOrderMainEntity testOrderMain){
		testOrderMainService.updateById(testOrderMain);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:testordermain:delete")
    public R delete(@RequestBody String[] ids){
		testOrderMainService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
