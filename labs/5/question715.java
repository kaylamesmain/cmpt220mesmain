import java.util.Arrays;
import java.util.Scanner;

public class question715 {

	public static int[] eliminateDuplicates(int[] list) {
		int count = 0;
		for(int x = 0; x < 9; x++) {
			for(int y = x+1; y < 10; y++) {
				if(list[x] == list[y]) {
					list[y] = 100;
				}
			}
			if (list[x] == 100) {
				count += 1;
			}
		}
		int end = list.length - 1 - count;
		Arrays.sort(list);
		int [] answer = Arrays.copyOfRange(list, 0, end);
		return answer;
		
	}
	// 1 2 3 2 1 6 3 4 5 2
	public static void main(String[] args) {
		int number;
		int count = 0;
		int[] list;
		list = new int [10];
		Scanner input = new Scanner(System.in);
		System.out.print("Enter 10 numbers: "); 
		while (count != 10) {
			number = input.nextInt();
			list[count] = number;
			count += 1;
		}
		eliminateDuplicates(list);
	}
}
