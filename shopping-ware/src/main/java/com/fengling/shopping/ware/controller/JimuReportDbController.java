package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.JimuReportDbEntity;
import com.fengling.shopping.ware.service.JimuReportDbService;
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
@RequestMapping("ware/jimureportdb")
public class JimuReportDbController {
    @Autowired
    private JimuReportDbService jimuReportDbService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:jimureportdb:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = jimuReportDbService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:jimureportdb:info")
    public R info(@PathVariable("id") String id){
		JimuReportDbEntity jimuReportDb = jimuReportDbService.getById(id);

        return R.ok().put("jimuReportDb", jimuReportDb);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:jimureportdb:save")
    public R save(@RequestBody JimuReportDbEntity jimuReportDb){
		jimuReportDbService.save(jimuReportDb);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:jimureportdb:update")
    public R update(@RequestBody JimuReportDbEntity jimuReportDb){
		jimuReportDbService.updateById(jimuReportDb);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:jimureportdb:delete")
    public R delete(@RequestBody String[] ids){
		jimuReportDbService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
