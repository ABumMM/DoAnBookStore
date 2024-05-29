/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doan;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JPanel;


public class QLKH extends javax.swing.JFrame {

    /**
     * Creates new form QLKH
     */
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    public QLKH() {
        initComponents();
        setLocationRelativeTo(null);
        KetNoiCSDL();
        Load_data_KH();
    }

    public JPanel getJPN() {
        return jpnKH; 
    }

    public void KetNoiCSDL() {
        try {
            conn = JDBCConnection.getJDBCConnection();
            if (conn != null) {
                System.out.println("Kết nối thành công");
            } else {
                System.out.println("Kết nối thất bại");
            }
        } catch (Exception ex) {
            Logger.getLogger(QLKH.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Load_data_KH() {
        try {
            ps = conn.prepareStatement("SELECT * FROM KhachHang");
            rs = ps.executeQuery();

            ResultSetMetaData rsd = rs.getMetaData();
            int c = rsd.getColumnCount();

            DefaultTableModel model = (DefaultTableModel) listKH.getModel();
            model.setRowCount(0);
            while (rs.next()) {
                Vector v1 = new Vector();
                for (int i = 1; i <= c; i++) {
                    v1.add(rs.getString("MaKH"));
                    v1.add(rs.getString("TenKH"));
                    v1.add(rs.getString("SDT"));
                    v1.add(rs.getString("Email"));
                    v1.add(rs.getString("GioiTinh"));
                    v1.add(rs.getString("DChi"));
                    v1.add(rs.getString("LoaiKH"));
                    v1.add(rs.getDate("NgSinh"));
                    v1.add(rs.getString("CMND"));
                }
                model.addRow(v1);
                listKH.setModel(model);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QLKH.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Load_data_KH(String MaKH) {
        try {
            ps = conn.prepareStatement("SELECT * FROM KhachHang WHERE MaKH = ?");
            ps.setString(1, MaKH);
            rs = ps.executeQuery();

            ResultSetMetaData rsd = rs.getMetaData();
            int c = rsd.getColumnCount();

            DefaultTableModel model = (DefaultTableModel) listKH.getModel();
            model.setRowCount(0);
            while (rs.next()) {
                Vector v1 = new Vector();
                for (int i = 1; i <= c; i++) {
                    v1.add(rs.getString("MaKH"));
                    v1.add(rs.getString("TenKH"));
                    v1.add(rs.getString("SDT"));
                    v1.add(rs.getString("Email"));
                    v1.add(rs.getString("GioiTinh"));
                    v1.add(rs.getString("DChi"));
                    v1.add(rs.getString("LoaiKH"));
                    v1.add(rs.getDate("NgSinh"));
                    v1.add(rs.getString("CMND"));
                }
                model.addRow(v1);
                listKH.setModel(model);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QLKH.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void LamMoi() {
        JTextMaKH.setText("");
        jTextTenKH.setText("");
        jTextSDT.setText("");
        jTextEmail.setText("");
        jRadioNam.setSelected(false);
        jRadioNu.setSelected(false);
        jTextDChi.setText("");
        jRadioVip.setSelected(false);
        jRadioNormal.setSelected(false);
        jTextCMND.setText("");
        jDate.setDate(null);
    }

    public void LamMoiTable() {
        try {
            ps = conn.prepareStatement("SELECT * FROM KhachHang");
            rs = ps.executeQuery();

            ResultSetMetaData rsd = rs.getMetaData();
            int c = rsd.getColumnCount();

            DefaultTableModel model = (DefaultTableModel) listKH.getModel();
            model.setRowCount(0);
            while (rs.next()) {
                Vector v1 = new Vector();
                for (int i = 1; i <= c; i++) {
                    v1.add(rs.getString("MaKH"));
                    v1.add(rs.getString("TenKH"));
                    v1.add(rs.getString("SDT"));
                    v1.add(rs.getString("Email"));
                    v1.add(rs.getString("GioiTinh"));
                    v1.add(rs.getString("DChi"));
                    v1.add(rs.getString("LoaiKH"));
                    v1.add(rs.getDate("NgSinh"));
                    v1.add(rs.getString("CMND"));
                }
                model.addRow(v1);
                listKH.setModel(model);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QLKH.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnKH = new javax.swing.JPanel();
        panelBoderFrm1 = new PanelBoder.PanelBoderFrm();
        panelBoderFrm2 = new PanelBoder.PanelBoderFrm();
        jLabel1 = new javax.swing.JLabel();
        panelBoderFrm3 = new PanelBoder.PanelBoderFrm();
        jLabel11 = new javax.swing.JLabel();
        panelBoderFrm4 = new PanelBoder.PanelBoderFrm();
        jLabel12 = new javax.swing.JLabel();
        panelBoderFrm6 = new PanelBoder.PanelBoderFrm();
        panelBoderFrm5 = new PanelBoder.PanelBoderFrm();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextTenKH = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextSDT = new javax.swing.JTextField();
        JTextMaKH = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextEmail = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jRadioNam = new javax.swing.JRadioButton();
        jRadioNu = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jTextDChi = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jRadioVip = new javax.swing.JRadioButton();
        jRadioNormal = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        jTextCMND = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jDate = new com.toedter.calendar.JDateChooser();
        panelBoderFrm7 = new PanelBoder.PanelBoderFrm();
        JButtonTim = new javax.swing.JButton();
        jButtonThem = new javax.swing.JButton();
        jButtonCapNhat = new javax.swing.JButton();
        jButtonXoa = new javax.swing.JButton();
        jButtonReset = new javax.swing.JButton();
        panelBoderFrm8 = new PanelBoder.PanelBoderFrm();
        jScrollPane1 = new javax.swing.JScrollPane();
        listKH = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelBoderFrm1.setBackground(new java.awt.Color(0, 51, 102));

        panelBoderFrm2.setBackground(new java.awt.Color(253, 240, 205));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ THÔNG TIN KHÁCH HÀNG");
        jLabel1.setToolTipText("");

        javax.swing.GroupLayout panelBoderFrm2Layout = new javax.swing.GroupLayout(panelBoderFrm2);
        panelBoderFrm2.setLayout(panelBoderFrm2Layout);
        panelBoderFrm2Layout.setHorizontalGroup(
            panelBoderFrm2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBoderFrm2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBoderFrm2Layout.setVerticalGroup(
            panelBoderFrm2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoderFrm2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelBoderFrm3.setBackground(new java.awt.Color(253, 240, 205));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("THÔNG TIN KHÁCH HÀNG");

        javax.swing.GroupLayout panelBoderFrm3Layout = new javax.swing.GroupLayout(panelBoderFrm3);
        panelBoderFrm3.setLayout(panelBoderFrm3Layout);
        panelBoderFrm3Layout.setHorizontalGroup(
            panelBoderFrm3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBoderFrm3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBoderFrm3Layout.setVerticalGroup(
            panelBoderFrm3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBoderFrm3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelBoderFrm4.setBackground(new java.awt.Color(253, 240, 205));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("DANH SÁCH KHÁCH HÀNG");

        javax.swing.GroupLayout panelBoderFrm4Layout = new javax.swing.GroupLayout(panelBoderFrm4);
        panelBoderFrm4.setLayout(panelBoderFrm4Layout);
        panelBoderFrm4Layout.setHorizontalGroup(
            panelBoderFrm4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBoderFrm4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBoderFrm4Layout.setVerticalGroup(
            panelBoderFrm4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoderFrm4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelBoderFrm6.setBackground(new java.awt.Color(253, 240, 205));

        panelBoderFrm5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel2.setText("Mã khách hàng:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel3.setText("Tên khách hàng:");

        jTextTenKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextTenKHActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel4.setText("Số điện thoại:");

        JTextMaKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTextMaKHActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel5.setText("Email:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel10.setText("Giới Tính:");

        jRadioNam.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jRadioNam.setText("Nam");

        jRadioNu.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jRadioNu.setText("Nữ");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel6.setText("Địa chỉ:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel7.setText("Loại khách hàng:");

        jRadioVip.setText("Thân Thiết");

        jRadioNormal.setText("Thường");
        jRadioNormal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioNormalActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel8.setText("CMND:");

        jTextCMND.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextCMNDActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel9.setText("Ngày sinh:");

        javax.swing.GroupLayout panelBoderFrm5Layout = new javax.swing.GroupLayout(panelBoderFrm5);
        panelBoderFrm5.setLayout(panelBoderFrm5Layout);
        panelBoderFrm5Layout.setHorizontalGroup(
            panelBoderFrm5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoderFrm5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelBoderFrm5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBoderFrm5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelBoderFrm5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4))
                        .addComponent(jLabel5)
                        .addComponent(jLabel10)
                        .addComponent(jLabel6))
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBoderFrm5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelBoderFrm5Layout.createSequentialGroup()
                        .addComponent(jRadioNam)
                        .addGap(42, 42, 42)
                        .addComponent(jRadioNu, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JTextMaKH)
                    .addComponent(jTextTenKH)
                    .addComponent(jTextSDT)
                    .addComponent(jTextEmail)
                    .addComponent(jTextDChi)
                    .addGroup(panelBoderFrm5Layout.createSequentialGroup()
                        .addComponent(jRadioVip, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioNormal))
                    .addComponent(jTextCMND)
                    .addComponent(jDate, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        panelBoderFrm5Layout.setVerticalGroup(
            panelBoderFrm5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoderFrm5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelBoderFrm5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTextMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelBoderFrm5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelBoderFrm5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelBoderFrm5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelBoderFrm5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioNam)
                    .addComponent(jRadioNu))
                .addGap(18, 18, 18)
                .addGroup(panelBoderFrm5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextDChi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelBoderFrm5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioVip)
                    .addComponent(jRadioNormal))
                .addGap(18, 18, 18)
                .addGroup(panelBoderFrm5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextCMND, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelBoderFrm5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        panelBoderFrm7.setBackground(new java.awt.Color(255, 255, 255));

        JButtonTim.setBackground(new java.awt.Color(253, 240, 205));
        JButtonTim.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        JButtonTim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/find.png"))); // NOI18N
        JButtonTim.setText("Tìm");
        JButtonTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonTimActionPerformed(evt);
            }
        });

        jButtonThem.setBackground(new java.awt.Color(253, 240, 205));
        jButtonThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Add-icon.png"))); // NOI18N
        jButtonThem.setText("Thêm");
        jButtonThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonThemActionPerformed(evt);
            }
        });

        jButtonCapNhat.setBackground(new java.awt.Color(253, 240, 205));
        jButtonCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/edit.png"))); // NOI18N
        jButtonCapNhat.setText("Cập nhập");
        jButtonCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCapNhatActionPerformed(evt);
            }
        });

        jButtonXoa.setBackground(new java.awt.Color(253, 240, 205));
        jButtonXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Trash-can-icon.png"))); // NOI18N
        jButtonXoa.setText("Xóa");
        jButtonXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonXoaActionPerformed(evt);
            }
        });

        jButtonReset.setBackground(new java.awt.Color(253, 240, 205));
        jButtonReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/arrow-circle-right-icon.png"))); // NOI18N
        jButtonReset.setText("Reset");
        jButtonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBoderFrm7Layout = new javax.swing.GroupLayout(panelBoderFrm7);
        panelBoderFrm7.setLayout(panelBoderFrm7Layout);
        panelBoderFrm7Layout.setHorizontalGroup(
            panelBoderFrm7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoderFrm7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBoderFrm7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBoderFrm7Layout.createSequentialGroup()
                        .addComponent(JButtonTim, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2))
                    .addComponent(jButtonThem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCapNhat, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonXoa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonReset, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBoderFrm7Layout.setVerticalGroup(
            panelBoderFrm7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoderFrm7Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(JButtonTim, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonThem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelBoderFrm6Layout = new javax.swing.GroupLayout(panelBoderFrm6);
        panelBoderFrm6.setLayout(panelBoderFrm6Layout);
        panelBoderFrm6Layout.setHorizontalGroup(
            panelBoderFrm6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoderFrm6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBoderFrm5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBoderFrm7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBoderFrm6Layout.setVerticalGroup(
            panelBoderFrm6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoderFrm6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBoderFrm6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelBoderFrm5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelBoderFrm7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelBoderFrm8.setBackground(new java.awt.Color(253, 240, 205));

        listKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã khách hàng", "Tên", "Số điện thoại", "Email", "Giới tính", "Địa chỉ", "Loại khách hàng", "Ngày sinh", "CMND"
            }
        ));
        listKH.setInheritsPopupMenu(true);
        listKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listKHMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                listKHMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(listKH);

        javax.swing.GroupLayout panelBoderFrm8Layout = new javax.swing.GroupLayout(panelBoderFrm8);
        panelBoderFrm8.setLayout(panelBoderFrm8Layout);
        panelBoderFrm8Layout.setHorizontalGroup(
            panelBoderFrm8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoderFrm8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBoderFrm8Layout.setVerticalGroup(
            panelBoderFrm8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoderFrm8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelBoderFrm1Layout = new javax.swing.GroupLayout(panelBoderFrm1);
        panelBoderFrm1.setLayout(panelBoderFrm1Layout);
        panelBoderFrm1Layout.setHorizontalGroup(
            panelBoderFrm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoderFrm1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBoderFrm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBoderFrm2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelBoderFrm1Layout.createSequentialGroup()
                        .addGroup(panelBoderFrm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(panelBoderFrm3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelBoderFrm6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBoderFrm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelBoderFrm8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelBoderFrm4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        panelBoderFrm1Layout.setVerticalGroup(
            panelBoderFrm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoderFrm1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBoderFrm2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBoderFrm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelBoderFrm3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelBoderFrm4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBoderFrm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelBoderFrm6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelBoderFrm8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(94, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpnKHLayout = new javax.swing.GroupLayout(jpnKH);
        jpnKH.setLayout(jpnKHLayout);
        jpnKHLayout.setHorizontalGroup(
            jpnKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBoderFrm1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpnKHLayout.setVerticalGroup(
            jpnKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBoderFrm1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpnKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jpnKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JTextMaKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTextMaKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTextMaKHActionPerformed

    private void JButtonTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonTimActionPerformed
        // TODO add your handling code here:
      StringBuilder sb = new StringBuilder();
        if (JTextMaKH.getText().equals("")){
            sb.append("Mã khách hàng không được để trống!!!");
           JTextMaKH.setBackground(Color.red);
        } else {
             JTextMaKH.setBackground(Color.white);
        }
        if (sb.length() > 0){
           JOptionPane.showMessageDialog(this, sb);
           return;
        }
        try{
            KhachHang kh = khmodify.find(JTextMaKH.getText());
        
        if (kh != null){
        // Xuất thông tin
            int selectedIndex = listKH.getSelectedRow();

            JTextMaKH.setText(kh.getMaKH());
            jTextTenKH.setText(kh.getTenKH());
            jTextSDT.setText(kh.getSDT());
            jTextEmail.setText(kh.getEmail());
            if(kh.getGioiTinh().equals("Nam")){
                jRadioNam.setSelected(true);
                jRadioNu.setSelected(false);
            }
            else if(kh.getGioiTinh().equals("Nu") || kh.getGioiTinh().equals("Nữ")){
                jRadioNam.setSelected(false);
                jRadioNu.setSelected(true);
            }
            else{
                jRadioNam.setSelected(false);
                jRadioNu.setSelected(false);
            }
            jTextDChi.setText(kh.getDchi());
            jDate.setDate(kh.getNgSinh());
            jTextCMND.setText(kh.getCMND());
            if(kh.getLoaiKH().equals("Than thiet") ||kh.getLoaiKH().equals("Thân thiết") || kh.getLoaiKH().equals("Thân Thiết") ){
                jRadioVip.setSelected(true);
                jRadioNormal.setSelected(false);
            }
            else if(kh.getLoaiKH().equals("Thuong") || kh.getLoaiKH().equals("Thường")){
                jRadioVip.setSelected(false);
                jRadioNormal.setSelected(true);
            }
            else{
                jRadioVip.setSelected(false);
                jRadioNormal.setSelected(false);
            }
            Load_data_KH(kh.getMaKH());
        } 
        else JOptionPane.showMessageDialog(this, "Khách hàng tìm kiếm không tồn tại!");
        } catch (Exception e){
         JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
         e.printStackTrace();
      }
    }//GEN-LAST:event_JButtonTimActionPerformed

    private void jTextTenKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextTenKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextTenKHActionPerformed

    private void jRadioNormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioNormalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioNormalActionPerformed

    private void listKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listKHMouseClicked
        // TODO add your handling code here:
        LamMoi();
        int selectedIndex = listKH.getSelectedRow();
        listKH.setColumnSelectionInterval(0,8);
        JTextMaKH.setText(listKH.getValueAt(selectedIndex, 0).toString());
        jTextTenKH.setText(listKH.getValueAt(selectedIndex, 1).toString());
        jTextSDT.setText(listKH.getValueAt(selectedIndex, 2).toString());
        jTextEmail.setText(listKH.getValueAt(selectedIndex, 3).toString());
        if(listKH.getValueAt(selectedIndex, 4).equals("Nam"))
            jRadioNam.setSelected(true);
        if(listKH.getValueAt(selectedIndex, 4).equals("Nu") || listKH.getValueAt(selectedIndex, 4).equals("Nữ"))
            jRadioNu.setSelected(true);
        jTextDChi.setText(listKH.getValueAt(selectedIndex, 5).toString());
        if(listKH.getValueAt(selectedIndex, 6).equals("Than thiet") || listKH.getValueAt(selectedIndex, 6).equals("Thân thiết") || listKH.getValueAt(selectedIndex, 6).equals("Thân Thiết"))
            jRadioVip.setSelected(true);
        if(listKH.getValueAt(selectedIndex, 6).equals("Thuong") || listKH.getValueAt(selectedIndex, 6).equals("Thường"))
            jRadioNormal.setSelected(true);
        jTextCMND.setText(listKH.getValueAt(selectedIndex, 8).toString());
        jDate.setDate((java.util.Date) listKH.getValueAt(selectedIndex, 7));
    }//GEN-LAST:event_listKHMouseClicked

    private void listKHMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listKHMouseReleased
//        LamMoi();
//        if(evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_DOWN){
//            int selectedIndex = listKH.getSelectedRow();
//            listKH.setColumnSelectionInterval(0,7);
//            listKH.setColumnSelectionInterval(0,7);
//            JTextMaKH.setText(listKH.getValueAt(selectedIndex, 0).toString());
//            jTextTenKH.setText(listKH.getValueAt(selectedIndex, 1).toString());
//            jTextSDT.setText(listKH.getValueAt(selectedIndex, 2).toString());
//            jTextEmail.setText(listKH.getValueAt(selectedIndex, 3).toString());
//            jTextDChi.setText(listKH.getValueAt(selectedIndex, 4).toString());
//            if(listKH.getValueAt(selectedIndex, 5).equals("Vip") || listKH.getValueAt(selectedIndex, 5).equals("VIP"));
//                jRadioVip.setSelected(true);
//            if(listKH.getValueAt(selectedIndex, 5).equals("Normal") || listKH.getValueAt(selectedIndex, 5).equals("NORMAL"));
//                jRadioNormal.setSelected(true);
//            jTextCMND.setText(listKH.getValueAt(selectedIndex, 7).toString());
//            jDate.setDate((java.util.Date) listKH.getValueAt(selectedIndex, 6));
//            Date date = null;
//            try {
//                date = new SimpleDateFormat("yyyy-MM-dd").parse((String)listKH.getValueAt(selectedIndex, 6));
//            } catch (ParseException ex) {
//                Logger.getLogger(QLKH.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            jDate.setDate(date);  
//       }
    }//GEN-LAST:event_listKHMouseReleased

    private void jButtonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResetActionPerformed
        // TODO add your handling code here:
        LamMoi();
        LamMoiTable();
    }//GEN-LAST:event_jButtonResetActionPerformed

    private void jButtonCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCapNhatActionPerformed
        StringBuilder sb = new StringBuilder();
        if(JTextMaKH.getText().equals("")){
            sb.append("!!Mã khách hàng không được để trống!!");
            JTextMaKH.setBackground(Color.red);
        }
        else{
            JTextMaKH.setBackground(Color.white);
        }
        if(sb.length() > 0){
            JOptionPane.showMessageDialog(this, sb);
            return;
        }
        try{
            KhachHang kh = new KhachHang();
            kh.setMaKH(JTextMaKH.getText());
            kh.setTenKH(jTextTenKH.getText());
            kh.setSDT(jTextSDT.getText());
            kh.setEmail(jTextEmail.getText());
            if(jRadioNam.isSelected()){
                kh.setGioiTinh(jRadioNam.getText());
            }
            if(jRadioNu.isSelected()){
                kh.setGioiTinh(jRadioNu.getText());
            }
            kh.setDchi(jTextDChi.getText());
            if(jRadioVip.isSelected()){
                kh.setLoaiKH(jRadioVip.getText());
            }
            if(jRadioNormal.isSelected()){
                kh.setLoaiKH(jRadioNormal.getText());
            }
            if(jDate.getDate() != null){
                java.util.Date birthday = jDate.getDate();
                java.sql.Date sqlbd = new java.sql.Date(birthday.getTime());
                kh.setNgSinh(sqlbd);
            }
            kh.setCMND(jTextCMND.getText());
            int result = JOptionPane.showConfirmDialog(null,"Bạn có muốn xóa khách hàng?", "Xóa", JOptionPane.YES_NO_OPTION);
            if(result == JOptionPane.YES_OPTION){
            khmodify.UpdateKH(kh);
            JOptionPane.showMessageDialog(this, "Đã cập nhật thành công");
            }
            else JOptionPane.showMessageDialog(this, "Chưa cập nhật");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this,"Error : "+ e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButtonCapNhatActionPerformed

    private void jButtonXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonXoaActionPerformed
        StringBuilder sb = new StringBuilder();
        if(JTextMaKH.getText().equals("")){
            sb.append("!!Mã khách hàng không được để trống!!");
            JTextMaKH.setBackground(Color.red);
        }
        else{
            JTextMaKH.setBackground(Color.white);
        }
        if(sb.length() > 0){
            JOptionPane.showMessageDialog(this, sb);
            return;
        }
        try{
            int result = JOptionPane.showConfirmDialog(null,"Bạn có muốn xóa khách hàng?", "Xóa", JOptionPane.YES_NO_OPTION);
            if(result == JOptionPane.YES_OPTION){
                khmodify.DeleteKH(JTextMaKH.getText());
                JOptionPane.showMessageDialog(this,"Đã xóa khách hàng thành công");
            }
            else{
                JOptionPane.showMessageDialog(this,"khách hàng chưa được xóa");
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this,"Error : "+e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButtonXoaActionPerformed

    private void jButtonThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonThemActionPerformed
        StringBuilder sb = new StringBuilder();
        if(JTextMaKH.getText().equals("")){
            sb.append("!!Mã khách hàng không được để trống!!");
            JTextMaKH.setBackground(Color.red);
        }
        else{
            JTextMaKH.setBackground(Color.white);
        }
        if(sb.length() > 0){
            JOptionPane.showMessageDialog(this, sb);
            return;
        }
        try{
            KhachHang kh = new KhachHang();
            kh.setMaKH(JTextMaKH.getText());
            kh.setTenKH(jTextTenKH.getText());
            kh.setSDT(jTextSDT.getText());
            kh.setEmail(jTextEmail.getText());
            if(jRadioNam.isSelected()){
                kh.setGioiTinh(jRadioNam.getText());
            }
            if(jRadioNu.isSelected()){
                kh.setGioiTinh(jRadioNu.getText());
            }
            kh.setDchi(jTextDChi.getText());
            if(jRadioVip.isSelected()){
                kh.setLoaiKH(jRadioVip.getText());
            }
            if(jRadioNormal.isSelected()){
                kh.setLoaiKH(jRadioNormal.getText());
            }
            if(jDate.getDate() != null){
                java.util.Date birthday = jDate.getDate();
                java.sql.Date sqlbd = new java.sql.Date(birthday.getTime());
                kh.setNgSinh(sqlbd);
            }
            kh.setCMND(jTextCMND.getText());
            khmodify.InsertKH(kh);
            JOptionPane.showMessageDialog(this, "Đã thêm thành công.");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this,"Error : "+e.getMessage());
        }
    }//GEN-LAST:event_jButtonThemActionPerformed

    private void jTextCMNDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextCMNDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextCMNDActionPerformed
   
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QLKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLKH().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JButtonTim;
    private javax.swing.JTextField JTextMaKH;
    private javax.swing.JButton jButtonCapNhat;
    private javax.swing.JButton jButtonReset;
    private javax.swing.JButton jButtonThem;
    private javax.swing.JButton jButtonXoa;
    private com.toedter.calendar.JDateChooser jDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jRadioNam;
    private javax.swing.JRadioButton jRadioNormal;
    private javax.swing.JRadioButton jRadioNu;
    private javax.swing.JRadioButton jRadioVip;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextCMND;
    private javax.swing.JTextField jTextDChi;
    private javax.swing.JTextField jTextEmail;
    private javax.swing.JTextField jTextSDT;
    private javax.swing.JTextField jTextTenKH;
    private javax.swing.JPanel jpnKH;
    private javax.swing.JTable listKH;
    private PanelBoder.PanelBoderFrm panelBoderFrm1;
    private PanelBoder.PanelBoderFrm panelBoderFrm2;
    private PanelBoder.PanelBoderFrm panelBoderFrm3;
    private PanelBoder.PanelBoderFrm panelBoderFrm4;
    private PanelBoder.PanelBoderFrm panelBoderFrm5;
    private PanelBoder.PanelBoderFrm panelBoderFrm6;
    private PanelBoder.PanelBoderFrm panelBoderFrm7;
    private PanelBoder.PanelBoderFrm panelBoderFrm8;
    // End of variables declaration//GEN-END:variables
}
