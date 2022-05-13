package com.dewen.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * NacosValue 不生效
 *
 * @author Dewen
 * @date 2022/5/13 09:49:07
 */
@RestController
public class TestController {

    @NacosValue(value = "${http_url:11111}", autoRefreshed = true)
    private String httpUrl;

    @GetMapping(value = "/getHttpUrl")
    public String getHttpUrl() {
        return this.httpUrl;
    }
}
