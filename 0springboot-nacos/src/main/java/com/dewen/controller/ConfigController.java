package com.dewen.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("config")
public class ConfigController {

    @NacosValue(value = "${useLocalCache:false}", autoRefreshed = true)
    private boolean useLocalCache;

    @NacosValue(value = "${http_url:127.0.0.1}", autoRefreshed = true)
    private String httpUrl;

    public void setUseLocalCache(boolean useLocalCache) {
        this.useLocalCache = useLocalCache;
    }

    @GetMapping(value = "/get")
    public boolean get() {
        return useLocalCache;
    }

    @GetMapping(value = "/getHttpUrl")
    public String getHttpUrl() {
        return this.httpUrl;
    }
}