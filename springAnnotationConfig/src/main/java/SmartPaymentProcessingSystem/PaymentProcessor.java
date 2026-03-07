package SmartPaymentProcessingSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PaymentProcessor {
	private PaymentService paymentService;
	@Autowired
	private TransactionLogger transactionLogger;
	
	public PaymentProcessor(@Qualifier("upiPayment")PaymentService paymentService)
	{
		this.paymentService=paymentService;
	}
	public void process()
	{
		paymentService.processPayment(5000);
	}
}
