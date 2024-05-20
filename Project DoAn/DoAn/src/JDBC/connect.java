/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class connect {
    public static Connection getJDBCConnection(){
        final String url ="jdbc:mysql://localhost:3306/DULIEU";
        final String user = "root";
        final String password ="16092003";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                return DriverManager.getConnection(url, user, password);
            } catch (SQLException ex) {
                Logger.getLogger(connect.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
