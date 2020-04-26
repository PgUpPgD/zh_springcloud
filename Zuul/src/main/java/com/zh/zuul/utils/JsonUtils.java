package com.zh.zuul.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {

    private static ObjectMapper objectMapper = new ObjectMapper();
    /*
    * 常见3种，将对象转换为json格式的字符串；
    * 将json格式的字符串转换为对象
    * 将json格式的字符串转换为列表
    * */
    public static String obj2JsonStr(Object obj){
        try {
            String jsonStr = objectMapper.writeValueAsString(obj);
            return jsonStr;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
