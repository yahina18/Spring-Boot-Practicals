package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.example.demo.Service.Service;
import com.example.demo.Service.TranscationService;



@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context =   SpringApplication.run(DemoApplication.class, args);
	    TranscationService transervice =   context.getBean(TranscationService.class);
	    transervice.netBankingService();
	    transervice.upiService();
	    transervice.upiService("Upi Transcation Successful");
	}

}
