package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.CesOrderMainEntity;
import com.fengling.shopping.ware.service.CesOrderMainService;
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
@RequestMapping("ware/cesordermain")
public class CesOrderMainController {
    @Autowired
    private CesOrderMainService cesOrderMainService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:cesordermain:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = cesOrderMainService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:cesordermain:info")
    public R info(@PathVariable("id") String id){
		CesOrderMainEntity cesOrderMain = cesOrderMainService.getById(id);

        return R.ok().put("cesOrderMain", cesOrderMain);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:cesordermain:save")
    public R save(@RequestBody CesOrderMainEntity cesOrderMain){
		cesOrderMainService.save(cesOrderMain);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:cesordermain:update")
    public R update(@RequestBody CesOrderMainEntity cesOrderMain){
		cesOrderMainService.updateById(cesOrderMain);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:cesordermain:delete")
    public R delete(@RequestBody String[] ids){
		cesOrderMainService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
