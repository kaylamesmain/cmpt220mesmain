package lab9;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class question1211 {
	public static void main(String[] args) throws FileNotFoundException {
		String fileString = new Scanner(new File(args[1])).nextLine();
		//where we replace the array
		System.out.println(fileString.replace(args[0], ""));
		
		
	}
}
