package lab8;

public class question113 {
	public static void main(String[] args) {
		
		//test Account Class
		Account testAccount = new Account(1, 1000);
		testAccount.setAnnualInterestRate(25.00);
		
		
		//test Checking Account subclass
		CheckingAccount testcheckingAccount = new CheckingAccount(2, 500, -25);
		testcheckingAccount.setAnnualInterestRate(15.00);
		
		//test Savings Account
		SavingsAccount testSavingsAccount = new SavingsAccount(3, 500);
		
		System.out.println(testAccount.toString());
		System.out.println(testcheckingAccount.toString());
		System.out.println(testSavingsAccount.toString());
		
		
	}
}
