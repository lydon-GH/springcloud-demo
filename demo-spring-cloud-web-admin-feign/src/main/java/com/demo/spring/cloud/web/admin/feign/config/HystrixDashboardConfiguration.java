package com.demo.spring.cloud.web.admin.feign.config;

import com.netflix.hystrix.contrib.metrics.eventstream.*;
import org.springframework.boot.web.servlet.*;
import org.springframework.context.annotation.*;

@Configuration
public class HystrixDashboardConfiguration {

    @Bean
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet streamServlet=new HystrixMetricsStreamServlet();
        ServletRegistrationBean servletRegistrationBean=new ServletRegistrationBean(streamServlet);
        servletRegistrationBean.setLoadOnStartup(1);
        servletRegistrationBean.addUrlMappings("/hystrix.stream");
        servletRegistrationBean.setName("HystrixMetricsStreamServlet");
        return servletRegistrationBean;
    }
}
