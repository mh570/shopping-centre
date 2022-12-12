package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.TestShoptypeTreeEntity;
import com.fengling.shopping.ware.service.TestShoptypeTreeService;
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
@RequestMapping("ware/testshoptypetree")
public class TestShoptypeTreeController {
    @Autowired
    private TestShoptypeTreeService testShoptypeTreeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:testshoptypetree:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = testShoptypeTreeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:testshoptypetree:info")
    public R info(@PathVariable("id") String id){
		TestShoptypeTreeEntity testShoptypeTree = testShoptypeTreeService.getById(id);

        return R.ok().put("testShoptypeTree", testShoptypeTree);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:testshoptypetree:save")
    public R save(@RequestBody TestShoptypeTreeEntity testShoptypeTree){
		testShoptypeTreeService.save(testShoptypeTree);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:testshoptypetree:update")
    public R update(@RequestBody TestShoptypeTreeEntity testShoptypeTree){
		testShoptypeTreeService.updateById(testShoptypeTree);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:testshoptypetree:delete")
    public R delete(@RequestBody String[] ids){
		testShoptypeTreeService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
