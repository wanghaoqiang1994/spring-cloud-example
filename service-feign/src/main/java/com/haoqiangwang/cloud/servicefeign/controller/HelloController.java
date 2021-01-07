package com.haoqiangwang.cloud.servicefeign.controller;

import com.haoqiangwang.cloud.servicefeign.pojo.HelloRequestPO;
import com.haoqiangwang.cloud.servicefeign.service.ScheduleServiceHello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class HelloController {

    @Autowired
    private ScheduleServiceHello scheduleServiceHello;

    @GetMapping(value = "/hi")
    public String syaHello(@RequestParam String name){
        return scheduleServiceHello.syaHelloFromClientOne(name);
    }

    @GetMapping(value = "/testDate")
    public String test(){
        HelloRequestPO helloRequestPO = new HelloRequestPO();
        helloRequestPO.setId(123L);
        helloRequestPO.setBillNo("12345678");
        helloRequestPO.setStatus("2");
        helloRequestPO.setCreateTime(new Date());
        helloRequestPO.setUpdateTime(new Date());
        return scheduleServiceHello.testDate(helloRequestPO);
    }
}
