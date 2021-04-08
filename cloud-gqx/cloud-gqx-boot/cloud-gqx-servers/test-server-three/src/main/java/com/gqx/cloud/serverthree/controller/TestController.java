package com.gqx.cloud.serverthree.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

/**
 *
 */
@RestController
@RefreshScope
public class TestController {

    @Value("${test.test:xxxxxx}")
    String test;
    @Value("${cs.cs:11111}")
    String cs;

    @GetMapping("/test")
    public String test() {
        return "test:"+test+"；CS:"+cs;
    }

}
