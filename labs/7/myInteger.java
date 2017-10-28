package Lab7;

public class myInteger {
	private int value;

	myInteger(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
	
	
	
	
	public boolean isEven() {
		return isEven(value);
			
	}
		
	public boolean isOdd() {
		return isOdd(value);
			
	}
		
	public boolean isPrime() {
		return isPrime(value);
	}
	
	
	
	
	
		
	public static boolean isEven(int number) {
		if (number % 2 == 0){
			return true;
		}
		else {
			return false;
		}
			
	}
		
	public static boolean isOdd(int number) {
		if (number % 2 == 1){
			return true;
		}
		else {
			return false;
		}
			
	}
		
	public static boolean isPrime(int number) {
		int half = number / 2;
		while (half != 1){
			if (number % half == 0) {
				return false;
			}
			half -= 1;
		}
		return true;	
	}
		
	
	
	
	
	
	
	public static boolean isEven(myInteger number) {
		return number.isEven();
			
	}
		
	public static boolean isOdd(myInteger number) {
		return number.isOdd();
	}
		
	public static boolean isPrime(myInteger number) {
		return number.isPrime();
	}
	
	
	
		
		
	public boolean equals(int number) {
		if (this.value == number) {
			return true;
		}
		else {
			return false;
		}
	}
		
	public boolean equals(myInteger number) {
		if(this.value == number.getValue()) {
			return true;
		}
		else {
			return false;	
		}
	}
		
		
	public static int parseInt(char[] array) {
		int number = Integer.parseInt(new String(array));
		return number;
	}
		
	public static int parseInt(String array) {
		return Integer.parseInt(array);
	}

}
