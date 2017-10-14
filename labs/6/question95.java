package lab6;

public class question95 {
	
	public static void main(String[] args) {
		java.util.GregorianCalendar currentCalendar = new java.util.GregorianCalendar();
		System.out.println("The year is " + currentCalendar.get(currentCalendar.YEAR));
		System.out.println("The year is " + currentCalendar.get(currentCalendar.MONTH));
		System.out.println("The year is " + currentCalendar.get(currentCalendar.DATE));
		System.out.println("------------------------------------");
		currentCalendar.setTimeInMillis(1234567898765L);
		System.out.println("The year is " + currentCalendar.get(currentCalendar.YEAR));
		System.out.println("The year is " + currentCalendar.get(currentCalendar.MONTH));
		System.out.println("The year is " + currentCalendar.get(currentCalendar.DATE));

	}

}
