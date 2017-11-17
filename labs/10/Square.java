package lab10;

public class Square extends GeometricObject implements Colorable {
	  /** Abstract method getArea */
		private double side; 
		
		protected Square() {
			side = 0; 
		}
		protected Square(double side) {
			this.side = side; 
		}
		public double getArea() {
		  return side * side;
		}

		/** Abstract method getPerimeter */
	  public double getPerimeter() {
		  return 4 * side;
	  }
		@Override
		public String howToColor() {
			// TODO Auto-generated method stub
			return "Color all four sides";
		}

}
