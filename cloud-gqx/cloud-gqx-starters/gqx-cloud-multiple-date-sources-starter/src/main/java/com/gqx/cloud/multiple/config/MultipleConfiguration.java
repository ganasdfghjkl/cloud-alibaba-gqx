package com.gqx.cloud.multiple.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.gqx.cloud.multiple.datasource.DynamicDataSource;
import com.gqx.cloud.multiple.properties.DataSourceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableConfigurationProperties({DataSourceProperties.class})
public class MultipleConfiguration {

    @Resource
    DataSourceProperties dataSourceProperties;

    @Bean
    public DynamicDataSource dynamicDataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        Map<Object,Object> map = new HashMap<>();
        DruidDataSource defaultDataSource = null;
        DruidDataSourceBuilder.create().build();
        dataSourceProperties.getSources().forEach(
                a->{
//                    DruidDataSource wdataSource = new DruidDataSource();
//                    wdataSource.setDriverClassName(dataSourceProperties.get);
//                    wdataSource.setUrl(wurl);
//                    wdataSource.setUsername(wuser);
//                    wdataSource.setPassword(wpassword);
//                    //连接池配置
//                    wdataSource.setMaxActive(maxActive);
//                    wdataSource.setMinIdle(minIdle);
//                    wdataSource.setInitialSize(initialSize);
//                    wdataSource.setMaxWait(maxWait);
//                    wdataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
//                    wdataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
//                    wdataSource.setTestWhileIdle(testWhileIdle);
//                    wdataSource.setTestOnBorrow(testOnBorrow);
//                    wdataSource.setTestOnReturn(testOnReturn);
//                    wdataSource.setValidationQuery("SELECT 'x'");
//                    wdataSource.setPoolPreparedStatements(true);
//                    wdataSource.setMaxPoolPreparedStatementPerConnectionSize(20);
//                    try {
//                        wdataSource.setFilters("stat");
//                    } catch (SQLException e) {
//                        e.printStackTrace();
//                    }
//                    map.put()

                }
        );


//        //jdbc配置
//        DruidDataSource wdataSource = new DruidDataSource();
//        wdataSource.setDriverClassName(wdriverClass);
//        wdataSource.setUrl(wurl);
//        wdataSource.setUsername(wuser);
//        wdataSource.setPassword(wpassword);
//        //连接池配置
//        wdataSource.setMaxActive(maxActive);
//        wdataSource.setMinIdle(minIdle);
//        wdataSource.setInitialSize(initialSize);
//        wdataSource.setMaxWait(maxWait);
//        wdataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
//        wdataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
//        wdataSource.setTestWhileIdle(testWhileIdle);
//        wdataSource.setTestOnBorrow(testOnBorrow);
//        wdataSource.setTestOnReturn(testOnReturn);
//        wdataSource.setValidationQuery("SELECT 'x'");
//        wdataSource.setPoolPreparedStatements(true);
//        wdataSource.setMaxPoolPreparedStatementPerConnectionSize(20);
//        try {
//            wdataSource.setFilters("stat");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        //jdbc配置
//        DruidDataSource rdataSource = new DruidDataSource();
//        rdataSource.setDriverClassName(rdriverClass);
//        rdataSource.setUrl(rurl);
//        rdataSource.setUsername(ruser);
//        rdataSource.setPassword(rpassword);
//
//        //连接池配置
//        rdataSource.setMaxActive(maxActive);
//        rdataSource.setMinIdle(minIdle);
//        rdataSource.setInitialSize(initialSize);
//        rdataSource.setMaxWait(maxWait);
//        rdataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
//        rdataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
//        rdataSource.setTestWhileIdle(testWhileIdle);
//        rdataSource.setTestOnBorrow(testOnBorrow);
//        rdataSource.setTestOnReturn(testOnReturn);
//        rdataSource.setValidationQuery("SELECT 'x'");
//        rdataSource.setPoolPreparedStatements(true);
//        rdataSource.setMaxPoolPreparedStatementPerConnectionSize(20);
//        try {
//            rdataSource.setFilters("stat");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        Map<Object,Object> map = new HashMap<>();
//        map.put("ds1_w", wdataSource);
//        map.put("ds1_r", rdataSource);
//
//        dynamicDataSource.setTargetDataSources(map);
//        dynamicDataSource.setDefaultTargetDataSource(rdataSource);

        return dynamicDataSource;
    }

}
