package com.demo.spring.cloud.zuul.provider;

import com.fasterxml.jackson.databind.*;
import org.springframework.cloud.netflix.zuul.filters.route.*;
import org.springframework.http.*;
import org.springframework.http.client.*;
import org.springframework.stereotype.*;

import java.io.*;
import java.util.*;

@Component
public class WebAdminFeignFallbackProvider implements FallbackProvider {
    @Override
    public String getRoute() {//失败时调用，调用返回具体路由服务，在这里是feign服务
        return "demo-spring-cloud-web-admin-feign";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return HttpStatus.OK.value();
            }

            @Override
            public String getStatusText() throws IOException {
                return HttpStatus.OK.getReasonPhrase();
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                ObjectMapper objectMapper=new ObjectMapper();
                Map map = new HashMap();
                map.put("status","200");
                map.put("message","无法连接，请检查你的网络");
                return new ByteArrayInputStream(objectMapper.writeValueAsString(map).getBytes("utf-8"));
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
                return httpHeaders ;
            }
        };
    }
}
