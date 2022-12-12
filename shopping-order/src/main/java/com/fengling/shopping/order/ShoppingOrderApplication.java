package com.fengling.shopping.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient //Nacos注册
@MapperScan("com.fengling.shopping.order.dao")
public class ShoppingOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShoppingOrderApplication.class, args);
    }
}
