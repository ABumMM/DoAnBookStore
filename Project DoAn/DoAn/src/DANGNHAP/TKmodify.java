/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DANGNHAP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import JDBC.connect; // Import JDBC connection class

public class TKmodify {
    public static TAIKHOAN Login(String tdn, String mk) throws Exception {
        String sql = "SELECT * FROM TAIKHOAN WHERE TenTK = ? AND MatKhauTK = ?";
        try (
            Connection connection = connect.getJDBCConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
        ) {
            ps.setString(1, tdn);
            ps.setString(2, mk);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    TAIKHOAN tk = new TAIKHOAN();
                    tk.setMaTK(rs.getString("MaTK"));
                    tk.setTenTK(rs.getString("TenTK"));
                    tk.setMatKhauTK(rs.getString("MatKhauTK"));
                    tk.setLoaiTK(rs.getString("LoaiTK"));
                    tk.setMaNV(rs.getString("MaNV"));
                    return tk;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static TAIKHOAN find(String MaTK) throws Exception {
        String SQL = "SELECT * FROM TAIKHOAN WHERE MaTK = ?";
        try (
            Connection conn = connect.getJDBCConnection();
            PreparedStatement ps = conn.prepareStatement(SQL);
        ) {
            ps.setString(1, MaTK);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    TAIKHOAN tk = new TAIKHOAN();
                    tk.setMaTK(rs.getString("MaTK"));
                    tk.setTenTK(rs.getString("TenTK"));
                    tk.setMatKhauTK(rs.getString("MatKhauTK"));
                    tk.setLoaiTK(rs.getString("LoaiTK"));
                    tk.setMaNV(rs.getString("MaNV"));
                    return tk;
                }
            }
        }
        return null;
    }

    public static boolean DeleteTK(String MaTK) throws Exception {
        try (
            Connection connection = connect.getJDBCConnection();
            PreparedStatement ps = connection.prepareStatement("DELETE FROM TAIKHOAN WHERE MaTK = ?");
        ) {
            ps.setString(1, MaTK);
            return ps.executeUpdate() > 0;
        }
    }

    public static boolean InsertTK(TAIKHOAN tk) throws Exception {
        try (
            Connection connection = connect.getJDBCConnection();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO TAIKHOAN(MaTK, TenTK, MatKhauTK, LoaiTK, MaNV) VALUES(?,?,?,?,?)");
        ) {
            ps.setString(1, tk.getMaTK());
            ps.setString(2, tk.getTenTK());
            ps.setString(3, tk.getMatKhauTK());
            ps.setString(4, tk.getLoaiTK());
            ps.setString(5, tk.getMaNV());
            return ps.executeUpdate() > 0;
        }
    }

    public static boolean UpdateTK(TAIKHOAN tk) throws Exception {
        try (
            Connection connection = connect.getJDBCConnection();
            PreparedStatement ps = connection.prepareStatement("UPDATE TAIKHOAN SET TenTK = ?, MatKhauTK = ?, LoaiTK = ?, MaNV = ? WHERE MaTK = ?");
        ) {
            ps.setString(1, tk.getTenTK());
            ps.setString(2, tk.getMatKhauTK());
            ps.setString(3, tk.getLoaiTK());
            ps.setString(4, tk.getMaNV());
            ps.setString(5, tk.getMaTK());
            return ps.executeUpdate() > 0;
        }
    }
}

