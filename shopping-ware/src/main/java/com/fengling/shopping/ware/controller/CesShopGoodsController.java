package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.CesShopGoodsEntity;
import com.fengling.shopping.ware.service.CesShopGoodsService;
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
@RequestMapping("ware/cesshopgoods")
public class CesShopGoodsController {
    @Autowired
    private CesShopGoodsService cesShopGoodsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:cesshopgoods:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = cesShopGoodsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:cesshopgoods:info")
    public R info(@PathVariable("id") String id){
		CesShopGoodsEntity cesShopGoods = cesShopGoodsService.getById(id);

        return R.ok().put("cesShopGoods", cesShopGoods);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:cesshopgoods:save")
    public R save(@RequestBody CesShopGoodsEntity cesShopGoods){
		cesShopGoodsService.save(cesShopGoods);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:cesshopgoods:update")
    public R update(@RequestBody CesShopGoodsEntity cesShopGoods){
		cesShopGoodsService.updateById(cesShopGoods);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:cesshopgoods:delete")
    public R delete(@RequestBody String[] ids){
		cesShopGoodsService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
