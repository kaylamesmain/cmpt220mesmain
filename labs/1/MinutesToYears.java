import java.util.Scanner;
//PROBLEM #2.7
public class MinutesToYears {
	public static void main(String[] args) {
		Scanner input= new Scanner (System.in);
		
		//prompts amount of minutes 
		System.out.print("Please enter the number of minutes you wish to calculate:"); 
		int minutes = input.nextInt(); 
		
		//Users input is divide into the integers 
		int years = minutes / 525600; 
		int days = (minutes % 525600) / (1440); 
		
		//Gives the number of days and years 
		System.out.println(minutes + " minutes is equal to " + years + " years and " + days + " days");
	}
}