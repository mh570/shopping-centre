package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.SysAnnouncementEntity;
import com.fengling.shopping.ware.service.SysAnnouncementService;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.R;



/**
 * 系统通告表
 *
 * @author mh570
 * @email 2317295126@qq.com
 * @date 2022-12-12 22:19:33
 */
@RestController
@RequestMapping("ware/sysannouncement")
public class SysAnnouncementController {
    @Autowired
    private SysAnnouncementService sysAnnouncementService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:sysannouncement:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysAnnouncementService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:sysannouncement:info")
    public R info(@PathVariable("id") String id){
		SysAnnouncementEntity sysAnnouncement = sysAnnouncementService.getById(id);

        return R.ok().put("sysAnnouncement", sysAnnouncement);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:sysannouncement:save")
    public R save(@RequestBody SysAnnouncementEntity sysAnnouncement){
		sysAnnouncementService.save(sysAnnouncement);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:sysannouncement:update")
    public R update(@RequestBody SysAnnouncementEntity sysAnnouncement){
		sysAnnouncementService.updateById(sysAnnouncement);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:sysannouncement:delete")
    public R delete(@RequestBody String[] ids){
		sysAnnouncementService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
