package com.gqx.cloud.servertwo.controller;

import com.gqx.cloud.dubbo.service.ITestService;
import com.gqx.cloud.servertwo.service.ITestDbService;
import com.gqx.cloud.servertwo.service.IUserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
public class TestController {

    @Resource
    DiscoveryClient discoveryClient;

    @Resource
    ITestDbService testDbService;
    @Resource
    IUserService userService;
    @GetMapping("/index")
    public String index(){
        List<ServiceInstance> instances = discoveryClient.getInstances("test-server-one");
        URI uri = instances.get(0).getUri();
        String url = uri.toString()+"/index";
        RestTemplate restTemplate = new RestTemplate();
        String str = restTemplate.getForObject(url,String.class);
        return str;
    }


    @DubboReference
    ITestService testService;
    @GetMapping("/dubbo")
    public String testDubbo(){
        return testService.testDubbo();
    }

    @GetMapping("/test")
    public String test() {
        testDbService.testSave();
        return "hello this server one";
    }



}
