package com.haoqiangwang.cloud.eurekaclient.controller;

import com.alibaba.fastjson.JSONObject;
import com.haoqiangwang.cloud.eurekaclient.pojo.HelloRequestPO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;

@RestController
public class ServiceController {

    private static final Logger logger = LoggerFactory.getLogger(ServiceController.class);

    @Value("${server.port}")
    private String port;

    @RequestMapping("/hi")
    public String sayHi(@RequestParam(value = "name", defaultValue = "haoqiang") String name){

        return "hi:" + name + ",i am from port:" + port;
    }

    @RequestMapping(value = "/test/date", method = RequestMethod.POST)
    public String testDate(@RequestBody HelloRequestPO helloRequestPO){
        logger.info("接收到的信息为：{}", JSONObject.toJSONString(helloRequestPO));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createTime = simpleDateFormat.format(helloRequestPO.getCreateTime());
        logger.info("时间接收结果为：{}", createTime);
        return "success";
    }
}
