import java.util.Scanner; 
public class question61 {
	public static void main(String[] args){
		
		//creates the table
        for (int pentagonal = 1; pentagonal <= 100; pentagonal++){
            System.out.printf("%7d ", getPentagonalNumber(pentagonal));
            
            //puts the integer into 10 seperate columns 
            if (pentagonal % 10 == 0)
                System.out.println();
        }
        System.out.println("The above is the first 100 pentagonal numbers in 10 columns");
    }
	//returns the pentagonal number 
    public static int getPentagonalNumber(int n){
        return (n * (3 * n - 1)) / 2;
    }
}

