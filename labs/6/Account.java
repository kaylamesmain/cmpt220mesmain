package lab6;
import java.util.Date;

public class Account {

	private int id; 
	private double balance; 
	private double annualInterestRate; 
	private Date dateCreated; 
	
	Account(){
		id = 0; 
		balance = 0; 
		annualInterestRate = 0;
		dateCreated = new Date();
		}
	
	Account(int startId, double startBalance){
		id = startId; 
		balance = startBalance;
		dateCreated = new Date();
	}
	
	public int getid() { 
		return id; 
	}
	
	public void setid(int id) {
		this.id= id; 
	}
	public double getBalance() {
		return balance; 
	}
	
	public void setBalance(double balance) {
		this.balance= balance; 
	}
	
	public double getAnnualInterestRate() {
		return annualInterestRate; 
	}
	
	public void setAnnualInterestRate(double AnnualInterestRate) {
		this.annualInterestRate= AnnualInterestRate; 
	}
	
	public String getdateCreated() { 
		return dateCreated.toString(); 
	}
	
	public double getMonthlyInterestRate() {
		return annualInterestRate/12; 
	}
	public double getMonthlyInterest() { 
		return balance * getMonthlyInterestRate();
	}
	
	public void withdraw(double withdrawAmount) { 
		setBalance(getBalance()-withdrawAmount); 
	}
	public void deposit(double deposit) { 
		setBalance(getBalance()+deposit); 
	}
		
}

	
