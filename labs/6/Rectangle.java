package lab6;

public class Rectangle {
	
	public double width;
	public double height;
	
	Rectangle() {
		width = 1;
		height = 1;
	} 
	
	Rectangle(double startWidth, double startHeight) {
		width = startWidth;
		height = startHeight;
	}
	

	double getArea(Rectangle r) {
		return r.height * r.width;
	}
	
	double getPerimeter(Rectangle r) {
		return (r.height * 2) + (r.width * 2);
	}
}

