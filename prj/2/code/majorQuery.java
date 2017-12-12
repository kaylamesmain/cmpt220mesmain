package tableTest;

import java.util.ArrayList;

public class majorQuery {
	private String table_name;
	
	private String sort_by;
	private String filter;
	private ArrayList <String> columns = new ArrayList<String>();
	private String majorQuery;
	
	
	
	public majorQuery()
	{
		table_name = "kids";
		sort_by = " Order by kid_id";
		filter = "";
		majorQuery = "Select * from " + table_name + sort_by;
	}
	
	public String getTable ()
	{
		return table_name;
	}
	
	public void setTable (String name)
	{
		table_name = name;
	}
	
	public String getSort()
	{
		return sort_by;
	}
	
	public void setSort (String sorted_by)
	{
		sort_by = sorted_by;
	}
	
	
	public String getFilter()
	{
		return filter;
	}
	
	public void setFilter (String filtered_by)
	{
		filter = filtered_by;
	}
	
	
	public String [] getColumns ()
	{
		String[] answer = new String[columns.size()];
		answer = columns.toArray(answer);
		return answer;
	}
	
	public void setColumns (String [] array)
	{
		columns.clear();
		for(int i = 0; i < array.length; i++) {
			columns.add(array[i]);
		}
	}
	
	public String getMajorQuery ()
	{
		return "Select * from " + table_name + " Where (1=1) " + filter + sort_by;
	}
	
	

}
