package com.gqx.cloud.serverfour.controller;

import com.gqx.cloud.serverfour.kafka.KafkaProducer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestKafkaController {

    @Resource
    KafkaProducer<String> kafkaProducer;
    @GetMapping("/sendKafka")
    public String sendKafka(){
        kafkaProducer.send("str","test");
        return "OK";
    }

}
