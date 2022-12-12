package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.JoaDemoEntity;
import com.fengling.shopping.ware.service.JoaDemoService;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.R;



/**
 * 流程测试
 *
 * @author mh570
 * @email 2317295126@qq.com
 * @date 2022-12-12 22:19:34
 */
@RestController
@RequestMapping("ware/joademo")
public class JoaDemoController {
    @Autowired
    private JoaDemoService joaDemoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:joademo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = joaDemoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:joademo:info")
    public R info(@PathVariable("id") String id){
		JoaDemoEntity joaDemo = joaDemoService.getById(id);

        return R.ok().put("joaDemo", joaDemo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:joademo:save")
    public R save(@RequestBody JoaDemoEntity joaDemo){
		joaDemoService.save(joaDemo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:joademo:update")
    public R update(@RequestBody JoaDemoEntity joaDemo){
		joaDemoService.updateById(joaDemo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:joademo:delete")
    public R delete(@RequestBody String[] ids){
		joaDemoService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
