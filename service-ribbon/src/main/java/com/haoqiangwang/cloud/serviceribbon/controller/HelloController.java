package com.haoqiangwang.cloud.serviceribbon.controller;

import com.haoqiangwang.cloud.serviceribbon.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private HelloService helloService;

    @RequestMapping(value = "/hi")
    public String hello(String name){
        logger.info("请求到service-ribbon中的hi接口...");
        return helloService.helloService(name);
    }

    @RequestMapping(value = "/hello")
    public String hello(){
        logger.info("请求到service-ribbon中的hello接口...");
        return helloService.hiService();
    }
}
