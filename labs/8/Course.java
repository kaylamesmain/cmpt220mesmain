// JA: Which is the class to test this?
package lab8;

import java.util.ArrayList;

public class Course {
	private String courseName;
	private ArrayList<String> students;

	public Course(String courseName) {
		this.courseName = courseName;
	}

	public void addStudent(String student) {
		students.add(student);
	}

	public String[] getStudents() {
		String [] answer = new String[students.size()];
		answer = students.toArray(answer);
		return answer;
	}

	public int getNumberOfStudents() {
		return students.size();
	}

	public String getCourseName() {
		return courseName;
	}

	
	public void dropStudent(String student) {
		students.remove(student);
	}
	
	public void clear(ArrayList<String> array) {
		ArrayList<String> new_array_list = new ArrayList<String>();
		students = new_array_list;
	}
	
}