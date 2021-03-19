package com.gqx.cloud.serverone;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.swing.*;

@SpringBootApplication
@EnableSwagger2
public class ServerOneApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServerOneApplication.class,args);
    }
}
