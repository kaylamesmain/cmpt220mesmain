import java.util.Scanner;

public class question81 {
	
	public static double [][] toMatrix(double[] array){
		int count = 0;
		double matrix [][] = new double [3][4];
		for(int x = 0; x < 3; x++) {
			for(int y = 0; y < 4; y++) {
				matrix[x][y] = array[count];
				count += 1;
			}
		}
		return matrix;
	}

	public static void main(String[] args) {
		double number;
		int count = 0;
		Scanner input = new Scanner(System.in);
		
		//Creating matrix 1
		double[] list;
		list = new double [12];
		System.out.println("Enter a 3-by-4 matrix row by row: "); 
		while (count != 12) {
			number = input.nextDouble();
			list[count] = number;
			count += 1;
		}
		
		double matrix[][] = new double[3][4];
		matrix = toMatrix(list);
		
		for(int col = 0; col < 4; col++) {
			double sum = 0.0;
			for(int row = 0; row < 3; row++) {
				sum += matrix[row][col];
			}
			System.out.println("Sum of the elements at column " + col + " is " + sum);
		}
		
	}
}
