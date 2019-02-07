package com.example.MqWithCamelBoot;

import javax.jms.Connection;

import org.apache.camel.component.jms.JmsComponent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.JmsTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ibm.mq.jms.MQConnectionFactory;

@Configuration
@EnableTransactionManagement
public class JmsConfiguration {

	
	
	@Value("${host}")
	private String host;
	@Value("${port}")
	private int port;
	@Value("${queue-manager}")
	private String queueManager;
	
	
	@Bean
	public JmsComponent mq(){
		JmsComponent jmsComponent = new JmsComponent();
		jmsComponent.setConnectionFactory(mqConnectionFactory());
		
		return jmsComponent;
	}


	@Bean
	public MQConnectionFactory mqConnectionFactory() {
		MQConnectionFactory factory = new MQConnectionFactory();
		System.out.println("host :: "+ host);
		factory.setHostName(host);
		try {
			factory.setPort(port);
			factory.setQueueManager(queueManager);
			Connection connection=factory.createConnection();
			connection.start(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return factory;
	}

	
	@Bean
	public PlatformTransactionManager jmsTransactionManager(MQConnectionFactory mqConnectionFactory) {
		JmsTransactionManager jmsTransactionManager = new JmsTransactionManager();
		jmsTransactionManager.setConnectionFactory(mqConnectionFactory);
		return jmsTransactionManager;
	}

	/*@Bean
	private MQQueueConnectionFactory mqQueueConnectionFactory() {
		MQQueueConnectionFactory mqQueueConnectionFactory = new MQQueueConnectionFactory();
		mqQueueConnectionFactory.setHostName(host);
		
		try {
			mqQueueConnectionFactory.setPort(port);
			mqQueueConnectionFactory.setQueueManager(queueManager);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mqQueueConnectionFactory;
	}*/
}
