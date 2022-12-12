package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.JeecgOrderCustomerEntity;
import com.fengling.shopping.ware.service.JeecgOrderCustomerService;
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
@RequestMapping("ware/jeecgordercustomer")
public class JeecgOrderCustomerController {
    @Autowired
    private JeecgOrderCustomerService jeecgOrderCustomerService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:jeecgordercustomer:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = jeecgOrderCustomerService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:jeecgordercustomer:info")
    public R info(@PathVariable("id") String id){
		JeecgOrderCustomerEntity jeecgOrderCustomer = jeecgOrderCustomerService.getById(id);

        return R.ok().put("jeecgOrderCustomer", jeecgOrderCustomer);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:jeecgordercustomer:save")
    public R save(@RequestBody JeecgOrderCustomerEntity jeecgOrderCustomer){
		jeecgOrderCustomerService.save(jeecgOrderCustomer);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:jeecgordercustomer:update")
    public R update(@RequestBody JeecgOrderCustomerEntity jeecgOrderCustomer){
		jeecgOrderCustomerService.updateById(jeecgOrderCustomer);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:jeecgordercustomer:delete")
    public R delete(@RequestBody String[] ids){
		jeecgOrderCustomerService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
