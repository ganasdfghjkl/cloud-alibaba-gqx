package com.gqx.cloud.multiple.config;

import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.jta.JtaTransactionManager;


import javax.transaction.TransactionManager;
import javax.transaction.UserTransaction;


/**
 *   JtaTransactionConfiguration 事务配置
 *   https://blog.csdn.net/qq_31665011/article/details/96286037
 */
@Configuration
public class JtaTransactionConfiguration {

    @Bean
    public UserTransaction userTransaction() throws Throwable {
        UserTransactionImp userTransactionImp = new UserTransactionImp();
        userTransactionImp.setTransactionTimeout(1000);
        return userTransactionImp;
    }

    @Bean(initMethod = "")
    public TransactionManager transactionManager() throws Throwable {
        UserTransactionManager transactionManager = new UserTransactionManager();
        transactionManager.setForceShutdown(false);
        return transactionManager;
    }

    @Bean(name = "platformTransactionManager")
    public PlatformTransactionManager platformTransactionManager() throws Throwable {
        return new JtaTransactionManager(userTransaction(), transactionManager());
    }

}
