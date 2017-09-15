import java.util.Scanner;
public class Question413 {
	 public static void main(String[] args)
	    {
	        Scanner in = new Scanner(System.in);
	        
	        System.out.print("Enter a character: ");
	        String character = in.next();
	        char letter = Character.toLowerCase(character.charAt(0));
	        if (!Character.isLetter(letter))
	            System.out.println(character + " is an invalid input.");
	        else
	        {
	            switch(letter)
	            {
	                case 'a':
	                case 'e':
	                case 'i': 
	                case 'o': 
	                case 'u':
	                    System.out.println(character + " is a vowel");
	                    break;
	                    
	                default:
	                    System.out.println(character + " is a consonant");
	            }    
	        }
	        
	    }
	 }