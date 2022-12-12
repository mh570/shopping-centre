package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.JimuReportMapEntity;
import com.fengling.shopping.ware.service.JimuReportMapService;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.R;



/**
 * 地图配置表
 *
 * @author mh570
 * @email 2317295126@qq.com
 * @date 2022-12-12 22:19:34
 */
@RestController
@RequestMapping("ware/jimureportmap")
public class JimuReportMapController {
    @Autowired
    private JimuReportMapService jimuReportMapService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:jimureportmap:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = jimuReportMapService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:jimureportmap:info")
    public R info(@PathVariable("id") String id){
		JimuReportMapEntity jimuReportMap = jimuReportMapService.getById(id);

        return R.ok().put("jimuReportMap", jimuReportMap);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:jimureportmap:save")
    public R save(@RequestBody JimuReportMapEntity jimuReportMap){
		jimuReportMapService.save(jimuReportMap);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:jimureportmap:update")
    public R update(@RequestBody JimuReportMapEntity jimuReportMap){
		jimuReportMapService.updateById(jimuReportMap);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:jimureportmap:delete")
    public R delete(@RequestBody String[] ids){
		jimuReportMapService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
