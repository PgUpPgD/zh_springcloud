package com.zh.micro_bank1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.zh.micro_bank1.dao")
public class MicroBank1Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroBank1Application.class, args);
    }

}
