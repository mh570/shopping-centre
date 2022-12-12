package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.JimuReportDbParamEntity;
import com.fengling.shopping.ware.service.JimuReportDbParamService;
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
@RequestMapping("ware/jimureportdbparam")
public class JimuReportDbParamController {
    @Autowired
    private JimuReportDbParamService jimuReportDbParamService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:jimureportdbparam:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = jimuReportDbParamService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:jimureportdbparam:info")
    public R info(@PathVariable("id") String id){
		JimuReportDbParamEntity jimuReportDbParam = jimuReportDbParamService.getById(id);

        return R.ok().put("jimuReportDbParam", jimuReportDbParam);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:jimureportdbparam:save")
    public R save(@RequestBody JimuReportDbParamEntity jimuReportDbParam){
		jimuReportDbParamService.save(jimuReportDbParam);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:jimureportdbparam:update")
    public R update(@RequestBody JimuReportDbParamEntity jimuReportDbParam){
		jimuReportDbParamService.updateById(jimuReportDbParam);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:jimureportdbparam:delete")
    public R delete(@RequestBody String[] ids){
		jimuReportDbParamService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
