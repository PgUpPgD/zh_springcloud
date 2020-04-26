package com.zh.micro_bank1.entity;

import lombok.Data;

import java.util.Date;

@Data
public class BankEntity {
    private Integer id;
    private Integer tid;
    private Integer uid;
    private String name;
    private Double balance;
    private Double addMoney;
    private Double subtract;
    private Date creatTime;
}
