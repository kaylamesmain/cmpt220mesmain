
public class question619 {

	public static boolean isValid(double side1, double side2, double side3) {
		double[] sides;
		sides = new double[3];
		sides[0] = side1;
		sides[1] = side2;
		sides[2] = side3; 
		
		for (int x = 0; x < sides.length - 2; x++) {
			for(int y = x+1; y < sides.length - 1; y++) {
				int missingIndex = 3 - y - x;
				if (sides[x] + sides[y] < sides[missingIndex]) {
					return false;
				}
			}
		}
		return true;
		
	}
	
	public static double area(double side1, double side2, double side3) {
		if (isValid(side1, side2, side3)) {
			double p = ((side1 + side2 + side3)/2);
			double area = Math.sqrt(p * ((p - side1) * (p - side2) * (p - side3)));
			System.out.println(area);
			return area;
		}
		else {
			System.out.println("The input is inValid");
			return 0.0;
		}
	}
	
	
	public static void main(String[] args) {
		area(1.0,1.0,1.0); // JA: You were supposed to get this info from the user
	}
	
}
