import java.util.Scanner; 
public class question513 {
	public static void main(String[] args) {
		int n= 0;
		int nCubed= 0; 
		
		//determines if n cubed is larger than 12000  
		while (nCubed < 12000) { 
			n++; 
			nCubed= n*n*n; 
		} // JA: You need to decrement n, since n*n*n is >= 12000
		System.out.println("The largest integer is " + n);
	}

}
