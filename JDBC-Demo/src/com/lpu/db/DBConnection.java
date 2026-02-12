package com.lpu.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.lpu.dao.StudentDao;
import com.lpu.model.Student;
import com.mysql.cj.jdbc.MysqlDataSource;

public class DBConnection {
	public static Connection getConnection() throws SQLException
	{
		MysqlDataSource ds = new MysqlDataSource();
		ds.setUser("root");
		ds.setPassword("pass123");
		ds.setUrl("jdbc:mysql://localhost:3306/test");
		Connection connection = ds.getConnection();
		return connection;
	}
	public static void main(String[] args)
	{
		Connection con = null;
		try {
				con=DBConnection.getConnection();
			System.out.println("Connection established: "+con);
			
			StudentDao sd=new StudentDao();
			List<Student> students = sd.findAll();
			for(Student s : students)
			{
				System.out.println(s);
			}

		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
