import java.util.Scanner;

public class question65 {
	//prompt the user 
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter three numbers: ");
		int num1 = input.nextInt();
		int num2 = input.nextInt();
		int num3 = input.nextInt();
		
		displaySortedNumbers(num1, num2, num3);
	}
		//check the increase numbers 
	public static void displaySortedNumbers(double num1, double num2, double num3) {

	    if (num1 > num2) {
	      double temp = num1;
	      num1 = num2;
	      num2 = temp;
	    }

	    if (num2 > num3) {
	      double temp = num2;
	      num2 = num3;
	      num3 = temp;
	    }

	    if (num1 > num2) {
	      double temp = num1;
	      num1 = num2;
	      num2 = temp;
	    }
	    
	    int smallest = (int) num1;
	    int middle = (int) num2;
	    int biggest = (int) num3;
	    
	    System.out.println("The sorted numbers are "+ smallest + " " + middle + " " + biggest);
		
	}
	}
