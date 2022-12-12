package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.JimuReportEntity;
import com.fengling.shopping.ware.service.JimuReportService;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.R;



/**
 * 在线excel设计器
 *
 * @author mh570
 * @email 2317295126@qq.com
 * @date 2022-12-12 22:19:34
 */
@RestController
@RequestMapping("ware/jimureport")
public class JimuReportController {
    @Autowired
    private JimuReportService jimuReportService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:jimureport:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = jimuReportService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:jimureport:info")
    public R info(@PathVariable("id") String id){
		JimuReportEntity jimuReport = jimuReportService.getById(id);

        return R.ok().put("jimuReport", jimuReport);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:jimureport:save")
    public R save(@RequestBody JimuReportEntity jimuReport){
		jimuReportService.save(jimuReport);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:jimureport:update")
    public R update(@RequestBody JimuReportEntity jimuReport){
		jimuReportService.updateById(jimuReport);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:jimureport:delete")
    public R delete(@RequestBody String[] ids){
		jimuReportService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
