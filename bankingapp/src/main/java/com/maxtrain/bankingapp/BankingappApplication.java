package com.maxtrain.bankingapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.maxtrain.bankingapp.account.*;
@SpringBootApplication
import com.maxtrain.bankingapp.savings.*;
public class BankingappApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingappApplication.class, args);
		
		var s1 = new Savings();
		s1.Description = "My Savings Account";
	}

}
