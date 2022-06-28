package com.dewen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.dewen.product.mapper")
public class ProductApplication {
    static {
        System.setProperty("druid.mysql.usePingMethod", "false");
        // 性能监控：skywalking
        // System.setProperty("javaagent", "D:\\Programs\\alibaba-group\\seata1.5.1\\ext\\apm-skywalking\\skywalking-agent.jar");
        // System.setProperty("skywalking.agent.service_name", "product-application");
        // System.setProperty("skywalking.collector.backend_service", "127.0.0.1:11800");
        // -javaagent:D:\Programs\alibaba-group\seata1.5.1\ext\apm-skywalking\skywalking-agent.jar -Dskywalking.agent.service_name=product-application  -Dskywalking.collector.backend_service=127.0.0.1:11800
    }

    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }
}
