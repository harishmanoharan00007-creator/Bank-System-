package App;

import java.util.*;

import com.example.bankSystem.Account;



public class Main {
	static Scanner nc = new Scanner(System.in);
	
	public static ArrayList<Account> accountList = new ArrayList<>();

	public static void main(String[] args) {
	
		System.out.println("==============================================================================================");
		System.out.println("                   BANK MANAGEMENT SYSTEM");
		System.out.println("==============================================================================================");
			
		
		

		
		
		while(true) {
			System.out.print("1. Create Account");
			System.out.print("\n2. View Account Details\n3. Deposit Money\n4. Withdraw Money\n5. Transfer Money\n6. View Transaction History\n8. Exit\n\n");
							
			System.out.println("Enter your Choice: ");
			int input_choice = Integer.parseInt(nc.nextLine().trim());
			switch (input_choice) {
			case 1: {
				
				System.out.println("Enter 1 - Saving Account");
				System.out.println("Enter 2 - Current Account");
				
				int account_type = Integer.parseInt(nc.nextLine().trim());

				 System.out.println("Enter the Account Name");
				 String name = nc.nextLine().trim();
				
				 
				 accountList.add(new Account(account_type ,name));
				 
					System.out.println("--------------------------------------------------------------------------------");
					break;
					}
			
			case 2:{
				for(Account acc : accountList)
				{
					System.out.println(acc.getAccountType() + "  "+acc.getAccountNumber() +" "+acc.getName() +" "+ acc.getBalance());
				}
				System.out.println("--------------------------------------------------------------------------------");
				break;
			}
			
			case 3:{
				
				System.out.println("Enter the Account Number ");
				int depo_accNo = Integer.parseInt(nc.nextLine().trim());
				
				Account depo_acc = findAccount(depo_accNo);
				boolean exitDeposite = false;
				while(depo_acc == null)
				{
					
					int check_toProceed;
					System.out.println("Entered Account Number is invalid");
					System.out.println("Do you want to Proceed");
					System.out.println("1 - Yes    2 - Exit the deposite");
					
					check_toProceed = Integer.parseInt(nc.nextLine().trim());
					if(check_toProceed == 1)
					{
						System.out.println("Enter the Account Number ");
						depo_accNo = Integer.parseInt(nc.nextLine().trim());
						depo_acc = findAccount(depo_accNo);
					}else {
						System.out.println("Thanks for Choiceing our Bank");
						System.out.println("--------------------------------------------------------------------------------");
						exitDeposite = true;
						break ;
					}

				}
				if(exitDeposite)
				{
					continue;
				}
				System.out.println("Enter the amount to deposite");
				double depo_amount = Double.parseDouble(nc.nextLine().trim());
				boolean exitAmount = false;
				int check_toamount;
				while(!depo_acc.deposite(depo_amount))
				{
					System.out.println("You have entered an Amount less or Equal to Zero");
					System.out.println("Enter 1. To re enter the amount   2.to Exit the depoite");
					check_toamount = Integer.parseInt(nc.nextLine().trim());
					
					if(check_toamount == 1)
					{
						System.out.println("Please enter an Amount greater than Zero");
						depo_amount = Double.parseDouble(nc.nextLine().trim());
					}else {
						exitAmount = true;
						break;
						
					}

				}
				if(exitAmount)
					continue;
				System.out.println("Deposited Sucessfully !!!!");
				
				break;
				
			}
			
			case 4:{
				System.out.println("Welcome to Withdrawl !!!!!!!!!");				
				System.out.println("Enter the Account Number ");
				int depo_accNo = Integer.parseInt(nc.nextLine().trim());
				
				Account depo_acc = findAccount(depo_accNo);
				boolean exitWithDrawl = false;
				while(depo_acc == null)
				{
					
					int check_toProceed;
					System.out.println("Entered Account Number is invalid");
					System.out.println("Do you want to Proceed");
					System.out.println("1 - Yes    2 - Exit the Withdrawl");
					
					check_toProceed = Integer.parseInt(nc.nextLine().trim());
					if(check_toProceed == 1)
					{
						System.out.println("Enter the Account Number ");
						depo_accNo = Integer.parseInt(nc.nextLine().trim());
						depo_acc = findAccount(depo_accNo);
					}else {
						System.out.println("Thanks for Choiceing our Bank");
						System.out.println("--------------------------------------------------------------------------------");
						exitWithDrawl = true;
						break ;
					}

				}
				if(exitWithDrawl)
				{
					continue;
				}
				System.out.println("Enter the amount to Withdraw!!!!!!!");
				double wd_amount = Double.parseDouble(nc.nextLine().trim());
				boolean exitAmount = false;
				int check_toamount;
				while(!depo_acc.withDraw(wd_amount))
				{
					System.out.println("You have entered an Amount less or Equal to Zero");
					System.out.println("Enter 1. To re enter the amount   2.to Exit the Withdrawl");
					check_toamount = Integer.parseInt(nc.nextLine().trim());
					
					if(check_toamount == 1)
					{
						System.out.println("Please enter an Amount greater than Zero");
						wd_amount = Double.parseDouble(nc.nextLine().trim());
					}else {
						exitAmount = true;
						break;
						
					}

				}
				if(exitAmount)
					continue;
				System.out.println("WithDrawl Sucessfully !!!!");
				
				System.out.println("Do you want to know the Balance available");
				System.out.println("1 - Yes  2 - No");
				
				int check_balance = Integer.parseInt(nc.nextLine().trim());
				if(check_balance == 1)
				{
					System.out.println(depo_acc.getBalance());
					
				}
				System.out.println("--------------------------------------------------------------------------------");
				
				break;				
			}
			
			case 5:{
				
				System.out.println("Welcome to Money Transfer !!!!!!!!!");				
				Account wd_accNo = printAccountNumber("Of your Account");
				
				if (wd_accNo == null) {
					break;
				}

				double depo_amt = printAmount("Transfer Money");
				
				if(depo_amt == 0)
				{
					break;
				}
				
				Account depo_accNo = printAccountNumber("of the Destination Account");
				
				if(depo_accNo == null)
				{
					break;
				}
				
				if(wd_accNo.getAccountNumber() == depo_accNo.getAccountNumber())
				{
					System.out.println("The Source and Destination account number cann't be the same");
					break;
				}
				
				if(wd_accNo.transfer(depo_amt,depo_accNo))
				{
					System.out.println("Amount is Transferred in the Account Successfully !!!!");
			
				}else {
					System.out.println("Amount is not Transferred in the Account!!!!");
				}
				
				
				
				break;				
				
			}
			
			case 6:{
				Account check_trans = printAccountNumber("to Check the tranaction History!!");
				if(check_trans == null)
					break;
				
				check_trans.displayTransaction();
				break;
			}
			
			case 7:{
				break;
			}
			
			case 8:{
				System.out.println("Thanks for Choiceing our Bank");
				System.out.println("--------------------------------------------------------------------------------");
				return ;
			}
			default: {
				
			}
			
			}
			
		}
			
		
		
		
		
	}

	public static Account findAccount(int accountNumber) {
	    for (Account acc : accountList) {
	        if (acc.getAccountNumber() == (accountNumber)) {
	            return acc;
	        }
	    }
	    return null;
	}	
	
	public static Account printAccountNumber(String Case)
	{
		Account depo_acc = null;
		int check_toProceed;	
		while(depo_acc == null)
		{
			System.out.println("Enter the Account Number "+Case);
			int depo_accNo = Integer.parseInt(nc.nextLine().trim());
			depo_acc = findAccount(depo_accNo);
			if(depo_acc == null)
			{
			
				System.out.println("Entered Account Number is invalid");
				System.out.println("Do you want to Proceed");
				System.out.println("1 - Yes    2 - Exit");
				check_toProceed = Integer.parseInt(nc.nextLine().trim());
				if(check_toProceed != 1)
				{
					System.out.println("Thanks for Choiceing our Bank");
					System.out.println("--------------------------------------------------------------------------------");
					break ;
				}
			}
			
		}
		
		
			return depo_acc;
		
		
	}
	public static boolean check_amount(double amount)
	{
		if(!Double.isFinite(amount) || amount <= 0 )
		{
			return false;
		}
		return true;
	}
	public static double printAmount(String Case) {
		
		double depo_amount = 0;
		boolean exitAmount = false;
		int check_toamount;
		while(!check_amount(depo_amount))
		{
			
			System.out.println("Enter the amount to "+Case);
			 depo_amount = Double.parseDouble(nc.nextLine().trim());
			 
			 if(!check_amount(depo_amount))
			 {
				 System.out.println("You have entered an Amount less or Equal to Zero");
					System.out.println("Enter 1. To re enter the amount   2.to Exit");
					check_toamount = Integer.parseInt(nc.nextLine().trim());
					
					if(check_toamount != 1)
					{
						break;	
					}
			 }
			

		}
		return depo_amount;
	}

}
