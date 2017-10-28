package Lab7;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Course {
	private String courseName;
	private String[] students = new String[1];
	private int numberOfStudents;

	public Course(String courseName) {
		this.courseName = courseName;
	}

	public void addStudent(String student) {
		if (getNumberOfStudents() == students.length) {
			String[] biggerArray = new String[getNumberOfStudents() + 1];
			for(int x = 0; x < students.length; x++) {
				biggerArray[x] = students[x];
			}
			students = biggerArray;
		}
		students[numberOfStudents] = student;
		numberOfStudents++;
	}

	public String[] getStudents() {
		String[] studentArray = new String[getNumberOfStudents()];
		for(int x = 0; x < students.length; x++) {
			studentArray[x] = students[x];
		}
		return studentArray;
	}

	public int getNumberOfStudents() {
		return numberOfStudents;
	}

	public String getCourseName() {
		return courseName;
	}

	
	public void dropStudent(String student) {
		for (int x = 0; x < students.length - 1; x++) {
			if(students[x] == student) {
				students[x] = null;
			}
		}
	}
	
	public void clear(String[] array) {
		String[] newArray = new String[0];
		students = newArray;
		numberOfStudents = 0;
	}
	
	

}