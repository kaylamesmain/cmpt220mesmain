package lab8;

public class CheckingAccount 
	extends Account{
	private double overdraftLimit;
	
	CheckingAccount(){
		super();
		overdraftLimit = -25;
	}
	
	CheckingAccount(int id, double balance, double overdraft){
		super(id, balance);
		this.overdraftLimit = overdraft;
	}
	
	public void setOverdraft(double overdraft) {
		this.overdraftLimit = overdraft;
	}
	
	public double getOverdraft() {
		return overdraftLimit;
	}
	
	public void withdrawMoney(double amount) {
		if (getBalance() - amount < overdraftLimit) {
			System.out.println("Sorry, Overdraft Limit Exceeded");
		}
		else {
			setBalance(getBalance() - amount);
		}
	}
	
	public String toString() {
		return super.toString() + "\nOverdraft Limit: $" + overdraftLimit;
	}
	
	
}
