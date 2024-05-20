package KMForm;


import DANGNHAP.TAIKHOAN;
import doan.JDBCConnection;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.event.KeyEvent;
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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class KMForm extends javax.swing.JPanel {

    /**
     * Creates new form KMForm
     */
   Connection conn;
PreparedStatement ps;
ResultSet rs;
TAIKHOAN tk;

public KMForm() {
    initComponents();
    KetNoiCSDL();
    KhuyeMai_Load();
}

public KMForm(TAIKHOAN in_tk) {
    initComponents();
    KetNoiCSDL();
    KhuyeMai_Load();
    tk = in_tk;
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
        System.err.println("Lỗi kết nối CSDL: " + ex.getMessage());
        ex.printStackTrace();
    }
}

public void KhuyeMai_Load() {
    try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM KhuyenMai");
         ResultSet rs = ps.executeQuery()) {
        ResultSetMetaData rsd = rs.getMetaData();
        int c = rsd.getColumnCount();

        DefaultTableModel model = (DefaultTableModel) ListKM.getModel();
        model.setRowCount(0);

        while (rs.next()) {
            Vector v1 = new Vector();
            for (int i = 1; i <= c; i++) {
                v1.add(rs.getString("MaKM"));
                v1.add(rs.getString("SoPhanTramGiam"));
                v1.add(rs.getDate("KMTuNgay"));
                v1.add(rs.getDate("KMDenNgay"));
                v1.add(rs.getString("DieuKienKM"));
            }
            model.addRow(v1);
            ListKM.setModel(model);
        }
    } catch (SQLException ex) {
        Logger.getLogger(KMForm.class.getName()).log(Level.SEVERE, null, ex);
    }
}

public void LamMoi() {
    txtMaKM.setText("");
    txtPhanTram.setText("");
    jdTu.setDate(null);
    jdDen.setDate(null);
    txtDK.setText("");
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMaKM = new javax.swing.JTextField();
        txtPhanTram = new javax.swing.JTextField();
        txtDK = new javax.swing.JTextField();
        jdDen = new com.toedter.calendar.JDateChooser();
        jdTu = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListKM = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(230, 175, 139));

        jLabel1.setBackground(new java.awt.Color(230, 175, 139));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ KHUYẾN MÃI");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jLabel2.setText("Mã khuyến mãi");

        jLabel3.setText("Số phần trăm giảm");

        jLabel4.setText("Khuyến mãi từ ngày");

        jLabel5.setText("Khuyến mãi đến ngày");

        jLabel6.setText("Điều kiện khuyến mãi");

        jButton1.setBackground(new java.awt.Color(230, 175, 139));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/find.png"))); // NOI18N
        jButton1.setText("Tìm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(230, 175, 139));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Add-icon.png"))); // NOI18N
        jButton2.setText("Thêm");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(230, 175, 139));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Trash-can-icon.png"))); // NOI18N
        jButton3.setText("Xóa");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(230, 175, 139));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/edit.png"))); // NOI18N
        jButton4.setText("Cập nhập");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(230, 175, 139));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/arrow-circle-right-icon.png"))); // NOI18N
        jButton5.setText("Làm mới");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        ListKM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã khuyến mãi", "Số phần trăm giảm", "Từ ngày", "Đến ngày", "Điều kiện"
            }
        ));
        ListKM.setPreferredSize(new java.awt.Dimension(1000, 300));
        ListKM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListKMMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ListKM);

        jPanel2.setBackground(new java.awt.Color(230, 175, 139));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("THÔNG TIN KHUYẾN MÃI");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel8)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(230, 175, 139));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("DANH SÁCH KHUYẾN MÃI");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel7)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtMaKM, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtPhanTram, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jdTu, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jdDen, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtDK, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaKM, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPhanTram, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jdTu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jdDen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDK, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 47, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if(tk.getLoaiTK().equals("Quản Lý"));
        else{
            JOptionPane.showMessageDialog(this, "Bạn không có quyền sử dụng chức năng này.");
            return;
        }
        StringBuilder sb = new StringBuilder();
        if (txtMaKM.getText().equals("")){
            sb.append("Mã khuyến mãi không được để trống!!!");
            txtMaKM.setBackground(Color.red);
        } else {
             txtMaKM.setBackground(Color.white);
        }
        if (sb.length() > 0){
            JOptionPane.showMessageDialog(this, sb);
            return;
        }
      try{  
        
        tacvuKM dao = new tacvuKM();
        int result = JOptionPane.showConfirmDialog(this,"Bạn chắc chắn muốn xóa khuyến mãi này?","Xác nhận", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION){
         dao.delete(txtMaKM.getText());
        JOptionPane.showMessageDialog(this, "Khuyến mãi đã xóa thành công!");
        } else {
        JOptionPane.showMessageDialog(this, "Khuyến mãi viên chưa được xóa!");
        }
      } catch (Exception e){
          JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
          e.printStackTrace();
      }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        StringBuilder sb = new StringBuilder();
        if (txtMaKM.getText().equals("")){
            sb.append("Mã khuyến mãi không được để trống!!!");
            txtMaKM.setBackground(Color.red);
        } else {
             txtMaKM.setBackground(Color.white);
        }
        if (sb.length() > 0){
            JOptionPane.showMessageDialog(this, sb);
            return;
        }
        try{  
          
        tacvuKM tv = new tacvuKM();
        KhuyenMai KM = tv.find(txtMaKM.getText());
        
        if (KM != null){
        // Xuất thông tin
        int selectedIndex = ListKM.getSelectedRow();
        
        txtMaKM.setText(KM.getMaKM());
        txtPhanTram.setText(KM.getSoPhanTramGiam());
        jdTu.setDate(KM.getKMTuNgay());
        jdDen.setDate(KM.getKMDenNgay());
        txtDK.setText(KM.getDieuKienKM());
        
       } else 
       
        JOptionPane.showMessageDialog(this, "Mã khuyến mãi tìm kiếm không tồn tại!");
      } catch (Exception e){
          JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
          e.printStackTrace();
      }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(tk.getLoaiTK().equals("Quản Lý"));
        else{
            JOptionPane.showMessageDialog(this, "Bạn không có quyền sử dụng chức năng này.");
            return;
        }
        StringBuilder sb = new StringBuilder();
        if (txtMaKM.getText().equals("")){
            sb.append("Mã khuyến mãi không được để trống!!!");
            txtMaKM.setBackground(Color.red);
        } else {
             txtMaKM.setBackground(Color.white);
        }
        if (sb.length() > 0){
            JOptionPane.showMessageDialog(this, sb);
            return;
        }
        try{  
        KhuyenMai KM = new KhuyenMai();
        KM.setMaKM(txtMaKM.getText());
        KM.setSoPhanTramGiam(txtPhanTram.getText());
        
         if(jdTu.getDate() != null ){
            java.util.Date utilStartDate = jdTu.getDate();
            java.sql.Date sqlStartDate = new java.sql.Date(utilStartDate.getTime());
            KM.setKMTuNgay(sqlStartDate);
        }
         
         if(jdDen.getDate() != null ){
            java.util.Date utilStartDate = jdDen.getDate();
            java.sql.Date sqlStartDate = new java.sql.Date(utilStartDate.getTime());
            KM.setKMDenNgay(sqlStartDate);
        }
        
        KM.setDieuKienKM(txtDK.getText());
        

        tacvuKM dao = new tacvuKM();
        dao.insert(KM);    
        JOptionPane.showMessageDialog(this, "Khuyến mãi được thêm vào thành công!");
      } catch (Exception e){
          JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
          
      }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if(tk.getLoaiTK().equals("Quản Lý"));
        else{
            JOptionPane.showMessageDialog(this, "Bạn không có quyền sử dụng chức năng này.");
            return;
        }
        StringBuilder sb = new StringBuilder();
        if (txtMaKM.getText().equals("")){
            sb.append("Mã khuyến mãi không được để trống!!!");
            txtMaKM.setBackground(Color.red);
        } else {
             txtMaKM.setBackground(Color.white);
        }
        if (sb.length() > 0){
            JOptionPane.showMessageDialog(this, sb);
            return;
        }
 
        try{  
       
        tacvuKM dao = new tacvuKM();
        dao.delete(txtMaKM.getText());
        KhuyenMai KM = new KhuyenMai();
        
        KM.setMaKM(txtMaKM.getText());
        KM.setSoPhanTramGiam(txtPhanTram.getText());
        
         if(jdTu.getDate() != null ){
            java.util.Date utilStartDate = jdTu.getDate();
            java.sql.Date sqlStartDate = new java.sql.Date(utilStartDate.getTime());
            KM.setKMTuNgay(sqlStartDate);
        }
         
         if(jdDen.getDate() != null ){
            java.util.Date utilStartDate = jdDen.getDate();
            java.sql.Date sqlStartDate = new java.sql.Date(utilStartDate.getTime());
            KM.setKMDenNgay(sqlStartDate);
        }
        
        
        dao.update(KM);  
        
        JOptionPane.showMessageDialog(this, "Khuyến mãi được cập nhật vào thành công!");
      } catch (Exception e){
          JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
      
      }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        LamMoi();
        try {
            ps = conn.prepareStatement("SELECT * FROM KhuyenMai ");
            rs = ps.executeQuery();
            
            ResultSetMetaData rsd = rs.getMetaData();
            int c = rsd.getColumnCount();
          
            DefaultTableModel model = (DefaultTableModel) ListKM.getModel();
            model.setRowCount(0);
            
            while (rs.next()){
                Vector v1 = new Vector();
                for(int i=1;i<=c;i++){
                    v1.add(rs.getString("MaKM"));
                    v1.add(rs.getString("SoPhanTramGiam"));
                    v1.add(rs.getDate("KMTuNgay"));
                    v1.add(rs.getDate("KMDenNgay"));
                    v1.add(rs.getString("DieuKienKM"));
                   
              }
                model.addRow(v1);
               ListKM.setModel(model);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(KMForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void ListKMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListKMMouseClicked
        // TODO add your handling code here:
        LamMoi();
        int selectedIndex = ListKM.getSelectedRow();
        ListKM.setColumnSelectionInterval(0,4);
        txtMaKM.setText(ListKM.getValueAt(selectedIndex, 0).toString());
        txtPhanTram.setText(ListKM.getValueAt(selectedIndex, 1).toString());
        jdTu.setDate((Date) ListKM.getValueAt(selectedIndex, 2));
        jdDen.setDate((Date) ListKM.getValueAt(selectedIndex, 3));
        txtDK.setText(ListKM.getValueAt(selectedIndex, 4).toString());
    }//GEN-LAST:event_ListKMMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ListKM;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdDen;
    private com.toedter.calendar.JDateChooser jdTu;
    private javax.swing.JTextField txtDK;
    private javax.swing.JTextField txtMaKM;
    private javax.swing.JTextField txtPhanTram;
    // End of variables declaration//GEN-END:variables
}
