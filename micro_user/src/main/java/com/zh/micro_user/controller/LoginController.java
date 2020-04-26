package com.zh.micro_user.controller;

import com.zh.micro_user.common.JsonResult;
import com.zh.micro_user.utils.JWTUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @RequestMapping("/login.do")
    public JsonResult login(String name, String password){
        if (name.equals("admin") && password.equals("123")){
            //和法用户，生成token
            String jwt = JWTUtils.createJwt(name);
            return new JsonResult(0,jwt);
        }else {
            return new JsonResult(1,"用户名或者密码错误");
        }
    }
}
