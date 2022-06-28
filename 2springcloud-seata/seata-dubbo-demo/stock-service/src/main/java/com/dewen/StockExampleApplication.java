package com.dewen;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.dewen")
@MapperScan({"com.dewen.mapper"})
@EnableDubbo(scanBasePackages = "com.dewen")
public class StockExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockExampleApplication.class, args);
    }

}

