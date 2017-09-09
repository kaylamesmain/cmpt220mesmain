import java.util.Scanner;
//PROBLEM #2.1
public class CelsiusToFahrenheit {
	public static void main(String[]args)
	{
		Scanner input= new Scanner (System.in); 
		
		//The users temperature in celsius 
		System.out.print ("Please enter the temperature in celsius:");
			double celsius = input.nextDouble(); 
		
		//Convert the celsius to fahrenheit 
		double fahrenheit = (celsius * (9.0/5)) + 32; 
		
	System.out.println("Celsius " + celsius + " is " + fahrenheit + " in fahrenheit"); 
	}
}
