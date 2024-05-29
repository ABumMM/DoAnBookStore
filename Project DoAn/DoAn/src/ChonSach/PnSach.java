/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChonSach;

import HOADON.CTHD;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.RowFilter;

public class PnSach extends javax.swing.JPanel {

    SachDao sdao = new SachDao();
    DefaultTableModel model;
    String[] listColumn = {"Mã sách", "Tên sách", "Tác giả", "Năm xuất bản", "Số lượng còn"
                           ,"Giá" ,"Thể loại" ,"Hình ảnh"};  
    private TableRowSorter<TableModel> rowSorter = null;
    
    public PnSach() {
        initComponents();
        Load_Data();
    }
    
    public DefaultTableModel setTableKH(List<ClassSach> listItem, String[] listColumn){
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
                ClassSach s = listItem.get(i);
                obj = new Object[columns];
                obj[0] = s.getMaSach();
                obj[1] = s.getTenSach();
                obj[2] = s.getTenTG();
                obj[3] = s.getNamXB();
                obj[4] = s.getSLTon();
                obj[5] = s.getGiaBan();
                obj[6] = s.getTheLoai();
                obj[7] = s.getHinhAnh();
                model.addRow(obj);
            }
        }
        return model;
    }
    
    public void Load_Data(){
        List<ClassSach> list = new ArrayList<>();
        list = sdao.getList();
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
                 if (e.getClickCount() == 2 && table.getSelectedRow() != -1) {
                     int selectedRowIndex = table.getSelectedRow();
                     String imagePath = (String) table.getValueAt(selectedRowIndex, 7);
                     displayImage(imagePath);
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
        scrollpane.setPreferredSize(new Dimension(600,563));
        jpnView.removeAll();
        jpnView.setLayout(new BorderLayout());
        jpnView.add(scrollpane);
        jpnView.validate();
        jpnView.repaint();
        
    }
    
    private void displayImage(String imagePath) {
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(jbnAnhSach.getWidth(), jbnAnhSach.getHeight(), Image.SCALE_SMOOTH);
        jbnAnhSach.setIcon(new ImageIcon(scaledImage));
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBoderFrm1 = new PanelBoder.PanelBoderFrm();
        jpnView = new PanelBoder.PanelBoderFrm();
        panelBoderFrm2 = new PanelBoder.PanelBoderFrm();
        panelBoderCircle1 = new PanelBoder.PanelBoderCircle();
        panelBoderCircle2 = new PanelBoder.PanelBoderCircle();
        jLabel1 = new javax.swing.JLabel();
        panelBoderFrm3 = new PanelBoder.PanelBoderFrm();
        jpnAnh = new PanelBoder.PanelBoderCircle();
        jbnAnhSach = new javax.swing.JLabel();
        panelBoderFrm4 = new PanelBoder.PanelBoderFrm();
        jLabel2 = new javax.swing.JLabel();
        jtfSearch = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        panelBoderFrm5 = new PanelBoder.PanelBoderFrm();
        panelBoderFrm6 = new PanelBoder.PanelBoderFrm();

        panelBoderFrm1.setBackground(new java.awt.Color(0, 51, 102));

        jpnView.setBackground(new java.awt.Color(253, 240, 205));

        javax.swing.GroupLayout jpnViewLayout = new javax.swing.GroupLayout(jpnView);
        jpnView.setLayout(jpnViewLayout);
        jpnViewLayout.setHorizontalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpnViewLayout.setVerticalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelBoderFrm2.setBackground(new java.awt.Color(253, 240, 205));

        panelBoderCircle1.setBackground(new java.awt.Color(0, 0, 0));
        panelBoderCircle1.setPreferredSize(new java.awt.Dimension(30, 30));

        javax.swing.GroupLayout panelBoderCircle1Layout = new javax.swing.GroupLayout(panelBoderCircle1);
        panelBoderCircle1.setLayout(panelBoderCircle1Layout);
        panelBoderCircle1Layout.setHorizontalGroup(
            panelBoderCircle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        panelBoderCircle1Layout.setVerticalGroup(
            panelBoderCircle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        panelBoderCircle2.setBackground(new java.awt.Color(0, 0, 0));
        panelBoderCircle2.setPreferredSize(new java.awt.Dimension(30, 30));

        javax.swing.GroupLayout panelBoderCircle2Layout = new javax.swing.GroupLayout(panelBoderCircle2);
        panelBoderCircle2.setLayout(panelBoderCircle2Layout);
        panelBoderCircle2Layout.setHorizontalGroup(
            panelBoderCircle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        panelBoderCircle2Layout.setVerticalGroup(
            panelBoderCircle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DANH SÁCH CÁC CUỐN SÁCH");

        javax.swing.GroupLayout panelBoderFrm2Layout = new javax.swing.GroupLayout(panelBoderFrm2);
        panelBoderFrm2.setLayout(panelBoderFrm2Layout);
        panelBoderFrm2Layout.setHorizontalGroup(
            panelBoderFrm2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBoderFrm2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(panelBoderCircle1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 941, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBoderCircle2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        panelBoderFrm2Layout.setVerticalGroup(
            panelBoderFrm2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBoderFrm2Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(panelBoderFrm2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBoderCircle1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelBoderCircle2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelBoderFrm3.setBackground(new java.awt.Color(253, 240, 205));

        jpnAnh.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jpnAnhLayout = new javax.swing.GroupLayout(jpnAnh);
        jpnAnh.setLayout(jpnAnhLayout);
        jpnAnhLayout.setHorizontalGroup(
            jpnAnhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnAnhLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbnAnhSach, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnAnhLayout.setVerticalGroup(
            jpnAnhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnAnhLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbnAnhSach, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelBoderFrm3Layout = new javax.swing.GroupLayout(panelBoderFrm3);
        panelBoderFrm3.setLayout(panelBoderFrm3Layout);
        panelBoderFrm3Layout.setHorizontalGroup(
            panelBoderFrm3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBoderFrm3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnAnh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBoderFrm3Layout.setVerticalGroup(
            panelBoderFrm3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBoderFrm3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnAnh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelBoderFrm4.setBackground(new java.awt.Color(253, 240, 205));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel2.setText("Nhập thông tin cần tìm:");

        jtfSearch.setBackground(new java.awt.Color(253, 240, 205));
        jtfSearch.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfSearch.setBorder(null);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout panelBoderFrm4Layout = new javax.swing.GroupLayout(panelBoderFrm4);
        panelBoderFrm4.setLayout(panelBoderFrm4Layout);
        panelBoderFrm4Layout.setHorizontalGroup(
            panelBoderFrm4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoderFrm4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBoderFrm4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBoderFrm4Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jtfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        panelBoderFrm4Layout.setVerticalGroup(
            panelBoderFrm4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoderFrm4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBoderFrm4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelBoderFrm4Layout.createSequentialGroup()
                        .addComponent(jtfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 6, Short.MAX_VALUE))
        );

        panelBoderFrm5.setBackground(new java.awt.Color(253, 240, 205));

        javax.swing.GroupLayout panelBoderFrm5Layout = new javax.swing.GroupLayout(panelBoderFrm5);
        panelBoderFrm5.setLayout(panelBoderFrm5Layout);
        panelBoderFrm5Layout.setHorizontalGroup(
            panelBoderFrm5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelBoderFrm5Layout.setVerticalGroup(
            panelBoderFrm5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelBoderFrm6Layout = new javax.swing.GroupLayout(panelBoderFrm6);
        panelBoderFrm6.setLayout(panelBoderFrm6Layout);
        panelBoderFrm6Layout.setHorizontalGroup(
            panelBoderFrm6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelBoderFrm6Layout.setVerticalGroup(
            panelBoderFrm6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
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
                        .addGroup(panelBoderFrm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBoderFrm1Layout.createSequentialGroup()
                                .addComponent(panelBoderFrm6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelBoderFrm4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jpnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBoderFrm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelBoderFrm5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelBoderFrm3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        panelBoderFrm1Layout.setVerticalGroup(
            panelBoderFrm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoderFrm1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(panelBoderFrm2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBoderFrm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBoderFrm1Layout.createSequentialGroup()
                        .addGroup(panelBoderFrm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelBoderFrm4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelBoderFrm6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelBoderFrm1Layout.createSequentialGroup()
                        .addComponent(panelBoderFrm3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelBoderFrm5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBoderFrm1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelBoderFrm1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jbnAnhSach;
    private PanelBoder.PanelBoderCircle jpnAnh;
    private PanelBoder.PanelBoderFrm jpnView;
    private javax.swing.JTextField jtfSearch;
    private PanelBoder.PanelBoderCircle panelBoderCircle1;
    private PanelBoder.PanelBoderCircle panelBoderCircle2;
    private PanelBoder.PanelBoderFrm panelBoderFrm1;
    private PanelBoder.PanelBoderFrm panelBoderFrm2;
    private PanelBoder.PanelBoderFrm panelBoderFrm3;
    private PanelBoder.PanelBoderFrm panelBoderFrm4;
    private PanelBoder.PanelBoderFrm panelBoderFrm5;
    private PanelBoder.PanelBoderFrm panelBoderFrm6;
    // End of variables declaration//GEN-END:variables
}
