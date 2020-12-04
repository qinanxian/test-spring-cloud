package com.object.serviceb.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("SERVICE-OBJECT-A")
public interface ServiceAFeignClient {
    @RequestMapping("/test/hello")
    public String hello();
}
