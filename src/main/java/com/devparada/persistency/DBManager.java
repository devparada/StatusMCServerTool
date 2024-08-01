/*
 * This file is part of StatusMCServerTool.
 *
 * StatusMCServerTool is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * StatusMCServerTool is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with StatusMCServerTool. If not, see <https://www.gnu.org/licenses/>.
 */
package com.devparada.persistency;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

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
            JOptionPane.showMessageDialog(null, e, "An error occurred", JOptionPane.WARNING_MESSAGE);
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
            JOptionPane.showMessageDialog(null, e, "An error occurred", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }
}
