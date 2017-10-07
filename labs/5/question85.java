import java.util.Arrays;
import java.util.Scanner;

public class question85 {
	public static double [][] addMatrix(double[][] a, double[][] b){
		double sumMatrix[][] = new double[3][3];
		for(int x = 0; x < 3; x++) {
			for(int y = 0; y < 3; y++) {
				sumMatrix[x][y] = a[x][y] + b[x][y];
			}
		}
		printMatrix(sumMatrix);
		return sumMatrix;
		
	}
	
	public static double [][] toMatrix(double[] array){
		int count = 0;
		double matrix [][] = new double [3][3];
		for(int x = 0; x < 3; x++) {
			for(int y = 0; y < 3; y++) {
				matrix[x][y] = array[count];
				count += 1;
			}
		}
		return matrix;
	}
	
	public static String printMatrix(double matrix[][]) {
		String answer = "";
	    for (int row = 0; row < matrix.length; row++) {
	        for (int column = 0; column < matrix[row].length; column++) {
	            System.out.print(matrix[row][column] + " ");
	        }
	        System.out.println("");
	    }
	    return answer;
	}
	
	public static void main(String[] args) {
		double number;
		int count = 0;
		Scanner input = new Scanner(System.in);
		
		//Creating matrix 1
		double[] list1;
		list1 = new double [9];
		System.out.print("Enter matrix1: "); 
		while (count != 9) {
			number = input.nextDouble();
			list1[count] = number;
			count += 1;
		}
		
		double matrix1[][] = new double[3][3];
		matrix1 = toMatrix(list1);
		
		
		
		//Creating matrix2
		count = 0;
		double[] list2;
		list2 = new double [9];
		System.out.print("Enter matrix2: "); 
		while (count != 9) {
			number = input.nextDouble();
			list2[count] = number;
			count += 1;
		}
		
		double matrix2[][] = new double[3][3];
		matrix2 = toMatrix(list2);
		System.out.println("The final matrix is: ");
		addMatrix(matrix1, matrix2);
		// 1 2 3 4 5 6 7 8 9
		// 0 2 4 1 4.5 2.2 1.1 4.3 5.2
		
	}
}
