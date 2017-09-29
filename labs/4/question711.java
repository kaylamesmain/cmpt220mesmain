import java.text.DecimalFormat;
import java.util.Scanner;

public class question711 {
	public static double mean(double[] x) {
		double sum = 0.0;
		int count = 0;
		while (count < x.length) {
			sum += x[count];
			count += 1;
		}
		return sum / 10;	
	}
	
	public static double deviation(double[] x) {
		double meanValue = mean(x);
		double sumOfNumerators = 0.0;
		int count = 0;
		while (count != x.length) {
			double currentNumerator = Math.pow((x[count] - meanValue), 2);
			sumOfNumerators += currentNumerator;
			count += 1;
		}
		return Math.sqrt((sumOfNumerators/(x.length - 1)));
	}
	
	
	// 1.9 2.5 3.7 2 1 6 3 4 5 2
	public static void main(String[] args) {
		double number;
		int count = 0;
		double[] list;
		list = new double [10];
		Scanner input = new Scanner(System.in);
		System.out.print("Enter 10 numbers:"); 
		while (count != 10) {
			number = input.nextDouble();
			list[count] = number;
			count += 1;
		}
		
		double meanValue = mean(list);
		double deviationValue = deviation(list);
		DecimalFormat meanDF = new DecimalFormat("#.##");
		DecimalFormat deviationDF = new DecimalFormat("#.#####");
		System.out.println("The mean is " + meanDF.format(meanValue));
		System.out.println("The standard deviation is " + deviationDF.format(deviationValue));
		
		
	}

}
