package com.example.JpaSpringBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.JpaSpringBoot.entity.Example;
import com.example.JpaSpringBoot.repository.ExampleRepository;

@Service
public class DemoServiceImpl implements DemoService{

	@Autowired
	private ExampleRepository exampleRepository;
	
	
	@Override
	public void insertDataintoDB() throws Exception {
		// TODO Auto-generated method stub
		
		Example example= new Example();
		
		example.setName("Kishore");
		example.setAge(23);
		example.setLocation("Gachibowli");
		example.setStatus(4);
		
		exampleRepository.save(example);
		
	}


	@Override
	public void updateDataintoDB(Example example) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("Before Status :" +example.getStatus());
		
		example.setAge(30);
		
		exampleRepository.save(example);
		
		System.out.println("After Status :" +example.getStatus());
		
	}

}
