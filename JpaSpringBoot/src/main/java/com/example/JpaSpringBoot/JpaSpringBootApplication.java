package com.example.JpaSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.JpaSpringBoot.controller.DemoController;


@SpringBootApplication
public class JpaSpringBootApplication {

	
	public static void main(String[] args) {
		ApplicationContext ctx =SpringApplication.run(JpaSpringBootApplication.class, args);
	
		
		DemoController demoCon= ctx.getBean(DemoController.class);
	
		
		
		System.out.println("Inside Main");
		
		//System.out.println("zsdasd" +demoCon);
		//demoCon.insertDb();
	}
}
