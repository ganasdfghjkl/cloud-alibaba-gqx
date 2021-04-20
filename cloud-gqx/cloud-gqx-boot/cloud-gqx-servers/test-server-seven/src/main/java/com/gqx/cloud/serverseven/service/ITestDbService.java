package com.gqx.cloud.serverseven.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gqx.cloud.serverseven.entity.Test;

public interface ITestDbService extends IService<Test> {

    void testSave();

}
