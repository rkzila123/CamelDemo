package com.example.JpaSpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.JpaSpringBoot.service.DemoService;

@Controller
public class DemoController {

	
	@Autowired
	private DemoService  demoService;
	
	public void insertDb(){
		
		try {
			demoService.insertDataintoDB();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
