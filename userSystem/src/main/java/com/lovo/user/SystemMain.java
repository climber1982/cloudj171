package com.lovo.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SystemMain {

    public static void main(String[] args) {
        SpringApplication.run(SystemMain.class);
    }
}
