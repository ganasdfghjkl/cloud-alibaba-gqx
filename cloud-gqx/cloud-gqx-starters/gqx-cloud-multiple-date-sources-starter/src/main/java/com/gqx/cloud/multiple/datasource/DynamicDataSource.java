package com.gqx.cloud.multiple.datasource;

import com.gqx.cloud.multiple.holder.DatabaseContextHolder;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    public Object determineCurrentLookupKey() {
        return DatabaseContextHolder.getDBKey();
    }

    @Override
    public DataSource determineTargetDataSource(){
        return super.determineTargetDataSource();
    }
}
