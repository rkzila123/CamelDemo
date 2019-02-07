package com.demo.process;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;

import com.demo.entity.Example;



public class MyProcessor implements Processor{
	
	
	
	@Autowired
	private ProcessMessage processMessage;

	
	public void process(Exchange exchange) throws Exception {
		
		try {
		Message in = exchange.getIn();
		
        Example example = in.getBody(Example.class);      
       System.out.println(example);
        
        //example.setStatus(1);
        processMessage.updateRecordFromExample(example);
                    
        } catch (Exception e) {}
        System.out.println("Done!");
		
	}


		
	}


