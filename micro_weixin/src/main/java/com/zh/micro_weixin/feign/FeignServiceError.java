package com.zh.micro_weixin.feign;

import com.zh.micro_weixin.entity.BankEntity;
import com.zh.micro_weixin.utils.JsonUtil;
import org.springframework.stereotype.Component;

//回退的方法
@Component
public class FeignServiceError implements FeignService{
    @Override
    public JsonUtil transfer(BankEntity bank) {
        return JsonUtil.setERROR("回退方法");
    }
}
