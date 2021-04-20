package com.gqx.cloud.serversix.controller;

import com.gqx.cloud.serversix.service.ITestDbService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Api("test")
public class TestController {
    @Resource
    ITestDbService testDbService;



    @GetMapping("/index")
    public String index() {
        return "hello this server one";
    }
    @GetMapping("/test")
    public String test()     {
        testDbService.testSave();

        return "hello this server one";
    }

}
