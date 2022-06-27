package com.dewen.controller;

import com.dewen.service.HelloService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：dewen
 */
@RefreshScope
@RestController
@RequestMapping(path = "/rdd")
public class RCDubboController {

    @DubboReference
    private HelloService helloService;


    /**
     * 获取用户名
     *
     * @return userName
     */
    @GetMapping("/test")
    public String test() {
        return helloService.hello("dewen");
    }
}