package com.object.servicea.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class rediscontroller {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @RequestMapping("/save")
    public void   RedisSave(){


    }
}
