package com.zh.micro_bank;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.zh.micro_bank.dao")
//@EnableDistributedTransaction
public class MicroBankApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroBankApplication.class, args);
    }

}
