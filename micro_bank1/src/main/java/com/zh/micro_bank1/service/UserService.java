package com.zh.micro_bank1.service;


import com.zh.micro_bank1.utils.JsonUtil;

public interface UserService {
    JsonUtil transfer(String name, Integer uid, Double subtract, Integer tid);
}
