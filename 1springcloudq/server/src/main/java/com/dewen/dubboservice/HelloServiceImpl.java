package com.dewen.dubboservice;

import com.dewen.service.HelloService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * 新增一个远程调用接口的实现类，实现上面在Api服务新增的接口，用Dubbo的DubboService注解，表示这是一个Dubbo的service层
 */
@DubboService
public class HelloServiceImpl implements HelloService {

    @Override
    public String hello(String name) {
        return "hello " + name;
    }
}
