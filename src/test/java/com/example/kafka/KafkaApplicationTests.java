package com.example.kafka;

import com.example.kafka.dao.UserRegistration;
import com.example.kafka.jpa.UserRegistrationJpaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KafkaApplicationTests {

	@Autowired
	UserRegistrationJpaRepository userRegistrationJpaRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void save(){
		UserRegistration userRegistration=new UserRegistration();
		userRegistration.setPhone("88524734333");
		userRegistration.setEmail("abcd@gmail.com");
		userRegistration.setLast_name("bansal");
		userRegistration.setFirst_name("raju");
		userRegistrationJpaRepository.insert(userRegistration);
	}
}
