package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.JimuReportDbFieldEntity;
import com.fengling.shopping.ware.service.JimuReportDbFieldService;
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
@RequestMapping("ware/jimureportdbfield")
public class JimuReportDbFieldController {
    @Autowired
    private JimuReportDbFieldService jimuReportDbFieldService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:jimureportdbfield:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = jimuReportDbFieldService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:jimureportdbfield:info")
    public R info(@PathVariable("id") String id){
		JimuReportDbFieldEntity jimuReportDbField = jimuReportDbFieldService.getById(id);

        return R.ok().put("jimuReportDbField", jimuReportDbField);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:jimureportdbfield:save")
    public R save(@RequestBody JimuReportDbFieldEntity jimuReportDbField){
		jimuReportDbFieldService.save(jimuReportDbField);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:jimureportdbfield:update")
    public R update(@RequestBody JimuReportDbFieldEntity jimuReportDbField){
		jimuReportDbFieldService.updateById(jimuReportDbField);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:jimureportdbfield:delete")
    public R delete(@RequestBody String[] ids){
		jimuReportDbFieldService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
