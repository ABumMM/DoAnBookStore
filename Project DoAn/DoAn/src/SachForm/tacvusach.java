/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SachForm;

import java.sql.Connection;
import SachForm.ClassSach;
import java.sql.PreparedStatement;
import JDBC.*;
import java.sql.ResultSet;
import java.sql.Date;

public class tacvusach {
    public boolean insert(ClassSach S)  throws Exception {
        String SQL = "INSERT INTO Sach (MaSach, TenSach, TenTG, NamXB, SLTon, GiaBan, MaTL, HinhAnh) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    
        try (
            Connection conn = connect.getJDBCConnection();
            PreparedStatement ps = conn.prepareStatement(SQL);
            ) {
                ps.setString(1, S.getMaSach());
                ps.setString(2, S.getTenSach());
                ps.setString(3, S.getTenTG());
                ps.setDate(4, new java.sql.Date(S.getNamXB().getTime())); 
                ps.setString(5, S.getSLTon());
                ps.setString(6, S.getGiaBan());
                ps.setString(7, S.getMaTL());
                ps.setString(8, S.getHinhAnh());
                return ps.executeUpdate() > 0;
        }      
    }
    
    public ClassSach find(String MaSach) throws Exception {
        String SQL = "select * from Sach where MaSach =?";
        
        try(
        Connection conn = connect.getJDBCConnection();
        PreparedStatement ps = conn.prepareStatement(SQL);
        ){
       ps.setString(1, MaSach);
       ResultSet rs = ps.executeQuery();
       if(rs.next()){
           ClassSach S = new ClassSach();
            S.setMaSach(rs.getString("MaSach"));
            S.setTenSach(rs.getString("TenSach"));
            S.setTenTG(rs.getString("TenTG"));
            S.setNamXB(rs.getDate("NamXB"));
            S.setSLTon(rs.getString("SLTon"));
            S.setGiaBan(rs.getString("GiaBan"));
            S.setMaTL(rs.getString("MaTL"));
            
            return S;
       }
       
       return null;
        }
    }
      
    public boolean update(ClassSach S)  throws Exception {
        String SQL = "UPDATE Sach SET TenSach = ?, TenTG = ?, NamXB = ?, SLTon = ?, GiaBan = ?, MaTL = ?, HinhAnh = ? WHERE MaSach = ?";
    
    try (
        Connection conn = connect.getJDBCConnection();
        PreparedStatement ps = conn.prepareStatement(SQL);
    ) {
        ps.setString(1, S.getTenSach());
        ps.setString(2, S.getTenTG());
        ps.setDate(3, new java.sql.Date(S.getNamXB().getTime())); // Chuyển đổi từ java.util.Date sang java.sql.Date
        ps.setString(4, S.getSLTon());
        ps.setString(5, S.getGiaBan());
        ps.setString(6, S.getMaTL());
        ps.setString(7, S.getHinhAnh());
        ps.setString(8, S.getMaSach());
        return ps.executeUpdate() > 0;
    }
    }
    
    public boolean delete(String MaSach) throws Exception {
        String SQL = "delete from Sach where MaSach=?";
    try(   
        Connection conn = connect.getJDBCConnection();
        PreparedStatement ps = conn.prepareStatement(SQL);
        ){
       ps.setString(1, MaSach);
       return ps.executeUpdate() >0;
        }
    }
}
