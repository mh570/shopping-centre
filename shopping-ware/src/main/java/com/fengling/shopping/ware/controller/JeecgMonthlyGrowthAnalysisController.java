package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.JeecgMonthlyGrowthAnalysisEntity;
import com.fengling.shopping.ware.service.JeecgMonthlyGrowthAnalysisService;
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
@RequestMapping("ware/jeecgmonthlygrowthanalysis")
public class JeecgMonthlyGrowthAnalysisController {
    @Autowired
    private JeecgMonthlyGrowthAnalysisService jeecgMonthlyGrowthAnalysisService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:jeecgmonthlygrowthanalysis:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = jeecgMonthlyGrowthAnalysisService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:jeecgmonthlygrowthanalysis:info")
    public R info(@PathVariable("id") Integer id){
		JeecgMonthlyGrowthAnalysisEntity jeecgMonthlyGrowthAnalysis = jeecgMonthlyGrowthAnalysisService.getById(id);

        return R.ok().put("jeecgMonthlyGrowthAnalysis", jeecgMonthlyGrowthAnalysis);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:jeecgmonthlygrowthanalysis:save")
    public R save(@RequestBody JeecgMonthlyGrowthAnalysisEntity jeecgMonthlyGrowthAnalysis){
		jeecgMonthlyGrowthAnalysisService.save(jeecgMonthlyGrowthAnalysis);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:jeecgmonthlygrowthanalysis:update")
    public R update(@RequestBody JeecgMonthlyGrowthAnalysisEntity jeecgMonthlyGrowthAnalysis){
		jeecgMonthlyGrowthAnalysisService.updateById(jeecgMonthlyGrowthAnalysis);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:jeecgmonthlygrowthanalysis:delete")
    public R delete(@RequestBody Integer[] ids){
		jeecgMonthlyGrowthAnalysisService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
