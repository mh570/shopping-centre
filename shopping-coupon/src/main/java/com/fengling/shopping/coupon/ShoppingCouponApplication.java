package com.fengling.shopping.coupon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient //Nacos注册
@MapperScan("com.fengling.shopping.coupon.dao")
public class ShoppingCouponApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShoppingCouponApplication.class, args);
    }
}
