package com.demo.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.demo.entity.Example;
import com.demo.process.MyProcessor;


public class SimpleRouteBuilder extends RouteBuilder {

	@Autowired
	private MyProcessor myProcessor;
	
	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		
		// Working
		//from("jpa://com.demo.entity.Example?consumer.namedQuery=selectQuery&consumer.delay=10000&consumeDelete=false").to("stream:out");
		
		
		from("jpa://com.demo.entity.Example?consumer.namedQuery=selectQuery&consumer.delay=10000&consumeDelete=false").process(myProcessor);

		
		/*from("jpa://com.demo.entity.Example?consumer.namedQuery=selectQuery&consumer.delay=10000&consumeDelete=false").process(exchange -> {
			Example order = exchange.getIn().getBody(Example.class);
            order.setStatus(1);

		});*/
		
		/*from("jpa://com.demo.entity.Example?consumer.namedQuery=selectQuery&consumer.delay=10000&consumeDelete=false").aggregate(constant(true), new ArrayListAggregationStrategy())
        .completionFromBatchConsumer().process(new MyProcessor());*/

		
		
	}

}
