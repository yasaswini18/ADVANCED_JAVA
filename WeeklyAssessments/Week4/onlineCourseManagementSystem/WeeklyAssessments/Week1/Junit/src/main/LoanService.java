package main;

public class LoanService {
	public boolean isEligible(int age, double salary) {
		if(age>=21 && age<=60 && salary>=25000)
		{
			return true;
		}
		return false;
	}
	public double calculateEMI(double loanAmount,int tenureYears)
	{
		if(loanAmount<=0 || tenureYears<=0) throw new IllegalArgumentException("Amount should not be negative");
		double emi = loanAmount/(tenureYears*12);
		return emi;
	}
	public String getLoanCategory(int creditScore) {
		if(creditScore>=750) return "Premium";
		else if(creditScore>=600 && creditScore<=749) return "Standard";
		else return "High Risk";
	}
}
