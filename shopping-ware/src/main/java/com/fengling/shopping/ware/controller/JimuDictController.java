package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.JimuDictEntity;
import com.fengling.shopping.ware.service.JimuDictService;
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
@RequestMapping("ware/jimudict")
public class JimuDictController {
    @Autowired
    private JimuDictService jimuDictService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:jimudict:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = jimuDictService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:jimudict:info")
    public R info(@PathVariable("id") String id){
		JimuDictEntity jimuDict = jimuDictService.getById(id);

        return R.ok().put("jimuDict", jimuDict);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:jimudict:save")
    public R save(@RequestBody JimuDictEntity jimuDict){
		jimuDictService.save(jimuDict);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:jimudict:update")
    public R update(@RequestBody JimuDictEntity jimuDict){
		jimuDictService.updateById(jimuDict);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:jimudict:delete")
    public R delete(@RequestBody String[] ids){
		jimuDictService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
