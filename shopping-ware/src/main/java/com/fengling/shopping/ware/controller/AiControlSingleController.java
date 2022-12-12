package com.fengling.shopping.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.ware.entity.AiControlSingleEntity;
import com.fengling.shopping.ware.service.AiControlSingleService;
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
@RequestMapping("ware/aicontrolsingle")
public class AiControlSingleController {
    @Autowired
    private AiControlSingleService aiControlSingleService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:aicontrolsingle:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = aiControlSingleService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:aicontrolsingle:info")
    public R info(@PathVariable("id") String id){
		AiControlSingleEntity aiControlSingle = aiControlSingleService.getById(id);

        return R.ok().put("aiControlSingle", aiControlSingle);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:aicontrolsingle:save")
    public R save(@RequestBody AiControlSingleEntity aiControlSingle){
		aiControlSingleService.save(aiControlSingle);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:aicontrolsingle:update")
    public R update(@RequestBody AiControlSingleEntity aiControlSingle){
		aiControlSingleService.updateById(aiControlSingle);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:aicontrolsingle:delete")
    public R delete(@RequestBody String[] ids){
		aiControlSingleService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
