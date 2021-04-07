package com.gqx.cloud.servertwo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class ServerTwoApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServerTwoApplication.class,args);
    }
}
