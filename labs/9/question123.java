package lab9;

import java.util.Scanner;
import java.util.Random;

public class question123 {
	public static void main(String[]args) {
		//prompting user 
		Scanner input = new Scanner (System.in); 
		System.out.println("Please enter the index of the array:");
		int index = input.nextInt();
			if (index <= 100) {
		
				// creating random integer
				int[] array = new int [100]; 
				for (int x=0; x<array.length; x++) {
					Random ran = new Random(); 
					int n = ran.nextInt(100)+1; 
					array[x] = n; 
				}
				System.out.println(array[index]);
			}
		else if (index > 100) {
			System.out.println("out of bounds of the array!");
		}
	}
}
