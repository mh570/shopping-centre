package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.CesOrderCustomerEntity;
import com.fengling.shopping.ware.service.CesOrderCustomerService;
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
@RequestMapping("ware/cesordercustomer")
public class CesOrderCustomerController {
    @Autowired
    private CesOrderCustomerService cesOrderCustomerService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:cesordercustomer:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = cesOrderCustomerService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:cesordercustomer:info")
    public R info(@PathVariable("id") String id){
		CesOrderCustomerEntity cesOrderCustomer = cesOrderCustomerService.getById(id);

        return R.ok().put("cesOrderCustomer", cesOrderCustomer);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:cesordercustomer:save")
    public R save(@RequestBody CesOrderCustomerEntity cesOrderCustomer){
		cesOrderCustomerService.save(cesOrderCustomer);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:cesordercustomer:update")
    public R update(@RequestBody CesOrderCustomerEntity cesOrderCustomer){
		cesOrderCustomerService.updateById(cesOrderCustomer);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:cesordercustomer:delete")
    public R delete(@RequestBody String[] ids){
		cesOrderCustomerService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
