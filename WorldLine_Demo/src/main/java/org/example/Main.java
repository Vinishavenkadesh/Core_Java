package org.example;
import java.sql.*;
public class Main {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/employee";
        String userName = "postgres";
        String password = "password";
        String query = "Select * from form";

        Connection conn = DriverManager.getConnection(url,userName,password);
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);

        while(rs.next()){
            System.out.println("Id : " + rs.getInt(1));
            System.out.println("Employee Name : " + rs.getString(2));
            System.out.println("salary : " + rs.getInt(3));
            System.out.println();
        }
    }
}