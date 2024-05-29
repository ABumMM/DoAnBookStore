/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SachForm;

import doan.JDBCConnection;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author DO THI THANH AN
 */
public class SachForm extends javax.swing.JFrame {

    Connection conn;
    PreparedStatement ps;
    ResultSet rs; 
    
    public SachForm() {
        initComponents();
        KetNoiCSDL();
        Sach_Load();
    }

    public JPanel getJPN(){
        return jpnSach;
    }

    public void KetNoiCSDL(){ 
        try {
            conn = JDBCConnection.getJDBCConnection();
            if (conn != null) {
                System.out.print("Kết nối thành công");
            } else {
                System.out.print("Kết nối thất bại");
            }
        } catch (Exception ex) {
            Logger.getLogger(SachForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    public void Sach_Load() {
    try {
        ps = conn.prepareStatement("SELECT * FROM Sach");
        rs = ps.executeQuery();
        
        ResultSetMetaData rsd = rs.getMetaData();
        int c = rsd.getColumnCount();
      
        DefaultTableModel model = (DefaultTableModel) ListSach.getModel();
        model.setRowCount(0);
        
        while (rs.next()) {
            Vector v1 = new Vector();
            for(int i = 1; i <= c; i++) {
                v1.add(rs.getString("MaSach"));
                v1.add(rs.getString("TenSach"));
                v1.add(rs.getString("TenTG"));
                v1.add(rs.getDate("NamXB"));
                v1.add(rs.getInt("SLTon"));
                v1.add(rs.getInt("GiaBan"));
                v1.add(rs.getString("MaTL"));
                v1.add(rs.getString("HinhAnh"));
            }
            model.addRow(v1);
        }
        ListSach.setModel(model); // Đặt model sau khi đã thêm tất cả các dòng
    } catch (SQLException ex) {
        Logger.getLogger(SachForm.class.getName()).log(Level.SEVERE, null, ex);
    } 
    }
    
    public void LamMoi(){
        txtMaSach.setText("");
        txtTenSach.setText("");
        txtTenTG.setText("");
        jdNamXB.setDate(null);
        txtSLTon.setText("");
        txtGiaBan.setText("");
        txtMaTL.setText("");
        lbHinhAnh.setIcon(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnSach = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        panelBoderFrm1 = new PanelBoder.PanelBoderFrm();
        jLabel8 = new javax.swing.JLabel();
        txtMaTL = new javax.swing.JTextField();
        txtGiaBan = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtSLTon = new javax.swing.JTextField();
        jdNamXB = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTenTG = new javax.swing.JTextField();
        txtTenSach = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtMaSach = new javax.swing.JTextField();
        btnFind = new javax.swing.JButton();
        panelBoderFrm6 = new PanelBoder.PanelBoderFrm();
        jLabel10 = new javax.swing.JLabel();
        panelBoderFrm5 = new PanelBoder.PanelBoderFrm();
        btnThemSach = new javax.swing.JButton();
        btnXoaSach = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnClean = new javax.swing.JButton();
        panelBoderFrm3 = new PanelBoder.PanelBoderFrm();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListSach = new javax.swing.JTable();
        panelBoderFrm4 = new PanelBoder.PanelBoderFrm();
        lbHinhAnh = new javax.swing.JLabel();
        panelBoderFrm2 = new PanelBoder.PanelBoderFrm();
        btnThemAnh = new javax.swing.JButton();
        txtLinkAnh = new javax.swing.JTextField();
        panelBoderFrm7 = new PanelBoder.PanelBoderFrm();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1359, 800));

        jpnSach.setBackground(new java.awt.Color(0, 51, 102));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setBackground(new java.awt.Color(0, 51, 102));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 51, 102));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("QUẢN LÝ SÁCH");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(9, 9, 9))
        );

        panelBoderFrm1.setBackground(new java.awt.Color(253, 240, 205));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Mã thể loại");

        txtGiaBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaBanActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Giá bán");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Số lượng tồn");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Năm xuất bản");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Tên tác giả");

        txtTenTG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenTGActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Tên sách");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Mã sách");

        txtMaSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaSachActionPerformed(evt);
            }
        });

        btnFind.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/magnifier.png"))); // NOI18N
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        panelBoderFrm6.setBackground(new java.awt.Color(0, 51, 102));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(249, 240, 173));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("THÔNG TIN SÁCH");

        javax.swing.GroupLayout panelBoderFrm6Layout = new javax.swing.GroupLayout(panelBoderFrm6);
        panelBoderFrm6.setLayout(panelBoderFrm6Layout);
        panelBoderFrm6Layout.setHorizontalGroup(
            panelBoderFrm6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoderFrm6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBoderFrm6Layout.setVerticalGroup(
            panelBoderFrm6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBoderFrm6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelBoderFrm5.setBackground(new java.awt.Color(0, 51, 102));

        btnThemSach.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnThemSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/more.png"))); // NOI18N
        btnThemSach.setText("Thêm");
        btnThemSach.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThemSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSachActionPerformed(evt);
            }
        });

        btnXoaSach.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnXoaSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/delete.png"))); // NOI18N
        btnXoaSach.setText("Xóa");
        btnXoaSach.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXoaSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaSachActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/maintenance.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnClean.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/broom.png"))); // NOI18N
        btnClean.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCleanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBoderFrm5Layout = new javax.swing.GroupLayout(panelBoderFrm5);
        panelBoderFrm5.setLayout(panelBoderFrm5Layout);
        panelBoderFrm5Layout.setHorizontalGroup(
            panelBoderFrm5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoderFrm5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThemSach, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnClean, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBoderFrm5Layout.setVerticalGroup(
            panelBoderFrm5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoderFrm5Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(panelBoderFrm5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnClean, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelBoderFrm5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnThemSach, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnXoaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelBoderFrm1Layout = new javax.swing.GroupLayout(panelBoderFrm1);
        panelBoderFrm1.setLayout(panelBoderFrm1Layout);
        panelBoderFrm1Layout.setHorizontalGroup(
            panelBoderFrm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoderFrm1Layout.createSequentialGroup()
                .addGroup(panelBoderFrm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBoderFrm1Layout.createSequentialGroup()
                        .addGroup(panelBoderFrm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBoderFrm1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(panelBoderFrm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelBoderFrm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jdNamXB, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSLTon, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBoderFrm1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(panelBoderFrm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelBoderFrm1Layout.createSequentialGroup()
                                        .addGroup(panelBoderFrm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panelBoderFrm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(panelBoderFrm1Layout.createSequentialGroup()
                                                .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(panelBoderFrm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBoderFrm1Layout.createSequentialGroup()
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBoderFrm1Layout.createSequentialGroup()
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtMaTL, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBoderFrm1Layout.createSequentialGroup()
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtTenTG, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelBoderFrm1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelBoderFrm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelBoderFrm6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelBoderFrm5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        panelBoderFrm1Layout.setVerticalGroup(
            panelBoderFrm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoderFrm1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBoderFrm6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelBoderFrm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnFind, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(panelBoderFrm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(panelBoderFrm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenTG, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(panelBoderFrm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jdNamXB, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(panelBoderFrm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSLTon, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(panelBoderFrm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(panelBoderFrm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaTL, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(panelBoderFrm5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        panelBoderFrm3.setBackground(new java.awt.Color(253, 240, 205));

        ListSach.setBackground(new java.awt.Color(253, 240, 205));
        ListSach.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        ListSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã sách", "Tên sách", "Tên tác giả", "Năm xuất bản", "Số lượng tồn", "Giá bán", "Mã thể loại", "Hình ảnh"
            }
        ));
        ListSach.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ListSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListSachMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ListSach);
        if (ListSach.getColumnModel().getColumnCount() > 0) {
            ListSach.getColumnModel().getColumn(1).setResizable(false);
            ListSach.getColumnModel().getColumn(2).setResizable(false);
            ListSach.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout panelBoderFrm3Layout = new javax.swing.GroupLayout(panelBoderFrm3);
        panelBoderFrm3.setLayout(panelBoderFrm3Layout);
        panelBoderFrm3Layout.setHorizontalGroup(
            panelBoderFrm3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoderFrm3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 908, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBoderFrm3Layout.setVerticalGroup(
            panelBoderFrm3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBoderFrm3Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        panelBoderFrm4.setBackground(new java.awt.Color(253, 240, 205));
        panelBoderFrm4.setMaximumSize(new java.awt.Dimension(304, 14));

        lbHinhAnh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout panelBoderFrm4Layout = new javax.swing.GroupLayout(panelBoderFrm4);
        panelBoderFrm4.setLayout(panelBoderFrm4Layout);
        panelBoderFrm4Layout.setHorizontalGroup(
            panelBoderFrm4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoderFrm4Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(lbHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        panelBoderFrm4Layout.setVerticalGroup(
            panelBoderFrm4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoderFrm4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbHinhAnh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelBoderFrm2.setBackground(new java.awt.Color(253, 240, 205));

        btnThemAnh.setText("Thêm ảnh");
        btnThemAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemAnhActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBoderFrm2Layout = new javax.swing.GroupLayout(panelBoderFrm2);
        panelBoderFrm2.setLayout(panelBoderFrm2Layout);
        panelBoderFrm2Layout.setHorizontalGroup(
            panelBoderFrm2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoderFrm2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(btnThemAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLinkAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBoderFrm2Layout.setVerticalGroup(
            panelBoderFrm2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoderFrm2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(panelBoderFrm2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLinkAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelBoderFrm7Layout = new javax.swing.GroupLayout(panelBoderFrm7);
        panelBoderFrm7.setLayout(panelBoderFrm7Layout);
        panelBoderFrm7Layout.setHorizontalGroup(
            panelBoderFrm7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelBoderFrm7Layout.setVerticalGroup(
            panelBoderFrm7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpnSachLayout = new javax.swing.GroupLayout(jpnSach);
        jpnSach.setLayout(jpnSachLayout);
        jpnSachLayout.setHorizontalGroup(
            jpnSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnSachLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBoderFrm1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBoderFrm3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpnSachLayout.createSequentialGroup()
                        .addComponent(panelBoderFrm4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelBoderFrm2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelBoderFrm7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpnSachLayout.setVerticalGroup(
            jpnSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnSachLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnSachLayout.createSequentialGroup()
                        .addGroup(jpnSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelBoderFrm4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jpnSachLayout.createSequentialGroup()
                                .addComponent(panelBoderFrm2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelBoderFrm7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelBoderFrm3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelBoderFrm1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaSachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaSachActionPerformed

    private void txtTenTGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenTGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenTGActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        StringBuilder sb = new StringBuilder();
        if (txtMaSach.getText().equals("")){
            sb.append("Mã sách không được để trống!!!");
            txtMaSach.setBackground(Color.red);
        } else {
             txtMaSach.setBackground(Color.white);
        }
        if (sb.length() > 0){
            JOptionPane.showMessageDialog(this, sb);
            return;
        }
        try{  
          
        tacvusach tv = new tacvusach();
        ClassSach S = tv.find(txtMaSach.getText());
        
        if (S != null){
        // Xuất thông tin
        int selectedIndex = ListSach.getSelectedRow();
        
        txtMaSach.setText(S.getMaSach());
        txtTenSach.setText(S.getTenSach());
        txtTenTG.setText(S.getTenTG());
        jdNamXB.setDate(S.getNamXB());
        txtSLTon.setText(S.getSLTon());
        txtGiaBan.setText(S.getGiaBan());
        txtMaTL.setText(S.getMaTL());   
        
       } else 
       
        JOptionPane.showMessageDialog(this, "Sách tìm kiếm không tồn tại!");
      } catch (Exception e){
          JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
          e.printStackTrace();
      }
    }//GEN-LAST:event_btnFindActionPerformed

    private void btnThemSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSachActionPerformed
        StringBuilder sb = new StringBuilder();
        if (txtMaSach.getText().equals("")){
            sb.append("Mã sách không được để trống!!!");
            txtMaSach.setBackground(Color.red);
        } else {
             txtMaSach.setBackground(Color.white);
        }
        if (sb.length() > 0){
            JOptionPane.showMessageDialog(this, sb);
            return;
        }
        try{  
        ClassSach S = new ClassSach();
        S.setMaSach(txtMaSach.getText());
        S.setTenSach(txtTenSach.getText());
        S.setTenTG(txtTenTG.getText());
        
         if(jdNamXB.getDate() != null ){
            java.util.Date utilStartDate = jdNamXB.getDate();
            java.sql.Date sqlStartDate = new java.sql.Date(utilStartDate.getTime());
            S.setNamXB(sqlStartDate);
        }
        
        S.setSLTon(txtSLTon.getText());
        S.setGiaBan(txtGiaBan.getText());
        S.setMaTL(txtMaTL.getText());
        String filePath = txtLinkAnh.getText();
        // Lấy chỉ tên của tệp hình ảnh từ đường dẫn
        String fileName = Paths.get(filePath).getFileName().toString();
        // Lưu chỉ tên của tệp hình ảnh vào đối tượng ClassSach
        S.setHinhAnh(fileName);
        tacvusach dao = new tacvusach();
        dao.insert(S);    
        JOptionPane.showMessageDialog(this, "Sách được thêm vào thành công!");
        Sach_Load();
      } catch (Exception e){
          JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
      }   
    }//GEN-LAST:event_btnThemSachActionPerformed

    private void btnXoaSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaSachActionPerformed
        StringBuilder sb = new StringBuilder();
        if (txtMaSach.getText().equals("")){
            sb.append("Mã sách không được để trống!!!");
            txtMaSach.setBackground(Color.red);
        } else {
             txtMaSach.setBackground(Color.white);
        }
        if (sb.length() > 0){
            JOptionPane.showMessageDialog(this, sb);
            return;
        }
      try{  
        
        tacvusach dao = new tacvusach();
        int result = JOptionPane.showConfirmDialog(this,"Bạn chắc chắn muốn xóa sách này?","Xác nhận", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION){
            dao.delete(txtMaSach.getText());    
            JOptionPane.showMessageDialog(this, "Sách đã xóa thành công!");
            Sach_Load();
        } else {
            JOptionPane.showMessageDialog(this, "Sách viên chưa được xóa!");
        }
      } catch (Exception e){
          JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
          e.printStackTrace();
      }
    }//GEN-LAST:event_btnXoaSachActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        StringBuilder sb = new StringBuilder();
        if (txtMaSach.getText().equals("")){
            sb.append("Mã sách không được để trống!!!");
            txtMaSach.setBackground(Color.red);
        } else {
            txtMaSach.setBackground(Color.white);
        }
        if (sb.length() > 0){
            JOptionPane.showMessageDialog(this, sb);
            return;
        }     
        try{  
            tacvusach dao = new tacvusach();
            ClassSach S = new ClassSach();
            S.setMaSach(txtMaSach.getText());
            S.setTenSach(txtTenSach.getText());
            S.setTenTG(txtTenTG.getText()); 
            if(jdNamXB.getDate() != null ){
                java.util.Date utilStartDate = jdNamXB.getDate();
                java.sql.Date sqlStartDate = new java.sql.Date(utilStartDate.getTime());
                S.setNamXB(sqlStartDate);
            }
            S.setSLTon(txtSLTon.getText());
            S.setGiaBan(txtGiaBan.getText());
            S.setMaTL(txtMaTL.getText());
        // Lấy đường dẫn từ txtLinkAnh
            String filePath = txtLinkAnh.getText();
        // Lấy chỉ tên của tệp hình ảnh từ đường dẫn
            String fileName = Paths.get(filePath).getFileName().toString();
        // Lưu chỉ tên của tệp hình ảnh vào đối tượng ClassSach
            S.setHinhAnh(fileName);
            dao.update(S);  
            JOptionPane.showMessageDialog(this, "Sách được cập nhật vào thành công!");
            Sach_Load();
    } catch (Exception e){
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
    }   
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanActionPerformed
        LamMoi();
        try {
            ps = conn.prepareStatement("SELECT * FROM SACH ");
            rs = ps.executeQuery();
            
            ResultSetMetaData rsd = rs.getMetaData();
            int c = rsd.getColumnCount();
          
            DefaultTableModel model = (DefaultTableModel) ListSach.getModel();
            model.setRowCount(0);
            
            while (rs.next()){
                Vector v1 = new Vector();
                for(int i=1;i<=c;i++){
                    v1.add(rs.getString("MaSach"));
                    v1.add(rs.getString("TenSach"));
                    v1.add(rs.getString("TenTG"));
                    v1.add(rs.getDate("NamXB"));
                    v1.add(rs.getString("SLTon"));
                    v1.add(rs.getString("GiaBan"));
                    v1.add(rs.getString("MaTL"));
                    v1.add(rs.getString("HinhAnh"));
              }
                model.addRow(v1);
               ListSach.setModel(model);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SachForm.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_btnCleanActionPerformed

    private void ListSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListSachMouseClicked
        LamMoi();
        try{
            int selectedIndex = ListSach.getSelectedRow();
            ListSach.setColumnSelectionInterval(0,7);
            txtMaSach.setText(ListSach.getValueAt(selectedIndex, 0).toString());
            txtTenSach.setText(ListSach.getValueAt(selectedIndex, 1).toString());
            txtTenTG.setText(ListSach.getValueAt(selectedIndex, 2).toString());
            jdNamXB.setDate((Date) ListSach.getValueAt(selectedIndex, 3));
            txtSLTon.setText(ListSach.getValueAt(selectedIndex, 4).toString());
            txtGiaBan.setText(ListSach.getValueAt(selectedIndex, 5).toString());
            txtMaTL.setText(ListSach.getValueAt(selectedIndex, 6).toString());
            String hinhAnhName = ListSach.getValueAt(selectedIndex, 7).toString();
            String hinhAnhPath = "D:\\OneDrive\\Máy tính\\MHN3#2\\java\\AppBanSach\\DoAn\\Project DoAn\\DoAn\\src\\Images\\" + File.separator + hinhAnhName;
        
        // Thay đổi kích thước của hình ảnh
            ImageIcon resizedIcon = resizeImageIcon(hinhAnhPath, 237, 274);    
        // Gắn hình ảnh đã thay đổi kích thước vào label
            lbHinhAnh.setIcon(resizedIcon);
        }
        catch(Exception e){
            e.printStackTrace();
        }           
    }//GEN-LAST:event_ListSachMouseClicked
    private ImageIcon resizeImageIcon(String imagePath, int width, int height) {
    ImageIcon originalIcon = new ImageIcon(imagePath); // Lấy hình ảnh từ đường dẫn
    // Thay đổi kích thước của hình ảnh
        Image img = originalIcon.getImage();
        Image scaledImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    // Tạo ImageIcon mới từ hình ảnh đã thay đổi kích thước
    return new ImageIcon(scaledImg);
}
    private void txtGiaBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiaBanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaBanActionPerformed

    private void btnThemAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemAnhActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
    
        // Lấy đường dẫn của tệp đã chọn
        File file = chooser.getSelectedFile();
        String fileName = file.getAbsolutePath();
    
        // Hiển thị đường dẫn trong trường văn bản
        txtLinkAnh.setText(fileName);
        ImageIcon icon = new ImageIcon(fileName);
    
    // Lấy kích thước của JLabel
    int width = lbHinhAnh.getWidth();
    int height = lbHinhAnh.getHeight();
    
    // Thay đổi kích thước của ảnh để vừa với kích thước của JLabel
    Image image = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
    
    // Tạo ImageIcon mới từ ảnh đã thay đổi kích thước
    ImageIcon scaledIcon = new ImageIcon(image);
    
    // Đặt ImageIcon mới làm hình ảnh của JLabel
    lbHinhAnh.setIcon(scaledIcon);
    }//GEN-LAST:event_btnThemAnhActionPerformed

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
            java.util.logging.Logger.getLogger(SachForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SachForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SachForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SachForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SachForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ListSach;
    private javax.swing.JButton btnClean;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThemAnh;
    private javax.swing.JButton btnThemSach;
    private javax.swing.JButton btnXoaSach;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdNamXB;
    private javax.swing.JPanel jpnSach;
    private javax.swing.JLabel lbHinhAnh;
    private PanelBoder.PanelBoderFrm panelBoderFrm1;
    private PanelBoder.PanelBoderFrm panelBoderFrm2;
    private PanelBoder.PanelBoderFrm panelBoderFrm3;
    private PanelBoder.PanelBoderFrm panelBoderFrm4;
    private PanelBoder.PanelBoderFrm panelBoderFrm5;
    private PanelBoder.PanelBoderFrm panelBoderFrm6;
    private PanelBoder.PanelBoderFrm panelBoderFrm7;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtLinkAnh;
    private javax.swing.JTextField txtMaSach;
    private javax.swing.JTextField txtMaTL;
    private javax.swing.JTextField txtSLTon;
    private javax.swing.JTextField txtTenSach;
    private javax.swing.JTextField txtTenTG;
    // End of variables declaration//GEN-END:variables
}
