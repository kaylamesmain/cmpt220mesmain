package lab10;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List; 

	public class question133 {
		public static void main(String[] args) {
			// Create and arrayList
			ArrayList<Number> list = new ArrayList<>();

			// Add unsorted numbers to list
			list.add(17);
			list.add(99);
			list.add(9.0);
			list.add(98.4);
			list.add(6.3);
			list.add(54.5);
			list.add(2);
			list.add(3.6);

			System.out.println(list.toString());

			// Sort list
			sort(list);

			// Display list of sorted numbers
			System.out.println(list.toString());
		}
	
		public static void sort(ArrayList<Number> list) {	        
	        for (int m = list.size(); m >= 0; m--) {
	            for (int i = 0; i < m - 1; i++) {
	                if (list.get(i).doubleValue() > list.get(i + 1).doubleValue()) {	
	                		Number temp = list.get(i);
	                		list.set(i, list.get(i + 1));
	                		list.set(i + 1 , temp);
	                }
	            }
	        }
	        
		}
}
