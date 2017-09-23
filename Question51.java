import java.util.Scanner; 
public class Question51 {

	public static void main(String[] args) {
		
		int number; 
		int positive = 0; //positive number 
		int negative = 0; //negative number 
		double sum = 0; //sum of all the numbers 
		int count = 0; //counting the integer 
		
		//prompt the user 
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an integer, the input ends if it is 0:"); 
		do {
			number = input.nextInt();
			if (number > 0)
				positive++; 
			else if (number < 0)
				negative++; 
				sum += number;
			if (number != 0)
				count++;
		}while (number !=0);
		
		//compute the average 
		double average = sum/ count; 
		
		//The output
		if (positive == 0 && negative == 0) {
			System.out.println("No Numbers are entered except 0");
			
		}
		else {
		System.out.println("The number of positive's is " + positive);
		System.out.println("The number of negative's is " + negative);
		System.out.println("The total is " + sum);
		System.out.println("The average is " + average);
		}
		}
	}
