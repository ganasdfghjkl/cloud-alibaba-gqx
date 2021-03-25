package com.gqx.cloud.servertwo.config;

import com.dangdang.ddframe.job.reg.base.CoordinatorRegistryCenter;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author
 */
@Configuration
public class ElasticJobRegistryCenterConfig {

    private static String ZK_SERVERS = "localhost:2181";

    private static String JOB_NAMESPACE = "elastic-job-test";

    @Bean(initMethod = "init")
    public CoordinatorRegistryCenter coordinatorRegistryCenter111(){
        ZookeeperConfiguration zookeeperConfiguration = new ZookeeperConfiguration(ZK_SERVERS, JOB_NAMESPACE);
        zookeeperConfiguration.setConnectionTimeoutMilliseconds(100);
        return new ZookeeperRegistryCenter(zookeeperConfiguration);
    }

}
