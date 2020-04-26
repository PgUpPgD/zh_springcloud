package com.zh.micro_weixin.feign;

import com.zh.micro_weixin.entity.BankEntity;
import com.zh.micro_weixin.utils.JsonUtil;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

//和调用服务保持一致    调用的方法挂掉才调用，只要有返回（错误）就不执行
@FeignClient(value = "micro-bank", fallback = FeignServiceError.class)
public interface FeignService {
    //和服务生产者保持一致
    @RequestMapping("user/transfer.do")
//    public JsonUtil transfer(@RequestParam("name") String name,   //bnank1可测试
//                             @RequestParam("uid") Integer uid,
//                             @RequestParam("subtract") Double subtract,
//                             @RequestParam("tid") Integer tid);
    JsonUtil transfer(@RequestBody BankEntity bank);
}
