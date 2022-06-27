package com.dewen;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// (scanBasePackages = "com.dewen", exclude = {DataSourceAutoConfiguration.class})
@EnableDubbo(scanBasePackages = "com.dewen")
public class BusinessExampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(BusinessExampleApplication.class, args);
    }

}

