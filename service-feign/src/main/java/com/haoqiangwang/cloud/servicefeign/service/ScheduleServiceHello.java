package com.haoqiangwang.cloud.servicefeign.service;

import com.haoqiangwang.cloud.servicefeign.service.impl.ScheduleServiceHelloHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
* @Description: fallback 添加熔断实现类
* @Author:      haoqiangwang3
* @CreateDate:  2020/8/28
*/
@FeignClient(value = "service-hi", fallback = ScheduleServiceHelloHystrix.class) //通过@FeignClient来指定调用哪个服务
public interface ScheduleServiceHello {

    @GetMapping("/hi")
    String syaHelloFromClientOne(@RequestParam(value = "name") String name);
}
