package com.dewen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableEurekaClient
//开启Turbine
@EnableTurbine
@EnableHystrixDashboard
public class TrubineApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrubineApplication.class, args);
    }

}
