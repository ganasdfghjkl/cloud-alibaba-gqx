package com.gqx.cloud.multiple.aspect;

import com.gqx.cloud.multiple.holder.DatabaseContextHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 *
 */
@Aspect
@Component
@Order(0)
public class DataSourceAOP {

    @Before("@annotation(targetDataSource)")
    public void beforeTargetDataSource(JoinPoint point, TargetDataSource targetDataSource) {
        if (Objects.nonNull(targetDataSource.value())) {
            DatabaseContextHolder.setDBKey(targetDataSource.value());
        }
    }

    @After("@annotation(targetDataSource)")
    public void afterTargetDataSource(JoinPoint point, TargetDataSource targetDataSource) {
        DatabaseContextHolder.clearDBKey();
    }

}
