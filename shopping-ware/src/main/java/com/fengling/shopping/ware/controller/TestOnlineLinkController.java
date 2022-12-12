package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.TestOnlineLinkEntity;
import com.fengling.shopping.ware.service.TestOnlineLinkService;
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
@RequestMapping("ware/testonlinelink")
public class TestOnlineLinkController {
    @Autowired
    private TestOnlineLinkService testOnlineLinkService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:testonlinelink:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = testOnlineLinkService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:testonlinelink:info")
    public R info(@PathVariable("id") String id){
		TestOnlineLinkEntity testOnlineLink = testOnlineLinkService.getById(id);

        return R.ok().put("testOnlineLink", testOnlineLink);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:testonlinelink:save")
    public R save(@RequestBody TestOnlineLinkEntity testOnlineLink){
		testOnlineLinkService.save(testOnlineLink);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:testonlinelink:update")
    public R update(@RequestBody TestOnlineLinkEntity testOnlineLink){
		testOnlineLinkService.updateById(testOnlineLink);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:testonlinelink:delete")
    public R delete(@RequestBody String[] ids){
		testOnlineLinkService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
