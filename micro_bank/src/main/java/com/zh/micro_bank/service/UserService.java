package com.zh.micro_bank.service;


import com.zh.micro_bank.utils.JsonUtil;

public interface UserService {
    JsonUtil transfer(String name, Integer uid, Double subtract, Integer tid);
}
