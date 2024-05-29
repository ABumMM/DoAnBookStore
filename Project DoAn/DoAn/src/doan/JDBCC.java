/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package doan;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author User
 */
public class JDBCC {
    public static Connection getJDBCConnection(){
        String url = "jdbc:mysql://localhost:3306/DULIEU?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "123456789";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            System.err.println("ClassNotFoundException: " + ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }
    
    public static void main(String[] args) {
        Connection connection = getJDBCConnection();
        if (connection != null) {
            System.out.println("Kết nối thành công!");
        } else {
            System.out.println("Kết nối thất bại!");
        }
    }
}
