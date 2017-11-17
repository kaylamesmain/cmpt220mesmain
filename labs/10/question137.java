package lab10;

public class question137 {

	public static void main(String[]args) {
		//Array of 5 GeometricObjects 
		GeometricObject[] squares = {new Square(1), new Square(2), new Square(3),
									new Square(4), new Square(5)}; 
		for (int i= 0; i< squares.length; i++) {
			System.out.println("Area: "+ squares[i].getArea());
			System.out.println("How To Color if it is Colorable: " + ((Square)squares[i]).howToColor());
			System.out.println("----------------------");
		}
	}
}
