import java.text.DecimalFormat;

public class question613 {
	public static double sumSeries (int i) {
		double sum = 0;
		while (i != 0) {
			sum += (i/(i+1.0));
			i -= 1;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("#.####");
		System.out.println("i		m(i)");
		System.out.println("_____________________");
		int count = 1;
		while(count != 21) {
		System.out.println(count + "		" + df.format(sumSeries(count)));
		count += 1;
		}
	}
}
