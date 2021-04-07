package com.gqx.cloud.servertwo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gqx.cloud.servertwo.entity.Test;

public interface ITestDbService extends IService<Test> {

    void testSave();

}
