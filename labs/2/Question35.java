import java.util.Scanner;
public class Question35 {
	public static void main(String[] args) {
		
		//Creating the scanner for input
			Scanner input=new Scanner(System.in);
			
			System.out.print("Enter todays day: ");
			int todayNum = input.nextInt();
			
			System.out.print("Enter the number of days elapsed since today: ");
			int elapsedNum = input.nextInt();
			
			
			String today = "";
			
			switch(todayNum) {
			case 0: today = "Sunday";
					break;
			case 1: today = "Monday";
			        break;
			case 2: today = "Tuesday";
			        break;
			case 3: today = "Wenesday";
			        break;
			case 4: today = "Thursday";
			        break;
			case 5: today = "Friday";
			        break;
			case 6: today = "Saturday";
			}
			
			String elapsedDay = "";
			
			elapsedNum = ((todayNum + elapsedNum) % 7);
			
			switch(elapsedNum) {
			case 0: elapsedDay = "Sunday";
					break;
			case 1: elapsedDay = "Monday";
					break;
			case 2: elapsedDay = "Tuesday";
					break;
			case 3: elapsedDay = "Wenesday";
					break;
			case 4: elapsedDay = "Thursday";
					break;
			case 5: elapsedDay = "Friday";
					break;
			case 6: elapsedDay = "Saturday";
			}
			
			System.out.println("Today is " + today + " the future day is of " + elapsedDay);
			
}
}
