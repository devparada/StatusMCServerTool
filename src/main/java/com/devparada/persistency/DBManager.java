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
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author devparada
 */
public class DBManager {

    private static Connection connection;

    public DBManager() {
        connect();
    }

    public static Connection connect() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:MCServers.db");
            System.out.println("Connect");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "An error occurred", JOptionPane.WARNING_MESSAGE);
        }
        return connection;
    }

    public boolean createTable() {
        Statement stmt = null;
        String sqlCreate = "CREATE TABLE MCServers("
                + "id integer PRIMARY KEY AUTOINCREMENT,"
                + "host varchar(255))";
        try {
            stmt = connection.createStatement();
            stmt.executeUpdate(sqlCreate);
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

    public ArrayList<Object[]> collectData() {
        ArrayList<Object[]> dataServers = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT host FROM McServers";
            stmt = connection.createStatement();
            rs = stmt.executeQuery(sql);

            ResultSetMetaData metaData = rs.getMetaData();
            int numServer = metaData.getColumnCount();

            while (rs.next()) {
                Object[] server = new Object[numServer];
                for (int i = 1; i <= numServer; i++) {
                    server[i - 1] = rs.getString(i);
                }
                dataServers.add(server);
            }
            return dataServers;
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
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e, "An error occurred", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        return null;
    }

    public void addRow(String hostIp) {
        PreparedStatement pstmt = null;
        try {
            String sql = "INSERT INTO MCServers (host) VALUES (?)";
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

    public boolean deleteRow(String hostIp) {
        System.out.println(hostIp);
        PreparedStatement pstmt = null;
        try {
            String sql = "DELETE FROM MCServers WHERE host LIKE ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, hostIp);
            pstmt.executeUpdate();
            return true;
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
        return false;
    }

    public boolean checkTable() {
        ResultSet rs = null;
        try {
            DatabaseMetaData dmd = connection.getMetaData();
            rs = dmd.getTables(null, null, "MCServers", new String[]{"TABLE"});
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "An error occurred", JOptionPane.WARNING_MESSAGE);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e, "An error occurred", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        return false;
    }
}
