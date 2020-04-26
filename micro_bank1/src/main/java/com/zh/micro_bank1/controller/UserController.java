package com.zh.micro_bank1.controller;

import com.zh.micro_bank1.entity.BankEntity;
import com.zh.micro_bank1.service.UserService;
import com.zh.micro_bank1.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("user/transfer.do")
    public JsonUtil transfer(BankEntity bank){
        System.out.println("2222222222222");
        String name = bank.getName();
        System.out.println(name);
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
