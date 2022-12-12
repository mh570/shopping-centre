package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.RepDemoEmployeeEntity;
import com.fengling.shopping.ware.service.RepDemoEmployeeService;
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
@RequestMapping("ware/repdemoemployee")
public class RepDemoEmployeeController {
    @Autowired
    private RepDemoEmployeeService repDemoEmployeeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:repdemoemployee:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = repDemoEmployeeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:repdemoemployee:info")
    public R info(@PathVariable("id") String id){
		RepDemoEmployeeEntity repDemoEmployee = repDemoEmployeeService.getById(id);

        return R.ok().put("repDemoEmployee", repDemoEmployee);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:repdemoemployee:save")
    public R save(@RequestBody RepDemoEmployeeEntity repDemoEmployee){
		repDemoEmployeeService.save(repDemoEmployee);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:repdemoemployee:update")
    public R update(@RequestBody RepDemoEmployeeEntity repDemoEmployee){
		repDemoEmployeeService.updateById(repDemoEmployee);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:repdemoemployee:delete")
    public R delete(@RequestBody String[] ids){
		repDemoEmployeeService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
