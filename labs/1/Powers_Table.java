public class Powers_Table{
public static void main(String[] args) {

// create the columns 
System.out.println("a \t a^2 \t a^3"); 

// creating the rows in the table 
int max_rows = 4; 
for (int row_num =1; row_num <= max_rows; row_num++) 
{
// the value of the rows 
int second_power = row_num * row_num; 
int third_power = row_num * second_power; 

System.out.println( row_num + " \t" + second_power + "\t" + third_power); 
}
}
}