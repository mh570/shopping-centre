package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.TestNoteEntity;
import com.fengling.shopping.ware.service.TestNoteService;
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
@RequestMapping("ware/testnote")
public class TestNoteController {
    @Autowired
    private TestNoteService testNoteService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:testnote:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = testNoteService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:testnote:info")
    public R info(@PathVariable("id") String id){
		TestNoteEntity testNote = testNoteService.getById(id);

        return R.ok().put("testNote", testNote);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:testnote:save")
    public R save(@RequestBody TestNoteEntity testNote){
		testNoteService.save(testNote);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:testnote:update")
    public R update(@RequestBody TestNoteEntity testNote){
		testNoteService.updateById(testNote);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:testnote:delete")
    public R delete(@RequestBody String[] ids){
		testNoteService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
