package com.jenson.board.kafka.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Sender {

    private KafkaTemplate<String, String> kafkaTemplate;

    public Sender(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String payload) {
        log.info("sending payload={}", payload);
        kafkaTemplate.send("sample_topic", payload);
    }
}
