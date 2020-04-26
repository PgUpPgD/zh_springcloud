package com.zh.micro_bank.controller;

import com.zh.micro_bank.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope //刷新
public class TestController {

    @Value("${username}")
    private String username;

    @RequestMapping("/test.do")
    public JsonUtil testName(){
        return JsonUtil.setOk(username);
    }
}
