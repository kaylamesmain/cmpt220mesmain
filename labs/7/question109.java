package Lab7;

import java.util.ArrayList;

public class question109 {
	public static void main(String[] args) {
		
		Course mathClass = new Course("Math");
		mathClass.addStudent("Stephen");
		mathClass.addStudent("Zayda");
		mathClass.addStudent("Alpha");
		mathClass.addStudent("Omega");
		
		mathClass.dropStudent("Alpha");

		String[] answer = removeNull(mathClass.getStudents());
		for(int x = 0; x < answer.length; x++) {
			System.out.println(answer[x] + " ");
		}
		
		
	}
	public static String[] removeNull(String[] a) {
		   ArrayList<String> removedNull = new ArrayList<String>();
		   for (String str : a)
		      if (str != null)
		         removedNull.add(str);
		   return removedNull.toArray(new String[0]);
		}
	
}
