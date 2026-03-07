package com.test.spring.springAnnotationConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageService {
	
	// FIELD INJECTION
	
//	@Autowired
//	private EmailService emailService;
	
	// SETTER -GETTER INJECTION
	@Autowired
	private EmailService emailService;
	private SmsService smsService;
//	@Autowired
//	public void setEmailService(EmailService emailService) {
//		this.emailService=emailService;
//	}
//	@Autowired
//	public void setSmsService(SmsService smsService) {
//		this.smsService=smsService;
//	}
	
	//CONSTRUCTOR INJECTION
	
	@Autowired
	public MessageService(EmailService emailService,SmsService smsService) {
		this.emailService=emailService;
		this.smsService=smsService;
	}
	
	
	
	public void sendMessage() {
		System.out.println("sending message");
		emailService.send();
	smsService.send();
	}

}
