package com.haoqiangwang.cloud.servicefeign.controller;

import com.haoqiangwang.cloud.servicefeign.service.ScheduleServiceHello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private ScheduleServiceHello scheduleServiceHello;

    @GetMapping(value = "/hi")
    public String syaHello(@RequestParam String name){
        return scheduleServiceHello.syaHelloFromClientOne(name);
    }
}
