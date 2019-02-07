package com.example.JPACamelBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;



@ImportResource({"classpath:spring-aop.xml"})
@SpringBootApplication
@EnableAutoConfiguration
public class JpaCamelBootApplication {

	public static void main(String[] args) {
		System.out.println(" ***********before running the project**********");
		System.out.println(" ***********before running the project**********");
		System.out.println(" ***********before running the project**********");
		System.out.println(" ***********before running the project**********");
		System.out.println(" ***********before running the project**********");
		System.out.println(" ***********before running the project**********");
		System.out.println(" ***********before running the project**********");
		System.out.println(" ***********before running the project**********");
		System.out.println(" ***********before running the project**********");
		SpringApplication.run(JpaCamelBootApplication.class, args);
		System.out.println("Boot");
	}
}
