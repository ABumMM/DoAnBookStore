/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doan;

/**
 *
 * @author hoang
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection { 
    public static Connection getJDBCConnection(){
        String url = "jdbc:mysql://localhost:3306/DULIEU?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "16092003";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                return DriverManager.getConnection(url, user, password);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
