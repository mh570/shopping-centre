package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.JimuReportShareEntity;
import com.fengling.shopping.ware.service.JimuReportShareService;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.R;



/**
 * 积木报表预览权限表
 *
 * @author mh570
 * @email 2317295126@qq.com
 * @date 2022-12-12 22:19:34
 */
@RestController
@RequestMapping("ware/jimureportshare")
public class JimuReportShareController {
    @Autowired
    private JimuReportShareService jimuReportShareService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:jimureportshare:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = jimuReportShareService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:jimureportshare:info")
    public R info(@PathVariable("id") String id){
		JimuReportShareEntity jimuReportShare = jimuReportShareService.getById(id);

        return R.ok().put("jimuReportShare", jimuReportShare);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:jimureportshare:save")
    public R save(@RequestBody JimuReportShareEntity jimuReportShare){
		jimuReportShareService.save(jimuReportShare);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:jimureportshare:update")
    public R update(@RequestBody JimuReportShareEntity jimuReportShare){
		jimuReportShareService.updateById(jimuReportShare);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:jimureportshare:delete")
    public R delete(@RequestBody String[] ids){
		jimuReportShareService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
