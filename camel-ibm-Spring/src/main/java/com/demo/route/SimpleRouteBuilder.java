package com.demo.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import com.demo.process.MyProcessor;


public class SimpleRouteBuilder extends RouteBuilder {

	@Autowired
	private MyProcessor myProcessor;
	
	@Override
	public void configure() throws Exception {		
			
		from("jms:queue:STARBRQ").process(myProcessor);	
		
	}

}
