package com.object.servicea.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
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

    @HystrixCommand(fallbackMethod = "fallback")  //指定回退方法
    @RequestMapping("/hystrix")
    public String Hystrix(){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "这是hystrix 保护测试";
    }

    /**
     * 回推方法，
     * @return
     */
    String fallback(){
        return "服务器繁忙，请稍等片刻！";
    }
}
