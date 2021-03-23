package A2_Banking;

public class Insufficientbalance extends Exception
{
	String str1;
	Insufficientbalance(String str2)
	{
		str1=str2;
	}
	public String toString()
	{ 
	 return ("Insufficientbalance Exception Occurred: "+str1) ;
	}
}