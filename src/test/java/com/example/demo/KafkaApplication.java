package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class KafkaApplication {

	@Autowired
	private KafkaSender kafkaSender;


	public static void main(String[] args) {
		SpringApplication.run(KafkaApplication.class, args);
	}

	//然后每隔1分钟执行一次
	@Scheduled(fixedRate = 100 * 60)
	public void testKafka() throws Exception {
		kafkaSender.sendTest();
	}

}
