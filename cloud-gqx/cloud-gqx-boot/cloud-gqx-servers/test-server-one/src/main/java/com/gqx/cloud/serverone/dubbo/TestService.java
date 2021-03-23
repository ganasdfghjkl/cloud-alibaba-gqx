package com.gqx.cloud.serverone.dubbo;

import com.gqx.cloud.dubbo.service.ITestService;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

@DubboService
public class TestService implements ITestService {

    @Override
    public String testDubbo() {


        return "hallo this one for dubbo";
    }
}
