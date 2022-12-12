package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.CesShopTypeEntity;
import com.fengling.shopping.ware.service.CesShopTypeService;
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
@RequestMapping("ware/cesshoptype")
public class CesShopTypeController {
    @Autowired
    private CesShopTypeService cesShopTypeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:cesshoptype:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = cesShopTypeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:cesshoptype:info")
    public R info(@PathVariable("id") String id){
		CesShopTypeEntity cesShopType = cesShopTypeService.getById(id);

        return R.ok().put("cesShopType", cesShopType);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:cesshoptype:save")
    public R save(@RequestBody CesShopTypeEntity cesShopType){
		cesShopTypeService.save(cesShopType);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:cesshoptype:update")
    public R update(@RequestBody CesShopTypeEntity cesShopType){
		cesShopTypeService.updateById(cesShopType);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:cesshoptype:delete")
    public R delete(@RequestBody String[] ids){
		cesShopTypeService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
