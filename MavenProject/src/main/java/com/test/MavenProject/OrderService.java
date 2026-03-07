package com.test.MavenProject;

public class OrderService {
private PaymentService paymentService;
	
	// Constructor Injection
	public OrderService(PaymentService paymentService) {
		this.paymentService=paymentService;
	}
	
	// Method to Test
	public String placeOrder(double amount) {
		boolean paymentSuccess = paymentService.processPayment(amount);
		if(paymentSuccess) {
			return "ORDER PLACED";
		}else {
			return "PAYMENT FAILED";
		}
	}
	
	//Additional method for verification
	public boolean validateAndPlaceOrder(double amount) {
		if(amount<=0) {
			return false;
		}
		
		boolean paymentSuccess = paymentService.processPayment(amount);
		return paymentSuccess;
	}
}
