package com.haoqiangwang.cloud.configclient.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigController {
    private static final Logger logger = LoggerFactory.getLogger(ConfigController.class);

    @Value("${config.name}")
    private String name;

    @Value("${config.password}")
    private String password;

    @RequestMapping(value="/config")
    public String config(){
        logger.info("请求读取的配置文件信息为：{}，{}",name, password);
        return "name=" + name + ",password=" + password;
    }
}
