package com.test.spring.springAnnotationConfig;

import org.springframework.stereotype.Component;

@Component
public class EmailService {
	
	public void send() {
		System.out.println("through email");
	}
	

}
