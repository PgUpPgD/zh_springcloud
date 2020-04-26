package com.zh.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.zh.zuul.utils.JWTUtils;
import com.zh.zuul.utils.JsonResult;
import com.zh.zuul.utils.JsonUtils;
import io.jsonwebtoken.Claims;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE; //前置
    }

    @Override
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER - 1;
    }

    //判断哪些需要过滤的逻辑
    @Override
    public boolean shouldFilter() {
        //获取当前请求的上下文对象
        RequestContext context = RequestContext.getCurrentContext();
        //获取请求对象
        HttpServletRequest request = context.getRequest();
        //获取请求路径
        String uri = request.getRequestURI();
        if (uri.contains("login")){
            return false;  //不过滤
        }
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        HttpServletResponse response = context.getResponse();
        response.setContentType("text/html;charset=utf-8");
        //从请求头中读取jwt
        String token = request.getHeader("token");
        if (token == null || token.isEmpty()){
            //不在进行路由
            context.setSendZuulResponse(false);
            JsonResult result = new JsonResult(401,"权限不够");
            String str = JsonUtils.obj2JsonStr(result);
            //设置响应体
            context.setResponseBody(str);
            return null;
        }
        //公钥解析jwt
        Claims claims = JWTUtils.parseJWT(token);
        //解析异常
        if (claims == null){
            //不在进行路由
            context.setSendZuulResponse(false);
            JsonResult jsonResult = new JsonResult(400,"身份信息异常");
            String jsonStr = JsonUtils.obj2JsonStr(jsonResult);  //json转string
            //设置响应体
            context.setResponseBody(jsonStr);
            return null;
        }
        return null;
    }
}
