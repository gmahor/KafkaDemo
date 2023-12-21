package com.kakfa.consumer;

import com.kakfa.payload.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumer {

    //    @KafkaListener(topics = "gmahor",groupId = "myGroup")
    public void consumeMsg(String msg) {
        log.info("Consuming the message from gmahor topic : {}", msg);
    }

    @KafkaListener(topics = "gmahor", groupId = "myGroup")
    public void consumeJsonMsg(Student student) {
        log.info("Consuming the message from gmahor topic : {}", student.toString());
    }

}
