
package tripsrecordsystem;

import config.dbConnector;
import config.passwordHasher;
import java.awt.Color;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class regForm extends javax.swing.JFrame {

   
    public regForm() {
        initComponents(); 
    }
    Color redd = new Color(198,20,17);
    Color shok = new Color(160,3,0);
    
    public static String dbemail, dbusername;
    
    
   public boolean duplicateCheck() {
    dbConnector dbc = new dbConnector();
    
    // Get the email from the input field
    String email = email1.getText();
    String contactnumber = cnumber.getText();
    
    // Validate that the email ends with @gmail.com
    if (!email.endsWith("@gmail.com")) {
        JOptionPane.showMessageDialog(null, "Email must end with @gmail.com");
        email1.setText(""); // Clear the email field
        return true; // Return true to indicate a validation error
    }
    if (!isValidContactNumber(contactnumber)) {
        JOptionPane.showMessageDialog(null, "Contact number must be an integer and only 11 digits.");
        cnumber.setText(""); // Clear the contact number field
       return true; // Return true to indicate a validation error
    }
    
    
    try {
        String query = "SELECT * FROM tbl_user WHERE u_username = ? OR u_email = ?";
        PreparedStatement preparedStatement = dbc.getConnection().prepareStatement(query);
        preparedStatement.setString(1, uname.getText());
        preparedStatement.setString(2, email);
        
        ResultSet resultSet = preparedStatement.executeQuery();
        
        if (resultSet.next()) {
            // Check for email duplication
            dbemail = resultSet.getString("u_email");
            if (dbemail.equals(email)) {
                JOptionPane.showMessageDialog(null, "Email is already Used!");
                email1.setText(""); // Clear the email field
                return true; // Return true to indicate a duplicate was found
            }
            
            // Check for username duplication
            dbusername = resultSet.getString("u_username");
            if (dbusername.equals(uname.getText())) {
                JOptionPane.showMessageDialog(null, "Username is already Used!");
                uname.setText(""); // Clear the username field
                return true; // Return true to indicate a duplicate was found
            }
        }
        
        return false; // No duplicates found
    } catch (SQLException ex) {
        System.out.println("" + ex);
        return false; // Return false in case of an exception
    }
}
   private boolean isValidContactNumber(String cnumber) {
    // Check if the contact number is a valid integer and has more than 11 digits
     if (cnumber.length() == 11) {
        try {
            Long.parseLong(cnumber); // This will throw an exception if cnumber is not a valid long
            return true; // Valid contact number
        } catch (NumberFormatException e) {
            return false; // Not a valid integer
        }
    }
    return false;
}

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jRegister = new javax.swing.JButton();
        jUserType = new javax.swing.JComboBox<>();
        uname = new javax.swing.JTextField();
        cnumber = new javax.swing.JTextField();
        email1 = new javax.swing.JTextField();
        CompleteName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        pword = new javax.swing.JPasswordField();
        pword2 = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(148, 22, 22));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 29, 29));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText(" TRUCKING CORP...");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 130, 10));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Century Schoolbook", 1, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("SHOOK ");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 160, 30));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rdm3_1.jpg"))); // NOI18N
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 200, 280));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Complete Name");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 90, 10));

        jRegister.setBackground(new java.awt.Color(160, 3, 0));
        jRegister.setForeground(new java.awt.Color(255, 255, 255));
        jRegister.setText("REGISTER");
        jRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jRegisterMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jRegisterMouseExited(evt);
            }
        });
        jRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRegisterActionPerformed(evt);
            }
        });
        jPanel2.add(jRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 240, 90, -1));

        jUserType.setBackground(new java.awt.Color(255, 51, 51));
        jUserType.setForeground(new java.awt.Color(255, 255, 255));
        jUserType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "USER", "ADMIN" }));
        jUserType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jUserTypeActionPerformed(evt);
            }
        });
        jPanel2.add(jUserType, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 140, -1));

        uname.setBackground(new java.awt.Color(215, 215, 215));
        jPanel2.add(uname, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 140, 30));

        cnumber.setBackground(new java.awt.Color(215, 215, 215));
        jPanel2.add(cnumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 140, 30));

        email1.setBackground(new java.awt.Color(215, 215, 215));
        jPanel2.add(email1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 140, 30));

        CompleteName.setBackground(new java.awt.Color(215, 215, 215));
        jPanel2.add(CompleteName, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 140, 30));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Email");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 30, 10));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Contact Number");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 90, 10));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Username");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, 10));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("User Type");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, -1, 10));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Password");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 60, 10));

        jLabel8.setBackground(new java.awt.Color(255, 102, 102));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/123.jpg"))); // NOI18N
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, 60, 30));

        jLabel9.setBackground(new java.awt.Color(115, 5, 5));
        jLabel9.setFont(new java.awt.Font("Stencil", 3, 10)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(128, 0, 0));
        jLabel9.setText("SHOOK TRUCKING");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 480, -1, -1));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Century Schoolbook", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("SHOOK TRUCKING");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 540, 200, 30));

        jButton1.setBackground(new java.awt.Color(160, 3, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Cancel");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("Confirm Password");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 110, 10));

        pword.setBackground(new java.awt.Color(215, 215, 215));
        pword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwordActionPerformed(evt);
            }
        });
        jPanel2.add(pword, new org.netbeans.lib.awtextra.AbsoluteConstraints(201, 30, 140, 30));

        pword2.setBackground(new java.awt.Color(215, 215, 215));
        pword2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pword2ActionPerformed(evt);
            }
        });
        jPanel2.add(pword2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 140, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 370, 280));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REGISTRATION FORM");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 10));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 340));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jUserTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jUserTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jUserTypeActionPerformed

    private void jRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRegisterActionPerformed
    
        
        

        if(CompleteName.getText().isEmpty()||email1.getText().isEmpty()||cnumber.getText().isEmpty()
            ||uname.getText().isEmpty()||pword.getText().isEmpty())

        {
            JOptionPane.showMessageDialog(null, "Fill apa ang wa na fill apan duh!");
        }else if(pword.getText().length()< 8){
            JOptionPane.showMessageDialog(null, "Password character should be 8 above");
            pword.setText("");

        } else if (!pword.getText().equals(pword2.getText())) {
            JOptionPane.showMessageDialog(null, "Passwords do not match.");
            pword.setText("");
            pword2.setText("");
        }
        
        
        else if(duplicateCheck()){
            System.out.println("Duplicate Exist");

        }

        else{

            dbConnector dbc=new dbConnector();
            
            try{
            String pass = passwordHasher.hashPassword(pword.getText());
            if(dbc.insertData("INSERT INTO tbl_user(u_name, u_email, u_number, u_username, u_password, u_status, u_type) "
                + "VALUES('"+CompleteName.getText()+"','"+email1.getText()+"','"+cnumber.getText()+"','"+uname.getText()+"','"+pass+"','PENDING','"+jUserType.getSelectedItem()+"')"))
        {
            JOptionPane.showMessageDialog(null, "Inserted Successfully");
            loginForm lfr=new loginForm();
            lfr.setVisible(true);
            this.dispose();

        }else{
            JOptionPane.showMessageDialog(null, "Connection Error!");

        }

        }catch(NoSuchAlgorithmException ex){
            System.out.println(""+ex);
        }
   }

    }//GEN-LAST:event_jRegisterActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        loginForm lgf = new loginForm();
        lgf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        jButton1.setBackground(redd);
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        jButton1.setBackground(shok);
    }//GEN-LAST:event_jButton1MouseExited

    private void jRegisterMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRegisterMouseEntered
        jRegister.setBackground(redd);
    }//GEN-LAST:event_jRegisterMouseEntered

    private void jRegisterMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRegisterMouseExited
       jRegister.setBackground(shok);
    }//GEN-LAST:event_jRegisterMouseExited

    private void pwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pwordActionPerformed

    private void pword2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pword2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pword2ActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(regForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new regForm().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CompleteName;
    private javax.swing.JTextField cnumber;
    private javax.swing.JTextField email1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jRegister;
    private javax.swing.JComboBox<String> jUserType;
    private javax.swing.JPasswordField pword;
    private javax.swing.JPasswordField pword2;
    private javax.swing.JTextField uname;
    // End of variables declaration//GEN-END:variables
}
