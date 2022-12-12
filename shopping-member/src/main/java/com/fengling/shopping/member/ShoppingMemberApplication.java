package com.fengling.shopping.member;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient //Nacos注册
@EnableFeignClients(basePackages = "com.fengling") //feign调用
@ComponentScan(basePackages = "com.fengling")
@MapperScan("com.fengling.shopping.member.dao")
public class ShoppingMemberApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShoppingMemberApplication.class, args);
    }
}
