package com.test.spring.springAnnotationConfig;

import org.springframework.stereotype.Component;

@Component
public class SmsService {
	public void send() {
		System.out.println("through sms");
	}

}
