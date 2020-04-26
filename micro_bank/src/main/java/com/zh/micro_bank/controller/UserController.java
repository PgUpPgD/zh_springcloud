package com.zh.micro_bank.controller;

import com.zh.micro_bank.entity.BankEntity;
import com.zh.micro_bank.service.UserService;
import com.zh.micro_bank.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("user/transfer.do")
    public JsonUtil transfer(@RequestBody BankEntity bank){
        System.out.println("1111111111111111");
        String name = bank.getName();
        Integer uid = bank.getUid();
        Double subtract = bank.getSubtract();
        Integer tid = bank.getTid();
//        public JsonUtil transfer(@RequestBody Map<String, Object> bank){
//        String name = bank.get("name").toString();
//        Integer uid = Integer.parseInt(bank.get("uid").toString());
//        Double subtract = Double.parseDouble(bank.get("subtract").toString());
//        Integer tid = Integer.parseInt(bank.get("tid").toString());

        return userService.transfer(name, uid, subtract, tid);
    }

}
