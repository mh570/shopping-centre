package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.DemoFieldDefValMainEntity;
import com.fengling.shopping.ware.service.DemoFieldDefValMainService;
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
@RequestMapping("ware/demofielddefvalmain")
public class DemoFieldDefValMainController {
    @Autowired
    private DemoFieldDefValMainService demoFieldDefValMainService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:demofielddefvalmain:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = demoFieldDefValMainService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:demofielddefvalmain:info")
    public R info(@PathVariable("id") String id){
		DemoFieldDefValMainEntity demoFieldDefValMain = demoFieldDefValMainService.getById(id);

        return R.ok().put("demoFieldDefValMain", demoFieldDefValMain);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:demofielddefvalmain:save")
    public R save(@RequestBody DemoFieldDefValMainEntity demoFieldDefValMain){
		demoFieldDefValMainService.save(demoFieldDefValMain);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:demofielddefvalmain:update")
    public R update(@RequestBody DemoFieldDefValMainEntity demoFieldDefValMain){
		demoFieldDefValMainService.updateById(demoFieldDefValMain);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:demofielddefvalmain:delete")
    public R delete(@RequestBody String[] ids){
		demoFieldDefValMainService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
