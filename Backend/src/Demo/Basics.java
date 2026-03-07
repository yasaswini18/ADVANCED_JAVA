package Demo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Basics {
	public static void main(String[] args) throws SQLException {
		String sql = "select ename from emp where job in('clerk')";
		String url = "jdbc:mysql://localhost:3306/scott";
		String username = "root";
		String password = "Yash@123";
		Connection con = DriverManager.getConnection(url,username,password);
		Statement st = con.createStatement();
		ResultSet result = st.executeQuery(sql);
		result.next();
		String name = result.getString(1);
		System.out.println(name);
		con.close();
	}

}
