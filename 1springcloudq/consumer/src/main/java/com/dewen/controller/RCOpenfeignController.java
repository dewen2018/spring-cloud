package com.dewen.controller;

import com.dewen.client.RCOpenfeignClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ：dewen
 */
@RefreshScope
@RestController
@RequestMapping(path = "/rcf")
public class RCOpenfeignController {

    @Resource
    private RCOpenfeignClient rcOpenfeignClient;


    /**
     * 获取用户名
     *
     * @return userName
     */
    @GetMapping("/test")
    public String test() {
        return rcOpenfeignClient.getUserName("dewen");
    }
}