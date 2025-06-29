/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jeo_mart;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class otp extends javax.swing.JFrame {

    /**
     * Creates new form otp
     */
    public otp() {
        initComponents();
    }
    
    public void sentopt(String reciptentEmail,String otp)
    {
        String smailid = smail.getText();
        String senderpwd = pwd.getText();
         Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true");

      
 Session session;
        session = Session.getInstance(props, 
                new javax.mail.Authenticator() {
                 protected javax.mail.PasswordAuthentication getPasswordAuthentication()
                 {
                     return new javax.mail.PasswordAuthentication(smailid,senderpwd);
                 }
                    
                    }
        );
        
        try {

            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(smailid));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(reciptentEmail));
            msg.setSubject("Your OTP code");

             msg.setText("Your OTP :"+otp);

            Transport.send(msg);

            JOptionPane.showMessageDialog(this, "OTP sent successfully");

        } catch (MessagingException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());}

    }
    private String generateOPT()
    {
        int otp1 = (int)(Math.random()*900000+100000);
        return String.valueOf(otp1);
    }
    private String generatedotp;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        clear = new javax.swing.JButton();
        back = new javax.swing.JButton();
        match = new javax.swing.JButton();
        sendotp = new javax.swing.JButton();
        close = new javax.swing.JButton();
        smail = new javax.swing.JTextField();
        pwd = new javax.swing.JTextField();
        rmail = new javax.swing.JTextField();
        otp = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("OTP");
        setMinimumSize(new java.awt.Dimension(661, 522));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("OTP(via Email)");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(266, 6, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("SENDER MAIL ID :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("PASSWORD :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("RECIVER MAIL ID :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("OTP :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 340, -1, -1));

        clear.setBackground(new java.awt.Color(255, 204, 0));
        clear.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        clear.setText("CLEAR");
        clear.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        clear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        getContentPane().add(clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(339, 428, 109, 32));

        back.setBackground(new java.awt.Color(255, 204, 0));
        back.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        back.setText("<-BACK");
        back.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(595, 6, -1, -1));

        match.setBackground(new java.awt.Color(255, 255, 51));
        match.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        match.setText("MATCH");
        match.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        match.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        match.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matchActionPerformed(evt);
            }
        });
        getContentPane().add(match, new org.netbeans.lib.awtextra.AbsoluteConstraints(212, 428, 109, 32));

        sendotp.setBackground(new java.awt.Color(255, 255, 51));
        sendotp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        sendotp.setText("SEND OTP");
        sendotp.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        sendotp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sendotp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendotpActionPerformed(evt);
            }
        });
        getContentPane().add(sendotp, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 428, 109, 32));

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
        getContentPane().add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(466, 428, 109, 32));

        smail.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        getContentPane().add(smail, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 230, 32));

        pwd.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        getContentPane().add(pwd, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, 230, 32));

        rmail.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        getContentPane().add(rmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, 230, 32));

        otp.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        otp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                otpActionPerformed(evt);
            }
        });
        getContentPane().add(otp, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 340, 230, 32));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/background.jpg"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 520));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void otpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_otpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_otpActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
       this.setVisible(false);
       new otp().setVisible(true);
    }//GEN-LAST:event_clearActionPerformed

    private void sendotpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendotpActionPerformed
       String em = rmail.getText();
        String regex = "^[a-zA-Z0-9]+(?:\\.[a-zA-Z0-9 ]+)*@(?:[a-z]+\\.)+[a-z]{2,3}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(em);
        if (matcher.matches()) {
            JOptionPane.showMessageDialog(this, " Valid Email");
        } else {
            JOptionPane.showMessageDialog(this, " Invalid Email");
        }
        if(!em.isEmpty())
        {
            generatedotp = generateOPT();
            sentopt(em, generatedotp);
               JOptionPane.showMessageDialog(this,"OTP sent to"+em);
        }
        else
        {
         JOptionPane.showMessageDialog(this,"Enter Valid Email ID");   
        }
    }//GEN-LAST:event_sendotpActionPerformed

    private void matchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matchActionPerformed
       String enteredotp = otp.getText();
       if(enteredotp.equals(generatedotp))
       {
           JOptionPane.showMessageDialog(this,"OTP Verified");
           
           this.setVisible(false);
           new main_page().setVisible(true);
       }
       else
       {
           JOptionPane.showMessageDialog(this,"Invalid OTP");
       
       }
    }//GEN-LAST:event_matchActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
       this.setVisible(false);
     new main_page().setVisible(true);
    }//GEN-LAST:event_backActionPerformed

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
       this.dispose();
    }//GEN-LAST:event_closeActionPerformed

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
            java.util.logging.Logger.getLogger(otp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(otp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(otp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(otp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new otp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton clear;
    private javax.swing.JButton close;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton match;
    private javax.swing.JTextField otp;
    private javax.swing.JTextField pwd;
    private javax.swing.JTextField rmail;
    private javax.swing.JButton sendotp;
    private javax.swing.JTextField smail;
    // End of variables declaration//GEN-END:variables
}
