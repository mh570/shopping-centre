package com.fengling.test;

import com.fengling.shopping.product.ShoppingProductApplication;
import com.fengling.shopping.product.entity.BrandEntity;
import com.fengling.shopping.product.service.BrandService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShoppingProductApplication.class)
public class TestApplication {

    @Resource
    BrandService brandService;

    @Test
    public void contextLoads() {
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setName("华为");
        brandService.save(brandEntity);
        System.out.println("保存成功");
    }

}

