package lab10;

public class question139 {
	public static void main(String[]args) {
		Circle circleOne = new Circle(5);
		Circle circleTwo = new Circle(5);
		
		//comparing the circles given 
		System.out.print("Are the two objects equal if their radii is the same?: " +
							circleOne.equals(circleTwo));
	}

}
