package lab6;

public class question93 {
	public static void main(String args[]) {
		long date = 100000;
		java.util.Date currentDate = new java.util.Date();
		while(date != 1e11) {
			currentDate.setTime(date);
			System.out.println(currentDate.toString());
			date *= 10;
			
		}
		
		
	}

}
