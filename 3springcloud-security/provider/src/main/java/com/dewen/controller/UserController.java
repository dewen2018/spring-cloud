package com.dewen.controller;

import com.dewen.dubboservice.HelloServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private HelloServiceImpl helloService;

    /**
     * 获取用户名
     *
     * @param userId
     * @return userName
     */
    @PreAuthorize("hasAnyAuthority('admin')")
    @GetMapping("/getUserName/{userId}")
    public String getUserName(@PathVariable String userId) {
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


    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return helloService.hello(name);
    }
}