package com.gqx.cloud.servertwo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gqx.cloud.servertwo.entity.Test;
import com.gqx.cloud.servertwo.entity.User;

public interface IUserService extends IService<User> {

    void testSave();

}
