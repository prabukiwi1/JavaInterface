package A2_Banking;

interface Bank 
{
	void createAccount(); 
	
	void deposit(double amount);
	
	void withdraw(double amount);
	
	double getBalance();
	
	double getAnnualInterest();
}
