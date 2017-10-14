package lab6;

public class Location {
	public int row;
	public int column;
	public double maxValue;
	
	Location(){
		row = 0;
		column = 0;
		maxValue = 0;
	}
	
	Location(int startRow, int startColumn, double startValue) {
		row = startRow;
		column = startColumn;
		maxValue = startValue;
	}
	
	int getRow() {
		return row;
	}
	
	public void setRow(int value) {
		this.row = value;
	}
	
	
	
	int getColumn() {
		return column;
	}
	
	public void setColumn(int value) {
		this.column = value;
	}
	
	
	
	double getValue() {
		return maxValue;
	}
	
	public void setValue(double value) {
		this.maxValue = value;
	}
	
	
	public static Location locateLargest(double[][] a) {
		Location largest = new Location();
		
		for(int row = 0; row < a.length; row++) {
			for(int col = 0; col < a[row].length; col++) {
				
				if (a[row][col] > largest.maxValue) {
					largest.setValue(a[row][col]);
					largest.setColumn(col);
					largest.setRow(row);
				}
			}
		}
		
		return largest;
		
	}
	
	

}
