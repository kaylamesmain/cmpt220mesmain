package Lab7;

public class Circle2D {

	private double x;
	private double y;
	private double radius;
	
	
	Circle2D(){
		this.x = 0;
		this.y = 0;
		this.radius = 1;
	}
	
	Circle2D(double startX, double startY, double startRadius){
		this.x = startX;
		this.y = startY;
		this.radius = startRadius;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public double getArea() {
		return (Math.PI*(Math.pow(radius, 2)));
	}
	
	public double getPerimeter() {
		return (2 * Math.PI * radius);
	}
	
	public boolean contains(double x, double y) {
		double ptAnswer = Math.sqrt(Math.pow(x - this.x, 2) + Math.pow(y - this.y, 2));
		if (ptAnswer < radius) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public boolean contains(Circle2D circle) {
		double ptAnswer = Math.sqrt(Math.pow(circle.getX() - x, 2) + Math.pow(circle.getY() - y, 2));
		if (ptAnswer < Math.abs(radius - circle.getRadius())) {
			return true;
		}
		else {
			return false;
		}
	}

	
	public boolean overlaps(Circle2D circle) {
		double ptAnswer = Math.sqrt(Math.pow(circle.getX() - x, 2) + Math.pow(circle.getY() - y, 2));
		if (ptAnswer < radius + circle.getRadius()) {
			return true;
		}
		else {
			return false;
		}
	}
}
