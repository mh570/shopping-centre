package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.TestPersonEntity;
import com.fengling.shopping.ware.service.TestPersonService;
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
@RequestMapping("ware/testperson")
public class TestPersonController {
    @Autowired
    private TestPersonService testPersonService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:testperson:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = testPersonService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:testperson:info")
    public R info(@PathVariable("id") String id){
		TestPersonEntity testPerson = testPersonService.getById(id);

        return R.ok().put("testPerson", testPerson);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:testperson:save")
    public R save(@RequestBody TestPersonEntity testPerson){
		testPersonService.save(testPerson);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:testperson:update")
    public R update(@RequestBody TestPersonEntity testPerson){
		testPersonService.updateById(testPerson);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:testperson:delete")
    public R delete(@RequestBody String[] ids){
		testPersonService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
