import java.util.Scanner;
//PROBLEM #2.9
public class Acceleration {
	public static void main(String[] args) {
		Scanner input= new Scanner (System.in);

		//prompts the user to enter the starting velocity in meters/seconds.
		System.out.println("Enter v0, v2 and t: (meters per second)"); 
			
			double v0 = input.nextDouble();
			double v1 = input.nextDouble(); 
			double t = input.nextDouble(); 
			
		//calculates the acceleration bu the given equation 
			double a= (v1-v0)/t;
			
		//displays the acceleration 
			System.out.println("The average acceleration is " + a);
	}					
}