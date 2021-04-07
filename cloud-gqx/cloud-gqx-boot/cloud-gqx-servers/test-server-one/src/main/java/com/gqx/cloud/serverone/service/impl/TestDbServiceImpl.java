package com.gqx.cloud.serverone.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gqx.cloud.serverone.entity.Test;
import com.gqx.cloud.serverone.mapper.TestMapper;
import com.gqx.cloud.serverone.service.ITestDbService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestDbServiceImpl extends ServiceImpl<TestMapper, Test> implements ITestDbService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void testSave() {
        Test t = new Test();
        t.setTitle("cs");
        t.setRemark("cs");
        save(t);
        int i = 1/0;
    }
}
