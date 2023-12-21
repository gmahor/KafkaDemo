package com.kakfa.controllers;

import com.kakfa.payload.Student;
import com.kakfa.producer.KafkaJsonProducer;
import com.kakfa.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/messages")
@RequiredArgsConstructor
public class MessageController {

    private final KafkaProducer kafkaProducer;
    private final KafkaJsonProducer kafkaJsonProducer;

    @PostMapping
    public ResponseEntity<String> sendMsg(@RequestBody String msg) {
        kafkaProducer.sendMessage(msg);
        return ResponseEntity.ok("Message send successfully");
    }


    @PostMapping("/json")
    public ResponseEntity<String> sendJsonMsg(@RequestBody Student student) {
        kafkaJsonProducer.sendMessage(student);
        return ResponseEntity.ok("Message send successfully as json");
    }


}
