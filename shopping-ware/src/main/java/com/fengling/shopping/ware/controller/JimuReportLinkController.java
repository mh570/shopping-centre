package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.JimuReportLinkEntity;
import com.fengling.shopping.ware.service.JimuReportLinkService;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.R;



/**
 * 超链接配置表
 *
 * @author mh570
 * @email 2317295126@qq.com
 * @date 2022-12-12 22:19:34
 */
@RestController
@RequestMapping("ware/jimureportlink")
public class JimuReportLinkController {
    @Autowired
    private JimuReportLinkService jimuReportLinkService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:jimureportlink:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = jimuReportLinkService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:jimureportlink:info")
    public R info(@PathVariable("id") String id){
		JimuReportLinkEntity jimuReportLink = jimuReportLinkService.getById(id);

        return R.ok().put("jimuReportLink", jimuReportLink);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:jimureportlink:save")
    public R save(@RequestBody JimuReportLinkEntity jimuReportLink){
		jimuReportLinkService.save(jimuReportLink);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:jimureportlink:update")
    public R update(@RequestBody JimuReportLinkEntity jimuReportLink){
		jimuReportLinkService.updateById(jimuReportLink);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:jimureportlink:delete")
    public R delete(@RequestBody String[] ids){
		jimuReportLinkService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
