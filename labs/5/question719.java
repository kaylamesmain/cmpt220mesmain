import java.util.Arrays;
import java.util.Scanner;

public class question719 {
	public static boolean isSorted(int [] list) {
		int [] original = new int[list.length];
		System.arraycopy(list, 0, original, 0, list.length);
		Arrays.sort(list);
		
		if (Arrays.equals(original, list)) {
			System.out.println("The list is already sorted");
			return true;
		}
		else {
			System.out.println("The list is not sorted");
			return false;
		}
		
	}
	
	public static void main(String[] args) {
		//Getting the size of the list
		int sizeOfList;
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the size of the list: ");
		sizeOfList = input.nextInt();
		
		//Getting contents of list according to that size
		int number;
		int count = 0;
		int[] list;
		list = new int [sizeOfList];
		System.out.print("Enter " + sizeOfList + " numbers: "); 
		while (count != sizeOfList) {
			number = input.nextInt();
			list[count] = number;
			count += 1;
		}
		System.out.println("The list has " + sizeOfList + " integers: " + Arrays.toString(list));
		isSorted(list);
	}

}
