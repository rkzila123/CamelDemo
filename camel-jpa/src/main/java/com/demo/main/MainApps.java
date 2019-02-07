package com.demo.main;

import org.apache.camel.CamelContext;
import org.apache.camel.spring.SpringCamelContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApps {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext applicationContext = 
				  new ClassPathXmlApplicationContext("ApplicationContext.xml");
		try {
			
		 /*Deprecated*/ 
			
		//SpringCamelContext camelContext = SpringCamelContext.springCamelContext(camelContext, false);

		CamelContext camelContext = new SpringCamelContext(applicationContext) ;		
		
		System.out.println("camelContext"+camelContext);
		
		
		 /*For XML routing Configuration*/
		
		//applicationContext.start();
		camelContext.start();
		
		System.out.println("Application context started");
	
          Thread.sleep(5 * 60 * 1000);
          camelContext.stop();
         
      }
      catch (InterruptedException e) {
          e.printStackTrace();
      }
		catch (Exception e) {
	          e.printStackTrace();
	      }
		
		 /*For XML routing Configuration*/
		
		//applicationContext.stop();
		//applicationContext.close();

	}

}
