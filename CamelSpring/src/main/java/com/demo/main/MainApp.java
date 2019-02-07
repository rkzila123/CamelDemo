package com.demo.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
	
		ClassPathXmlApplicationContext applicationContext = 
				  new ClassPathXmlApplicationContext("ApplicationContext.xml");
	
		applicationContext.start();
		
		System.out.println("Application context started");
		try {
            Thread.sleep(5 * 60 * 1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
		applicationContext.stop();
		applicationContext.close();
	}

}
