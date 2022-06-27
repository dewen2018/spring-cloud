package com.dewen.dubboservice;

import com.dewen.service.HelloService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Value;

/**
 * 新增一个远程调用接口的实现类，实现上面在Api服务新增的接口，用Dubbo的DubboService注解，表示这是一个Dubbo的service层
 */
@DubboService(version = "1.0.0",
        interfaceClass = HelloService.class,
        loadbalance = "roundrobin",
        cluster = "failfast")
public class HelloServiceImpl implements HelloService {

    @Value("${spring.application.name}")
    private String applicationName;

    @Override
    public String sayContext(String content) {
        return String.format("[%s]: |-dubbo-|  %s ", applicationName, content);
    }


    @Override
    public String hello(String name) {
        try {
            int a = 1 / 0;
        } catch (Exception e) {
            e.printStackTrace();
            return String.format("[%s]: |-dubbo-|  %s ", applicationName, e.getMessage());
        }
        return "hello " + name;
    }
}
