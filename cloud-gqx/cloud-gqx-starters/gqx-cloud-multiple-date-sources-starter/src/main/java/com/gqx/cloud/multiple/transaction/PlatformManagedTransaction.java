package com.gqx.cloud.multiple.transaction;

import com.gqx.cloud.multiple.datasource.DynamicDataSource;
import org.mybatis.spring.transaction.SpringManagedTransaction;
import org.springframework.jdbc.datasource.DataSourceUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.ConcurrentHashMap;

public class PlatformManagedTransaction extends SpringManagedTransaction {

    DataSource dataSource;
    ConcurrentHashMap<Object, Connection> map = new ConcurrentHashMap<>();

    public PlatformManagedTransaction(DataSource dataSource) {
        super(dataSource);
        this.dataSource = dataSource;
    }

    @Override
    public Connection getConnection() throws SQLException {

        DynamicDataSource dynamicDataSource = (DynamicDataSource) dataSource;
        Object key = dynamicDataSource.determineCurrentLookupKey();
        if (map.containsKey(key)) {
            return map.get(key);
        }
        Connection con = DataSourceUtils.getConnection(dynamicDataSource.determineTargetDataSource());
        map.put(key, con);
        return con;
    }


}
