package com.example.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

@SpringBootApplication
@EnableScheduling
public class ProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProducerApplication.class, args);
	}

	@Autowired
	private JmsTemplate jmsTemplate;

	@Scheduled(fixedRate = 1000)
	void produceMessage() {
		this.jmsTemplate.convertAndSend("test-topic", "test-data " + LocalDateTime.now());
	}

}
