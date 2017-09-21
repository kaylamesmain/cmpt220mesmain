import java.util.Scanner;
public class Question421 {
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("this program checks if the social security number entered is valid");
        System.out.println("Please enter a SSN");
        String s = input.nextLine();
        boolean isSSN = true;

        if (s.length() != 11){
            isSSN = false;
        }
        if (!Character.isDigit(s.charAt(0))) // JA: What about all the other characters?
            isSSN = false;
        else if(s.charAt(2) != '_') // JA: This should be charAt(3)
            isSSN = false;
        else if(s.charAt(5) != '_') // JA: This should be charAt(6)
            isSSN = false;


        //display
        System.out.println(isSSN);

        if (isSSN == true)
            System.out.println(s + " is a valid social security number");
        else
            System.out.println(s  + " is an invalid social security number");
    }

}

// JA: It didn't compile becuase of this extra }
//}
