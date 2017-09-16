import java.util.Scanner;
public class Question423 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
        
		System.out.println("Enter employee's name:");
        String name = input.nextLine();
        
        System.out.println("Enter number of hours per a week");
        int hours = input.nextInt();
        
        System.out.println("Enter hourly payrate");
        float payRate = input.nextFloat();
        
        System.out.println("Enter federal tax withholding rate:");
        float federalRate = input.nextFloat();
        
        System.out.println("Enter state tax withholding rate:");
        float stateRate = input.nextFloat();
        
        
        float grossPay = hours * payRate;
        float federalWithholding = grossPay * federalRate;
        float stateWithholding = grossPay * stateRate;
        float totalDeduction = federalWithholding + stateWithholding;
        float netPay = grossPay - totalDeduction;
        
        System.out.println("Employee Name: " + name);
        System.out.println("Hours Worked: " + hours);
        System.out.println("Pay Rate: $" + payRate);
        System.out.println("Gross Pay: $" + grossPay);
        System.out.println("Deductions");
        System.out.println("    Federal Withholding (" + federalRate + "%): $" + federalWithholding);
        System.out.println("    State Withholding (" + stateRate + "%): $" + stateWithholding);
        System.out.println("    Total Deduction: $" + totalDeduction);
        System.out.println("Net Pay: $" + netPay);
        
        
        
        
        
	}
	
	
}
