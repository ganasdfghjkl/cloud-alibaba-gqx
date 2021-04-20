package com.gqx.cloud.serverfive.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Value("${powerjob.worker.akka-port}")
    String port;
    @Value("${powerjob.worker.app-name}")
    String appName;
    @Value("${powerjob.worker.server-address}")
    String  serverAddress;

    @GetMapping("/index")
    public String index(){
        return appName+serverAddress+port;
    }


}
