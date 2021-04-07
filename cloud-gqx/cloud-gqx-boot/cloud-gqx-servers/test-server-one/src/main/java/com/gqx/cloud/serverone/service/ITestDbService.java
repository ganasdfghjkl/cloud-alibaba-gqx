package com.gqx.cloud.serverone.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gqx.cloud.serverone.entity.Test;

public interface ITestDbService extends IService<Test> {

    void testSave();

}
