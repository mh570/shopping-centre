package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.JeecgOrderTicketEntity;
import com.fengling.shopping.ware.service.JeecgOrderTicketService;
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
@RequestMapping("ware/jeecgorderticket")
public class JeecgOrderTicketController {
    @Autowired
    private JeecgOrderTicketService jeecgOrderTicketService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:jeecgorderticket:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = jeecgOrderTicketService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:jeecgorderticket:info")
    public R info(@PathVariable("id") String id){
		JeecgOrderTicketEntity jeecgOrderTicket = jeecgOrderTicketService.getById(id);

        return R.ok().put("jeecgOrderTicket", jeecgOrderTicket);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:jeecgorderticket:save")
    public R save(@RequestBody JeecgOrderTicketEntity jeecgOrderTicket){
		jeecgOrderTicketService.save(jeecgOrderTicket);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:jeecgorderticket:update")
    public R update(@RequestBody JeecgOrderTicketEntity jeecgOrderTicket){
		jeecgOrderTicketService.updateById(jeecgOrderTicket);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:jeecgorderticket:delete")
    public R delete(@RequestBody String[] ids){
		jeecgOrderTicketService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
