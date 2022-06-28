package com.dewen.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Dewen
 * @date 2022/5/13 09:49:07
 */
@RestController
@RefreshScope
public class Test2Controller {
    @Value(value = "${author}")
    private String author;

    @GetMapping(value = "/getProjectInfo")
    public String getProjectInfo() {
        return "The project created by " + author;
    }

    @GetMapping(value = "/echo/{string}")
    public String echo(@PathVariable String string) {
        return "Hello Nacos Discovery " + string;
    }

}
