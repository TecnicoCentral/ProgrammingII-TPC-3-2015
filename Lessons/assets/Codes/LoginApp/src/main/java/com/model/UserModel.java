package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class UserModel {
    private static final String URL_DB = "jdbc:mysql://localhost:3306/LoginApp";
    private static final String USER = "root";
    private static final String PASSWORD = "$123456789";
    private Connection connection;

    public UserModel() {
        try {
            connection = DriverManager.getConnection(URL_DB, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int CreateTable(){
      try{
        String query = "CREATE TABLE IF NOT EXISTS Users ("+
                          "id INT AUTO_INCREMENT PRIMARY KEY,"+
                          "username VARCHAR(50) UNIQUE NOT NULL,"+
                          "password VARCHAR(50) NOT NULL,"+
                          "image VARCHAR(200) NULL"+
                       ");";;

        Statement stmt = connection.createStatement();
        int result = stmt.executeUpdate(query);
        return result;
      } catch (Exception e) {
            e.printStackTrace();
      }
      return -1;
    }

    public boolean validateUser(String username, String password) {
        try {
            String query = "SELECT * FROM Users WHERE username = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean registerUser(String username, String password, String image) {
        try {
            String query = "INSERT INTO Users (username, password, image) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, image);
            statement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}