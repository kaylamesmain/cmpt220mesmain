import java.util.Scanner;
public class Question32 {
	public static void main(String[] args) { 
		
		//generating the integers 
		int firstInteger=(int)(Math.random()*10); 
		int secondInteger=(int)(Math.random()*10);
		int thirdInteger=(int)(Math.random()*10);
		
		int sum = firstInteger + secondInteger + thirdInteger;
		 
		
		//Creating the scanner for input
		Scanner input=new Scanner(System.in);
		
		System.out.println(firstInteger + "+" + secondInteger + "+" + thirdInteger + "= ?");
		int answer = input.nextInt();
		
		if (answer != sum) {
			System.out.println("Incorrect!");
		}
		else {
			System.out.println("Correct!");
		}
		
		
		
		
	}
}
