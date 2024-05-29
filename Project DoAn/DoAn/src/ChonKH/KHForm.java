/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChonKH;

import HOADON.HOADON;
import doan.KhachHang;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author hoang
 */
public class KHForm extends javax.swing.JFrame {

    /**
     * Creates new form KHForm
     */
    KHDAO khdao = new KHFormImpl();
    DefaultTableModel model;
    String[] listColumn = {"Mã khách hàng", "Tên khách hàng", "SDT", "Email"
                            , "Giới tính", "Địa chỉ", "Loại khách hàng", "Ngày sinh", "CMND"};  
    private TableRowSorter<TableModel> rowSorter = null;
    String MaNV;
    HOADON hd;
    public KHForm() {
        initComponents();
        setLocationRelativeTo(null);
        Load_Data();
        setVisible(true);
    }
    public void TruyenDLDi(HOADON in_hd){
        hd = in_hd;
    }
    public DefaultTableModel setTableKH(List<KhachHang> listItem, String[] listColumn){
        model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        model.setColumnIdentifiers(listColumn);
        int columns =  listColumn.length;
        Object[] obj = null;
        int rows = listItem.size();
        if(rows > 0){
            for(int i = 0; i< rows; i++){
                KhachHang kh = listItem.get(i);
                obj = new Object[columns];
                obj[0] = kh.getMaKH();
                obj[1] = kh.getTenKH();
                obj[2] = kh.getSDT();
                obj[3] = kh.getEmail();
                obj[4] = kh.getGioiTinh();
                obj[5] = kh.getDchi();
                obj[6] = kh.getLoaiKH();
                obj[7] = kh.getNgSinh();
                obj[8] = kh.getCMND();
                model.addRow(obj);
            }
        }
        return model;
    }
    
    public void Load_Data(){
        List<KhachHang> list = new ArrayList<>();
        list = khdao.getList();
        model = setTableKH(list, listColumn);
        JTable table = new JTable(model);
        
        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);
        
        jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if(text.trim().length() == 0){
                    rowSorter.setRowFilter(null);
                }
                else{
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if(text.trim().length() == 0){
                    rowSorter.setRowFilter(null);
                }
                else{
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 2 && table.getSelectedRow() != -1){
                    model = (DefaultTableModel) table.getModel();
                    int selectedRowIndex = table.getSelectedRow();
                    MaNV = table.getValueAt(selectedRowIndex, 0).toString();
                    hd.NhanDLVe(MaNV);
                    dispose();
                }
            }
        });
        
        
        table.getTableHeader().setFont(new Font("Arrival", Font.BOLD,14));
        table.getTableHeader().setPreferredSize(new Dimension(100,50));
        table.setRowHeight(50);
        table.validate();
        table.repaint();
        JScrollPane scrollpane = new JScrollPane();
        scrollpane.getViewport().add(table);
        scrollpane.setPreferredSize(new Dimension(1300, 400));
        panelBoderFrm1.removeAll();
        panelBoderFrm1.setLayout(new BorderLayout());
        panelBoderFrm1.add(scrollpane);
        panelBoderFrm1.validate();
        panelBoderFrm1.repaint();
    }
    
    public void LamMoi(){
        List<KhachHang> list = new ArrayList<>();
        list = khdao.getList();
        model = setTableKH(list, listColumn);
        JTable table = new JTable(model);
        
        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);
        
        jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if(text.trim().length() == 0){
                    rowSorter.setRowFilter(null);
                }
                else{
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if(text.trim().length() == 0){
                    rowSorter.setRowFilter(null);
                }
                else{
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 2 && table.getSelectedRow() != -1){
                    model = (DefaultTableModel) table.getModel();
                    int selectedRowIndex = table.getSelectedRow();
                    MaNV = table.getValueAt(selectedRowIndex, 0).toString();
                    hd.NhanDLVe(MaNV);
                    dispose();
                }
            }
        });
        
        
        table.getTableHeader().setFont(new Font("Arrival", Font.BOLD,14));
        table.getTableHeader().setPreferredSize(new Dimension(100,50));
        table.setRowHeight(50);
        table.validate();
        table.repaint();
        JScrollPane scrollpane = new JScrollPane();
        scrollpane.getViewport().add(table);
        scrollpane.setPreferredSize(new Dimension(1300, 400));
        panelBoderFrm1.removeAll();
        panelBoderFrm1.setLayout(new BorderLayout());
        panelBoderFrm1.add(scrollpane);
        panelBoderFrm1.validate();
        panelBoderFrm1.repaint();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBoderFrm2 = new PanelBoder.PanelBoderFrm();
        panelBoderFrm1 = new PanelBoder.PanelBoderFrm();
        jpnView = new PanelBoder.PanelBoderFrm();
        jLabel1 = new javax.swing.JLabel();
        panelBoderFrm3 = new PanelBoder.PanelBoderFrm();
        jtfSearch = new javax.swing.JTextField();
        jButtonThem = new javax.swing.JButton();
        jButtonRS = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        panelBoderCircle1 = new PanelBoder.PanelBoderCircle();
        panelBoderCircle2 = new PanelBoder.PanelBoderCircle();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelBoderFrm2.setBackground(new java.awt.Color(0, 51, 102));
        panelBoderFrm2.setPreferredSize(new java.awt.Dimension(673, 529));

        panelBoderFrm1.setBackground(new java.awt.Color(253, 240, 205));

        javax.swing.GroupLayout panelBoderFrm1Layout = new javax.swing.GroupLayout(panelBoderFrm1);
        panelBoderFrm1.setLayout(panelBoderFrm1Layout);
        panelBoderFrm1Layout.setHorizontalGroup(
            panelBoderFrm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 661, Short.MAX_VALUE)
        );
        panelBoderFrm1Layout.setVerticalGroup(
            panelBoderFrm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 399, Short.MAX_VALUE)
        );

        jpnView.setBackground(new java.awt.Color(235, 212, 155));

        jLabel1.setBackground(new java.awt.Color(253, 240, 205));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DANH SÁCH KHÁCH HÀNG");

        javax.swing.GroupLayout jpnViewLayout = new javax.swing.GroupLayout(jpnView);
        jpnView.setLayout(jpnViewLayout);
        jpnViewLayout.setHorizontalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpnViewLayout.setVerticalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnViewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelBoderFrm3.setBackground(new java.awt.Color(253, 240, 205));

        jtfSearch.setBackground(new java.awt.Color(253, 240, 205));
        jtfSearch.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfSearch.setBorder(null);
        jtfSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfSearchActionPerformed(evt);
            }
        });

        jButtonThem.setBackground(new java.awt.Color(204, 255, 255));
        jButtonThem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonThem.setText("Thêm");
        jButtonThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonThemActionPerformed(evt);
            }
        });

        jButtonRS.setBackground(new java.awt.Color(204, 204, 255));
        jButtonRS.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonRS.setText("Làm Mới");
        jButtonRS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRSActionPerformed(evt);
            }
        });

        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout panelBoderFrm3Layout = new javax.swing.GroupLayout(panelBoderFrm3);
        panelBoderFrm3.setLayout(panelBoderFrm3Layout);
        panelBoderFrm3Layout.setHorizontalGroup(
            panelBoderFrm3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoderFrm3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelBoderFrm3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jtfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jButtonThem, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonRS, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        panelBoderFrm3Layout.setVerticalGroup(
            panelBoderFrm3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoderFrm3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panelBoderFrm3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBoderFrm3Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jtfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBoderFrm3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonThem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonRS, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelBoderCircle1.setPreferredSize(new java.awt.Dimension(50, 50));

        javax.swing.GroupLayout panelBoderCircle1Layout = new javax.swing.GroupLayout(panelBoderCircle1);
        panelBoderCircle1.setLayout(panelBoderCircle1Layout);
        panelBoderCircle1Layout.setHorizontalGroup(
            panelBoderCircle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );
        panelBoderCircle1Layout.setVerticalGroup(
            panelBoderCircle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

        panelBoderCircle2.setPreferredSize(new java.awt.Dimension(62, 62));

        javax.swing.GroupLayout panelBoderCircle2Layout = new javax.swing.GroupLayout(panelBoderCircle2);
        panelBoderCircle2.setLayout(panelBoderCircle2Layout);
        panelBoderCircle2Layout.setHorizontalGroup(
            panelBoderCircle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );
        panelBoderCircle2Layout.setVerticalGroup(
            panelBoderCircle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelBoderFrm2Layout = new javax.swing.GroupLayout(panelBoderFrm2);
        panelBoderFrm2.setLayout(panelBoderFrm2Layout);
        panelBoderFrm2Layout.setHorizontalGroup(
            panelBoderFrm2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoderFrm2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBoderFrm2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBoderFrm2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(panelBoderCircle1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelBoderFrm3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelBoderCircle2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelBoderFrm2Layout.createSequentialGroup()
                        .addGroup(panelBoderFrm2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelBoderFrm1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jpnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        panelBoderFrm2Layout.setVerticalGroup(
            panelBoderFrm2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoderFrm2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBoderFrm2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBoderFrm2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(panelBoderFrm3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelBoderCircle1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelBoderCircle2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBoderFrm1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBoderFrm2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBoderFrm2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfSearchActionPerformed

    private void jButtonThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonThemActionPerformed
        // TODO add your handling code here:
        TTKH frame = new TTKH();
        frame.setTitle("Thông tin khách hàng");
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }//GEN-LAST:event_jButtonThemActionPerformed

    private void jButtonRSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRSActionPerformed
        // TODO add your handling code here:
        LamMoi();
        
    }//GEN-LAST:event_jButtonRSActionPerformed

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
            java.util.logging.Logger.getLogger(KHForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KHForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KHForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KHForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KHForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonRS;
    private javax.swing.JButton jButtonThem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private PanelBoder.PanelBoderFrm jpnView;
    private javax.swing.JTextField jtfSearch;
    private PanelBoder.PanelBoderCircle panelBoderCircle1;
    private PanelBoder.PanelBoderCircle panelBoderCircle2;
    private PanelBoder.PanelBoderFrm panelBoderFrm1;
    private PanelBoder.PanelBoderFrm panelBoderFrm2;
    private PanelBoder.PanelBoderFrm panelBoderFrm3;
    // End of variables declaration//GEN-END:variables
}
