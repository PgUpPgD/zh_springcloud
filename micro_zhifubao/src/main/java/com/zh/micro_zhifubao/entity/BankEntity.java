package com.zh.micro_zhifubao.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BankEntity implements Serializable {
    private Integer id;
    private Integer tid;
    private Integer uid;
    private String name;
    private Double balance;
    private Double addMoney;
    private Double subtract;
    private Date creatTime;
}
