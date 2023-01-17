package com.fengling.shopping.elasticsearch.controller;

import com.fengling.common.exception.BizCodeEnume;
import com.fengling.common.to.es.SkuEsModel;
import com.fengling.common.utils.R;
import com.fengling.shopping.elasticsearch.service.ProductSaveService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/search/save")
public class ElasticSaveController {
    @Autowired
    private ProductSaveService productSaveService;

    @PostMapping("/product")
    public R productStatusUp(@RequestBody List<SkuEsModel> skuEsModelList) {
        boolean b = true;
        try {
            b = productSaveService.productStatusUp(skuEsModelList);
        } catch (IOException e) {
            e.printStackTrace();
            log.error("错误");
            return R.error(BizCodeEnume.DAO_EXCEPTION.getCode(), BizCodeEnume.DAO_EXCEPTION.getMsg());
        }

        if (!b) {
            return R.ok();
        } else {
            return R.error(BizCodeEnume.DAO_EXCEPTION.getCode(), BizCodeEnume.DAO_EXCEPTION.getMsg());
        }
    }
}
