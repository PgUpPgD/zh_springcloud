package com.zh.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

@Component
public class SecondFilter extends ZuulFilter {
    //设置过滤器的类型       该四个方法是用来设置的，没有先后顺序，多个过滤器，建多个
    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;  //4种filter类型之一 post
    }

    //设置filter的优先级
    @Override
    public int filterOrder() {
        return 0;   //默认是5，减1后是4
    }

    //是否执行过滤，true表示需要过滤
    @Override
    public boolean shouldFilter() {
        return false;
    }

    //过滤器的核心逻辑
    @Override
    public Object run() throws ZuulException {
        System.out.println("post");
        return null;
    }
}
