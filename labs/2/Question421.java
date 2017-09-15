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
        if (!Character.isDigit(s.charAt(0)))
            isSSN = false;
        else if(s.charAt(2) != '_')
            isSSN = false;
        else if(s.charAt(5) != '_')
            isSSN = false;


        //display
        System.out.println(isSSN);

        if (isSSN == true)
            System.out.println(s + " is a valid social security number");
        else
            System.out.println(s  + " is an invalid social security number");
    }

}

}
