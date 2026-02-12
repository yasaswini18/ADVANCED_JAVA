package com.test.Calculator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    Calculator c = new Calculator();

    @Test
    void testAdd() {
        assertEquals(10, c.add(5, 5));
        assertNotEquals(10,c.add(2, 2));
    }

    @Test
    void testSub() {
        assertEquals(2, c.sub(5, 3));
    }

    @Test
    void testMul() {
        assertEquals(15, c.mul(5, 3));
    }

    @Test
    void testDiv() {
        assertEquals(2, c.div(10, 5));
        assertThrows(ArithmeticException.class,
        		()-> c.div(10, 0));
    }
    
    @Test
    void testIsEven() {
    	assertTrue(c.add(2, 2)%2==0);
    }
    
    @Test
    void testIsOdd() {
    	assertFalse(c.add(3, 2)%2==0);
    }
    
    @Test
    void testIsNull() {
    	String s= null;
    	assertNull(s);
    }
    
    @Test
    void testIsNotNull() {
    	assertNotNull(c);
    }
    
    @Test
    void testIsSameReference() {
    	Calculator c1 = c;
    	Calculator c2 = new Calculator();
    	assertSame(c1,c);
    	assertNotSame(c1,c2);
    }
    
    @Test
    void testDivisionByZeroUsingFail() {
    	try {
    		c.div(10, 0);
    		fail("Arithmetic Exception is not thrown");
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    
   
}
