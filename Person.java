package A2_Banking;

import java.util.ArrayList;
import java.util.Scanner;

public class Person extends SBI {
	
	private int person_id;
	private String name;
	private long account_num;
	private char account_type; // Current Account (c) , Savings Account (s)
	private String email;
	private static ArrayList<Integer> list_person_ids = new ArrayList<Integer>();
	private static ArrayList<Long> list_account_nums = new ArrayList<Long>();
	private static double crnt_max;
	
	
	static {
		 System.out.println("**********************************");
		 System.out.println("* Welcome to our Banking System  *");
		 System.out.println("**********************************");
	}
	
	public Person(String prsn_name, String prsn_email, char prsn_acnt_type)
	{
		super();
		this.name = prsn_name.toUpperCase();
		this.email = prsn_email;
		this.account_type = prsn_acnt_type;
		person_id_generator();
		account_num_generator();
	}
	
	private void person_id_generator()
	{
		//Math.random generates a value between 0 to 1
		//To Generate random int value from 2047100 to 2047300
    	//Syntax --> Math.random() * (max - min + 1) + min
		this.setPerson_id((int)(Math.random() * (2047300 - 2047100 + 1) + 2047100));
		
		if(!list_person_ids.contains(this.getPerson_id()))
		{
			list_person_ids.add(this.getPerson_id());
		}
		else 
		{
			while(list_person_ids.contains(this.getPerson_id()))// To repeat the process until a unique id is generated
			{
				System.out.println("hello");
				this.setPerson_id((int)(Math.random() * (2047102 - 2047100 + 1) + 2047100));
				if(!list_person_ids.contains(this.getPerson_id())){list_person_ids.add(this.getPerson_id());break;}//Adds the newly created unique randomised student id to the "IDS" arraylist
			}
		}
	}
	

	private void account_num_generator()
	{
		//Math.random generates a value between 0 to 1
		//To Generate random int value from 100000000L to 999999999L
		//Syntax --> Math.random() * (max - min + 1) + min
		this.setAccount_num((int)(Math.random() * (999999999L - 100000000L + 1) + 100000000L));
		
		if(!list_account_nums.contains(this.getAccount_num()))
		{
			list_account_nums.add(this.getAccount_num());
		}
		else 
		{
			while(list_account_nums.contains(this.getAccount_num()))// To repeat the process until a unique id is generated
			{
				System.out.println("hello");
				this.setAccount_num((int)(Math.random() * (999999999L - 100000000L + 1) + 100000000L));
				if(!list_account_nums.contains(this.getAccount_num())){list_account_nums.add(this.getAccount_num());break;}//Adds the newly created unique randomised student id to the "IDS" arraylist
			}
		}
	}
	
	public int getPerson_id() {
		return person_id;
	}

	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}
	
	public long getAccount_num() {
		return account_num;
	}

	public void setAccount_num(long account_num) {
		this.account_num = account_num;
	}
	
	private void transactions()
	{
		char opt; Scanner stdInp = new Scanner(System.in);
		boolean trns = true;
		
		while(trns)
		{
			System.out.println("\nChoose the type of Transaction (d/w/q):-"); 
			System.out.println("1. Desposit --> 'd' "); 
			System.out.println("2. Withdraw --> 'w' ");
			System.out.println("3. Quit     --> 'q' ");
			opt = stdInp.nextLine().charAt(0);
			if (opt == 'd')
			{
				System.out.println("Enter the amount to be deposited:");
				this.deposit(Integer.parseInt(stdInp.nextLine()));
			}
			else if(opt == 'w')
			{
				System.out.println("Enter the amount to be withdrawn:");
				this.withdraw(Integer.parseInt(stdInp.nextLine()));
			}
			else if(opt == 'q')
			{
				trns =false;
				System.out.println("Transaction Completed!");
			}
			else
			{
				System.out.println("Invalid option! Try again");
			}
		}
	}
	
	private void accountDetails()
	{
		System.out.println("\nDisplaying Account Details");
		System.out.println("Person ID       : " + this.person_id);
		System.out.println("Name	        : " + this.name);
		System.out.println("Bank ID         : " + this.branch_id);
		System.out.println("Bank Name       : " + this.branch);
		System.out.println("Balance         : " + this.getBalance());
		System.out.println("Annual Interest : " + this.getAnnualInterest());
	}
    
	private static void endnote() {
		System.out.println("\nThank you for choosing "+bank_name+" for your banking needs.");
		System.out.println("Have a great day ahead.");
	}
	
	public static void main(String args[])
	{
		
		  int noOfPrsn; Scanner stdInp = new Scanner(System.in);
		  System.out.println("Enter the number of Person's to create bank account: ");
		  noOfPrsn = Integer.parseInt(stdInp.nextLine());
		  int prsn_index_max_bal = 0; double final_max_bal = 0; double crnt__max;
		  
		  String name; String email; char acnt_typ; char trns;
		  Person[] prsn = new Person[noOfPrsn]; 
		  for(int x=0; x< prsn.length;x++) 
		  {
			  System.out.println("\n------------------------"); 
			  System.out.println("|    Person ----> " + (x+1)+"    |"); 
			  System.out.println("------------------------");

			  System.out.println("Enter your Name: "); 
			  name = stdInp.nextLine();
			  
			  System.out.println("Enter your email: "); 
			  email = stdInp.nextLine();
			  
			  System.out.println("Choose from the below option for the type of account to be created (c/s):-"
			  ); System.out.println(" 1. Current Account ----> 'c'");
			  System.out.println(" 2. Savings Account ----> 's'"); 
			  acnt_typ = stdInp.nextLine().charAt(0);
			  
			  prsn[x] = new Person(name,email,acnt_typ);
			  
			  System.out.println("Would you like to perform any transactions? y/n");
			  trns = stdInp.nextLine().charAt(0);
			  
			  if(trns == 'y')
			  {
				  prsn[x].transactions();
			  }
			  
			  //checking max_balance persons index
			  if(x==0)
			  {
				  prsn_index_max_bal=0;
				  final_max_bal=prsn[x].getBalance();
			  }
			  else
			  {
				  crnt_max=Math.max(final_max_bal,prsn[x].getBalance());
				  if (crnt_max == prsn[x].getBalance()) 
				  {
					  prsn_index_max_bal=x;
					  final_max_bal=prsn[x].getBalance(); 
				  }
			  }
			  
		  }
		  
		  
		if(prsn.length>=1) {
		 prsn[prsn_index_max_bal].accountDetails();}
		
		endnote();
	     
	}
}
