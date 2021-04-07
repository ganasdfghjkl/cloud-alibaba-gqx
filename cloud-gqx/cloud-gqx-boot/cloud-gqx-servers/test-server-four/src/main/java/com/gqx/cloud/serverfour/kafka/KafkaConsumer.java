package com.gqx.cloud.serverfour.kafka;

import com.gqx.util.json.JsonUtils;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class KafkaConsumer {
    @KafkaListener(topics = "test", groupId = "group")
    public void topic_test(ConsumerRecord<String, Object> record, Acknowledgment ack, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        if (Objects.nonNull(record) &&  Objects.nonNull(record.value())){

            System.out.println("消息被消费");
            System.out.println("消息内容为："+ JsonUtils.toJsonString(record.value()));
            ack.acknowledge();
        }
    }
}
