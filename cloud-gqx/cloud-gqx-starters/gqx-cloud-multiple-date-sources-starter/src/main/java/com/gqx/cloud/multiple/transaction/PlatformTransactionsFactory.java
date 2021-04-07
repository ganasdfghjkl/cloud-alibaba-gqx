package com.gqx.cloud.multiple.transaction;

import org.apache.ibatis.session.TransactionIsolationLevel;
import org.apache.ibatis.transaction.Transaction;
import org.mybatis.spring.transaction.SpringManagedTransactionFactory;

import javax.sql.DataSource;
import java.sql.Connection;

public class PlatformTransactionsFactory extends SpringManagedTransactionFactory {
    @Override
    public Transaction newTransaction(DataSource dataSource, TransactionIsolationLevel level, boolean autoCommit) {
        return new PlatformManagedTransaction(dataSource);
    }
}
