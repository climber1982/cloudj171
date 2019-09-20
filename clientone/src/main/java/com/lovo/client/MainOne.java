package com.lovo.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//@EnableEurekaClient //统一注册
//@EnableDiscoveryClient //统一配置
//@EnableCircuitBreaker //熔断
public class MainOne {
    public static void main(String[] args) {

        SpringApplication.run(MainOne.class);
    }
}
