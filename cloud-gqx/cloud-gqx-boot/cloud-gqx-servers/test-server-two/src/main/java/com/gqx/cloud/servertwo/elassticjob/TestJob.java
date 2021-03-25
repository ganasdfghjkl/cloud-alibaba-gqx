package com.gqx.cloud.servertwo.elassticjob;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import org.springframework.stereotype.Component;

@Component
public class TestJob implements SimpleJob {
    @Override
    public void execute(ShardingContext shardingContext) {
        for (int i = 0; i <10 ; i++) {
            System.out.println("执行任务测试");
        }
    }
}
