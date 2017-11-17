package lab10;
import static java.lang.Math.sqrt;

public class Octagon extends GeometricObject implements Comparable<Octagon>, Cloneable {
	private double side; 
	
	protected Octagon() {
		side = 0;
	}
	protected Octagon(double side) {
		this.side = side; 
	}
	
	public double getSide() {
		return side;
	}
	
	public void setSide(double side) {
		this.side = side;
	}
	
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return 2 + (4 / (Math.sqrt(2))) * side * side; 
	}

	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return 8 * side;
	}
	
	public Octagon clone() {
		return this;
	}
	
	public int compareTo(Octagon oct2) {
		// TODO Auto-generated method stub
		if (this.side == oct2.getSide()) {
			return 0;
		}
		else {
			return -1;
		}
	}
}

