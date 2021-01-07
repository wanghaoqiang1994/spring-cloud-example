package com.haoqiangwang.cloud.servicefeign.service.impl;

import com.haoqiangwang.cloud.servicefeign.pojo.HelloRequestPO;
import com.haoqiangwang.cloud.servicefeign.service.ScheduleServiceHello;
import org.springframework.stereotype.Component;

@Component
public class ScheduleServiceHelloHystrix implements ScheduleServiceHello {
    @Override
    public String syaHelloFromClientOne(String name) {
        return "sorry," + name;
    }

    @Override
    public String testDate(HelloRequestPO helloRequestPO) {
        return "null";
    }


}
