package com.demo.process;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

import com.demo.main.MainApp;

public class MyProcessor implements Processor{

	
	
	@Override
	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub
		
		
		/*public void setProducer(ProducerTemplate producer) {
		    this.producer = producer;
		  }*/
		
		Message in = exchange.getIn();
        String msg = in.getBody(String.class);      
        System.out.println(msg);
        System.out.println("Message Length :"+msg.length());
        //msg=msg.concat("111");
        try {
            Thread.sleep(10 * 1000);
           /* MainApp.producer.send(new Processor() {
				
				@Override
				public void process(Exchange outExchange) throws Exception {
					// TODO Auto-generated method stub
					outExchange.getIn().setBody(msg+"111");
					
				}
			});*/
            
            
            /*MainApp.producer.sendBody("jms:queue:STARBRSFTQ", new Processor() {
				
				@Override
				public void process(Exchange outExchange) throws Exception {
					// TODO Auto-generated method stub
					outExchange.getIn().setBody(msg+"111");
					
				}
			});*/
            
            MainApp.producer.sendBody("jms:queue:STARBRSFTQ?asyncConsumer=true", msg+"111");
            
            
            
        } catch (InterruptedException e) {}
        System.out.println("Done!");
		
	}

}
