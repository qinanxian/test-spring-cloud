package com.object.servicea.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class TestController {
    @Value("${server.port}")
    private String port;

    @RequestMapping("/hello")
    public String hello(){
        return "你好 世界 ==>"+port;
    }
}
