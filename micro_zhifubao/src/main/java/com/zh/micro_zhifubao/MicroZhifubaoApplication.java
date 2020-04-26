package com.zh.micro_zhifubao;

import com.zh.micro_zhifubao.config.MyRuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
//针对具体的服务指定负载均衡策略
@RibbonClient(name="micro-bank", configuration = MyRuleConfig.class)
@EnableHystrix
@EnableHystrixDashboard    //启用Dashboard
public class MicroZhifubaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroZhifubaoApplication.class, args);
    }

}
