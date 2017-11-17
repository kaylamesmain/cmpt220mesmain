package lab10;

public class question1311 {
	
	public static void main(String[] args) {
		Octagon octagonOne = new Octagon(5);
		Octagon octagonTwo = octagonOne.clone();
		
		System.out.println("Area: " + octagonOne.getArea());
		System.out.println("Perimeter: " + octagonOne.getPerimeter());
		int result = (octagonOne.compareTo(octagonTwo));
		if (result == 0)
			System.out.println("Octagon is equal to its clone."); 
		else
			System.out.println("Octagon is not equal to its clone");
	}
}

