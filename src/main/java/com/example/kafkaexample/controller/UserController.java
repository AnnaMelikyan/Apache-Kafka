package com.example.kafkaexample.controller;

import com.example.kafkaexample.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class UserController {

  @Autowired
   KafkaTemplate <String, User> kafkaTemplate;

  private static final String TOPIC="my_topic";

  @GetMapping("/publish/{name}")
  public String post(@PathVariable("name")  String name) {
    kafkaTemplate.send(TOPIC, new User(name, "poxosyan"));
    return "Published successfully";
  }
}
