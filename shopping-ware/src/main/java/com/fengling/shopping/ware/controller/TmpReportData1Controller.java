package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.TmpReportData1Entity;
import com.fengling.shopping.ware.service.TmpReportData1Service;
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
@RequestMapping("ware/tmpreportdata1")
public class TmpReportData1Controller {
    @Autowired
    private TmpReportData1Service tmpReportData1Service;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:tmpreportdata1:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = tmpReportData1Service.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{monty}")
    //@RequiresPermissions("ware:tmpreportdata1:info")
    public R info(@PathVariable("monty") String monty){
		TmpReportData1Entity tmpReportData1 = tmpReportData1Service.getById(monty);

        return R.ok().put("tmpReportData1", tmpReportData1);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:tmpreportdata1:save")
    public R save(@RequestBody TmpReportData1Entity tmpReportData1){
		tmpReportData1Service.save(tmpReportData1);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:tmpreportdata1:update")
    public R update(@RequestBody TmpReportData1Entity tmpReportData1){
		tmpReportData1Service.updateById(tmpReportData1);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:tmpreportdata1:delete")
    public R delete(@RequestBody String[] montys){
		tmpReportData1Service.removeByIds(Arrays.asList(montys));

        return R.ok();
    }

}
