package com.gqx.cloud.zookeeper.config;

import com.gqx.cloud.zookeeper.entity.ZookeeperProperties;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.annotation.Resource;

@Configuration
@EnableConfigurationProperties({ZookeeperProperties.class})
@ConditionalOnProperty(prefix = "cloud.gqx.enable",name = "zookeeper",havingValue = "true")
public class ZookeeperConfig {

    @Resource
    ZookeeperProperties zookeeperProperties;


    @Bean(initMethod = "start")
    public CuratorFramework curatorFramework(){
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(zookeeperProperties.getBaseSleepTimeMs(), zookeeperProperties.getMaxRetries());
        CuratorFramework client = CuratorFrameworkFactory.newClient(zookeeperProperties.getServers(), retryPolicy);
        return client;
    }

}
