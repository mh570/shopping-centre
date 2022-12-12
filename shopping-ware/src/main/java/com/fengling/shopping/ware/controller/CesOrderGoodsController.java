package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.CesOrderGoodsEntity;
import com.fengling.shopping.ware.service.CesOrderGoodsService;
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
@RequestMapping("ware/cesordergoods")
public class CesOrderGoodsController {
    @Autowired
    private CesOrderGoodsService cesOrderGoodsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:cesordergoods:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = cesOrderGoodsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:cesordergoods:info")
    public R info(@PathVariable("id") String id){
		CesOrderGoodsEntity cesOrderGoods = cesOrderGoodsService.getById(id);

        return R.ok().put("cesOrderGoods", cesOrderGoods);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:cesordergoods:save")
    public R save(@RequestBody CesOrderGoodsEntity cesOrderGoods){
		cesOrderGoodsService.save(cesOrderGoods);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:cesordergoods:update")
    public R update(@RequestBody CesOrderGoodsEntity cesOrderGoods){
		cesOrderGoodsService.updateById(cesOrderGoods);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:cesordergoods:delete")
    public R delete(@RequestBody String[] ids){
		cesOrderGoodsService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
