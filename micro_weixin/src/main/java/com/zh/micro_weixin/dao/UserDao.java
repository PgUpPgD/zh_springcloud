package com.zh.micro_weixin.dao;

import com.zh.micro_weixin.entity.BankEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    int addMsg1(BankEntity bank);
    int addMsg(BankEntity bank);
}
