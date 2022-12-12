package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.TmpReportDataIncomeEntity;
import com.fengling.shopping.ware.service.TmpReportDataIncomeService;
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
@RequestMapping("ware/tmpreportdataincome")
public class TmpReportDataIncomeController {
    @Autowired
    private TmpReportDataIncomeService tmpReportDataIncomeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:tmpreportdataincome:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = tmpReportDataIncomeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{bizIncome}")
    //@RequiresPermissions("ware:tmpreportdataincome:info")
    public R info(@PathVariable("bizIncome") String bizIncome){
		TmpReportDataIncomeEntity tmpReportDataIncome = tmpReportDataIncomeService.getById(bizIncome);

        return R.ok().put("tmpReportDataIncome", tmpReportDataIncome);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:tmpreportdataincome:save")
    public R save(@RequestBody TmpReportDataIncomeEntity tmpReportDataIncome){
		tmpReportDataIncomeService.save(tmpReportDataIncome);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:tmpreportdataincome:update")
    public R update(@RequestBody TmpReportDataIncomeEntity tmpReportDataIncome){
		tmpReportDataIncomeService.updateById(tmpReportDataIncome);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:tmpreportdataincome:delete")
    public R delete(@RequestBody String[] bizIncomes){
		tmpReportDataIncomeService.removeByIds(Arrays.asList(bizIncomes));

        return R.ok();
    }

}
