package lab8;

public class Triangle
	extends GeometricObject{
		private double side1;
		private double side2;
		private double side3;
		
		Triangle(){
			side1 = 1.0;
			side2 = 1.0;
			side3 = 1.0;
		}
		
		Triangle(double sideA, double sideB, double sideC){
			side1 = sideA;
			side2 = sideB;
			side3 = sideC;
		}
		
		public double getSide1() {
			return side1;
		}
		
		public double getSide2() {
			return side2;
		}
		
		public double getSide3() {
			return side3;
		}
		
		public double getHeight() {
			return (2 * (side1 / side2));
		}
		
		public double getArea() {
			double s = (side1 + side2 + side3) / 2;
			return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
		}
		
		public double getPerimeter() {
			return side1 + side2 + side3;
		}
		
		public String toString() {
			return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;
		}
	}
