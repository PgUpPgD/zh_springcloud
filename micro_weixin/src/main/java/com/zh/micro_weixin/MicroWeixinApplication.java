package com.zh.micro_weixin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
@MapperScan("com.zh.micro_weixin.dao")
//@EnableDistributedTransaction
@EnableHystrix
public class MicroWeixinApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroWeixinApplication.class, args);
    }

}
