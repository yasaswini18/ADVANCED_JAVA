package SmartPaymentProcessingSystem;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class TransactionLogger {
	
	@PostConstruct
	public void init()
	{
		System.out.println("Logger Initialized");
	}
	@PreDestroy
	public void destroy()
	{
		System.out.println("Logger destroyed");
	}
}
