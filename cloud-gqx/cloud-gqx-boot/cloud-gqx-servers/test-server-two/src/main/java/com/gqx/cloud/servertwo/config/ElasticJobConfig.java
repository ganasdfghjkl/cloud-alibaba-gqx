package com.gqx.cloud.servertwo.config;

import com.dangdang.ddframe.job.api.ElasticJob;
import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.JobRootConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.lite.spring.api.SpringJobScheduler;
import com.dangdang.ddframe.job.reg.base.CoordinatorRegistryCenter;
import com.gqx.cloud.servertwo.elassticjob.TestJob;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author
 */
@Configuration
public class ElasticJobConfig {



    @Resource
    CoordinatorRegistryCenter coordinatorRegistryCenter;
    @Resource
    TestJob testJob;

    @Bean(initMethod = "init")
    public SpringJobScheduler springJobScheduler(){

        return new SpringJobScheduler(testJob,
                coordinatorRegistryCenter,
                liteJobConfiguration(testJob.getClass(),
                        "0/10 * * * * ?",
                        1,
                        "","test"
                        ));
    }


    public LiteJobConfiguration liteJobConfiguration(final  Class<? extends ElasticJob> jobClazz,
                                                     final  String cron,
                                                     final  int shardingTotalCount,
                                                     final String shardingItemParameters,
                                                     final String jobName
                                                     ){
        JobCoreConfiguration.Builder jobCoreConfBuilder = JobCoreConfiguration.newBuilder(
                StringUtils.isBlank(jobName)?jobClazz.getName():jobName,
                cron,shardingTotalCount);

        if (StringUtils.isNotBlank(shardingItemParameters)){
            jobCoreConfBuilder.shardingItemParameters(shardingItemParameters);
        }

        SimpleJobConfiguration simpleJobConfiguration = new SimpleJobConfiguration(jobCoreConfBuilder.build(),jobClazz.getCanonicalName());

       return LiteJobConfiguration.newBuilder(simpleJobConfiguration).overwrite(true).build();
    }


}
