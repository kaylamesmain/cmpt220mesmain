package Lab7;

public class question1011 {
	public static void main(String[] args) {
		Circle2D c1 = new Circle2D(2, 2, 5.5);
		System.out.println("For Circle C1:");
		System.out.println("Area: " + c1.getArea());
		System.out.println("Perimeter: " + c1.getPerimeter());
		System.out.println("Contains Method (double, double): " + c1.contains(3, 3));
		System.out.println("Contains Method (Circle2D): " + c1.contains(new Circle2D(4, 5, 10.5)));
		System.out.println("Overlaps Method: " + c1.overlaps(new Circle2D(3, 5, 2.3)));
	}

}
