import java.util.Scanner;
public class Question317 {
	public static void main(String[] args) {
		String answer = "";
		Scanner input = new Scanner(System.in);

		// Generate a random integer 0, 1, or 2
		int cpNumber = (int)(Math.random() * 3);

		// Prompt the user to enter a number 0, 1, or 2
		System.out.print("scissor (0), rock (1), paper (2): ");
		int user = input.nextInt();

		answer += "The computer chose ";
		
		switch (cpNumber)
		{
			case 0: 
				answer += "scissor."; 
				break;
				
			case 1: 
				answer += "rock."; 
				break;
				
			case 2: 
				answer += "paper.";
				
		}

		answer += " You are ";
		
		switch (user)
		{
		case 0: 
			answer += "scissor."; 
			break;
			
		case 1: 
			answer += "rock."; 
			break;
			
		case 2: 
			answer += "paper.";
				
		}

		// Display result
		if (cpNumber == user)
			answer += " too. It is a draw";
		else
		{
			boolean win = (user == 0 && cpNumber == 2) ||
						  (user == 1 && cpNumber == 0) || 
						  (user == 2 && cpNumber == 1);
			if (win)
				answer += " You won";
			else
				answer += " You lose";
		}
		
		System.out.println(answer);
	}
	
}
