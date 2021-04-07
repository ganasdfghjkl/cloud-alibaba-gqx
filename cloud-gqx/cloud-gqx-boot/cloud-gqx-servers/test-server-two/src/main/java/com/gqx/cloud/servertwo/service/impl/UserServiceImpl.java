package com.gqx.cloud.servertwo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gqx.cloud.multiple.aspect.TargetDataSource;
import com.gqx.cloud.servertwo.entity.Test;
import com.gqx.cloud.servertwo.entity.User;
import com.gqx.cloud.servertwo.mapper.TestMapper;
import com.gqx.cloud.servertwo.mapper.UserMapper;
import com.gqx.cloud.servertwo.service.ITestDbService;
import com.gqx.cloud.servertwo.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    @Transactional(value = "platformTransactionManager", rollbackFor = Exception.class)
    @TargetDataSource("tese2")
    public void testSave() {
        User t = new User();
        t.setTitle("cs");
        t.setRemark("cs");
        save(t);
    }
}
