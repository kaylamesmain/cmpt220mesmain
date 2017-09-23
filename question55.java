import java.util.Scanner; 
public class question55 {
	public static void main(String[] args) {
		//creating the table to be aligned 
		System.out.printf("%15s %6s | %6s %15s", "Kilograms", "Pounds", "Pounds", "Kilograms\n");
		//converts the kilo into pounds and pounds to kilo 
		for (int i = 1, j = 20; i <= 199; i = i + 2, j = j + 5) {
			System.out.printf("%15d %6.1f | %6d %15.2f\n",  i, i * 2.2, j, j * 0.4545); 
		}
	}

}
