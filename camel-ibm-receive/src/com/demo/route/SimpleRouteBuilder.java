package com.demo.route;

import org.apache.camel.builder.RouteBuilder;

import com.demo.process.MyProcessor;

public class SimpleRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		
	
		//from("jms:queue:STARBRQ").process(new MyProcessor()).to("file:C:/OutputFolder"); // Partially Working
		
		//from("jms:queue:STARBRQ").to("stream:out"); //Working
		
		//from("jms:queue:STARBRQ").to("jms:queue:STARBRSFTQ"); // Working
		
		from("jms:queue:STARBRQ?asyncConsumer=true").process(new MyProcessor()); // Working
	
		//from("jms:queue:STARBRQ").to("file:C:/OutputFolder"); // Not Working

	
	}

}
