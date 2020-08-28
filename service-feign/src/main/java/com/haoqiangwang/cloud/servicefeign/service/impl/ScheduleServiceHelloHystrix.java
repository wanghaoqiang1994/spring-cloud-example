package com.haoqiangwang.cloud.servicefeign.service.impl;

import com.haoqiangwang.cloud.servicefeign.service.ScheduleServiceHello;
import org.springframework.stereotype.Component;

@Component
public class ScheduleServiceHelloHystrix implements ScheduleServiceHello {
    @Override
    public String syaHelloFromClientOne(String name) {
        return "sorry," + name;
    }
}
