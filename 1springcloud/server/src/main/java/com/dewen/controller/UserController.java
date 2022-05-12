package com.dewen.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：dewen
 */
@RefreshScope
@RestController
@RequestMapping(path = "/user")
public class UserController {

    private static final String USER_NAME = "dewen";

    @Value("${userName}")
    private String userName;
    @Value("${server.port}")
    private String port;

    /**
     * 获取用户名
     *
     * @param userId
     * @return userName
     */
    @GetMapping("getUserName")
    public String getUserName(@RequestParam("userId") String userId) {
        System.out.println(port);
        if (USER_NAME.equals(userId)) {
            return userName;
        } else {
            return "佚名";
        }
    }

    /**
     * 获取用户年龄
     *
     * @param userId
     */
    @GetMapping("getUserAge")
    public String getUserAge(@RequestParam("userId") String userId) {
        if (USER_NAME.equals(userId)) {
            return "18";
        } else {
            return "24";
        }
    }
}