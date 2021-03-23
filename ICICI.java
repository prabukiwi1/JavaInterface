package A2_Banking;

public class ICICI implements Bank {
	
	static String bank_name = "ICICI";
	static String branch_id;
	static String branch;
	static String location;
	private double balance;
	private double monthly_interest_rate;
    
	public ICICI() {
		createAccount();
	}
	
	@Override
	public void createAccount() {
		branch_id = "001061";
		branch    = "ICICI - TIRUPUR";
		location  = "PALLADAM MAIN ROAD,TIRUPPUR-641603";
		setMonthlyInterest(4.5);
	}

	@Override
	public void deposit(double amount) {
		setBalance(this.balance+amount);
	}

	@Override
	public void withdraw(double amount) {
		try
		{
			if( (this.getBalance() - amount)<0)
			{
				throw new Insufficientbalance("The withdraw amount exceeds current account balance :(");
			}
			else {setBalance(this.balance-amount);}
		}catch(Insufficientbalance e)
		{
			System.out.println(e);
		}
	}
    

	public void setBalance(double amt) {
		this.balance = amt;
	}
	
	@Override
	public double getBalance() {
		return this.balance;
	}

	@Override
	public double getAnnualInterest() {
		return this.monthly_interest_rate/100;
	}
	
	void setMonthlyInterest(double ir) {
		this.monthly_interest_rate = ir;
	}
	
}