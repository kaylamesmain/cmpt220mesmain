package lab6;

import java.util.Scanner;

public class question911 {
	
	public static void main(String[] args) {
		System.out.println("Please enter numbers for a,b,c,d,e,f of Linear Equation: ");
		Scanner input = new Scanner(System.in);
		double a = input.nextDouble();
		double b = input.nextDouble();
		double c = input.nextDouble();
		double d = input.nextDouble();
		double e = input.nextDouble();
		double f = input.nextDouble();
		LinearEquation answer = new LinearEquation(a,b,c,d,e,f);
		if (answer.isSolvable()) {
			System.out.println("x = " + answer.getX());
			System.out.println("y = " + answer.getY());
		}
		else {
			System.out.println("The equation has no solution.");
		}
		
		
	}

}
