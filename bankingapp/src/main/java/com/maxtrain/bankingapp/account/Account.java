package com.maxtrain.bankingapp.account;

import java.math.BigDecimal;
@SuppressWarnings("unused")

public class Account {
	private String accountId;
	
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	
	private double balance;
	public double getBalance() {
		return balance;
}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	private String description;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public boolean deposit(double interest) throws Exception {
		if (interest <= 0 ) { 
			throw new Exception("Invalid transaction! Amount cannot be zero or negativve!");
		}
		else { 
				return true;
			}
		}
	
	public boolean withdraw(double amount) {
		if (amount <= 0) {
			System.out.println("Invalid Transaction! Amount cannot be zero or negative!");
		}
		//if (amount.compareTo(amount)> balance) throws Exception {
			//throw new Exception("Insufficient Funds");
		//}
		return true;
	}
	
	public boolean transfer(double amount, Account ToAccount) throws Exception {
		if (amount <= 0) {
			throw new Exception("Invalid Transaction! Account cannot be zero or negative!");
		}
		else {
			return true;
		}
	}
	

}



/*
public boolean transfer(BigDecimal amount, Account ToAccount) throws Exception {
	if (amount.compareTo(amount) <= 0) {
		throw new Exception("Invalid Transaction! Account cannot be zero or negative!");
	}
	else {
		return true;
*/