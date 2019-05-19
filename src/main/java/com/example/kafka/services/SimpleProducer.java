package com.example.kafka.services;

/*
 * @author: mohit5.kumar
 * @created: 08/05/19
 */
import java.util.*;
import org.apache.kafka.clients.producer.*;
import org.springframework.stereotype.Service;

public interface SimpleProducer {
    void produce(Object obj,String kafkaTopic, String kafkaKey) throws Exception;
}
