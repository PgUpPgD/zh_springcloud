package com.zh.micro_bank.dao;

import com.zh.micro_bank.entity.BankEntity;
import com.zh.micro_bank.entity.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    UserEntity findByUserName(String name);
    UserEntity findById(Integer id);
    int updateUserB(UserEntity user);
    int insertBank(BankEntity bank);

}
