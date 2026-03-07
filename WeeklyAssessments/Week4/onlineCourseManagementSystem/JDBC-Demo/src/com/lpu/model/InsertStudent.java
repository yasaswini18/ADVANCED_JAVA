package com.lpu.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertStudent {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";  // Change "test" to your DB name
        String user = "root";  // Your MySQL username
        String password = "pass123";  // Your MySQL password

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO student (id, name, age) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, 1);
            pstmt.setString(2, "Yasaswini");
            pstmt.setInt(3, 21);

            int rows = pstmt.executeUpdate();
            System.out.println(rows + " row(s) inserted.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
