package com.example.JpaSpringBoot.service;

import com.example.JpaSpringBoot.entity.Example;

public interface DemoService {

	
	public void insertDataintoDB() throws Exception;
	
	public void updateDataintoDB(Example example) throws Exception;
}
