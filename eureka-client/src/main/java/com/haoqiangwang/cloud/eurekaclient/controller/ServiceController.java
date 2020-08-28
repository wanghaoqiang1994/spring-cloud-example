package com.haoqiangwang.cloud.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/hi")
    public String sayHi(@RequestParam(value = "name", defaultValue = "haoqiang") String name){

        return "hi:" + name + ",i am from port:" + port;
    }
}
