package com.zh.micro_zhifubao.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRuleConfig {

    @Bean
    public IRule iRule(){
        return new RandomRule();  //随机策略
    }
}
