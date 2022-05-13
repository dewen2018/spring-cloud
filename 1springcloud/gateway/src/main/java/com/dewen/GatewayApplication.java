package com.dewen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Note：main class
 *
 * @author ：dewen
 * @description：
 * @date ：Created in 2020/9/10
 */
@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(GatewayApplication.class, args);
//        ConfigurableApplicationContext applicationContext = SpringApplication.run(GatewayApplication.class, args);
//        while (true) {
//            //当动态配置刷新时，会更新到 Enviroment中，因此这里每隔一秒中从Enviroment中获取配置
//            String userName = applicationContext.getEnvironment().getProperty("http_url");
//            String userAge = applicationContext.getEnvironment().getProperty("author");
//            System.err.println("user name :" + userName + "; age: " + userAge);
//            TimeUnit.SECONDS.sleep(5);
//        }

    }
}
