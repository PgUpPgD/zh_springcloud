package com.zh.micro_tm;

import com.codingapi.txlcn.tm.config.EnableTransactionManagerServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableTransactionManagerServer //启用事务管理
public class MicroTmApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroTmApplication.class, args);
    }

}
