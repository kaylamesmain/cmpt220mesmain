import java.text.DecimalFormat;
public class Question69 {
	
	public static double footToMeter (double foot) {
		double meter = foot * 0.305;
		return meter;
	}
	
	public static double meterToFoot (double meter) {
		double foot = meter * 3.279;
		return foot;
	}
	
	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("#.###");
		double count = 1.0;
		double count2 = count + 19;
		System.out.println("Feet		Meters	|	Meters		Feet");
		System.out.println("__________________________________________________________________________");
		while(count < 11.0) {
			System.out.println(count + "		" + df.format(footToMeter(count)) 
							   +  "		" 
							   + count2 + "		" + df.format(meterToFoot(count2)));
			count += 1.0;
			count2 += 5.0;
		}
	}

}

