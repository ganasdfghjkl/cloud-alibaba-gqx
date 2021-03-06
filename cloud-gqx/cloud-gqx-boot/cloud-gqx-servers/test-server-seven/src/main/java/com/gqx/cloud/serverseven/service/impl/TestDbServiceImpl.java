package com.gqx.cloud.serverseven.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gqx.cloud.serverseven.entity.Test;
import com.gqx.cloud.serverseven.mapper.TestMapper;
import com.gqx.cloud.serverseven.service.ITestDbService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class TestDbServiceImpl extends ServiceImpl<TestMapper, Test> implements ITestDbService {

    static AtomicInteger atomicInteger = new AtomicInteger(2);

    @Override
    @GlobalTransactional(name = "test",rollbackFor = Exception.class)
    @Transactional(rollbackFor = Exception.class)
    public void testSave() {
        Test t = new Test();
        t.setTitle("cs");
        t.setRemark("cs");
        save(t);
        int i = atomicInteger.getAndIncrement();
        if (i % 2 ==0){
            int test = i/0;
        }
    }
}
