/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import admin.*;
import config.Logs;
import config.Session;
import config.dbConnector;
import java.awt.Image;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import config.Session;
import config.dbConnector;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
/**
 *
 * @author mypc
 */
public class AccountUpdate1 extends javax.swing.JFrame {
    
    private String currentImagePath = "";
    public void setAccountDetails(String name, String emailVal, String contact, 
                               String user, String type, String status, String imgPath) {
    fullname.setText(name);
    email.setText(emailVal);
    contactnumber.setText(contact);
    

    if (imgPath != null && !imgPath.isEmpty()) {
        ImageIcon icon = new ImageIcon(imgPath);
        Image scaled = icon.getImage().getScaledInstance(
            aimage.getWidth(), aimage.getHeight(), Image.SCALE_SMOOTH
        );
        aimage.setIcon(new ImageIcon(scaled));
    }
}

    /**
     * Creates new form AccountUpdate
     */
    public AccountUpdate1() {
        initComponents();
        setLocationRelativeTo(null);
        
    }
    
    public String destination = "";
    File selectedFile;
    public String oldpath;
    public String path;
    
    public void setAccountData(String name, String emailVal, String contact,
                                String user, String type, String status, String imgPath) {
        fullname.setText(name);
        email.setText(emailVal);
        contactnumber.setText(contact);
        oldpath = (imgPath != null) ? imgPath : ""; // ← never null
        destination = ""; // ← reset destination each time form loads

        if (imgPath != null && !imgPath.isEmpty()) {
            ImageIcon icon = ResizeImage(imgPath, null, aimage);
            aimage.setIcon(icon);
        }
    }
    
    public int FileExistenceChecker(String path){
        File file = new File(path);
        String fileName = file.getName();
        
        Path filePath = Paths.get("src/userimages", fileName);
        boolean fileExists = Files.exists(filePath);
        
        if (fileExists) {
            return 1;
        } else {
            return 0;
        }
    
    }
    
    public static int getHeightFromWidth(String imagePath, int desiredWidth) {
        try {
            // Read the image file
            File imageFile = new File(imagePath);
            BufferedImage image = ImageIO.read(imageFile);
            
            // Get the original width and height of the image
            int originalWidth = image.getWidth();
            int originalHeight = image.getHeight();
            
            // Calculate the new height based on the desired width and the aspect ratio
            int newHeight = (int) ((double) desiredWidth / originalWidth * originalHeight);
            
            return newHeight;
        } catch (IOException ex) {
            System.out.println("No image found!");
        }
        
        return -1;
    }
    
    public  ImageIcon ResizeImage(String ImagePath, byte[] pic, JLabel label) {
    ImageIcon MyImage = null;
        if(ImagePath !=null){
            MyImage = new ImageIcon(ImagePath);
        }else{
            MyImage = new ImageIcon(pic);
        }
        
    int newHeight = getHeightFromWidth(ImagePath, label.getWidth());

    Image img = MyImage.getImage();
    Image newImg = img.getScaledInstance(label.getWidth(), newHeight, Image.SCALE_SMOOTH);
    ImageIcon image = new ImageIcon(newImg);
    return image;
}
     public void imageUpdater(String existingFilePath, String newFilePath){
        File existingFile = new File(existingFilePath);
        if (existingFile.exists()) {
            String parentDirectory = existingFile.getParent();
            File newFile = new File(newFilePath);
            String newFileName = newFile.getName();
            File updatedFile = new File(parentDirectory, newFileName);
            existingFile.delete();
            try {
                Files.copy(newFile.toPath(), updatedFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Image updated successfully.");
            } catch (IOException e) {
                System.out.println("Error occurred while updating the image: "+e);
            }
        } else {
            try{
                Files.copy(selectedFile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);
            }catch(IOException e){
                System.out.println("Error on update!");
            }
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

        page = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jPanel14 = new javax.swing.JPanel();
        aimage = new javax.swing.JLabel();
        TruckID = new javax.swing.JLabel();
        update1 = new javax.swing.JButton();
        upload = new javax.swing.JButton();
        remove = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        update = new javax.swing.JButton();
        fullname = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        contactnumber = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        page.setBackground(new java.awt.Color(255, 255, 255));
        page.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel7.setText("Full Name               :");
        page.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, 100, -1));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel9.setText("Email                      :");
        page.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, 100, -1));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel11.setText("Contact Number     :");
        page.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, 110, -1));

        jLabel10.setBackground(new java.awt.Color(255, 102, 102));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/123.jpg"))); // NOI18N
        page.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 60, 30));

        jLabel12.setBackground(new java.awt.Color(255, 102, 102));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/123.jpg"))); // NOI18N
        page.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 60, 30));
        page.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, 280, 10));
        page.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 560, 12));
        page.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 570, 20));

        jLabel4.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Account Details");
        page.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 440, 25));
        page.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 560, 12));

        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel14.add(aimage, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 240, 210));

        TruckID.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        TruckID.setText(" ");
        jPanel14.add(TruckID, new org.netbeans.lib.awtextra.AbsoluteConstraints(-120, 70, 140, -1));

        update1.setBackground(new java.awt.Color(0, 51, 204));
        update1.setForeground(new java.awt.Color(255, 255, 255));
        update1.setText("Update");
        update1.setEnabled(false);
        update1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                update1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                update1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                update1MouseExited(evt);
            }
        });
        update1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update1ActionPerformed(evt);
            }
        });
        jPanel14.add(update1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 100, 40));

        upload.setBackground(new java.awt.Color(0, 51, 204));
        upload.setForeground(new java.awt.Color(255, 255, 255));
        upload.setText("Upload");
        upload.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                uploadMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                uploadMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                uploadMouseExited(evt);
            }
        });
        upload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadActionPerformed(evt);
            }
        });
        jPanel14.add(upload, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 100, 40));

        remove.setBackground(new java.awt.Color(204, 0, 0));
        remove.setForeground(new java.awt.Color(255, 255, 255));
        remove.setText("Remove");
        remove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                removeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                removeMouseExited(evt);
            }
        });
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });
        jPanel14.add(remove, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 100, 40));

        page.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 260, 280));

        cancel.setBackground(new java.awt.Color(255, 0, 0));
        cancel.setForeground(new java.awt.Color(255, 255, 255));
        cancel.setText("Back");
        cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cancelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cancelMouseExited(evt);
            }
        });
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        page.add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 390, 100, 40));

        update.setBackground(new java.awt.Color(51, 255, 51));
        update.setForeground(new java.awt.Color(102, 102, 102));
        update.setText("Update");
        update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                updateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                updateMouseExited(evt);
            }
        });
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        page.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 100, 40));

        fullname.setBackground(new java.awt.Color(215, 215, 215));
        fullname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fullnameActionPerformed(evt);
            }
        });
        page.add(fullname, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, 140, 30));

        email.setBackground(new java.awt.Color(215, 215, 215));
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        page.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, 140, 30));

        contactnumber.setBackground(new java.awt.Color(215, 215, 215));
        page.add(contactnumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 140, 140, 30));

        getContentPane().add(page, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void uploadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uploadMouseClicked

    }//GEN-LAST:event_uploadMouseClicked

    private void uploadMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uploadMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_uploadMouseEntered

    private void uploadMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uploadMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_uploadMouseExited

    private void uploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadActionPerformed
         JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    try {
                        selectedFile = fileChooser.getSelectedFile();
                        destination = "src/userimages/" + selectedFile.getName();
                        path  = selectedFile.getAbsolutePath();
                        
                        
                        if(FileExistenceChecker(path) == 1){
                          JOptionPane.showMessageDialog(null, "File Already Exist, Rename or Choose another!");
                            destination = "";
                            path="";
                        }else{
                            aimage.setIcon(ResizeImage(path, null, aimage));
                            remove.setEnabled(true);
                         
                        }
                    } catch (Exception ex) {
                        System.out.println("File Error!");
                    }
                }
    }//GEN-LAST:event_uploadActionPerformed

    private void cancelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelMouseEntered

    private void cancelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelMouseExited

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        try {
        Session session = Session.getInstance();
        dbConnector dbc = new dbConnector();
        String sql = "SELECT * FROM tbl_user WHERE u_id = ?";
        PreparedStatement pst = dbc.getConnection().prepareStatement(sql);
        pst.setInt(1, session.getUid());
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            AccountDetails_1 ad = new AccountDetails_1();
            ad.setAccountDetails(
                rs.getString("u_name"),
                rs.getString("u_email"),
                rs.getString("u_number"),
                rs.getString("u_username"),
                rs.getString("u_type"),
                rs.getString("u_status"),
                rs.getString("u_image")
            );
            ad.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "User not found!");
        }

        rs.close();
        pst.close();
        dbc.close();

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage());
    }

    }//GEN-LAST:event_cancelActionPerformed

    private void update1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_update1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_update1MouseClicked

    private void update1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_update1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_update1MouseEntered

    private void update1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_update1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_update1MouseExited

    private void update1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_update1ActionPerformed

    private void updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_updateMouseClicked

    private void updateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_updateMouseEntered

    private void updateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_updateMouseExited

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
       if (fullname.getText().isEmpty() || email.getText().isEmpty() || contactnumber.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Fill apa ang wa na fill apan duh!");
    } else {
        try {
            Session session = Session.getInstance();
            dbConnector dbc = new dbConnector();

            // Determine final image path
            String finalImagePath = destination.isEmpty() ? oldpath : destination;

            PreparedStatement pst;
            String sql = "UPDATE tbl_user SET u_name = ?, u_email = ?, u_number = ?, u_image = ? WHERE u_id = ?";
            pst = dbc.getConnection().prepareStatement(sql);
            pst.setString(1, fullname.getText());
            pst.setString(2, email.getText());
            pst.setString(3, contactnumber.getText());
            pst.setString(4, finalImagePath);
            pst.setInt(5, session.getUid());

            int rows = pst.executeUpdate();

            if (rows > 0) {
                // Handle image file update
                if (!destination.isEmpty()) {
                    if (!(oldpath.equals(destination))) {
                        imageUpdater(oldpath, path);
                    }
                }

                // Log the action
                String userFullname = session.getCname();
                String action = "Updated User Account: " + fullname.getText();
                Logs.logFunctionCall(session.getUid(), userFullname, action);

                JOptionPane.showMessageDialog(null, "Account updated successfully!");

                // Go back to AccountDetails with refreshed data
                AccountDetails_1 ad = new AccountDetails_1();
                String sqlSelect = "SELECT * FROM tbl_user WHERE u_id = ?";
                PreparedStatement pst2 = dbc.getConnection().prepareStatement(sqlSelect);
                pst2.setInt(1, session.getUid());
                ResultSet rs = pst2.executeQuery();

                if (rs.next()) {
                    ad.setAccountDetails(
                        rs.getString("u_name"),
                        rs.getString("u_email"),
                        rs.getString("u_number"),
                        rs.getString("u_username"),
                        rs.getString("u_type"),
                        rs.getString("u_status"),
                        rs.getString("u_image")
                    );
                }

                rs.close();
                pst2.close();
                pst.close();
                dbc.close();

                ad.setVisible(true);
                this.dispose();

            } else {
                JOptionPane.showMessageDialog(null, "Update failed!");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage());
        }
    }


    }//GEN-LAST:event_updateActionPerformed

    private void removeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_removeMouseClicked

    private void removeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_removeMouseEntered

    private void removeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_removeMouseExited

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
      remove.setEnabled(false);

        aimage.setIcon(null);
        destination = "";
        path = "";
    }//GEN-LAST:event_removeActionPerformed

    private void fullnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fullnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fullnameActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

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
            java.util.logging.Logger.getLogger(AccountUpdate1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AccountUpdate1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AccountUpdate1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AccountUpdate1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AccountUpdate1().setVisible(true);
            }
        });
    }

    void setAccountUpdate(String text, String text0, String text1, String currentImagePath) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel TruckID;
    public javax.swing.JLabel aimage;
    public javax.swing.JButton cancel;
    private javax.swing.JTextField contactnumber;
    private javax.swing.JTextField email;
    private javax.swing.JTextField fullname;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JPanel page;
    public javax.swing.JButton remove;
    public javax.swing.JButton update;
    public javax.swing.JButton update1;
    public javax.swing.JButton upload;
    // End of variables declaration//GEN-END:variables
}
