import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class question75 {
	public static void main(String[] args){
		int number;
		int count = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		Scanner input = new Scanner(System.in);
		System.out.print("Enter 10 numbers:"); 
		do {
			number = input.nextInt();
			if (!list.contains(number)) {
				list.add(number);
			}
			count += 1;
		}while (count != 10);
		Collections.sort(list);
		
		System.out.println("The number of distinct numbers is: " + list.size());
		System.out.println("The distint numbers are: " + list);
	
	}

}

