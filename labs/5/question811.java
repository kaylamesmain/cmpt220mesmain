import java.util.Scanner;

public class question811 {
	
	public static String decimalToBinaryModified(int n) {
        StringBuilder s = new StringBuilder();
        while (n != 0) {
            s.append(n & 1);
            n = n >> 1;
        }
        while (s.length() < 9) {
            s.insert(0, "0");
        }
        return s.toString();
    }

	
	
    public static void main(String[] args) {

        int[][] m = new int[3][3];
        
        //Retrieving int to turn into binary string 
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number between 0 and 511: ");
        int number = input.nextInt();
        
        
        //Taking int given and passing to helper method to turn it into a binary string
        String binaryString = decimalToBinaryModified(number);
        
        int binaryIndex = 0;
        
        //Creating 3 by 3 matrix using binary string using 0's and 1's
        for (int i = 0; i < m.length; i++) {
            for (int k = 0; k < m[i].length; k++) {
                int coinSide = (binaryString.charAt(binaryIndex++) == '0') ? 0 : 1;
                m[i][k] = coinSide;
            }
        }
        
        
        //Replacing 0's and 1's with H's and T's
        for (int i = 0; i < m.length; i++) {
            for (int k = 0; k < m[i].length; k++) {
                char ch = (m[i][k] == 0) ? 'H' : 'T';
                System.out.print(ch + " ");
            }
            System.out.println("");
        }
    }

}
