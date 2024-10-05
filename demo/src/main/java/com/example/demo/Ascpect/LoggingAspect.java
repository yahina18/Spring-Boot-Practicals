package com.example.demo.Ascpect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	
	@Before("execution(* com.example.demo.Service.*.*(..))")
	public void logging()
	{ 
		System.out.println("---------- Logging code ------------ ");
	}
	
	@After("execution(* com.example.demo.Service.TranscationService.*())")
	public void afterLogging()
	{
		System.out.println("----------After target method-------");
	}
	
	@Around("execution(* com.example.demo.Service.*.*(..))")
	public void aroudTraget()
	{
		System.out.println("Aroud annotation ");
	}
	
}
