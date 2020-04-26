package com.zh.micro_weixin.service.impl;

import com.zh.micro_weixin.dao.UserDao;
import com.zh.micro_weixin.entity.BankEntity;
import com.zh.micro_weixin.feign.FeignService;
import com.zh.micro_weixin.service.TransferService;
import com.zh.micro_weixin.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@Transactional
public class TransferServiceImpl implements TransferService {

    @Autowired
    private FeignService feignService;
    @Autowired
    private UserDao userDao;

    /**
     * @LcnTransaction（）括号里可配置事务传播特性，不配有默认
     */
//    @LcnTransaction  //在使用事务的方法上，该注解使用lcn模式处理分布式事务
    @Override
    public JsonUtil inMoney(BankEntity bank) {
//        String name = bank.getName();
//        Double subtract = bank.getSubtract();
//        Integer tid = bank.getTid();
//        Integer uid = bank.getUid();

        //当该调用的方法报错后才会回退
        JsonUtil transfer = feignService.transfer(bank);
//        if(transfer.getCode() == 1){
//            throw new RuntimeException();
//        }
        bank.setBalance(10001.0);
        int j = userDao.addMsg1(bank);

//        int k = 10 / 0;   //普通事务可回滚本地方法

        int i = userDao.addMsg(bank);
        return transfer;
    }
}
