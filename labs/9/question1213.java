package lab9;
import java.io.*;
import java.util.*;

public class question1213 {
	/** Main method */
	public static void main(String[] args) throws Exception {
		if (args.length != 1) {
			System.out.println("Proper use: java lab9.question1213 [file_path]fffr");
			System.exit(1);
		}
		else {
			File file = new File(args[0]);
				if (!file.exists()) {
					System.out.println("The file " + args[0] + " does not exist");
					System.exit(2);
				}
				else {
			
					int char_count = 0;
					int word_count = 0;
					int line_count = 0;
					
					try (
							// Create input file
							Scanner input1 = new Scanner(file);
							Scanner input2 = new Scanner(file);
						) {
							while (input1.hasNext() || input2.hasNext()) {
								if (input1.hasNext()){
									line_count++;
									String line = input1.nextLine();
									char_count += line.length();
								}
								else if(input2.hasNext()) {
									String word = input2.next();
									word_count++;
								}
							}
						}
						
					System.out.println("The number of chars is: " + char_count);
					System.out.println("The number of words is: " + word_count);
					System.out.println("The number of lines is: " + line_count);
	}
	}
	}
	
	
}
