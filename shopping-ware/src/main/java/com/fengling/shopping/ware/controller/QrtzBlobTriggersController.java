package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.QrtzBlobTriggersEntity;
import com.fengling.shopping.ware.service.QrtzBlobTriggersService;
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
@RequestMapping("ware/qrtzblobtriggers")
public class QrtzBlobTriggersController {
    @Autowired
    private QrtzBlobTriggersService qrtzBlobTriggersService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:qrtzblobtriggers:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = qrtzBlobTriggersService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{schedName}")
    //@RequiresPermissions("ware:qrtzblobtriggers:info")
    public R info(@PathVariable("schedName") String schedName){
		QrtzBlobTriggersEntity qrtzBlobTriggers = qrtzBlobTriggersService.getById(schedName);

        return R.ok().put("qrtzBlobTriggers", qrtzBlobTriggers);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:qrtzblobtriggers:save")
    public R save(@RequestBody QrtzBlobTriggersEntity qrtzBlobTriggers){
		qrtzBlobTriggersService.save(qrtzBlobTriggers);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:qrtzblobtriggers:update")
    public R update(@RequestBody QrtzBlobTriggersEntity qrtzBlobTriggers){
		qrtzBlobTriggersService.updateById(qrtzBlobTriggers);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:qrtzblobtriggers:delete")
    public R delete(@RequestBody String[] schedNames){
		qrtzBlobTriggersService.removeByIds(Arrays.asList(schedNames));

        return R.ok();
    }

}
