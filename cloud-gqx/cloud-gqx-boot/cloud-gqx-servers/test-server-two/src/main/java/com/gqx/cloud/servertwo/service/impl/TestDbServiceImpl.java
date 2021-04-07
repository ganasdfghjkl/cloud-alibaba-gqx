package com.gqx.cloud.servertwo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gqx.cloud.multiple.aspect.TargetDataSource;
import com.gqx.cloud.servertwo.entity.Test;
import com.gqx.cloud.servertwo.mapper.TestMapper;
import com.gqx.cloud.servertwo.service.ITestDbService;
import com.gqx.cloud.servertwo.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class TestDbServiceImpl extends ServiceImpl<TestMapper, Test> implements ITestDbService {

    @Resource
    IUserService userService;

    @Override
    @Transactional(value = "platformTransactionManager", rollbackFor = Exception.class)
    @TargetDataSource("tese1")
    public void testSave() {
        Test t = new Test();
        t.setTitle("cs");
        t.setRemark("cs");
        save(t);
        userService.testSave();
        int i = 1/0;
    }
}
