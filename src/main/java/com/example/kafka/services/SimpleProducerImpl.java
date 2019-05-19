package com.example.kafka.services;

import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.producer.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Properties;

/*
 * @author: mohit5.kumar
 * @created: 08/05/19
 */

@Service
public class SimpleProducerImpl implements SimpleProducer{

    private static final Logger LOGGER		= LoggerFactory.getLogger(SimpleProducerImpl.class);


    @Override
    public void produce(Object obj, String kafkaTopic, String kafkaKey) throws Exception{

        ObjectMapper Obj = new ObjectMapper();
        String value = Obj.writeValueAsString(obj);

        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092,localhost:9093");
        props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);

        ProducerRecord<String, String> record = new ProducerRecord<>(kafkaTopic,kafkaKey,value);
        producer.send(record,getCommonKafkaCallback(obj,  kafkaKey, kafkaTopic));
        producer.close();

        System.out.println("SimpleProducer Completed.");
    }

    private static Callback getCommonKafkaCallback(Object obj, String key, String topic) {
        return new Callback() {
            public void onCompletion(RecordMetadata metadata, Exception exception) {
                if (exception != null)
                    // Using '+' deliberately here to print exception in the same line.
                    // Using  ',' to print exception adds a new line to the log making it harder to trace.
                    LOGGER.error(
                            "Exception while getting message acknowledgement for kafka object {}, key {}, topic {}- " + exception,
                            obj, key, topic);
            }
        };
    }
}
