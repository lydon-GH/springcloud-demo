package com.demo.spring.cloud.service.admin.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {
    @Value("${server.port}")
    private String port;

    @RequestMapping(value = "hi",method = RequestMethod.GET)
    public String sayHi(String message){
        return String.format("Hi your message is : %s port:%s",message,port);
    }
}
