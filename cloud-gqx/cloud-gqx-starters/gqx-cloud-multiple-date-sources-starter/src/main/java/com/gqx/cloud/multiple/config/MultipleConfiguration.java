package com.gqx.cloud.multiple.config;

import com.alibaba.druid.pool.xa.DruidXADataSource;
import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.gqx.cloud.multiple.aspect.DataSourceAOP;
import com.gqx.cloud.multiple.datasource.DynamicDataSource;
import com.gqx.cloud.multiple.properties.DataSourceProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Configuration
@EnableConfigurationProperties({DataSourceProperties.class})
@Import({DataSourceAOP.class})
@ConditionalOnProperty(prefix = DataSourceProperties.DATA_SOURCE_PREFIX,name = "enable",havingValue = "true")
public class MultipleConfiguration {

    @Resource
    DataSourceProperties dataSourceProperties;

    @Bean
    public DynamicDataSource dynamicDataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        Map<Object,Object> map = new HashMap<>();
        AtomikosDataSourceBean defaultDateSource = null;
        for (int i = 0; i < dataSourceProperties.getSources().size(); i++) {
            DataSourceProperties.DataSourceInfoProperties a = dataSourceProperties.getSources().get(i);
            DruidXADataSource dataSource = new DruidXADataSource();
            dataSource.setDriverClassName(a.getDriverClassName());
            dataSource.setUrl(a.getUrl());
            dataSource.setUsername(a.getUsername());
            dataSource.setPassword(a.getPassword());
            //连接池配置
            dataSource.setMaxActive(dataSourceProperties.getMaxActive());
            dataSource.setMinIdle(dataSourceProperties.getMinIdle());
            dataSource.setInitialSize(dataSourceProperties.getInitialSize());
            dataSource.setMaxWait(dataSourceProperties.getMaxWait());
            dataSource.setTimeBetweenEvictionRunsMillis(dataSourceProperties.getTimeBetweenEvictionRunsMillis());
            dataSource.setMinEvictableIdleTimeMillis(dataSourceProperties.getMinEvictableIdleTimeMillis());
            dataSource.setTestWhileIdle(dataSourceProperties.getTestWhileIdle());
            dataSource.setTestOnBorrow(dataSourceProperties.getTestOnBorrow());
            dataSource.setTestOnReturn(dataSourceProperties.getTestOnReturn());
            dataSource.setValidationQuery("SELECT 1");
            dataSource.setPoolPreparedStatements(true);
            dataSource.setMaxPoolPreparedStatementPerConnectionSize(dataSourceProperties.getMaxPoolPreparedStatementPerConnectionSize());
            try {
                dataSource.setFilters(dataSourceProperties.getFilters());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            AtomikosDataSourceBean atomikosDataSource = new AtomikosDataSourceBean();
            atomikosDataSource.setUniqueResourceName(a.getDataSourceName());
            atomikosDataSource.setXaDataSource(dataSource);
            atomikosDataSource.setTestQuery("SELECT 1");
            if (Objects.isNull(defaultDateSource)){
                defaultDateSource = atomikosDataSource;
            }
            map.put(atomikosDataSource,dataSourceProperties);
        }
        dynamicDataSource.setTargetDataSources(map);
        dynamicDataSource.setDefaultTargetDataSource(defaultDateSource);
        dynamicDataSource.afterPropertiesSet();
        return dynamicDataSource;
    }

    /**
     * 逻辑删除插件
     */

    /**
     * 分页插件
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }

}
