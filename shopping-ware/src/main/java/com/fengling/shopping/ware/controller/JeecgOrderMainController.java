package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.JeecgOrderMainEntity;
import com.fengling.shopping.ware.service.JeecgOrderMainService;
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
@RequestMapping("ware/jeecgordermain")
public class JeecgOrderMainController {
    @Autowired
    private JeecgOrderMainService jeecgOrderMainService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:jeecgordermain:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = jeecgOrderMainService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:jeecgordermain:info")
    public R info(@PathVariable("id") String id){
		JeecgOrderMainEntity jeecgOrderMain = jeecgOrderMainService.getById(id);

        return R.ok().put("jeecgOrderMain", jeecgOrderMain);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:jeecgordermain:save")
    public R save(@RequestBody JeecgOrderMainEntity jeecgOrderMain){
		jeecgOrderMainService.save(jeecgOrderMain);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:jeecgordermain:update")
    public R update(@RequestBody JeecgOrderMainEntity jeecgOrderMain){
		jeecgOrderMainService.updateById(jeecgOrderMain);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:jeecgordermain:delete")
    public R delete(@RequestBody String[] ids){
		jeecgOrderMainService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
