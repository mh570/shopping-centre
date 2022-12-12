package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.DemoFieldDefValSubEntity;
import com.fengling.shopping.ware.service.DemoFieldDefValSubService;
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
@RequestMapping("ware/demofielddefvalsub")
public class DemoFieldDefValSubController {
    @Autowired
    private DemoFieldDefValSubService demoFieldDefValSubService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:demofielddefvalsub:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = demoFieldDefValSubService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:demofielddefvalsub:info")
    public R info(@PathVariable("id") String id){
		DemoFieldDefValSubEntity demoFieldDefValSub = demoFieldDefValSubService.getById(id);

        return R.ok().put("demoFieldDefValSub", demoFieldDefValSub);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:demofielddefvalsub:save")
    public R save(@RequestBody DemoFieldDefValSubEntity demoFieldDefValSub){
		demoFieldDefValSubService.save(demoFieldDefValSub);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:demofielddefvalsub:update")
    public R update(@RequestBody DemoFieldDefValSubEntity demoFieldDefValSub){
		demoFieldDefValSubService.updateById(demoFieldDefValSub);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:demofielddefvalsub:delete")
    public R delete(@RequestBody String[] ids){
		demoFieldDefValSubService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
