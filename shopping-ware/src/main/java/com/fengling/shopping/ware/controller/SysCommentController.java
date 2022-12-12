package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.SysCommentEntity;
import com.fengling.shopping.ware.service.SysCommentService;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.R;



/**
 * 系统评论回复表
 *
 * @author mh570
 * @email 2317295126@qq.com
 * @date 2022-12-12 22:19:34
 */
@RestController
@RequestMapping("ware/syscomment")
public class SysCommentController {
    @Autowired
    private SysCommentService sysCommentService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:syscomment:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysCommentService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:syscomment:info")
    public R info(@PathVariable("id") String id){
		SysCommentEntity sysComment = sysCommentService.getById(id);

        return R.ok().put("sysComment", sysComment);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:syscomment:save")
    public R save(@RequestBody SysCommentEntity sysComment){
		sysCommentService.save(sysComment);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:syscomment:update")
    public R update(@RequestBody SysCommentEntity sysComment){
		sysCommentService.updateById(sysComment);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:syscomment:delete")
    public R delete(@RequestBody String[] ids){
		sysCommentService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
