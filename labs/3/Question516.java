import java.util.Scanner; 
public class Question516 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number you would like to factor: ");
	    int value = input.nextInt();
		int remainder = 0;
		int i=2;
		while (value / i != 1){
			remainder = value%i;
			if(remainder == 0) {
				System.out.print(i + " ");
				//System.out.print(value);
				value = value/i; 
			}
			else i++;
		}
		System.out.print(i + " ");
	}
   		
}
