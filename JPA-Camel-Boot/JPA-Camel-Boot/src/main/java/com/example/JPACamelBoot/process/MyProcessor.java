package com.example.JPACamelBoot.process;

import javax.jms.Connection;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.jms.JmsComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ibm.mq.jms.MQConnectionFactory;



@Component
public class MyProcessor implements Processor{
	
	/*@Autowired
	private CamelContext camelContext;
	*/
	/*@Autowired
	private MQConnectionFactory factory;*/
	
	/*@Autowired
	private ProcessMessage processMessage;*/
	
	@Autowired
	private ProducerTemplate producerTemplate;

	//@Transactional(readOnly=false)
	public void process(Exchange exchange) throws Exception {
		
		try {
		Message in = exchange.getIn();
		
        //Example example = in.getBody(Example.class);      
       
		String str=in.getBody(String.class);
		
        System.out.println(str);
        
        //example.setStatus(1);
      //  processMessage.updateRecordFromExample(example);
        
        
        
        
        
        
        
        // Mq Configuration
        
        MQConnectionFactory factory= new MQConnectionFactory();
        factory.setQueueManager("STARBRQM");
        factory.setHostName("IFT-HYD-DT-0318");
        factory.setPort(1414);
       // factory.setChannel("QM1.SVR");
        System.out.println("creating queue connection"); 
        Connection connection=factory.createConnection();
       // QueueConnection connection= (QueueConnection) factory.createConnection(); 
        System.out.println("starting qconn"); 
        connection.start(); 
        System.out.println("creating session"); 
       // QueueSession session= connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE); 
        
       // camelContext.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(factory));
      
        //ProducerTemplate producer=camelContext.createProducerTemplate();
        
        System.out.println("producerTemplate :: " +producerTemplate);
        
        producerTemplate.sendBody("jms:queue:STARBRSFTQ?asyncConsumer=true", str);
                    
        } catch (Exception e) {
        	e.printStackTrace();
        }
        System.out.println("Done!");
		
	}


		
	}


