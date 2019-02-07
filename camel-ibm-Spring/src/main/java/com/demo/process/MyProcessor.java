package com.demo.process;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;



public class MyProcessor implements Processor{
	
	
	
	public void process(Exchange exchange) throws Exception {
		
		try {
		Message in = exchange.getIn();
		
        String example = in.getBody(String.class);      
        System.out.println(example);
        
                    
        } catch (Exception e) {}
        System.out.println("Done!");
		
	}

	
	
		
	}


