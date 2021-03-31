package com.gqx.cloud.multiple.holder;

/**
 * 用来指定使用哪一个数据源
 */
public class DatabaseContextHolder {
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    public static void setDBKey(String dataSourceKey) {
        contextHolder.set(dataSourceKey);
    }

    public static String getDBKey() {
        return contextHolder.get();
    }

    public static void clearDBKey() {
        contextHolder.remove();
    }
}
