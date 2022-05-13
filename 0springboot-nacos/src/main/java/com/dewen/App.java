package com.dewen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ：dewen
 */
//@NacosPropertySource(dataId = "springboot-nacos-dev.yaml", autoRefreshed = true, groupId = "springboot-nacos")
@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
