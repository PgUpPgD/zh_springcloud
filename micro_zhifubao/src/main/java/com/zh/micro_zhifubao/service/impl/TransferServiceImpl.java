package com.zh.micro_zhifubao.service.impl;

import com.zh.micro_zhifubao.service.TransferService;
import com.zh.micro_zhifubao.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class TransferServiceImpl implements TransferService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public JsonUtil inMoney(String name, Integer uid, Double subtract, Integer tid) {
        Map<String, Object> map = new HashMap<>();
        map.put("name",name);
        map.put("uid",uid);
        map.put("subtract",subtract);
        map.put("tid",tid);
        //调用另外的程序接口
//        RestTemplate restTemplate = new RestTemplate();
        //调用单个/多个参数
        // 1.路径和对应的参数，2.资源的返回值类型，3.路径中用到的参数
        //{数字}表示位置顺序
//        JsonUtil object = restTemplate.getForObject
//                ("http://localhost:7001/user/transfer.do?name={1}&uid={2}&subtract={3}&tid={4}",
//                        JsonUtil.class, name, uid, subtract, tid);
//        System.out.println(object.getCode());
//        JsonUtil result = restTemplate.postForObject
//                ("http://localhost:7001/user/transfer.do?", map, JsonUtil.class);
//        System.out.println(result.getCode());

        //----------启用负载均衡-----------
        //不能在写ip:port,使用服务名称
        JsonUtil result = restTemplate.getForObject
                ("http://micro-bank/user/transfer.do?name={1}&uid={2}&subtract={3}&tid={4}",
                        JsonUtil.class, name, uid, subtract, tid);
        System.out.println(result.getMsg());
        return result;
    }
}
