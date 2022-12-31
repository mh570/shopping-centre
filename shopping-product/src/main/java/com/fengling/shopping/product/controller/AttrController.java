package com.fengling.shopping.product.controller;

import java.util.Arrays;
import java.util.Map;

import com.fengling.shopping.product.vo.AttrRespVo;
import com.fengling.shopping.product.vo.AttrVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fengling.shopping.product.entity.AttrEntity;
import com.fengling.shopping.product.service.AttrService;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.R;



/**
 * 
 *
 * @author mh570
 * @email 2317295126@qq.com
 * @date 2022-12-12 22:24:58
 */
@RestController
@RequestMapping("product/attr")
public class AttrController {
    @Autowired
    private AttrService attrService;

    //    http://localhost:8818/api/product/attr/base/list/0    ?t=1672224381161&page=1&limit=10&key=
    @GetMapping("/{attrType}/list/{catelogId}")
    public R baseAttrList(@PathVariable("catelogId") Long catelogId,
                          @PathVariable("attrType") String attrType,
                          @RequestParam Map<String, Object> params) {
        PageUtils page = attrService.queryBaseAttrList(catelogId,params,attrType);
        return R.ok().put("page", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:attr:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = attrService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{attrId}")
    public R info(@PathVariable("attrId") Long attrId){
		AttrRespVo attrRespVo = attrService.getAttrInfo(attrId);
        return R.ok().put("attr", attrRespVo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:attr:save")
    public R save(@RequestBody AttrVo attr){
		attrService.saveAttr(attr);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody AttrVo attr){
		attrService.updateAttrById(attr);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:attr:delete")
    public R delete(@RequestBody Long[] attrIds){
		attrService.removeByIds(Arrays.asList(attrIds));

        return R.ok();
    }

}
