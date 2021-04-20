package com.gqx.cloud.serverseven.dubbo;

import com.gqx.cloud.dubbo.service.ITestSeataService;
import com.gqx.cloud.serverseven.service.ITestDbService;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

@DubboService
public class TestSeataService implements ITestSeataService {

    @Resource
    ITestDbService testDbService;

    @Override
    public void TestSeata() {
        testDbService.testSave();
    }
}
