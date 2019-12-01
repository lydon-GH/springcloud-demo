package com.demo.spring.cloud.web.admin.feign.service.hystrix;

import com.demo.spring.cloud.web.admin.feign.service.*;
import org.springframework.stereotype.*;

@Component
public class AdminServiceHystrix implements AdminService {
    @Override
    public String sayHi(String message) {
        return String.format("hi your message is : %s but request bad"+message);
    }
}
