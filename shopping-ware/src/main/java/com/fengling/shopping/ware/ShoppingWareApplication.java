package com.fengling.shopping.ware;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan("com.fengling.shopping.ware.dao")
@EnableDiscoveryClient //Nacos注册
public class ShoppingWareApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShoppingWareApplication.class, args);
    }
}
