import java.util.Scanner;
public class question63 {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
        System.out.print("Please enter an integer to test.");
        int integer = input.nextInt();
        isPalindrome(integer);
	}
	
	public static int reverse(int number) {
		int num = number;
        int reverseNum = 0;

        while (num != 0) {
            int remainder = num % 10;
            reverseNum = reverseNum * 10 + remainder;
            num = num / 10;
        }
        return reverseNum;
	}

	public static boolean isPalindrome(int number) {
		if (number == reverse(number)) {
			System.out.println("The number " + number + " is a Palindrome");
			return true;
		}
		else {
			System.out.println("The number " + number + " is not a Palindrome");
			return false;
		}
	}
}