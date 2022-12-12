package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.JimuReportDataSourceEntity;
import com.fengling.shopping.ware.service.JimuReportDataSourceService;
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
@RequestMapping("ware/jimureportdatasource")
public class JimuReportDataSourceController {
    @Autowired
    private JimuReportDataSourceService jimuReportDataSourceService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:jimureportdatasource:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = jimuReportDataSourceService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:jimureportdatasource:info")
    public R info(@PathVariable("id") String id){
		JimuReportDataSourceEntity jimuReportDataSource = jimuReportDataSourceService.getById(id);

        return R.ok().put("jimuReportDataSource", jimuReportDataSource);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:jimureportdatasource:save")
    public R save(@RequestBody JimuReportDataSourceEntity jimuReportDataSource){
		jimuReportDataSourceService.save(jimuReportDataSource);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:jimureportdatasource:update")
    public R update(@RequestBody JimuReportDataSourceEntity jimuReportDataSource){
		jimuReportDataSourceService.updateById(jimuReportDataSource);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:jimureportdatasource:delete")
    public R delete(@RequestBody String[] ids){
		jimuReportDataSourceService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
