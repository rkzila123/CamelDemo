package com.example.JpaSpringBoot.utils;


import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.JpaSpringBoot.entity.Example;
import com.example.JpaSpringBoot.service.DemoService;




@Component
public class MyProcessor implements Processor{
	
	@Autowired
	private DemoService demoService;
	
	public void process(Exchange exchange) throws Exception {
		
		try {
		Message in = exchange.getIn();
		
        Example example = in.getBody(Example.class);      
       		
        System.out.println(example);
        
        demoService.updateDataintoDB(example);
           
          } catch (Exception e) {
        	e.printStackTrace();
        }
        System.out.println("Done!");
		
	}


		
	}


