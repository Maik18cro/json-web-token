package com.example.VerificationJWT.databases;
import com.example.VerificationJWT.services.User;

import java.sql.*;

public class DataBase {
    final String url = "jdbc:mysql://localhost:3306/DatabasesJwt";
    final String userDatabases = "root";
    final String passwordDatabases = "";

    public User database(String email, String name, String password, String city) throws SQLException {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, userDatabases, passwordDatabases);
            Statement statement = connection.createStatement();
            PreparedStatement insertQuery = connection.prepareStatement("INSERT INTO DatabasesJwt (id,emailUser,nameUser, passwordUser,cityUser) VALUES (?, ?, ?, ?, ?)");
            insertQuery.setString(1, "0");
            insertQuery.setString(2, email);
            insertQuery.setString(3, name);
            insertQuery.setString(4, password);
            insertQuery.setString(5, city);
            insertQuery.executeUpdate();
            System.out.println("nice");
        } catch (SQLException e) {
            System.out.println("error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("success");
        connection.close();
        return null;
    }



public User loginVerication(String email, String password) {
    Connection connection = null;
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(url, userDatabases, passwordDatabases);
        System.out.println("conexion");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT (emailUser) FROM DatabasesJwt WHERE emailUser = " + email);
//        ResultSet resultSet = statement.executeQuery("SELECT * FROM DatabasesJwt ");

//            System.out.println("ID: " + resultSet.getInt("id"));
            System.out.println("Email: " + resultSet.getString("emailUser"));
//            System.out.println("Name: " + resultSet.getString("nameUser"));
//            System.out.println("Password: " + resultSet.getString("passwordUser").equals(password));
//            System.out.println("City: " + resultSet.getString("cityUser"));


    } catch (SQLException e) {
        System.out.println("error: " + e.getMessage() );

    } catch (ClassNotFoundException e) {
        throw new RuntimeException(e);
    }
    System.out.println("success");
    return null;
    }



}
