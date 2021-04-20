package com.gqx.cloud.serversix.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gqx.cloud.dubbo.service.ITestSeataService;
import com.gqx.cloud.serversix.entity.Test;
import com.gqx.cloud.serversix.mapper.TestMapper;
import com.gqx.cloud.serversix.service.ITestDbService;
import io.seata.spring.annotation.GlobalTransactional;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestDbServiceImpl extends ServiceImpl<TestMapper, Test> implements ITestDbService {

    @DubboReference
    ITestSeataService testSeataService;

    @Override
    @GlobalTransactional(name = "test",rollbackFor = Exception.class)
    @Transactional(rollbackFor = Exception.class)
    public void testSave() {
        Test t = new Test();
        t.setTitle("cs");
        t.setRemark("cs");
        save(t);
        testSeataService.TestSeata();
    }
}
