package com.fengling.shopping.product.web;

import com.alibaba.fastjson.JSON;
import com.fengling.shopping.product.entity.CategoryEntity;
import com.fengling.shopping.product.service.CategoryService;
import com.fengling.shopping.product.vo.CateLog2Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;


@Controller
public class IndexController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping({"/", "/index.html"})
    public String indexPage(Model model) {
        List<CategoryEntity> categoryEntityList = categoryService.getLevel1Category();
        model.addAttribute("categoryList",categoryEntityList);
        return "index";
    }
//    index/catalog.json
    @ResponseBody
    @GetMapping({"json/catalog.json"})
    public Map<String, List<CateLog2Vo>> getCatalogJson(){
        Map<String, List<CateLog2Vo>> map = categoryService.getCatalogJson();

        return map;
    }
}

