package lab8;

public class SavingsAccount 
	extends Account{
		 SavingsAccount(){
			 super();
		 }
		 
		 SavingsAccount(int id, double balance){
			 super(id, balance);
		 }
		 
		 public void withdrawMoney(double amount) {
			 if(getBalance() < amount ) {
				 System.out.println("Im sorry you dont have enough money to withdraw that amount");
			 }
			 else
			 {
				 setBalance(getBalance() - amount);
			 }
		 }
		 
	}


