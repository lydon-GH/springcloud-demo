package com.demo.spring.cloud.config;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.cloud.client.discovery.*;
import org.springframework.cloud.config.server.*;
import org.springframework.cloud.netflix.eureka.*;

@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class ConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication.class,args);
    }
}
