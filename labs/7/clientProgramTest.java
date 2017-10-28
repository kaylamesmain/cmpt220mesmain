package Lab7;

import java.util.Scanner;

public class clientProgramTest {
	public static void main(String[] args) {
		
		int values [] = {12, 13, 14};
		
		
		for (int i = 0; i < values.length; i++) {
			System.out.println("Test on " + values[i]);
			myInteger value = new myInteger(values[i]);
			
			System.out.println(value.getValue() + " is Even(): " + value.isEven());
			System.out.println(values[i] + " is Even(int): " + myInteger.isEven(values[i]));
			System.out.println(value.getValue() + " is Even(myInteger): " + myInteger.isEven(value));
			System.out.println("------------------------");
			System.out.println(value.getValue() + " is Odd(): " + value.isOdd());
			System.out.println(values[i] + " is Odd(int): " + myInteger.isOdd(values[i]));
			System.out.println(value.getValue() + " is Odd(myInteger): " + myInteger.isOdd(value));
			System.out.println("------------------------");
			System.out.println(value.getValue() + " is Prime(): " + value.isPrime());
			System.out.println(values[i] + " is Prime(int): " + myInteger.isPrime(values[i]));
			System.out.println(value.getValue() + " is Prime(myInteger): " + myInteger.isPrime(value));
			System.out.println("------------------------------------------------------------");
		}
		
		int[] values2 = {5, 9, 7};
		myInteger value = new myInteger(9);
		System.out.println("equals(Int) test on: " + value.getValue());
		for (int i = 0; i < values2.length; i++) {
			System.out.println(values2[i] + ": " + value.equals(values2[i]));
		}
		System.out.println("------------------------");

		System.out.println("equals(myInteger) test on: " + value.getValue());
		for (int i = 0; i < values2.length; i++) {
			myInteger myInteger = new myInteger(values2[i]);	
			System.out.println(values2[i] + ": " + value.equals(myInteger));
		}

		System.out.println("------------------------------------------------------------");
		System.out.println("parseInt(char[] array) test on {'1', '2', '3', '4'}: " );
		char [] test = {'1', '2', '3', '4'};
		System.out.println(myInteger.parseInt(test));
		
		System.out.println("------------------------------------------------------------");
		System.out.println("parseInt(String int) test on '456': " );
		String test2 = "456";
		System.out.println(myInteger.parseInt(test2));
		
		
		
		

		
		
		
	}

}
