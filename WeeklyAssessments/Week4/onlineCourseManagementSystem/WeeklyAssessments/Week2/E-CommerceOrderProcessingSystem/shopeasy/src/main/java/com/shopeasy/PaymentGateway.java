package com.shopeasy;

public interface PaymentGateway {

    boolean processPayment(double amount);
}