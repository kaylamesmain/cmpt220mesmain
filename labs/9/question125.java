package lab9;
import java.util.Scanner;

public class question125 {
			public static void main(String[] args) {
				
				//prompting user 
				Scanner input = new Scanner (System.in);
				System.out.println("Please enter three lengths of sides: ");
				
				double side1 = input.nextDouble();
				double side2 = input.nextDouble();
				double side3 = input.nextDouble();
				
				Triangle testTriangle;
				try {
					testTriangle = new Triangle(side1, side2, side3);
					System.out.println("Test the sum of two sides if greater than other side: " + testTriangle);
					
				} catch (IllegalTriangleException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
		}
}
