package com.demo.main;

import javax.jms.Connection;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

import com.demo.route.SimpleRouteBuilder;
import com.ibm.mq.jms.MQConnectionFactory;

public class MainApp {

	
	public static ProducerTemplate producer;
    public static void main(String[] args) {
        SimpleRouteBuilder routeBuilder = new SimpleRouteBuilder();
        CamelContext ctx = new DefaultCamelContext();
        
        //configure jms component  
        
        //QueueConnectionFactory qFactory= new create
        MQConnectionFactory factory = new MQConnectionFactory();
        try {
        	
        //factory.setTransportType(WMQConstants.WMQ_CM_CLIENT);
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
        
        ctx.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(factory));
        
        producer = ctx.createProducerTemplate();
        
            ctx.addRoutes(routeBuilder);
            ctx.start();
            Thread.sleep(5 * 60 * 1000);
            ctx.stop();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

}
