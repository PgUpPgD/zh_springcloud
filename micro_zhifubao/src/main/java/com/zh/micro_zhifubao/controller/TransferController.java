package com.zh.micro_zhifubao.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zh.micro_zhifubao.entity.BankEntity;
import com.zh.micro_zhifubao.service.TransferService;
import com.zh.micro_zhifubao.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//对整个类生效，也可配超时时间
@DefaultProperties(defaultFallback = "defaultError")
public class TransferController {

    @Autowired
    private TransferService transferService;

    //使用该注解对修饰的方法起到保护作用，如果出异常，则调用指定的回退方法
//    @HystrixCommand(fallbackMethod = "transferError")//回退方法
    //回退加超时处理  超过多少秒没响应（0.1秒），即回退处理
//    @HystrixCommand(fallbackMethod = "transferError", commandProperties = {
//         @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "100")
//    })
    //断路器配置
    @HystrixCommand(commandProperties = {
            //设置断路器生效，默认配置
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            //一个统计窗口内熔断触发的最小个数，本例中5/10s
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
            //熔断5秒后去尝试请求
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000"),
            //失败率达到30百分比后熔断
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "30")})
    @RequestMapping("zfb/transfer.do")
    public JsonUtil inMoney(BankEntity bankEntity){
        String name = bankEntity.getName();
        Integer uid = bankEntity.getUid();
        Double subtract = bankEntity.getSubtract();
        Integer tid = bankEntity.getTid();
        return transferService.inMoney(name, uid, subtract, tid);
    }

    //回退方法  方法参数返回值等，保持一致
    public JsonUtil transferError(BankEntity bankEntity){
        return JsonUtil.setERROR();
    }

    //整个类的默认回退方法
    public JsonUtil defaultError(){
        return JsonUtil.setERROR();
    }




}
