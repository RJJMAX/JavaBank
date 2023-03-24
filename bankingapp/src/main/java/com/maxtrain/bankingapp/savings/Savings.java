package com.maxtrain.bankingapp.savings;
import java.math.BigDecimal;
import com.maxtrain.bankingapp.account.Account;
@SuppressWarnings("unused")


public class Savings extends Account {
	

	private double interestRate;
	
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	public double payInterest(int months) {
		double interest = balance * (interestRate/12) * months;
		deposit(interest);
		return(interest);
	}
	
}
