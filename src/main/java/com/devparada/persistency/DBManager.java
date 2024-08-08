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
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author devparada
 */
public class DBManager {

    private static Connection connection;
    private static final String SQL_CREATE = """
                  CREATE TABLE MCServers(
                  id integer PRIMARY KEY AUTOINCREMENT,
                  host varchar(255))""";

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
        Statement stmt = null;
        try {
            connect();
            stmt = connection.createStatement();
            stmt.executeUpdate(SQL_CREATE);
            stmt.close();
            connection.close();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "An error occurred", JOptionPane.WARNING_MESSAGE);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e, "An error occurred", JOptionPane.WARNING_MESSAGE);
            }
        }
        return false;
    }

    public void addRow(String hostIp) {
        PreparedStatement pstmt = null;
        try {
            String sql = "INSERT INTO MCServers (host) VALUES (?)";
            connect();
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, hostIp);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "An error occurred", JOptionPane.WARNING_MESSAGE);
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e, "An error occurred", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}
