package com.gqx.cloud.serverfour.kafka;

import com.gqx.util.json.JsonUtils;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import javax.annotation.Resource;

@Component
public class KafkaProducer<T> {
    @Resource
    private KafkaTemplate<String,T> kafkaTemplate;

    public void send(T t, String topic){
        String obj2String = JsonUtils.toJsonString(t);
        //发送消息
        ListenableFuture<SendResult<String, T>> future = kafkaTemplate.send(topic, t);
        future.addCallback(new ListenableFutureCallback<SendResult<String, T>>() {
            @Override
            public void onFailure(Throwable throwable) {
                //发送失败的处理
            }
            @Override
            public void onSuccess(SendResult<String, T> stringObjectSendResult) {
                //成功的处理
            }
        });
    }


}
