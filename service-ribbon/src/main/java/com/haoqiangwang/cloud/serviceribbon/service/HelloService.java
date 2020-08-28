package com.haoqiangwang.cloud.serviceribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloError")
    public String helloService(String name){

        return restTemplate.getForObject("http://SERVICE-HI/hi?name=" + name,String.class);
    }

    public String hiService(){
        return restTemplate.getForObject("http://SERVICE-HI/hi", String.class);
    }

    /**
     * 请求service-hi接口失败时调用如下方法
     * @param name
     * @return
     */
    public String helloError(String name){
        return "hi," + name + ",sorry,error！";
    }
}
