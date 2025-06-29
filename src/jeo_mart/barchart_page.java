/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jeo_mart;

import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.jfree.chart.*;
import org.jfree.data.*;
import javax.swing.*;
import java.sql.*;
import org.jfree.data.category.DefaultCategoryDataset;


/**
 *
 * @author ASUS
 */
public class barchart_page extends javax.swing.JFrame {

    /**
     * Creates new form barchart_page
     */
    public barchart_page() {
        initComponents();
    }
  public static String decrypt(String encryptedcode , String secretkey) throws Exception
    {
        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec  secrectkeyspec = new SecretKeySpec(secretkey.getBytes(),"AES");
        cipher.init(Cipher.DECRYPT_MODE,secrectkeyspec);
        byte[] decodedbyte = Base64.getDecoder().decode(encryptedcode);
        byte[] encryptbyte = cipher.doFinal(decodedbyte);
        return new String(encryptbyte);
    }
    private final String SECRET_KEY = "1234567890123456";
    
    public ResultSet getDataFromDatabase() {
        ResultSet resultSet = null;
        try
        {
            Connection conn = JDBC.con();
            PreparedStatement pst = conn.prepareStatement("select product_name,price from jeomart_product_table");
             resultSet = pst.executeQuery();
        }
        
//          Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
//           Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=jeomart_billind_sys;user=SASIDHARAN-S;password=sasi");
            
           
          
        
          catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        return resultSet;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        close = new javax.swing.JButton();
        chart = new javax.swing.JButton();
        back = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BAR CHART PAGE");
        setMinimumSize(new java.awt.Dimension(747, 587));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel1.setText("BARCHART PAGE");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 15, -1, -1));

        close.setBackground(new java.awt.Color(255, 0, 0));
        close.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        close.setText("CLOSE");
        close.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });
        getContentPane().add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(476, 493, 128, 35));

        chart.setBackground(new java.awt.Color(0, 153, 255));
        chart.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        chart.setText("BAR CHART");
        chart.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        chart.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        chart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chartActionPerformed(evt);
            }
        });
        getContentPane().add(chart, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 493, 128, 35));

        back.setBackground(new java.awt.Color(255, 204, 0));
        back.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        back.setText("<- BACK");
        back.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(656, 21, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/background.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 590));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
       this.setVisible(false);
      new main_page().setVisible(true);
    }//GEN-LAST:event_backActionPerformed

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
       this.dispose();
    }//GEN-LAST:event_closeActionPerformed

    private void chartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chartActionPerformed
       DefaultCategoryDataset dataset = new DefaultCategoryDataset();
       try{
       ResultSet resultSet = getDataFromDatabase();
       JFreeChart barChart = ChartFactory.createBarChart(
       "Product VS Price",
               "Product",
               "Price",
               dataset
               );
       
       ChartPanel chartpanel = new ChartPanel(barChart);
       chartpanel.setPreferredSize(new java.awt.Dimension(200,200));
           setContentPane(chartpanel);
           
           while(resultSet.next())
           {
               String pname = resultSet.getString("product_name");
               double pprice = Double.parseDouble(decrypt(resultSet.getString("price"),SECRET_KEY));
               dataset.addValue(pprice,"Values" ,pname);
           }
           JOptionPane.showMessageDialog(this,"Bar Chart Generated");
       }
       catch(Exception e)
       {
           JOptionPane.showMessageDialog(this,e);
       }
    }//GEN-LAST:event_chartActionPerformed

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
            java.util.logging.Logger.getLogger(barchart_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(barchart_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(barchart_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(barchart_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new barchart_page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton chart;
    private javax.swing.JButton close;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
