package com.zh.micro_weixin.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zh.micro_weixin.entity.BankEntity;
import com.zh.micro_weixin.service.TransferService;
import com.zh.micro_weixin.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferController {

    @Autowired
    private TransferService transferService;

    @HystrixCommand(defaultFallback = "transferError")
    @RequestMapping("weixin/transfer.do")
    public JsonUtil inMoney(@RequestBody BankEntity bankEntity){
        return transferService.inMoney(bankEntity);
    }

    public JsonUtil transferError(){
        return JsonUtil.setERROR("转账失败");
    }

}
