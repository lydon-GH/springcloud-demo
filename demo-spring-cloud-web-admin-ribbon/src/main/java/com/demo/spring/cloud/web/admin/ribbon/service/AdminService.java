package com.demo.spring.cloud.web.admin.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.client.*;

@Service
public class AdminService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")
    public String sayHi(String message){
        return restTemplate.getForObject("http://DEMO-SPRING-CLOUD-SERVICE-ADMIN/hi?message="+message,String.class);
    }

    public String hiError(String message){
        return String.format("hi your message is : %s but request bad"+message);
    }

}
