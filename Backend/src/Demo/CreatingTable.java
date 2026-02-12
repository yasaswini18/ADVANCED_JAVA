package Demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreatingTable {
public static void main(String[] args) {
//	String url = "jdbc:mysql://localhost:3306/scott";
//	String user = "root";
//	String pass = "Yash@123";
	String sql = "CREATE TABLE IF NOT EXISTS STUDENT_OTHER("+
	             "S_ID INT PRIMARY KEY,"+
			     "S_NAME VARCHAR(20) NOT NULL,"+
	             "S_CITY VARCHAR(20)"+
			     ")";
	try {
	Connection con = DBConnection.getConnection();
	Statement st = con.createStatement();
	st.executeUpdate(sql);
	System.out.println("Table created successfully");
	con.close();
	}catch(Exception e) {
		e.printStackTrace();
	}
}
}
