package com.example.MqWithCamelBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.properties") 
public class MqWithCamelBootApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(MqWithCamelBootApplication.class, args);	
	}
	
	
}
