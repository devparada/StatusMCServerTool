/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.devparada.persistency;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author devparada
 */
public class DBManager {

    public static Connection connection;
    private static final String SQL_CREATE = """
                  CREATE TABLE MCServers(
                  id INT primary key,
                  name varchar(255), host varchar(255), ip INT)""";

    public static Connection connect() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:MCServers.db");
            System.out.println("Connect");
        } catch (SQLException e) {
            // Remove
            e.printStackTrace();
        }
        return connection;
    }

    public static boolean createTable() {
        Statement stmt;
        try {
            connect();
            stmt = connection.createStatement();
            stmt.executeUpdate(SQL_CREATE);
            stmt.close();
            connection.close();
            return true;
        } catch (SQLException e) {
            // Remove
            e.printStackTrace();
        }
        return false;
    }

}
