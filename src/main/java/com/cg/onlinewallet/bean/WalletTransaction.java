package com.cg.onlinewallet.bean;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class WalletTransaction {

	
	private String transactionId;
	private String description;
	private LocalDateTime dateOfTransaction;
	private double Amount;
	private  double accountBalance;
	
	
	
	public WalletTransaction(String transactionId, String description, LocalDateTime dateOfTransaction,
			double amount,double accountBalance)
	{
		super();
		this.transactionId = transactionId;
		this.description = description;
		this.dateOfTransaction = dateOfTransaction;
		Amount = amount;
		this.accountBalance = accountBalance;
	}
	
	
	public WalletTransaction()
	{
		super();
		
	}


	public String getTransactionId() 
	{
		return transactionId;
	}
	public void setTransactionId(String randomUUIDString)
	{
		this.transactionId = randomUUIDString;
	}
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public LocalDateTime getDateOfTransaction()
	{
		return dateOfTransaction;
	}
	public void setDateOfTransaction(LocalDateTime dateOfTransaction)
	{
		this.dateOfTransaction = dateOfTransaction;
	}
	public double getAmount()
	{
		return Amount;
	}
	public void setAmount(double amount)
	{
		Amount = amount;
	}
	public double getAccountBalance()
	{
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance)
	{
		this.accountBalance = accountBalance;
	}	
}


