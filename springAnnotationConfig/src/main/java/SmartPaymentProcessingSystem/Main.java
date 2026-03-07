package SmartPaymentProcessingSystem;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args)
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println("Bean Ready to use");
		PaymentProcessor processor = context.getBean(PaymentProcessor.class);
		processor.process();
		
		context.close();
	}
}
