package SmartPaymentProcessingSystem;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@Lazy
public class CreditCardPayment implements PaymentService {
	@Override
	public void processPayment(double amount)
	{
		
	}
	private TransactionLogger transactionLogger;
	public CreditCardPayment(TransactionLogger transactionLogger)
	{
		this.transactionLogger=transactionLogger;
	}
	
}
