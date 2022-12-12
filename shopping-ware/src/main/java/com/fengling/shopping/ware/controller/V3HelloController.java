package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.V3HelloEntity;
import com.fengling.shopping.ware.service.V3HelloService;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.R;



/**
 * 
 *
 * @author mh570
 * @email 2317295126@qq.com
 * @date 2022-12-12 22:19:33
 */
@RestController
@RequestMapping("ware/v3hello")
public class V3HelloController {
    @Autowired
    private V3HelloService v3HelloService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:v3hello:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = v3HelloService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:v3hello:info")
    public R info(@PathVariable("id") String id){
		V3HelloEntity v3Hello = v3HelloService.getById(id);

        return R.ok().put("v3Hello", v3Hello);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:v3hello:save")
    public R save(@RequestBody V3HelloEntity v3Hello){
		v3HelloService.save(v3Hello);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:v3hello:update")
    public R update(@RequestBody V3HelloEntity v3Hello){
		v3HelloService.updateById(v3Hello);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:v3hello:delete")
    public R delete(@RequestBody String[] ids){
		v3HelloService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
