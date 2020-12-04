package com.object.serviceb.controller;

import com.object.serviceb.service.ServiceAFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testb")
public class TestBController {
    @Autowired
    ServiceAFeignClient aFeignClient;

    @RequestMapping("/call")
    public String call(){
        String hello = aFeignClient.hello();
        return "B 访问 A 的访问结果是:"+hello;
    }

}
