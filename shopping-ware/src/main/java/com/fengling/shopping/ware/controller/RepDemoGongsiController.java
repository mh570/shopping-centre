package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.RepDemoGongsiEntity;
import com.fengling.shopping.ware.service.RepDemoGongsiService;
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
@RequestMapping("ware/repdemogongsi")
public class RepDemoGongsiController {
    @Autowired
    private RepDemoGongsiService repDemoGongsiService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:repdemogongsi:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = repDemoGongsiService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:repdemogongsi:info")
    public R info(@PathVariable("id") Integer id){
		RepDemoGongsiEntity repDemoGongsi = repDemoGongsiService.getById(id);

        return R.ok().put("repDemoGongsi", repDemoGongsi);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:repdemogongsi:save")
    public R save(@RequestBody RepDemoGongsiEntity repDemoGongsi){
		repDemoGongsiService.save(repDemoGongsi);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:repdemogongsi:update")
    public R update(@RequestBody RepDemoGongsiEntity repDemoGongsi){
		repDemoGongsiService.updateById(repDemoGongsi);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:repdemogongsi:delete")
    public R delete(@RequestBody Integer[] ids){
		repDemoGongsiService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
