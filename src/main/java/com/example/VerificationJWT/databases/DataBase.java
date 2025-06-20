package com.example.VerificationJWT.databases;
import com.example.VerificationJWT.response.Response;
import com.example.VerificationJWT.response.ResponseErorr;
import com.example.VerificationJWT.response.ResponseUsers;
import com.example.VerificationJWT.services.User;

import java.sql.*;

public class DataBase {

    final String url = "jdbc:mysql://localhost:3306/DatabasesJwt";
    final String userDatabases = "root";
    final String passwordDatabases = "";



    public User database(String email, String name, String password, String city) throws SQLException{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, userDatabases, passwordDatabases);
            Statement statement = connection.createStatement();
            PreparedStatement insertQuery = connection.prepareStatement("INSERT INTO DatabasesJwt (id,emailUser,nameUser, passwordUser,cityUser) VALUES (?, ?, ?, ?, ?)");
                insertQuery.setString(1, "0");
                insertQuery.setString(2, email);
                insertQuery.setString(3, name);
                insertQuery.setString(4, password);
                insertQuery.setString(5, city);
            insertQuery.executeUpdate();
            System.out.println("nice");
            connection.close();
        } catch (SQLException e) {
            System.out.println("error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("success");
        return null;
    }



public Response loginVerication(String email, String password) {
        String idUser = "";
    Connection connection = null;
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(url, userDatabases, passwordDatabases);
        System.out.println("conexion");
        Statement statement = connection.createStatement();
        PreparedStatement resultSetInfo = connection.prepareStatement("SELECT id,emailUser,passwordUser FROM DatabasesJwt WHERE emailUser=? AND passwordUser=?" );
        resultSetInfo.setString(1, email);
        resultSetInfo.setString(2, password);
        ResultSet emailAndPassword = resultSetInfo.executeQuery();
        while (emailAndPassword.next()) {
            idUser = emailAndPassword.getString("id");
            System.out.println("id: " + emailAndPassword.getString("id"));
            System.out.println("email: " + emailAndPassword.getString("emailUser"));
            System.out.println("password: " + emailAndPassword.getString("passwordUser"));

        }
        System.out.println("idUser: " + idUser);
        connection.close();
        if (!idUser.isEmpty()) {
            return new Response(
                    "success",
                    200,
                    "OK"
            );
        } else {
            return new ResponseErorr(
                "failure",
                404,
                "Not Found",
                "email or password incorrect"
        );
        }
    } catch (SQLException e) {
        System.out.println("error: " + e.getMessage() );

    } catch (ClassNotFoundException e) {
        throw new RuntimeException(e);
    }
    System.out.println("success");
    return null;
    }
    //get id according to email
    public int getId(String email) {
        int idUser = 0;
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, userDatabases, passwordDatabases);
            Statement statement = connection.createStatement();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id FROM DatabasesJwt WHERE emailUser= ?");
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                idUser = resultSet.getInt("id");
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return idUser;
    }

    //get user email
    public String getUserEmail(String email) {
        String emailUser = "";
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, userDatabases, passwordDatabases);
            Statement statement = connection.createStatement();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT emailUser FROM DatabasesJwt WHERE emailUser= ?");
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                emailUser = resultSet.getString("emailUser");
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return emailUser;
    }

    //get user password
    public String getUserPassword(String password) {
        String PasswordUser = "";
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, userDatabases, passwordDatabases);
            Statement statement = connection.createStatement();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT passwordUser FROM DatabasesJwt WHERE passwordUser= ?");
            preparedStatement.setString(1, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                PasswordUser = resultSet.getString("passwordUser");
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return PasswordUser;
    }

    //get user name
    public String getUserName(String name) {
        String NameUser = "";
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, userDatabases, passwordDatabases);
            Statement statement = connection.createStatement();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT nameUser FROM DatabasesJwt WHERE nameUser= ?");
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                NameUser = resultSet.getString("nameUser");
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return NameUser;
    }
    //get all data from id
    public Response getUserData(int id) {
        String idUser = "";
        String emailUser = "";
        String nameUser = "";
        String passwordUser = "";
        String cityUser = "";
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, userDatabases, passwordDatabases);
            Statement statement = connection.createStatement();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM DatabasesJwt WHERE id= ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                idUser = resultSet.getString("id");
                emailUser = resultSet.getString("emailUser");
                nameUser = resultSet.getString("nameUser");
                passwordUser = resultSet.getString("passwordUser");
                cityUser = resultSet.getString("cityUser");
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return new  ResponseUsers(
                idUser,
                emailUser,
                nameUser,
                passwordUser,
                cityUser,
                "success",
                200,
                "OK"
        );
    }
    //delete user by id
    public Response deleteUser(int id) {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, userDatabases, passwordDatabases);
            Statement statement = connection.createStatement();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM DatabasesJwt WHERE id= ?");
            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            connection.close();
            if (rowsAffected > 0) {
                return new Response(
                        "success",
                        200,
                        "OK"
                );
            } else {
                return new ResponseErorr(
                        "failure",
                        404,
                        "Not Found",
                        "User not found"
                );
            }
        } catch (SQLException e) {
            System.out.println("error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}
