package com.demo.spring.cloud.web.admin.feign;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.cloud.client.discovery.*;
import org.springframework.cloud.netflix.hystrix.dashboard.*;
import org.springframework.cloud.openfeign.*;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@EnableHystrixDashboard
public class WebAdminFeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebAdminFeignApplication.class,args);
    }
}
