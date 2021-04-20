package com.gqx.cloud.serversix.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gqx.cloud.serversix.entity.Test;

public interface ITestDbService extends IService<Test> {

    void testSave();

}
