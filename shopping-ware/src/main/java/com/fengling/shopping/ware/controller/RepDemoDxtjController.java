package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.RepDemoDxtjEntity;
import com.fengling.shopping.ware.service.RepDemoDxtjService;
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
@RequestMapping("ware/repdemodxtj")
public class RepDemoDxtjController {
    @Autowired
    private RepDemoDxtjService repDemoDxtjService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:repdemodxtj:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = repDemoDxtjService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:repdemodxtj:info")
    public R info(@PathVariable("id") String id){
		RepDemoDxtjEntity repDemoDxtj = repDemoDxtjService.getById(id);

        return R.ok().put("repDemoDxtj", repDemoDxtj);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:repdemodxtj:save")
    public R save(@RequestBody RepDemoDxtjEntity repDemoDxtj){
		repDemoDxtjService.save(repDemoDxtj);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:repdemodxtj:update")
    public R update(@RequestBody RepDemoDxtjEntity repDemoDxtj){
		repDemoDxtjService.updateById(repDemoDxtj);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:repdemodxtj:delete")
    public R delete(@RequestBody String[] ids){
		repDemoDxtjService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
