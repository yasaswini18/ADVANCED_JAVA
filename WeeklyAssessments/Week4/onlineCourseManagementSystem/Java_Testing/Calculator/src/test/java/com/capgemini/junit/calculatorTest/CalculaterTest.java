package com.capgemini.junit.calculatorTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.capgemini.junit.calculator.Calculator;

public class CalculaterTest {
	Calculator calculator = new Calculator();
	
	@Test
	public void testAdd() {
		assertEquals(5,calculator.sum(2,3));
	}
}
