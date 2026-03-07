package com.test.StudentService;

import  static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AgeEligibilityTest {
	AgeEligibility age = new AgeEligibility();
	
	@Test
	void testAgeValid() {
		assertTrue(age.isEligible(18));
	}
	
	@Test
	void testAgeNotValid() {
		assertFalse(age.isEligible(17));
	}
	
	@Test
	void testAgeEquals() {
		assertEquals(true,age.isEligible(21));
	}
	
	@Test
	void testAgeNotEquals() {
		assertNotEquals(false,age.isEligible(18));
	}
	
	@Test
	void testAgeNotNull() {
		
		assertNotNull(age);
	}
	
	@Test
	void testAgeNull() {
		Integer a = null;
		assertNull(a);
	}
	
	@Test
	void testAgeReference()
	{
		AgeEligibility age1 = age;
		assertSame(age1,age);
	}
	
	@Test
	void testAgeReferenceNotEqual()
	{
		AgeEligibility age1 = new AgeEligibility();
		assertNotSame(age1,age);
	}
	
	@Test
	void testAgeExceptionCase()
	{
		assertThrows(IllegalArgumentException.class,
				()-> age.isEligible(-5) );
	}
	
	@Test
	void testAgePassingNullUsingFail() {
		try {
			age.isEligible(-5);
			fail("IllegalArgumentException expected here");
		}catch(IllegalArgumentException e) {
			
		}
	}
	
	@Test
	void testAgeUsingAll()
	{
		assertAll(
			() -> assertEquals(true,age.isEligible(21)),
			() -> assertNotEquals(false,age.isEligible(21)),
			() -> assertTrue(age.isEligible(19)),
			() -> assertFalse(age.isEligible(16))
				);
		
		
	}

}
