package com.example.JPACamelBoot.process;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.JPACamelBoot.entity.Example;
import com.example.JPACamelBoot.repository.ExampleRepository;

@Component
public class ProcessMessage {
	
	@Autowired 
	private ExampleRepository exampleRepository;
	
	@Transactional()
	public void updateRecordFromExample(Example example) {
		
         
		
		System.out.println(example.getName());
		
		example.setStatus(1);
        
		Example example2 = exampleRepository.save(example);
		
		String name= example2.getName();
		
		System.out.println("name"+name);
		System.out.println("status"+example2.getStatus());
		
		//Example emp=exampleRepository.findByName(example.getName());
		
		/*Example2 empTwo= new Example2();
		
		//exampleTwoRepository.findOne(name);
		
		empTwo.setName(example.getName());
		empTwo.setAge(example.getAge());
		empTwo.setLocation(example.getLocation());
		if(example.getStatus()==1){
			empTwo.setStatus(2);
		}else{
			empTwo.setStatus(1);
		}
		
		empTwo.setCrDate(new Date());
		
		exampleTwoRepository.save(empTwo);*/
		
        
		
		
	}
}
