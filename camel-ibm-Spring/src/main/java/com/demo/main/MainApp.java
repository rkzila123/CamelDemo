package com.demo.main;

import org.apache.camel.CamelContext;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.spring.SpringCamelContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ibm.mq.jms.MQConnectionFactory;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ClassPathXmlApplicationContext applicationContext = 
				  new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		MQConnectionFactory  wmqConnectionFactory= applicationContext.getBean(MQConnectionFactory.class);
				
		try {
			CamelContext camelContext = new SpringCamelContext(applicationContext) ;
									
			System.out.println("camelContext"+camelContext);
								
			camelContext.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(wmqConnectionFactory));
			
			camelContext.start();
			
			System.out.println("Application context started");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
