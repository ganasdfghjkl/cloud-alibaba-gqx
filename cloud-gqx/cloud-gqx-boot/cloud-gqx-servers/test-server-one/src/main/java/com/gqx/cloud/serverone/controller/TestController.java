package com.gqx.cloud.serverone.controller;

import io.swagger.annotations.Api;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@Api("test")
public class TestController {
    @Resource
    DiscoveryClient discoveryClient;
    @Resource
    CuratorFramework curatorFramework;


    @GetMapping("/getServices")
    public List<String> getClients() {
        InterProcessMutex interProcessMutex = new InterProcessMutex(curatorFramework, "/AAAA");
        List<String> list = new ArrayList<>();
        try {
            interProcessMutex.acquire();
            list = discoveryClient.getServices();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                interProcessMutex.release();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return list;
    }

    @GetMapping("/index")
    public String index() {
        return "hello this server one";
    }
    @GetMapping("/test")
    public String test() {

        return "hello this server one";
    }

}
