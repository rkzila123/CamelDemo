package com.example.MqWithCamelBoot;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class SimpleRouteBuilder extends RouteBuilder {

	@Autowired
	private MyProcessor myProcessor;
	
	@Override
	public void configure() throws Exception {		
			
		from("jms:queue:STARBRQ").process(myProcessor);	
		
	}

}
