package com.lpu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lpu.model.Student;

import com.lpu.db.DBConnection;

public class StudentDao {
	public List<Student> findAll()
	{
		List<Student> list = new ArrayList<>();
		try(Connection con = DBConnection.getConnection())
		{
			Statement st = con.createStatement();
			ResultSet rs = (st).executeQuery("select * from student");
			while(rs.next())
			{
				int id = rs.getInt("id");
				String name=rs.getString("name");
				int age = rs.getInt("age");
				
				list.add(new Student(id, name, age));
				
			}
		}catch(SQLException e)
		{ 
			e.printStackTrace();
		}
		return list;
	}
	
	public Student add(Student student)
	{
		try(Connection con = DBConnection.getConnection())
		{
			PreparedStatement ps = con.prepareStatement("INSERT INTO student VALUES(?, ?, ?, ?)");
			ps.setInt(1, student.getId());
			ps.setString(2, student.getName());
			ps.setInt(3, student.getAge());
			
			int rowsInserted = ps.executeUpdate();
			if (rowsInserted == 1)
            return student;
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}

public Student findById(int id) {
    try (Connection con = DBConnection.getConnection()) {
        PreparedStatement pst = con.prepareStatement("SELECT * FROM student WHERE id = ?");
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            String name = rs.getString("name");
            int age = rs.getInt("age");
            return new Student(id, name, age);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}

		}
	

 