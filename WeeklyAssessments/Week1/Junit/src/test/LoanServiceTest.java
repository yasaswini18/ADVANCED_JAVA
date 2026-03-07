package test;


import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import main.LoanService;

public class LoanServiceTest {
	LoanService loan = new LoanService();
	
	@Test
	public void validEligibility()
	{
		assertTrue(loan.isEligible(25,50000));
	}
	
	@Test
	public void invalidEligibility()
	{
		assertFalse(loan.isEligible(15, 20000));
    }
	
	@Test
	public void invalidAge()
	{
		assertFalse(loan.isEligible(15, 50000));
	}
	
	@Test
	public void invalidSalary()
	{
		assertFalse(loan.isEligible(26, 20000));
	}
	
	@Test
	public void validEMICalculation()
	{
		assertEquals(3000,loan.calculateEMI(360000, 10));
	}
	
	@Test
	public void invalidEMICalculation()
	{
		assertNotEquals(2500,loan.calculateEMI(360000, 10));
	}
	
	@Test
	public void invalidLoanAmount()
	{
		assertThrows(IllegalArgumentException.class,
				()->loan.calculateEMI(-33, 120000));
	}
	
	@Test
	public void invalidTenure()
	{
		assertThrows(IllegalArgumentException.class,
				()->loan.calculateEMI(120000, -10));
	}
	
	@Test
	public void notNullCheck()
	{
		assertNotNull(loan);
	}
	
	@Test
	public void creditScoreCategories()
	{
		assertAll(
				()->assertEquals("Premium",loan.getLoanCategory(800)),
				()->assertEquals("Standard",loan.getLoanCategory(650)),
				()->assertEquals("High Risk",loan.getLoanCategory(500))
				);
	}
	
	
	
}
