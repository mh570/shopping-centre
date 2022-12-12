package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.JimuDictItemEntity;
import com.fengling.shopping.ware.service.JimuDictItemService;
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
@RequestMapping("ware/jimudictitem")
public class JimuDictItemController {
    @Autowired
    private JimuDictItemService jimuDictItemService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:jimudictitem:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = jimuDictItemService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:jimudictitem:info")
    public R info(@PathVariable("id") String id){
		JimuDictItemEntity jimuDictItem = jimuDictItemService.getById(id);

        return R.ok().put("jimuDictItem", jimuDictItem);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:jimudictitem:save")
    public R save(@RequestBody JimuDictItemEntity jimuDictItem){
		jimuDictItemService.save(jimuDictItem);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:jimudictitem:update")
    public R update(@RequestBody JimuDictItemEntity jimuDictItem){
		jimuDictItemService.updateById(jimuDictItem);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:jimudictitem:delete")
    public R delete(@RequestBody String[] ids){
		jimuDictItemService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
