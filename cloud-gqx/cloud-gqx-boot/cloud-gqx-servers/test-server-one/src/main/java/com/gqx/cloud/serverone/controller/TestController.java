package com.gqx.cloud.serverone.controller;

import io.swagger.annotations.Api;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api("test")
public class TestController {
    @Resource
    DiscoveryClient discoveryClient;

    @GetMapping("/getServices")
    public List<String> getClients(){
        return discoveryClient.getServices();
    }
    @GetMapping("/index")
    public String index(){
        return "hello this server one";
    }


}
