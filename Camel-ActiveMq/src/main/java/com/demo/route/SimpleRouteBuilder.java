package com.demo.route;

import org.apache.camel.builder.RouteBuilder;

public class SimpleRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		
		from("file:C:/inputFolder").split().tokenize("\n").to("jms:queue:javainuse");
	    
		
	}

}
