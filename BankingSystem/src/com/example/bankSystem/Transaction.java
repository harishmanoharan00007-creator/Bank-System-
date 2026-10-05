package com.example.bankSystem;
import java.time.LocalDateTime;
public  class Transaction {

	private int type;
	private String name;
	private double amount;
	private int from_accNo;
	private int to_accNO;
	private LocalDateTime date_time;
	private char status;
	private String message;
	
	public Transaction(int  type,double amount,int from_accNo, int to_accNo,char status , String message)
	{
		
		this.type = type;
		
		if(type == 1)
		{
			this.name = "Deposite";
		}else if(type == 2)
		{
			this.name = "Withdrawl";
		}else {
			this.name = "Transaction";
		}
		
		this.amount = amount;
		this.from_accNo = from_accNo;
		
		if(to_accNo != -404)
		{
			this.to_accNO = to_accNo;
		}
		
		this.date_time = LocalDateTime.now();
		this.status = status;
		this.message = message;
				
	}
	public int getType() {
	    return type;
	}

	public String getName() {
	    return name;
	}

	public double getAmount() {
	    return amount;
	}

	public int getFrom_accNo() {
	    return from_accNo;
	}

	public int getTo_accNO() {
	    return to_accNO;
	}

	public LocalDateTime getDate_time() {
	    return date_time;
	}

	public char getStatus() {
	    return status;
	}

	public String getMessage() {
	    return message;
	}
	
	
}
