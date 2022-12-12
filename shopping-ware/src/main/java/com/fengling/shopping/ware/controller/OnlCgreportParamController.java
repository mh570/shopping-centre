package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.OnlCgreportParamEntity;
import com.fengling.shopping.ware.service.OnlCgreportParamService;
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
@RequestMapping("ware/onlcgreportparam")
public class OnlCgreportParamController {
    @Autowired
    private OnlCgreportParamService onlCgreportParamService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:onlcgreportparam:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = onlCgreportParamService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:onlcgreportparam:info")
    public R info(@PathVariable("id") String id){
		OnlCgreportParamEntity onlCgreportParam = onlCgreportParamService.getById(id);

        return R.ok().put("onlCgreportParam", onlCgreportParam);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:onlcgreportparam:save")
    public R save(@RequestBody OnlCgreportParamEntity onlCgreportParam){
		onlCgreportParamService.save(onlCgreportParam);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:onlcgreportparam:update")
    public R update(@RequestBody OnlCgreportParamEntity onlCgreportParam){
		onlCgreportParamService.updateById(onlCgreportParam);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:onlcgreportparam:delete")
    public R delete(@RequestBody String[] ids){
		onlCgreportParamService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
