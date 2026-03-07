package com.test.Calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import  static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

public class CalculatorParameterizedTest {
	Calculator c = new Calculator();
	@ParameterizedTest
	@CsvSource({
		"2,3,5",
		"0,0,0",
		"-5,10,5",
		"100,200,300"
	})
	public void testAddParameterized(int a,int b,int expected) {
		assertEquals(expected,c.add(a, b));
		System.out.println(a+" "+b);
	}
	
	@ParameterizedTest
	@CsvSource({
		"10,10,0",
		"6,3,3",
		"5,5,0",
		"4,7,-3"
	})
	public void testSubtractParameterized(int a,int b,int expected) {
		assertEquals(expected,c.sub(a, b));
	}
	
	@ParameterizedTest
	@ValueSource(ints = {2,4,6,8,0,24,56,78})
	public void testIsEvenReturnsTrue(int a) {
		assertTrue(c.isEven(a));
	}
	
	@ParameterizedTest
	@MethodSource("provideDivisionTestCases")
	public void testDivideWithMethodSource(int a,int b,int expected) {
		assertEquals(expected,c.div(a, b));
	}
	
	private static Stream<Arguments> provideDivisionTestCases(){
		return Stream.of(
				Arguments.of(20,4,5),
				Arguments.of(15,5,3),
				Arguments.of(0,7,0),
				Arguments.of(10,2,5)
				);
	}
	
	@ParameterizedTest
	@CsvSource({
		"0,1",
		"1,1",
		"2,2",
		"5,120",
		"6,720"
	})
	public void testFactorialParameterized(int input,int expected) {
		assertEquals(expected,c.factorial(input));
	}
	
	@ParameterizedTest
	@CsvFileSource(files = "test-Resources/add-data.csv",numLinesToSkip=1)
	public void simpleAddTest(int a,int b, int expected) {
		System.out.println("Simple @Csvfilesource test: "+a+" + "+b);
		assertEquals(expected,c.add(a, b));
	}
}
