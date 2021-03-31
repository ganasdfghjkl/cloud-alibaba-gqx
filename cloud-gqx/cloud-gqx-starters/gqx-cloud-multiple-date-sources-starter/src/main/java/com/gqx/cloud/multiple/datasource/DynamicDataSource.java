package com.gqx.cloud.multiple.datasource;

import com.gqx.cloud.multiple.holder.DatabaseContextHolder;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DatabaseContextHolder.getDBKey();
    }
}
