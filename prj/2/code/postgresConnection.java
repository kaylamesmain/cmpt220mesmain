package tableTest;
import java.sql.*;
import javax.swing.*;

/*Establish the connection between the Java Files and the database i am trying to connect to*/
public class postgresConnection {
	Connection conn = null;
	/*dbConnection method to return the connection to the database */
	public static Connection dbConnector()
	{
		/*Try/catch to catch any possible errors and display them in the console*/
		try {
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/christmas_santa",
		            "postgres", "alpaca");
			return conn;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e);
			e.printStackTrace();
			return null;
		}
	}

}
