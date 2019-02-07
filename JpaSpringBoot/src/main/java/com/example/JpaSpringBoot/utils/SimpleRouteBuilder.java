package com.example.JpaSpringBoot.utils;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;



@Component
public class SimpleRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		try {
		
			from("jpa://com.example.JPACamelBoot.entity.Example?consumer.namedQuery=selectQuery&consumer.delay=10000&consumeDelete=false").process(new MyProcessor());

		} catch (Exception e) {
			e.printStackTrace();
		}
	
		System.out.println("After Route");
		
	}

}
