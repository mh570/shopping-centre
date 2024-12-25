package com.fengling.shopping.elasticsearch;

import com.alibaba.fastjson.JSON;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

//@EnableTransactionManagement
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
//@MapperScan("com.fengling.shopping.product.dao")
@EnableDiscoveryClient //Nacos注册
@EnableFeignClients(basePackages = "com.fengling") //feign调用
//@ComponentScan(basePackages = "com.fengling")
public class ServiceElasticsearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceElasticsearchApplication.class, args);
    }

}
