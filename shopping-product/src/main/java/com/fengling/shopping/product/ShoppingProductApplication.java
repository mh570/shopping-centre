package com.fengling.shopping.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan("com.fengling.shopping.product.dao")
@EnableDiscoveryClient //Nacos注册
public class ShoppingProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShoppingProductApplication.class, args);
    }
}
