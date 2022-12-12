package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.OnlAuthRelationEntity;
import com.fengling.shopping.ware.service.OnlAuthRelationService;
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
@RequestMapping("ware/onlauthrelation")
public class OnlAuthRelationController {
    @Autowired
    private OnlAuthRelationService onlAuthRelationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:onlauthrelation:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = onlAuthRelationService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:onlauthrelation:info")
    public R info(@PathVariable("id") String id){
		OnlAuthRelationEntity onlAuthRelation = onlAuthRelationService.getById(id);

        return R.ok().put("onlAuthRelation", onlAuthRelation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:onlauthrelation:save")
    public R save(@RequestBody OnlAuthRelationEntity onlAuthRelation){
		onlAuthRelationService.save(onlAuthRelation);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:onlauthrelation:update")
    public R update(@RequestBody OnlAuthRelationEntity onlAuthRelation){
		onlAuthRelationService.updateById(onlAuthRelation);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:onlauthrelation:delete")
    public R delete(@RequestBody String[] ids){
		onlAuthRelationService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
