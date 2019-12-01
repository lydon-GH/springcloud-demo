package com.demo.spring.cloud.web.admin.ribbon;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.cloud.client.discovery.*;
import org.springframework.cloud.netflix.hystrix.*;
import org.springframework.cloud.netflix.ribbon.*;

@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
public class WebAdminRibbonApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebAdminRibbonApplication.class,args);
    }
}
