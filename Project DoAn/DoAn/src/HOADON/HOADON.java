
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HOADON;
import static BaoCaoForm.BCForm.disableAccessWarnings;
import ChonKH.KHForm;
import ChonKM.KMFrame;
import DANGNHAP.TAIKHOAN;
import JDBC.connect;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import doan.JDBCConnection;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
import java.util.HashMap;
import java.util.Map;
import javax.swing.JPanel;
import java.util.List;
import HOADON.chitiet;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class HOADON extends javax.swing.JFrame {

    /**
     * Creates new form HOADON
     */
    TAIKHOAN tk;
    KHForm khk;
    public JPanel getJPN(){
        return jpnHD;
    }
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    public HOADON() {
        initComponents();
        setLocationRelativeTo(null);
        KetNoiCSDL();
        Load_data_HD();
    }

    public void NhanDLVe(String MaNV){
        jMaKH.setText(MaNV);
    }
    public void NhanDLVeMaKM(String MaKM){
        jMaKM.setText(MaKM);
    }
    public HOADON(TAIKHOAN in_tk) {
        initComponents();
        KetNoiCSDL();
        Load_data_HD();
        tk = in_tk;
    }

    public void KetNoiCSDL() {
        try {
            // Sử dụng lớp connect để lấy kết nối
            conn = connect.getJDBCConnection();
            if (conn != null) {
                System.out.println("Kết nối thành công");
            } else {
                System.out.println("Kết nối thất bại");
            }
        } catch (Exception ex) {
            Logger.getLogger(HOADON.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Load_data_HD() {
        try {
            ps = conn.prepareStatement("SELECT * FROM HD ");
            rs = ps.executeQuery();

            ResultSetMetaData rsd = rs.getMetaData();
            int c = rsd.getColumnCount();

            DefaultTableModel model = (DefaultTableModel) listHD.getModel();
            model.setRowCount(0);
            while (rs.next()) {
                Vector v1 = new Vector();
                for (int i = 1; i <= c; i++) {
                    v1.add(rs.getString("MaHD"));
                    v1.add(rs.getDate("NgayMuaSach"));
                    v1.add(rs.getString("TongTienHD"));
                    v1.add(rs.getString("MaNV"));
                    v1.add(rs.getString("MaKH"));
                    v1.add(rs.getString("MaKM"));
                }
                model.addRow(v1);
                listHD.setModel(model);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HOADON.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Load_data_HD(String MaHD) {
        try {
            ps = conn.prepareStatement("SELECT * FROM HD WHERE MaHD = ?");
            ps.setString(1, MaHD);
            rs = ps.executeQuery();

            ResultSetMetaData rsd = rs.getMetaData();
            int c = rsd.getColumnCount();

            DefaultTableModel model = (DefaultTableModel) listHD.getModel();
            model.setRowCount(0);
            while (rs.next()) {
                Vector v1 = new Vector();
                for (int i = 1; i <= c; i++) {
                    v1.add(rs.getString("MaHD"));
                    v1.add(rs.getDate("NgayMuaSach"));
                    v1.add(rs.getString("TongTienHD"));
                    v1.add(rs.getString("MaNV"));
                    v1.add(rs.getString("MaKH"));
                    v1.add(rs.getString("MaKM"));
                }
                model.addRow(v1);
                listHD.setModel(model);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HOADON.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void LamMoi() {
        jMaHD.setText("");
        jNgayMua.setDate(null);
        jMaNV.setText("");
        jMaKH.setText("");
        jMaKM.setText("");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnHD = new PanelBoder.PanelBoderFrm();
        panelBoderFrm2 = new PanelBoder.PanelBoderFrm();
        panelBoderFrm1 = new PanelBoder.PanelBoderFrm();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        InHD = new javax.swing.JButton();
        panelBoderFrm7 = new PanelBoder.PanelBoderFrm();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jNgayMua = new com.toedter.calendar.JDateChooser();
        jMaHD = new javax.swing.JTextField();
        jMaNV = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jChonKH = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButtonChonMaNV = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButtonChonKM = new javax.swing.JButton();
        jMaKH = new javax.swing.JTextField();
        jMaKM = new javax.swing.JTextField();
        panelBoderFrm8 = new PanelBoder.PanelBoderFrm();
        jButtonThem = new javax.swing.JButton();
        jButtonXoa = new javax.swing.JButton();
        jButtonCN = new javax.swing.JButton();
        jButtonReset = new javax.swing.JButton();
        panelBoderFrm3 = new PanelBoder.PanelBoderFrm();
        jScrollPane1 = new javax.swing.JScrollPane();
        listHD = new javax.swing.JTable();
        panelBoderFrm5 = new PanelBoder.PanelBoderFrm();
        jLabel7 = new javax.swing.JLabel();
        panelBoderFrm4 = new PanelBoder.PanelBoderFrm();
        jLabel8 = new javax.swing.JLabel();
        panelBoderFrm6 = new PanelBoder.PanelBoderFrm();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpnHD.setBackground(new java.awt.Color(0, 51, 102));
        jpnHD.setPreferredSize(new java.awt.Dimension(1108, 478));

        panelBoderFrm2.setBackground(new java.awt.Color(253, 240, 205));

        panelBoderFrm1.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setBackground(new java.awt.Color(253, 240, 205));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/find.png"))); // NOI18N
        jButton1.setText("Tìm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(253, 240, 205));
        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/eye.png"))); // NOI18N
        jButton2.setText("Xem chi tiết");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(253, 240, 205));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/invoice.png"))); // NOI18N
        jButton3.setText("Tính tổng tiền");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        InHD.setBackground(new java.awt.Color(253, 240, 205));
        InHD.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        InHD.setText("In hóa đơn");
        InHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InHDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBoderFrm1Layout = new javax.swing.GroupLayout(panelBoderFrm1);
        panelBoderFrm1.setLayout(panelBoderFrm1Layout);
        panelBoderFrm1Layout.setHorizontalGroup(
            panelBoderFrm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBoderFrm1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelBoderFrm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                    .addComponent(InHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelBoderFrm1Layout.setVerticalGroup(
            panelBoderFrm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoderFrm1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(InHD, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelBoderFrm7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel2.setText("Mã hóa đơn:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel3.setText("Ngày mua sách:");

        jMaHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMaHDActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel4.setText("Mã nhân viên:");

        jChonKH.setText("...");
        jChonKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChonKHActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel5.setText("Mã khách hàng:");

        jButtonChonMaNV.setText("...");
        jButtonChonMaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonChonMaNVActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel6.setText("Mã khuyến mãi:");

        jButtonChonKM.setText("...");
        jButtonChonKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonChonKMActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBoderFrm7Layout = new javax.swing.GroupLayout(panelBoderFrm7);
        panelBoderFrm7.setLayout(panelBoderFrm7Layout);
        panelBoderFrm7Layout.setHorizontalGroup(
            panelBoderFrm7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoderFrm7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBoderFrm7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBoderFrm7Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jMaKM, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonChonKM, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBoderFrm7Layout.createSequentialGroup()
                        .addGroup(panelBoderFrm7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2))
                        .addGroup(panelBoderFrm7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBoderFrm7Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(panelBoderFrm7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jMaKH)
                                    .addComponent(jMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelBoderFrm7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonChonMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jChonKH, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelBoderFrm7Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelBoderFrm7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jNgayMua, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBoderFrm7Layout.setVerticalGroup(
            panelBoderFrm7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBoderFrm7Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(panelBoderFrm7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelBoderFrm7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNgayMua, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(panelBoderFrm7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonChonMaNV))
                .addGap(18, 18, 18)
                .addGroup(panelBoderFrm7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jChonKH))
                .addGap(20, 20, 20)
                .addGroup(panelBoderFrm7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jMaKM, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonChonKM))
                .addContainerGap())
        );

        panelBoderFrm8.setBackground(new java.awt.Color(255, 255, 255));

        jButtonThem.setBackground(new java.awt.Color(253, 240, 205));
        jButtonThem.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jButtonThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Add-icon.png"))); // NOI18N
        jButtonThem.setText("Thêm");
        jButtonThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonThemActionPerformed(evt);
            }
        });

        jButtonXoa.setBackground(new java.awt.Color(253, 240, 205));
        jButtonXoa.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jButtonXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Trash-can-icon.png"))); // NOI18N
        jButtonXoa.setText("Xóa");
        jButtonXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonXoaActionPerformed(evt);
            }
        });

        jButtonCN.setBackground(new java.awt.Color(253, 240, 205));
        jButtonCN.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jButtonCN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/edit.png"))); // NOI18N
        jButtonCN.setText("Cập nhật");
        jButtonCN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCNActionPerformed(evt);
            }
        });

        jButtonReset.setBackground(new java.awt.Color(253, 240, 205));
        jButtonReset.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jButtonReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/arrow-circle-right-icon.png"))); // NOI18N
        jButtonReset.setText("Reset");
        jButtonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBoderFrm8Layout = new javax.swing.GroupLayout(panelBoderFrm8);
        panelBoderFrm8.setLayout(panelBoderFrm8Layout);
        panelBoderFrm8Layout.setHorizontalGroup(
            panelBoderFrm8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoderFrm8Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButtonThem, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonCN)
                .addGap(18, 18, 18)
                .addComponent(jButtonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBoderFrm8Layout.setVerticalGroup(
            panelBoderFrm8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoderFrm8Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelBoderFrm8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonThem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCN, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelBoderFrm2Layout = new javax.swing.GroupLayout(panelBoderFrm2);
        panelBoderFrm2.setLayout(panelBoderFrm2Layout);
        panelBoderFrm2Layout.setHorizontalGroup(
            panelBoderFrm2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoderFrm2Layout.createSequentialGroup()
                .addGroup(panelBoderFrm2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBoderFrm2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelBoderFrm7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelBoderFrm1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(panelBoderFrm8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelBoderFrm2Layout.setVerticalGroup(
            panelBoderFrm2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBoderFrm2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBoderFrm2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelBoderFrm7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelBoderFrm1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBoderFrm8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelBoderFrm3.setBackground(new java.awt.Color(253, 240, 205));

        listHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hóa đơn", "Ngày mua sách", "Tổng tiền ", "Mã nhân viên", "Mã khách hàng", "Mã khuyến mãi"
            }
        ));
        listHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listHDMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listHD);

        javax.swing.GroupLayout panelBoderFrm3Layout = new javax.swing.GroupLayout(panelBoderFrm3);
        panelBoderFrm3.setLayout(panelBoderFrm3Layout);
        panelBoderFrm3Layout.setHorizontalGroup(
            panelBoderFrm3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBoderFrm3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBoderFrm3Layout.setVerticalGroup(
            panelBoderFrm3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoderFrm3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelBoderFrm5.setBackground(new java.awt.Color(253, 240, 205));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("THÔNG TIN HÓA ĐƠN");

        javax.swing.GroupLayout panelBoderFrm5Layout = new javax.swing.GroupLayout(panelBoderFrm5);
        panelBoderFrm5.setLayout(panelBoderFrm5Layout);
        panelBoderFrm5Layout.setHorizontalGroup(
            panelBoderFrm5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBoderFrm5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBoderFrm5Layout.setVerticalGroup(
            panelBoderFrm5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoderFrm5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelBoderFrm4.setBackground(new java.awt.Color(253, 240, 205));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("DANH SÁCH HÓA ĐƠN");

        javax.swing.GroupLayout panelBoderFrm4Layout = new javax.swing.GroupLayout(panelBoderFrm4);
        panelBoderFrm4.setLayout(panelBoderFrm4Layout);
        panelBoderFrm4Layout.setHorizontalGroup(
            panelBoderFrm4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoderFrm4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBoderFrm4Layout.setVerticalGroup(
            panelBoderFrm4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBoderFrm4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("HÓA ĐƠN");

        javax.swing.GroupLayout panelBoderFrm6Layout = new javax.swing.GroupLayout(panelBoderFrm6);
        panelBoderFrm6.setLayout(panelBoderFrm6Layout);
        panelBoderFrm6Layout.setHorizontalGroup(
            panelBoderFrm6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoderFrm6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBoderFrm6Layout.setVerticalGroup(
            panelBoderFrm6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoderFrm6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jpnHDLayout = new javax.swing.GroupLayout(jpnHD);
        jpnHD.setLayout(jpnHDLayout);
        jpnHDLayout.setHorizontalGroup(
            jpnHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnHDLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBoderFrm6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpnHDLayout.createSequentialGroup()
                        .addGroup(jpnHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelBoderFrm2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelBoderFrm5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelBoderFrm4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelBoderFrm3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jpnHDLayout.setVerticalGroup(
            jpnHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnHDLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBoderFrm6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelBoderFrm5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelBoderFrm4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBoderFrm2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelBoderFrm3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnHD, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        StringBuilder sb = new StringBuilder();
        if (jMaHD.getText().equals("")){
            sb.append("Mã hóa đơn không được để trống!!!");
           jMaHD.setBackground(Color.red);
        } else {
             jMaHD.setBackground(Color.white);
        }
        if (sb.length() > 0){
           JOptionPane.showMessageDialog(this, sb);
           return;
        }
        try{
            HD hd = HDmodify.find(jMaHD.getText());
            if (hd != null){
            jMaHD.setText(hd.getMaHD());
            jNgayMua.setDate(hd.getNgayMuaSach());
            jMaNV.setText(hd.getMaNV());
            jMaKH.setText(hd.getMaKH());
            jMaKM.setText(hd.getMaKM());
            Load_data_HD(hd.getMaHD());
            }
            else JOptionPane.showMessageDialog(this, "Hóa đơn tìm kiếm không tồn tại!");
        } catch (Exception e){
         JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
         e.printStackTrace();
      }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResetActionPerformed
        // TODO add your handling code here:
        LamMoi();
        Load_data_HD();
    }//GEN-LAST:event_jButtonResetActionPerformed

    private void jButtonXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonXoaActionPerformed
        // TODO add your handling code here:
        StringBuilder sb = new StringBuilder();
        if(jMaHD.getText().equals("")){
            sb.append("!!Mã khách hàng không được để trống!!");
            jMaHD.setBackground(Color.red);
        }
        else{
            jMaHD.setBackground(Color.white);
        }
        if(sb.length() > 0){
            JOptionPane.showMessageDialog(this, sb);
            return;
        }
        try{
            int result = JOptionPane.showConfirmDialog(null,"Bạn có muốn xóa hóa đơn không?", "Xóa", JOptionPane.YES_NO_OPTION);
            if(result == JOptionPane.YES_OPTION){
                HDmodify.DeleteHD(jMaHD.getText());
                JOptionPane.showMessageDialog(this,"Đã xóa hóa đơn thành công");
            }
            else{
                JOptionPane.showMessageDialog(this,"Hóa đơn chưa được xóa");
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this,"Error : "+e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButtonXoaActionPerformed

    private void jButtonThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonThemActionPerformed
        // TODO add your handling code here:
        StringBuilder sb = new StringBuilder();
        if(jMaHD.getText().equals("")){
            sb.append("!!Mã hóa đơn không được để trống!!");
            jMaHD.setBackground(Color.red);
        }
        else{
            jMaHD.setBackground(Color.white);
        }
        if(sb.length() > 0){
            JOptionPane.showMessageDialog(this, sb);
            return;
        }
        try{
            HD hd = new HD();
            hd.setMaHD(jMaHD.getText());
            if(jNgayMua.getDate() != null){
                java.util.Date birthday = jNgayMua.getDate();
                java.sql.Date sqlbd = new java.sql.Date(birthday.getTime());
                hd.setNgayMuaSach(sqlbd);
            }
            hd.setMaNV(jMaNV.getText());
            hd.setMaKH(jMaKH.getText());
            hd.setMaKM(jMaKM.getText());
            HDmodify.InsertHD(hd);
            JOptionPane.showMessageDialog(this, "Đã thêm thành công.");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this,"Error : "+e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButtonThemActionPerformed

    private void jButtonCNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCNActionPerformed
        // TODO add your handling code here:
        StringBuilder sb = new StringBuilder();
        if(jMaHD.getText().equals("")){
            sb.append("!!Mã hóa đơn không được để trống!!");
            jMaHD.setBackground(Color.red);
        }
        else{
            jMaHD.setBackground(Color.white);
        }
        if(sb.length() > 0){
            JOptionPane.showMessageDialog(this, sb);
            return;
        }
        try{
            HD hd = new HD();
            hd.setMaHD(jMaHD.getText());
            if(jNgayMua.getDate() != null){
                java.util.Date birthday = jNgayMua.getDate();
                java.sql.Date sqlbd = new java.sql.Date(birthday.getTime());
                hd.setNgayMuaSach(sqlbd);
            }
            hd.setMaNV(jMaNV.getText());
            hd.setMaKH(jMaKH.getText());
            hd.setMaKM(jMaKM.getText());
            int result = JOptionPane.showConfirmDialog(null,"Bạn có muốn cập nhật hóa đơn không?", "cập nhật", JOptionPane.YES_NO_OPTION);
            if(result == JOptionPane.YES_OPTION){
                HDmodify.UpdateHD(hd);
                JOptionPane.showMessageDialog(this,"Đã Cập nhật thành công.");
            }
            else{
                JOptionPane.showMessageDialog(this,"Hóa đơn chưa được cập nhật");
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this,"Error : "+e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButtonCNActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        StringBuilder sb = new StringBuilder();
        if(jMaHD.getText().equals("")){
            sb.append("!!Mã hóa đơn không được để trống!!");
            jMaHD.setBackground(Color.red);
        }
        else{
            jMaHD.setBackground(Color.white);
        }
        if(sb.length() > 0){
            JOptionPane.showMessageDialog(this, sb);
            return;
        }
        jpnHD.removeAll();
        jpnHD.setLayout(new BorderLayout());
        jpnHD.add(new CTHD(jMaHD.getText()).getJPN());
        jpnHD.validate();
        jpnHD.repaint();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        StringBuilder sb = new StringBuilder();
        if(jMaHD.getText().equals("")){
            sb.append("!!Mã hóa đơn không được để trống!!");
            jMaHD.setBackground(Color.red);
        }
        else{
            jMaHD.setBackground(Color.white);
        }
        if(sb.length() > 0){
            JOptionPane.showMessageDialog(this, sb);
            return;
        }
        try{
           HDmodify.Tinh_TongHD(jMaHD.getText());
           JOptionPane.showMessageDialog(this, "Đã tính thành công.");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this,"Error : "+e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void listHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listHDMouseClicked
        // TODO add your handling code here:
        try{
        LamMoi();
        int selectedIndex = listHD.getSelectedRow();
        listHD.setColumnSelectionInterval(0,5);
        jMaHD.setText(listHD.getValueAt(selectedIndex, 0).toString());
        jNgayMua.setDate((java.util.Date) listHD.getValueAt(selectedIndex, 1));
        jMaNV.setText(listHD.getValueAt(selectedIndex, 3).toString());
        jMaKH.setText(listHD.getValueAt(selectedIndex, 4).toString());
        jMaKM.setText(listHD.getValueAt(selectedIndex, 5).toString());
        }
        catch(Exception e){
        }
    }//GEN-LAST:event_listHDMouseClicked
    
    private void InHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InHDActionPerformed
        if(jMaHD.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã hóa đơn không được để trống.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            jMaHD.setBackground(Color.RED);
            return;
        } else {
            jMaHD.setBackground(Color.WHITE);
        }

        StringBuilder sb = new StringBuilder();

        try {
            // Tạo một tài liệu PDF mới
            Document document = new Document();

            // Chọn đường dẫn để lưu file PDF
            String outputPath = "D:\\OneDrive\\Máy tính\\MHN3#2\\java\\AppBanSach\\DoAn\\Project DoAn\\DoAn\\src\\report\\HoaDon.pdf";
            PdfWriter.getInstance(document, new FileOutputStream(outputPath));

            // Mở tài liệu để bắt đầu viết
            document.open();

            // Khai báo các kiểu font
            Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
            Font normalFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);

            // Thêm logo vào trang đầu tiên của tài liệu
            Image logo = Image.getInstance("D:\\OneDrive\\Máy tính\\MHN3#2\\java\\AppBanSach\\DoAn\\Project DoAn\\DoAn\\src\\Images\\open-book.png");
            logo.setAlignment(Element.ALIGN_LEFT);
            document.add(logo);

            // Thêm tiêu đề hóa đơn
            Paragraph title = new Paragraph("HÓA ĐƠN BÁN HÀNG", boldFont);
            title.setAlignment(Element.ALIGN_MIDDLE);
            document.add(title);

            // Thêm đường kẻ ngang phía dưới tiêu đề
            document.add(new Paragraph("------------------------------------------------------------"));
            document.add(Chunk.NEWLINE); // Khoảng trống

            // Thêm thông tin cơ bản của hóa đơn
            document.add(new Paragraph("Mã hóa đơn: " + jMaHD.getText(), boldFont));

            // Thêm ngày mua vào hóa đơn (nếu có)
            if(jNgayMua.getDate() != null) {
                document.add(new Paragraph("Ngày mua: " + new SimpleDateFormat("dd/MM/yyyy").format(jNgayMua.getDate()), normalFont));
            }

            // Thêm thông tin nhân viên vào hóa đơn (nếu có)
            if(!jMaNV.getText().isEmpty()) {
                document.add(new Paragraph("Nhân viên: " + jMaNV.getText(), normalFont));
            }

            // Thêm thông tin khách hàng vào hóa đơn (nếu có)
            if(!jMaKH.getText().isEmpty()) {
                document.add(new Paragraph("Khách hàng: " + jMaKH.getText(), normalFont));
            }

            // Thêm thông tin khuyến mãi vào hóa đơn (nếu có)
            if(!jMaKM.getText().isEmpty()) {
                document.add(new Paragraph("Khuyến mãi: " + jMaKM.getText(), normalFont));
            }

            // Thêm đường kẻ ngang phía trên phần tổng tiền
            document.add(new Paragraph("------------------------------------------------------------"));
            document.add(Chunk.NEWLINE); // Khoảng trống

            // Tính và thêm tổng tiền vào hóa đơn
            double tongTien = HDmodify.layTongTienHoaDon(jMaHD.getText());
            document.add(new Paragraph("Tổng tiền: " + String.format("%.2f", tongTien) + " VND", boldFont));

            // Thêm đường kẻ ngang phía dưới phần tổng tiền
            document.add(new Paragraph("------------------------------------------------------------"));

            // Đóng tài liệu
            document.close();

            JOptionPane.showMessageDialog(this, "Hóa đơn đã được in thành công và lưu vào: " + outputPath);
        } catch (FileNotFoundException ex) {
            sb.append("Lỗi: Không tìm thấy đường dẫn để lưu file PDF.\n");
        } catch (DocumentException ex) {
            sb.append("Lỗi: Không thể tạo tài liệu PDF.\n");
        } catch (IOException ex) {
            sb.append("Lỗi: Có lỗi khi ghi file PDF.\n");
        } catch (Exception e) {
            sb.append("Đã xảy ra lỗi khi tạo hóa đơn PDF.\n");
        }

        // Hiển thị thông báo lỗi (nếu có)
        if(sb.length() > 0) {
            JOptionPane.showMessageDialog(this, sb.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_InHDActionPerformed
    
    private void jChonKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChonKHActionPerformed
        // TODO add your handling code here: 
        khk = new KHForm();
        khk.TruyenDLDi(this);
    }//GEN-LAST:event_jChonKHActionPerformed

    private void jButtonChonMaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChonMaNVActionPerformed
        // TODO add your handling code here:
        jMaNV.setText(tk.getMaNV());
    }//GEN-LAST:event_jButtonChonMaNVActionPerformed

    private void jButtonChonKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChonKMActionPerformed
        // TODO add your handling code here:
        KMFrame km = new KMFrame();
        km.TruyenDL(this);
    }//GEN-LAST:event_jButtonChonKMActionPerformed

    private void jMaHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMaHDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMaHDActionPerformed

    
    
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
            java.util.logging.Logger.getLogger(HOADON.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HOADON.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HOADON.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HOADON.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HOADON().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton InHD;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonCN;
    private javax.swing.JButton jButtonChonKM;
    private javax.swing.JButton jButtonChonMaNV;
    private javax.swing.JButton jButtonReset;
    private javax.swing.JButton jButtonThem;
    private javax.swing.JButton jButtonXoa;
    private javax.swing.JButton jChonKH;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jMaHD;
    private javax.swing.JTextField jMaKH;
    private javax.swing.JTextField jMaKM;
    private javax.swing.JTextField jMaNV;
    private com.toedter.calendar.JDateChooser jNgayMua;
    private javax.swing.JScrollPane jScrollPane1;
    private PanelBoder.PanelBoderFrm jpnHD;
    private javax.swing.JTable listHD;
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
