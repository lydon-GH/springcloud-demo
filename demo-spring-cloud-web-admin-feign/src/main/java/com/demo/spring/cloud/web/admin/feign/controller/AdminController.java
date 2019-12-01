package com.demo.spring.cloud.web.admin.feign.controller;

import com.demo.spring.cloud.web.admin.feign.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "hi",method = RequestMethod.GET)
    public String sayHi(String message){
        return adminService.sayHi(message);
    }
}
