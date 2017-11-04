package lab8;

import java.util.Scanner;

public class question111 {
	public static void main (String[] args) {
		Scanner input = new Scanner (System.in);
		System.out.println("Please enter three sides lengths: ");
		double side1 = input.nextDouble();
		double side2 = input.nextDouble();
		double side3 = input.nextDouble();
		System.out.println("Now enter a color: ");
		String color = input.next();
		System.out.println("Lastly enter true or false whether or not the Triangle is filled or not: ");
		Boolean filled = input.nextBoolean();
		
		Triangle testTriangle = new Triangle(side1, side2, side3);
		testTriangle.setColor(color);
		testTriangle.setFilled(filled);
		
		System.out.println("Traingle properties:");
		System.out.println("-----------------------------------");
		System.out.println("Area: " + testTriangle.getArea());
		System.out.println("Perimeter: " + testTriangle.getPerimeter());
		System.out.println("Color: " + testTriangle.getColor());
		System.out.println("Filled?: " + testTriangle.isFilled());
	}

}
