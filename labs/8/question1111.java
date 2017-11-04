package lab8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class question1111 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList<Integer> test = new ArrayList<Integer>();
		int [] a;
		int count = 0;
		System.out.println("Please enter five numbers: ");
		while (count != 5) {
			test.add(input.nextInt());
			count++;
		}
		System.out.println("The list in increasing order is: " + increasingDisplay(test));

		
	}
	
	public static void sort(ArrayList<Integer> list) {
		Collections.sort(list);	
	}
	
	public static String increasingDisplay(ArrayList<Integer> list) {
		sort(list);
		String answer = "";
		for(int x = 0; x < list.size(); x++) {
			answer += list.get(x) + " ";
		}
		return answer;
	}
}
