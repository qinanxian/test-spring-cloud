package com.object.servicezuul;

import com.object.servicezuul.filter.GetTokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy //开启网关
public class ServiceZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceZuulApplication.class, args);
    }

    //将过滤器交给Spring管理  不然不生效
    @Bean
    public GetTokenFilter tokenFilter(){
        return new GetTokenFilter();
    }
}
