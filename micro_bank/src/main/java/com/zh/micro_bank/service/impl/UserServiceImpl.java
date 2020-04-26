package com.zh.micro_bank.service.impl;

import com.zh.micro_bank.dao.UserDao;
import com.zh.micro_bank.entity.BankEntity;
import com.zh.micro_bank.entity.UserEntity;
import com.zh.micro_bank.service.UserService;
import com.zh.micro_bank.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
//@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

//    @LcnTransaction
    @Override
    public JsonUtil transfer(String name, Integer uid, Double subtract, Integer tid) {
        //余额是否足够的判断
        UserEntity userName = userDao.findByUserName(name);
        UserEntity userEntity = userDao.findById(tid);
        if (StringUtils.isEmpty(userName)){
            return JsonUtil.setERROR();
        }else if (userName.getUid() != uid){
            return JsonUtil.setERROR();
        }
        //加钱
        UserEntity entity = new UserEntity();
        Double balance = userName.getBalance() + subtract;
        entity.setBalance(balance);
        entity.setUid(uid);
        int i = userDao.updateUserB(entity);
        //添加记录
        BankEntity bankEntity = new BankEntity();
        bankEntity.setBalance(balance);
        bankEntity.setUid(uid);
        bankEntity.setName(name);
        bankEntity.setAddMoney(subtract);
        int i1 = userDao.insertBank(bankEntity);
        //减钱
        UserEntity entity1 = new UserEntity();
        entity1.setBalance(userEntity.getBalance() - subtract);
        entity1.setUid(tid);
        int i2 = userDao.updateUserB(entity1);
        //添加记录
        BankEntity bankEntity1 = new BankEntity();
        bankEntity1.setName(userEntity.getName());
        bankEntity1.setBalance(userEntity.getBalance() - subtract);
        bankEntity1.setUid(tid);
        bankEntity1.setSubtract(subtract);
        int i3 = userDao.insertBank(bankEntity1);
        if ((i == 0) || (i1 == 0) || (i2 == 0) || (i3 == 0)){
            return JsonUtil.setERROR();
        }
        return JsonUtil.setOk();
    }
}
