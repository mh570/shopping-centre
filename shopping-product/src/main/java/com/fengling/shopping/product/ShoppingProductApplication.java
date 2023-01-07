package com.fengling.shopping.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.fengling.shopping.product.dao")
@EnableDiscoveryClient //Nacos注册
@EnableFeignClients(basePackages = "com.fengling") //feign调用
@ComponentScan(basePackages = "com.fengling")

public class ShoppingProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShoppingProductApplication.class, args);
    }
}
