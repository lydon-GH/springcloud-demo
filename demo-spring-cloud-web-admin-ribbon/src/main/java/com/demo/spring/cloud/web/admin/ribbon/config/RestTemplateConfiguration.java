package com.demo.spring.cloud.web.admin.ribbon.config;

import org.springframework.beans.factory.annotation.*;
import org.springframework.cloud.client.loadbalancer.*;
import org.springframework.context.annotation.*;
import org.springframework.web.client.*;

@Configuration
public class RestTemplateConfiguration {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
