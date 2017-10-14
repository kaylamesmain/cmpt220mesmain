package lab6;

public class question91 {
	static void displayInfo(Rectangle r) {
		System.out.println("Width: " + r.width);
		System.out.println("Height: " + r.height);
		System.out.println("Area: " + r.getArea(r));
		System.out.println("Perimeter: " + r.getPerimeter(r));
		System.out.println("---------------------------------------");
	}
	
	public static void main(String [] args) {
		
		Rectangle firstRectangle = new Rectangle(4, 40);
		Rectangle secondRectangle = new Rectangle(3.5, 35.9);
		Rectangle thirdRectangle = new Rectangle();
		System.out.println("For the First Rectangle: ");
		displayInfo(firstRectangle);
		System.out.println("For the Second Rectangle: ");
		displayInfo(secondRectangle);
		System.out.println("For the Third Rectangle: ");
		displayInfo(thirdRectangle);
		
	}

}
