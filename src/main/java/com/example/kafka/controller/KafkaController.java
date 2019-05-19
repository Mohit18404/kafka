package com.example.kafka.controller;

import com.example.kafka.constants.KafkaTopics;
import com.example.kafka.dto.UserSignupBody;
import com.example.kafka.services.SimpleProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/*
 * @author: mohit5.kumar
 * @created: 08/05/19
 */
@RestController
public class KafkaController {
    @Autowired
    SimpleProducer simpleProducer;

    public static final Logger logger= LoggerFactory.getLogger(KafkaController.class);

    @GetMapping(value = "produce/data")
    public String produceDataByKafka(@RequestParam String name){
        try {
            simpleProducer.produce(name, KafkaTopics.SimpleProducerTopic.name(), String.valueOf(System.currentTimeMillis()));
        }catch (Exception e){
            System.out.println(e);
        }
        return "data has been produced";
    }

    @PostMapping(value = "insert/data")
    public String insertDataByKafka(@RequestBody UserSignupBody userSignupBody){
        if (userSignupBody==null){
            HttpStatus.BAD_REQUEST.is4xxClientError();
            return "Please check parametres";
        }
        try {

        }catch (Exception e){
            System.out.println(e);
        }
        return "data has been produced";
    }
}
