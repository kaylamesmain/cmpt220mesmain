import java.util.Scanner;

public class question617 {
	public static void printMatrix(int n) {
		for (int x = 0; x < n; x++) {
		    for (int y = 0; y < n; y++) {
		        System.out.print(Math.round((Math.random() * 1)) + " ");
		    }
		    System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter n:");
		int number = input.nextInt();
		printMatrix(number);	
	}

}
