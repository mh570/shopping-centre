package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.OssFileEntity;
import com.fengling.shopping.ware.service.OssFileService;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.R;



/**
 * Oss File
 *
 * @author mh570
 * @email 2317295126@qq.com
 * @date 2022-12-12 22:19:34
 */
@RestController
@RequestMapping("ware/ossfile")
public class OssFileController {
    @Autowired
    private OssFileService ossFileService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:ossfile:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = ossFileService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:ossfile:info")
    public R info(@PathVariable("id") String id){
		OssFileEntity ossFile = ossFileService.getById(id);

        return R.ok().put("ossFile", ossFile);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:ossfile:save")
    public R save(@RequestBody OssFileEntity ossFile){
		ossFileService.save(ossFile);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:ossfile:update")
    public R update(@RequestBody OssFileEntity ossFile){
		ossFileService.updateById(ossFile);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:ossfile:delete")
    public R delete(@RequestBody String[] ids){
		ossFileService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
