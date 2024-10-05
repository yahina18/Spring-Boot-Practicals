package com.example.demo.Service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

@Service
public class TranscationService {

	public void netBankingService()
	{
		System.out.println("net service");
	}
	
	public void upiService()
	{
		System.out.println("upi service");
	}
	
	public void upiService(String notification)
	{
		System.out.println("upi service"+notification);
	}
	
}
