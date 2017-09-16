import java.util.Scanner;
	public class Question311 {
		public static void main(String[] strings) {

	        Scanner input = new Scanner(System.in);

	        int totalDays = 0; 
	        String month = "";

	        System.out.print("Input a month number: ");
	        int monthNumber = input.nextInt();

	        System.out.print("Input a year: ");
	        int year = input.nextInt();

	        switch (monthNumber) {
	            case 1:
	                month = "January";
	                totalDays = 31;
	                break;
	            case 2:
	                month = "February";
	                if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
	                    totalDays = 29;
	                } else {
	                    totalDays = 28;
	                }
	                break;
	            case 3:
	                month = "March";
	                totalDays = 31;
	                break;
	            case 4:
	                month = "April";
	                totalDays = 30;
	                break;
	            case 5:
	                month = "May";
	                totalDays = 31;
	                break;
	            case 6:
	                month = "June";
	                totalDays = 30;
	                break;
	            case 7:
	                month = "July";
	                totalDays = 31;
	                break;
	            case 8:
	                month = "August";
	                totalDays = 31;
	                break;
	            case 9:
	                month = "September";
	                totalDays = 30;
	                break;
	            case 10:
	                month = "October";
	                totalDays = 31;
	                break;
	            case 11:
	                month = "November";
	                totalDays = 30;
	                break;
	            case 12:
	                month = "December";
	                totalDays = 31;
	        }
	        System.out.print(month + " " + year + " has " + totalDays + " days\n");
	    }
	}

