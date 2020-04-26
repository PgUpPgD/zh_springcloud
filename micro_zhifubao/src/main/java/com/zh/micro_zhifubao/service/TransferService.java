package com.zh.micro_zhifubao.service;

import com.zh.micro_zhifubao.utils.JsonUtil;

public interface TransferService {

    //向支付宝转钱
    JsonUtil inMoney(String name, Integer uid, Double subtract, Integer tid);
}
