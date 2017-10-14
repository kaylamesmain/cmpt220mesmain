package lab6;
public class question97 {
	
	public static void main (String[]args) { 
		Account testAccount = new Account(1122,20000); 
		testAccount.setAnnualInterestRate(0.045);
		testAccount.withdraw(2500.00);
		testAccount.deposit(3000.00);
		
		System.out.println("Balance: $" + testAccount.getBalance());
		System.out.println("Monthly Interest: $" + testAccount.getMonthlyInterest());
		System.out.println("Date Account Created:" + testAccount.getdateCreated());
		
		
	}

}
