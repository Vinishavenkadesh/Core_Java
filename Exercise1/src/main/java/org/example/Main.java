package org.example;
import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
      insertdata();
//      setData();
//        deleteData();
    }
    public static void setData() throws SQLException{

        String url = "jdbc:postgresql://localhost:5432/forms";
        String userName = "postgres";
        String password = "password";
        String query = "select * from form";

        Connection conn = DriverManager.getConnection(url,userName,password);
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);

        while(rs.next()){
            System.out.println("Id : " + rs.getInt(1));
            System.out.println("Name : " + rs.getString(2));
            System.out.println("Gpa : " + rs.getInt(3));
            System.out.println();
        }
    }

    public static void insertdata() throws SQLException{
        Scanner sc = new Scanner(System.in);
        String url = "jdbc:postgresql://localhost:5432/forms";
        String userName = "postgres";
        String password = "password";
        String query = "insert into form values(?,?,?);";

        int id = sc.nextInt();
        sc.nextLine();
        String Name = sc.nextLine();
        double GPA = sc.nextDouble();


        Connection conn = DriverManager.getConnection(url,userName,password);
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setInt(1,id);
        pst.setString(2,Name);
        pst.setDouble(3,GPA);

        int row = pst.executeUpdate();
        System.out.println("Row affected : " +  row);
    }

    public static void deleteData() throws SQLException{

        String url = "jdbc:postgresql://localhost:5432/forms";
        String userName = "postgres";
        String password = "password";
        String query = "Delete from form where id>=6";

        Connection conn = DriverManager.getConnection(url,userName,password);
        Statement st = conn.createStatement();
        int row = st.executeUpdate(query);

        System.out.println("Num of rows affected : " + row);

    }
}