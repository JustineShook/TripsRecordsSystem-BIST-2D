/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import config.Logs;
import config.Session;
import config.dbConnector;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;
import tripsrecordsystem.loginForm;


public class usersForm extends javax.swing.JFrame {

    /**
     * Creates new form adminDashboard
     */
    public usersForm() {
        initComponents();
        displayData();
 
    }
    
    Color shok = new Color(160,3,0);
    Color redd = new Color(198,20,17);
    
    
    
    public void displayData(){
        try{
            dbConnector dbc = new dbConnector();
            ResultSet rs;
            rs = dbc.getData("SELECT * FROM tbl_user");
            usersTable.setModel(DbUtils.resultSetToTableModel(rs));
             rs.close();
        }catch(SQLException ex){
            System.out.println("Errors: "+ex.getMessage());
        
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

        jPanel1 = new javax.swing.JPanel();
        BackPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        p_add = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        UserID = new javax.swing.JLabel();
        DELETE = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        p_edit = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        usersTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 29, 29));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BackPanel.setBackground(new java.awt.Color(160, 3, 0));
        BackPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BackPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BackPanelMouseExited(evt);
            }
        });
        BackPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("BACK");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        BackPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 10));

        jPanel1.add(BackPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 0, 50, 30));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("USERS FORM");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, 10));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 30));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        p_add.setBackground(new java.awt.Color(160, 3, 0));
        p_add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p_addMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                p_addMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                p_addMouseExited(evt);
            }
        });
        p_add.setLayout(null);

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 153, 153));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("ADD");
        p_add.add(jLabel11);
        jLabel11.setBounds(0, 10, 120, 17);

        jPanel2.add(p_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 120, 40));

        UserID.setBackground(new java.awt.Color(0, 0, 0));
        UserID.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        UserID.setForeground(new java.awt.Color(153, 153, 153));
        UserID.setText("ID");
        jPanel2.add(UserID, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, 30, -1));

        DELETE.setBackground(new java.awt.Color(160, 3, 0));
        DELETE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DELETEMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DELETEMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DELETEMouseExited(evt);
            }
        });
        DELETE.setLayout(null);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 153, 153));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("DELETE");
        DELETE.add(jLabel9);
        jLabel9.setBounds(0, 10, 120, 17);

        jPanel2.add(DELETE, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 120, 40));

        p_edit.setBackground(new java.awt.Color(160, 3, 0));
        p_edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p_editMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                p_editMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                p_editMouseExited(evt);
            }
        });
        p_edit.setLayout(null);

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 153, 153));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("UPDATE");
        p_edit.add(jLabel10);
        jLabel10.setBounds(0, 10, 120, 17);

        jPanel2.add(p_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 120, 40));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("Current User :");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 70, -1));

        jPanel4.setBackground(new java.awt.Color(255, 0, 0));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user.png"))); // NOI18N
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 120, 90));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("USER");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 120, -1));

        jPanel4.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, -1));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 140, 130));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/login-background.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 380));

        jScrollPane1.setViewportView(usersTable);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 820, 340));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 990, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
         adminDashboard ads=new adminDashboard();
            ads.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        Session sess = Session.getInstance();
        if(sess.getUid()==0){ 
            JOptionPane.showMessageDialog(null, "No Account, Login First");
            loginForm lgf = new loginForm();
            lgf.setVisible(true);
            this.dispose();
        }else{
            UserID.setText(""+sess.getUid());
    
        }
       
        
    }//GEN-LAST:event_formWindowActivated

    private void p_addMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_addMouseEntered
        p_add.setBackground(redd);   
    }//GEN-LAST:event_p_addMouseEntered

    private void p_addMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_addMouseExited
     
        p_add.setBackground(shok);
    }//GEN-LAST:event_p_addMouseExited

    private void BackPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackPanelMouseEntered
        BackPanel.setBackground(redd);
    }//GEN-LAST:event_BackPanelMouseEntered

    private void BackPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackPanelMouseExited
        BackPanel.setBackground(shok);
    }//GEN-LAST:event_BackPanelMouseExited

    private void p_addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_addMouseClicked
       CreateUserForm cuf =new CreateUserForm();
        cuf.setVisible(true);
        cuf.remove.setEnabled(false);
        cuf.select.setEnabled(true);
        this.dispose();
    }//GEN-LAST:event_p_addMouseClicked

    private void p_editMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_editMouseClicked
        int rowIndex = usersTable.getSelectedRow();
        
        if(rowIndex<0){
            JOptionPane.showMessageDialog(null, "Please select Item!");
        }else{
          
            
            try{
            dbConnector dbc = new dbConnector();
            TableModel tbl = usersTable.getModel();
            ResultSet rs = dbc.getData("SELECT*FROM tbl_user WHERE u_id = '"+tbl.getValueAt(rowIndex, 0)+"'");
            if(rs.next()){
                CreateUserForm crf = new CreateUserForm();
                crf.uID.setText(""+rs.getInt("u_id"));
                crf.CompleteName.setText(""+rs.getString("u_name"));
                crf.uname.setText(""+rs.getString("u_username"));
                crf.pword.setText(""+rs.getString("u_password"));
                crf.pword1.setText(""+rs.getString("u_password"));
                crf.email.setText(""+rs.getString("u_email"));
                crf.cnumber.setText(""+rs.getString("u_number"));
                crf.jUserStatus.setSelectedItem(""+rs.getString("u_status"));
                crf.jUserType.setSelectedItem(""+rs.getString("u_type"));
                crf.image.setIcon(crf.ResizeImage(rs.getString("u_image"), null, crf.image));
                crf.oldpath = rs.getString("u_image");
                crf.path = rs.getString("u_image");
                crf.destination = rs.getString("u_image");
                crf.addB.setEnabled(false);
                crf.UpdateB.setEnabled(true);
                crf.setVisible(true);
                
                if(rs.getString("u_image").isEmpty()){
                 crf.select.setEnabled(true);
                 crf.remove.setEnabled(false);
                }else{
                 crf.select.setEnabled(false);
                 crf.remove.setEnabled(true);
                }
                
                this.dispose();
            }
            }catch(SQLException ex){  
              System.out.println(""+ex);
            }
        
        }
    
        
    }//GEN-LAST:event_p_editMouseClicked

    private void p_editMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_editMouseEntered
        p_edit.setBackground(redd);
    }//GEN-LAST:event_p_editMouseEntered

    private void p_editMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_editMouseExited
        p_edit.setBackground(shok);
    }//GEN-LAST:event_p_editMouseExited

    private void BackPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackPanelMouseClicked
        adminDashboard ads=new adminDashboard();
        ads.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackPanelMouseClicked

    private void DELETEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DELETEMouseClicked
      int rowIndex = usersTable.getSelectedRow();

if (rowIndex < 0) {
    JOptionPane.showMessageDialog(null, "Please select a user to delete!");
} else {
    int confirm = JOptionPane.showConfirmDialog(null, 
        "Are you sure you want to delete this user?", 
        "Confirm Delete", 
        JOptionPane.YES_NO_OPTION);

    if (confirm == JOptionPane.YES_OPTION) {
        TableModel tbl = usersTable.getModel();
        String userId = tbl.getValueAt(rowIndex, 0).toString();   // Assuming u_id is column 0
        String userName = tbl.getValueAt(rowIndex, 1).toString(); // Assuming u_name is column 1

        try {
            dbConnector dbc = new dbConnector();
            String sql = "DELETE FROM tbl_user WHERE u_id = ?";
            PreparedStatement pst = dbc.getConnection().prepareStatement(sql);
            pst.setString(1, userId);

            int result = pst.executeUpdate();

            if (result > 0) {
                JOptionPane.showMessageDialog(null, "User deleted successfully.");

                // Remove from table model to update UI
               ((DefaultTableModel) usersTable.getModel()).removeRow(rowIndex);
                // Logging
                Session session = Session.getInstance();
                int currentUserId = session.getUid();
                String currentUserName = session.getCname();
                String action = ("Admin Deleted a User Account successfully");
                Logs.logFunctionCall(currentUserId, currentUserName, action);

            } else {
                JOptionPane.showMessageDialog(null, "User not found or could not be deleted.");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error deleting user: " + ex.getMessage());
        }
    }
}
    }//GEN-LAST:event_DELETEMouseClicked

    private void DELETEMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DELETEMouseEntered
          DELETE.setBackground(redd);
    }//GEN-LAST:event_DELETEMouseEntered

    private void DELETEMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DELETEMouseExited
         DELETE.setBackground(shok);
    }//GEN-LAST:event_DELETEMouseExited
     
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
            java.util.logging.Logger.getLogger(usersForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(usersForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(usersForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(usersForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new usersForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BackPanel;
    private javax.swing.JPanel DELETE;
    private javax.swing.JLabel UserID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel p_add;
    private javax.swing.JPanel p_edit;
    private javax.swing.JTable usersTable;
    // End of variables declaration//GEN-END:variables
}
