package SmartPaymentProcessingSystem;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class UpiPayment implements PaymentService{
	@Override
	public void processPayment(double amount)
	{
		System.out.println("Upi Payment: "+amount);
	}
	private TransactionLogger transactionLogger;
	public UpiPayment(TransactionLogger transactionLogger)
	{
		this.transactionLogger=transactionLogger;
	}
	
}
