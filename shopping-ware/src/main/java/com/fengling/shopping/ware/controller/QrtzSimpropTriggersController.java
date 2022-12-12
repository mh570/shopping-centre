package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.QrtzSimpropTriggersEntity;
import com.fengling.shopping.ware.service.QrtzSimpropTriggersService;
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
@RequestMapping("ware/qrtzsimproptriggers")
public class QrtzSimpropTriggersController {
    @Autowired
    private QrtzSimpropTriggersService qrtzSimpropTriggersService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:qrtzsimproptriggers:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = qrtzSimpropTriggersService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{schedName}")
    //@RequiresPermissions("ware:qrtzsimproptriggers:info")
    public R info(@PathVariable("schedName") String schedName){
		QrtzSimpropTriggersEntity qrtzSimpropTriggers = qrtzSimpropTriggersService.getById(schedName);

        return R.ok().put("qrtzSimpropTriggers", qrtzSimpropTriggers);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:qrtzsimproptriggers:save")
    public R save(@RequestBody QrtzSimpropTriggersEntity qrtzSimpropTriggers){
		qrtzSimpropTriggersService.save(qrtzSimpropTriggers);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:qrtzsimproptriggers:update")
    public R update(@RequestBody QrtzSimpropTriggersEntity qrtzSimpropTriggers){
		qrtzSimpropTriggersService.updateById(qrtzSimpropTriggers);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:qrtzsimproptriggers:delete")
    public R delete(@RequestBody String[] schedNames){
		qrtzSimpropTriggersService.removeByIds(Arrays.asList(schedNames));

        return R.ok();
    }

}
