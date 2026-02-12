package com.test.Calculator;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }

    public int mul(int a, int b) {
        return a * b;
    }

    public int div(int a, int b) {
        return a / b;
    }
    
    public boolean isEven(int a) {
    	return a%2==0;
    }
    
    public int factorial(int a) {
    	if(a<=1) return 1;
    	return a*factorial(a-1);
    }
}

