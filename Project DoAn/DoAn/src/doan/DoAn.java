/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doan;

import DANGNHAP.DangNhap;

/**
 *
 * @author hoang
 */
public class DoAn {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>
   
    /* Create and display the form */
    java.awt.EventQueue.invokeLater(() -> {
        DangNhap dangNhap = new DangNhap();
        dangNhap.setVisible(true);
        dangNhap.setLocationRelativeTo(null); // Đặt vị trí của cửa sổ ở giữa màn hình
    });
    }
    
}
