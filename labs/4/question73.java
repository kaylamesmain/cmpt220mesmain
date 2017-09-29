import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class question73 {
	
	public static void main(String[] args){
		int number;
		ArrayList<Integer> list = new ArrayList<Integer>();
		Scanner input = new Scanner(System.in);
		System.out.print("Enter integer's between 1 and 100, the input ends if it is 0:"); 
		do {
			number = input.nextInt();
			list.add(number);
		}while (number !=0);
		
		Collections.sort(list);
		
		int index = 1;
		while (index != list.size()) {
			int lastOccurence = list.lastIndexOf(list.get(index));
			int numOfOccurences = lastOccurence - index + 1;
			if (numOfOccurences == 1) {
				System.out.println(list.get(index) + " occurs " + numOfOccurences + " time");
			}
			else {
				System.out.println(list.get(index) + " occurs " + numOfOccurences + " times");
			}
			if (lastOccurence == list.size()) {
				break;
			}
			else {
				index = lastOccurence + 1;
			}
		}
		System.out.println(list);
	
	}
	

}
