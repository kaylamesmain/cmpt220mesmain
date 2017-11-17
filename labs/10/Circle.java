package lab10;

public class Circle extends GeometricObject implements Comparable<Double> {
	  private double radius;

	  public Circle() {
	  }

	  public Circle(double radius) {
	    this.radius = radius;
	  }

	  
	  public double getRadius() {
	    return radius;
	  }

	  //radius
	  public void setRadius(double radius) {
	    this.radius = radius;
	  }

	  //Area
	  public double getArea() {
	    return radius * radius * Math.PI;
	  }

	  //Diameter
	  public double getDiameter() {
	    return 2 * radius;
	  }

	 
	  public double getPerimeter() {
	    return 2 * radius * Math.PI;
	  }

	  //circle information
	  public void printCircle() {
	    System.out.println("The circle is created " + getDateCreated() +
	      " and the radius is " + radius);
	  }
	  
	  
	//comparable interface
	  public boolean equals(Circle circle2) {
		  if (circle2 instanceof Circle) {
			  if (circle2.getRadius() == this.radius) {
				  return true; 
			  }
		  }
		  return false;
	  }

	@Override
	public int compareTo(Double radius) {
		if (this.radius == radius) {
		return 0;
	}
		else {
			return -1;
		}
	}
	}