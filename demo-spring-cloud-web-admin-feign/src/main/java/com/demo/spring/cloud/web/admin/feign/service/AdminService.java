package com.demo.spring.cloud.web.admin.feign.service;

import com.demo.spring.cloud.web.admin.feign.service.hystrix.*;
import org.springframework.cloud.openfeign.*;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "demo-spring-cloud-service-admin",fallback = AdminServiceHystrix.class)
public interface AdminService {
    @RequestMapping(value = "hi" ,method = RequestMethod.GET)
    public String sayHi(@RequestParam(value = "message") String message);

}
