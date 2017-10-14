package lab6;
public class LinearEquation {
	
	private double a;
	private double b;
	private double c;
	private double d;
	private double e;
	private double f;
	
	LinearEquation(double first, double second, double third, double fourth, double fifth, double sixth){
		a = first;
		b = second;
		c = third;
		d = fourth;
		e = fifth;
		f = sixth;		
	}
	
	double getA() {
		return a;
	}
	
	double getB() {
		return b;
	}
	
	double getC() {
		return c;
	}
	
	double getD() {
		return d;
	}
	
	double getE() {
		return e;
	}
	
	double getF() {
		return f;
	}
	
	
	boolean isSolvable() {
		if((a * d) - (b * c) != 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	double getX() {
		return (((e*f) - (b*f)) / ((a*d) - (b*c)));
	}
	
	double getY() {
		return (((a*f) - (e*c)) / ((a*d) - (b*c)));
	}
	
	

}
