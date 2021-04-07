package com.gqx.cloud.multiple.config;

import com.alibaba.druid.pool.xa.DruidXADataSource;
import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.gqx.cloud.multiple.aspect.DataSourceAOP;
import com.gqx.cloud.multiple.datasource.DynamicDataSource;
import com.gqx.cloud.multiple.properties.DataSourceProperties;
import com.gqx.cloud.multiple.transaction.PlatformTransactionsFactory;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Configuration
@EnableConfigurationProperties({DataSourceProperties.class})
@Import({DataSourceAOP.class,JtaTransactionConfiguration.class})
@ConditionalOnProperty(prefix = DataSourceProperties.DATA_SOURCE_PREFIX,name = "enable",havingValue = "true")
public class MultipleConfiguration {

    @Resource
    DataSourceProperties dataSourceProperties;

    @Bean
    public DynamicDataSource dataSource() {
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
            atomikosDataSource.setMaxPoolSize(dataSourceProperties.getMaxActive());
            atomikosDataSource.setMaxLifetime(dataSourceProperties.getMaxWait().intValue());
            atomikosDataSource.setTestQuery("SELECT 1");
            if (Objects.isNull(defaultDateSource)){
                defaultDateSource = atomikosDataSource;
            }
            map.put(a.getDataSourceName(),atomikosDataSource);
        }
        dynamicDataSource.setTargetDataSources(map);
        dynamicDataSource.setDefaultTargetDataSource(defaultDateSource);
        dynamicDataSource.afterPropertiesSet();
        return dynamicDataSource;
    }

    @Bean(name = "sqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory(DynamicDataSource dataSource)
            throws Exception {

        MybatisSqlSessionFactoryBean sqlSessionFactory = new MybatisSqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
        //sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/*/*Mapper.xml"));

        MybatisConfiguration configuration = new MybatisConfiguration();
        //configuration.setDefaultScriptingLanguage(MybatisXMLLanguageDriver.class);
        configuration.setJdbcTypeForNull(JdbcType.NULL);
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.setCacheEnabled(false);
        sqlSessionFactory.setConfiguration(configuration);
        sqlSessionFactory.setPlugins(new Interceptor[]{ //PerformanceInterceptor(),OptimisticLockerInterceptor()
                mybatisPlusInterceptor() //添加分页功能
        });
        sqlSessionFactory.setTransactionFactory(new PlatformTransactionsFactory());
        //sqlSessionFactory.setGlobalConfig(globalConfiguration());
        return sqlSessionFactory.getObject();
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
