package com.demo.route;

import org.apache.camel.builder.RouteBuilder;

import com.demo.processor.MyProcessor;

public class SimpleRouteBuilder extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Configure");
		from("file:C:/inputFolder?noop=true").process(new MyProcessor()).to("file:C:/outputFolder");
		
	}

	

}
