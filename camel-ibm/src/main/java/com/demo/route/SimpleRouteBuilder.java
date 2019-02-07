package com.demo.route;

import org.apache.camel.builder.RouteBuilder;

public class SimpleRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		
		from("file:C:/inputFolder?noop=true").split().tokenize("\n").to("jms:queue:RBIH0000000");
	    
		
	}

}
