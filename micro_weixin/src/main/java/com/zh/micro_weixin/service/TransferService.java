package com.zh.micro_weixin.service;

import com.zh.micro_weixin.entity.BankEntity;
import com.zh.micro_weixin.utils.JsonUtil;

public interface TransferService {

    //向支付宝转钱
    JsonUtil inMoney(BankEntity bank);
}
