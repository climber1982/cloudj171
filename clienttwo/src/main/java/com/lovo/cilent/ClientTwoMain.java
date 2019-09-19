package com.lovo.cilent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient //注册
@EnableDiscoveryClient//集中配置
public class ClientTwoMain {

    public static void main(String[] args) {
        SpringApplication.run(ClientTwoMain.class);
    }
}
