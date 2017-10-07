import java.util.Arrays;
import java.util.Scanner;

public class question79 {
	public static double min(double[] array) {
		Arrays.sort(array);
		return array[0];
	}

	public static void main(String[] args) {
		double number;
		int count = 0;
		double[] list;
		list = new double [10];
		Scanner input = new Scanner(System.in);
		System.out.print("Enter 10 numbers: "); 
		while (count != 10) {
			number = input.nextDouble();
			list[count] = number;
			count += 1;
		}
		System.out.println("The minimum number is " + min(list));
	}

}

