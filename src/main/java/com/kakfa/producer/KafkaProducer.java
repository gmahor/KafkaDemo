package com.kakfa.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String msg) {
        log.info("sending message to gmahor topic : {}",msg);
        kafkaTemplate.send("gmahor", msg);
    }
}
