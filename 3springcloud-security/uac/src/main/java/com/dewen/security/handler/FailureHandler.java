package com.dewen.security.handler;

import com.alibaba.fastjson.JSONObject;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class FailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        JSONObject json = new JSONObject();
        json.put("code", 500);
        json.put("msg", "登录失败，账号/密码失败");
        // if(e instanceof LockedException){
        //     map.put("msg","账号被锁定,登录失败");
        // }else if(e instanceof BadCredentialsException){
        //     map.put("msg","用户名或密码错误,登录失败");
        // }
        response.setHeader("Content-type", "application/json;charset=utf-8");
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getWriter().write(JSONObject.toJSONString(json));
    }

}