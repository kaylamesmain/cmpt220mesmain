package Lab7;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class question105 {
	public static void main(String[] args) {
		System.out.println("Please enter a positive integer: ");
		Scanner input = new Scanner (System.in);
		
		int userNum = input.nextInt();
		StackOfIntegers answer = new StackOfIntegers(factorsLength(userNum));
		int[] factorArray = factors(userNum);
		for(int x = 0; x < factorArray.length; x++) {
			answer.push(factorArray[x]);
		}
		
		
		System.out.println("Here is the StackOfIntegers variable in reverse order:");
		for(int x = factorArray.length - 1; x >= 0; x-- ) {
			System.out.print(factorArray[x] + " ");
		}
		
		
	}
	
	public static int factorsLength(int facNum) {
		int count = 0;
		for(int x = 2; x <= facNum; x++){
            while(facNum % x == 0){
                count += 1;
                facNum = facNum / x;
            }
        }
		return count;
	}
	
	public static int[] factors(int facNum) {
		int[] answer = new int[factorsLength(facNum)];
		int index = 0;
		for(int x = 2; x <= facNum; x++){
            while(facNum % x == 0){
                facNum = facNum/x;
                answer[index] = x;
                index += 1;
            }
        }
		return answer;
	}

}
