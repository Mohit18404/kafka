package com.example.kafka.controller;

import com.example.kafka.constants.KafkaTopics;
import com.example.kafka.dao.UserRegistration;
import com.example.kafka.dto.UserSignupBody;
import com.example.kafka.jpa.UserRegistrationJpaRepository;
import com.example.kafka.pojo.AuditRequest;
import com.example.kafka.pojo.AuditRequestBuilder;
import com.example.kafka.services.SimpleProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @author: mohit5.kumar
 * @created: 10/05/19
 */
@RestController
@RequestMapping("/user")
public class SignupController {
    @Autowired
    UserRegistrationJpaRepository userRegistrationJpaRepository;
    @Autowired
    SimpleProducer simpleProducer;

    private static final Logger LOGGER		= LoggerFactory.getLogger(SignupController.class);

    @PostMapping("/register")
    public String userRegister(@RequestBody UserSignupBody userSignupBody){
        if(userSignupBody==null || userSignupBody.getPhone()==null){
            HttpStatus.BAD_REQUEST.is4xxClientError();
            LOGGER.info("parametrs are missing {}", userSignupBody);
            return "Please provide parameteres";
        }

        UserRegistration userRegistration=null;
        if(userSignupBody.getName()!=null){
            String[] name=userSignupBody.getName().split(" ");
            userRegistration=new UserRegistration();
            userRegistration.setFirst_name(name[0]);
            userRegistration.setLast_name(name[1]);
        }
        userRegistration.setEmail(userSignupBody.getEmail());
        userRegistration.setPhone(userSignupBody.getPhone());
        userRegistrationJpaRepository.insert(userRegistration);
        LOGGER.info("data has been saved in db");
        AuditRequest auditRequest=new AuditRequestBuilder().setActor(userSignupBody.getActor())
                .setName(userSignupBody.getName()).setPhone(userSignupBody.getPhone())
                .setEmail(userSignupBody.getEmail()).build();
        try {
            simpleProducer.produce(auditRequest, KafkaTopics.AuditHistory.name(),String.valueOf(System.currentTimeMillis()));
            LOGGER.info("Audit has been created");
        }catch (Exception e){
            System.out.println(e);
        }
        return "Registaraion success";
    }
}
