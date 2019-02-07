package com.example.JPACamelBoot.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import com.example.JPACamelBoot.process.MyProcessor;


@Component
public class SimpleRouteBuilder extends RouteBuilder {

	/*@Autowired
	private MyProcessor myProcessor;*/
	
	@Override
	public void configure() throws Exception {
		
		try {
			//from("jpa://com.example.JPACamelBoot.entity.Example?consumer.namedQuery=selectQuery&consumer.delay=10000&consumeDelete=false").process(myProcessor);
		
			from("jpa://com.example.JPACamelBoot.entity.Example?consumer.namedQuery=selectQuery&consumer.delay=10000").process(new MyProcessor());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		System.out.println("After Route");
		
	}

}
