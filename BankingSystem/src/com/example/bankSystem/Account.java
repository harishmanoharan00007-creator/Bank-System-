package com.example.bankSystem;
import java.util.*;

public class Account {
	private static int count = 1000;
	private int accountType;
	private int accountNumber;
	private String name;
	private double balance;
	public ArrayList<Transaction> transaction = new ArrayList<>();
		
	public Account(int accountType, String name) {
		if(accountType != 1 && accountType != 2)
		{
			throw new IllegalArgumentException("Account Type can be either 1 or 2");
		}
		
		if(name.length() == 0 )
		{
			throw new IllegalArgumentException("User Name cannot be Blank");
		}
		
				
		this.accountType = accountType;
		this.accountNumber = generateId();
		this.name = name;
		
	}
	public int getAccountType() {
		return accountType;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}

	public String getName() {
		return name;
	}
	
	public double getBalance() {
		return balance;
	}
	private static int generateId() {
		count++;
		return count;
	}
	
	
	public boolean deposite(double amount)
	{
	    if (!Double.isFinite(amount) || amount <= 0)
	    {
	    	transaction.add(new Transaction(1, amount,getAccountNumber(), -404, 'F' , "Deposited Failed Due to infinte Amount"));
	        return false;
	    }

	    double newBalance = balance + amount;

	    if (!Double.isFinite(newBalance))
	    {
	    	transaction.add(new Transaction(1, amount,getAccountNumber(), -404, 'F' , "Deposited Failed Due to infinte balance"));
	        return false;
	    }

	    balance = newBalance;
	    
	    transaction.add(new Transaction(1, amount,getAccountNumber(), -404, 'S' , "Deposited Successfully"));
	    return true;
	}
	
	public boolean withDraw(double amount)
	{
		if(!Double.isFinite(amount))
		{
			transaction.add(new Transaction(2, amount,getAccountNumber(), -404, 'F' , "Withdrwal Failed Due to infinte amount"));
			return false;
		}
		
		if(amount <= 0)
		{
			transaction.add(new Transaction(2, amount,getAccountNumber(), -404, 'F' , "Withdrwal Failed Due to invalid amount"));
			return false;
		}
		
		
		if(amount > balance)
			
		{
			transaction.add(new Transaction(2, amount,getAccountNumber(), -404, 'F' , "Withdrwal Failed Due to insufficent Balance"));
			return false;
		}
		balance-=amount;
		
		transaction.add(new Transaction(2, amount,getAccountNumber(), -404, 'S' , "Withdrwal Successfull!!!!!!"));
		return true;
	}
	
	public  boolean transfer(double amount, Account destination)
	{

		if(withDraw(amount))
		{
			//System.out.println("Amount is withdrawn from the Account Successfully !!!!");
			if(destination.deposite(amount))
			{
				System.out.println("Amount is Transferred in the Account Successfully !!!!");
			}else {
				
						deposite(amount);
						System.out.println("The Failue Amount is Deposited again successfully !!!!");
						transaction.add(new Transaction(3, amount,getAccountNumber(), destination.getAccountNumber(), 'F' , "Tranaction Failed"));
						destination.transaction.add(new Transaction(3, amount,getAccountNumber(), destination.getAccountNumber(), 'F' , "Tranaction Failed"));
						return false;
				}

		}else {
		
			System.out.println("Server is slow please try after some time");	
			transaction.add(new Transaction(3, amount,getAccountNumber(), destination.getAccountNumber(), 'F' , "Tranaction Failed"));
			destination.transaction.add(new Transaction(3, amount,getAccountNumber(), destination.getAccountNumber(), 'F' , "Tranaction Failed"));
			return false;
		}
		transaction.add(new Transaction(3, amount,getAccountNumber(), destination.getAccountNumber(), 'S' , "Tranaction Successfull !!!!"));
		destination.transaction.add(new Transaction(3, amount,getAccountNumber(), destination.getAccountNumber(), 'S' , "Tranaction Successfull"));
		return true;
	}
	
	public void displayTransaction()
	{
		for(Transaction trans : transaction)
		{
			System.out.println(trans.getType() +" "+ trans.getName()+" "+trans.getAmount()+" "+trans.getFrom_accNo() +" "+trans.getTo_accNO()+" "+trans.getStatus()+" "+trans.getMessage());
		}
	}
	


}
