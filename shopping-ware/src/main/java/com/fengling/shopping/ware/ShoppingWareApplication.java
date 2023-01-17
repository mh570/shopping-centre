package com.fengling.shopping.ware;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient //Nacos注册
@MapperScan("com.fengling.shopping.ware.dao")
@EnableFeignClients(basePackages = "com.fengling") //feign调用

public class ShoppingWareApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShoppingWareApplication.class, args);
    }
}
