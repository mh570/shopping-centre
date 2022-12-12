package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.SysAnnouncementSendEntity;
import com.fengling.shopping.ware.service.SysAnnouncementSendService;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.R;



/**
 * 用户通告阅读标记表
 *
 * @author mh570
 * @email 2317295126@qq.com
 * @date 2022-12-12 22:19:33
 */
@RestController
@RequestMapping("ware/sysannouncementsend")
public class SysAnnouncementSendController {
    @Autowired
    private SysAnnouncementSendService sysAnnouncementSendService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:sysannouncementsend:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysAnnouncementSendService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:sysannouncementsend:info")
    public R info(@PathVariable("id") String id){
		SysAnnouncementSendEntity sysAnnouncementSend = sysAnnouncementSendService.getById(id);

        return R.ok().put("sysAnnouncementSend", sysAnnouncementSend);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:sysannouncementsend:save")
    public R save(@RequestBody SysAnnouncementSendEntity sysAnnouncementSend){
		sysAnnouncementSendService.save(sysAnnouncementSend);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:sysannouncementsend:update")
    public R update(@RequestBody SysAnnouncementSendEntity sysAnnouncementSend){
		sysAnnouncementSendService.updateById(sysAnnouncementSend);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:sysannouncementsend:delete")
    public R delete(@RequestBody String[] ids){
		sysAnnouncementSendService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
