    
package user;

import admin.*;
import config.Session;
import config.dbConnector;
import java.awt.Color;
import java.awt.Image;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static tripsrecordsystem.regForm.dbemail;


/**
 *
 * @author mypc
 */
public class CreateTripsForm extends javax.swing.JFrame {

    /**
     * Creates new form AdminRegForm
     */
    public CreateTripsForm() {
        initComponents();
    }
    
    
    
    
    Color shok = new Color(160,3,0);
    Color redd = new Color(198,20,17);
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        addB = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        Cancelbutton = new javax.swing.JButton();
        Clearb = new javax.swing.JButton();
        DeleteB = new javax.swing.JButton();
        UpdateB = new javax.swing.JButton();
        Refresh = new javax.swing.JButton();
        TruckID = new javax.swing.JTextField();
        description = new javax.swing.JTextField();
        weight = new javax.swing.JTextField();
        start = new javax.swing.JTextField();
        end = new javax.swing.JTextField();
        depart = new javax.swing.JTextField();
        arrival = new javax.swing.JTextField();
        distance = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        TripStatus = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        DriverID = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        Drivertripadd = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        userID = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 29, 29));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText(" TRUCKING CORP...");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 130, 10));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Century Schoolbook", 1, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("SHOOK ");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 160, 30));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rdm3_1.jpg"))); // NOI18N
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 200, 430));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addB.setBackground(new java.awt.Color(198, 20, 17));
        addB.setForeground(new java.awt.Color(255, 255, 255));
        addB.setText("Add");
        addB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addBMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addBMouseExited(evt);
            }
        });
        addB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBActionPerformed(evt);
            }
        });
        jPanel2.add(addB, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 80, -1));

        jLabel8.setBackground(new java.awt.Color(255, 102, 102));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/123.jpg"))); // NOI18N
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, 60, 30));

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

        Cancelbutton.setBackground(new java.awt.Color(198, 20, 17));
        Cancelbutton.setForeground(new java.awt.Color(255, 255, 255));
        Cancelbutton.setText("Cancel");
        Cancelbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CancelbuttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CancelbuttonMouseExited(evt);
            }
        });
        Cancelbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelbuttonActionPerformed(evt);
            }
        });
        jPanel2.add(Cancelbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 80, -1));

        Clearb.setBackground(new java.awt.Color(198, 20, 17));
        Clearb.setForeground(new java.awt.Color(255, 255, 255));
        Clearb.setText("Clear");
        Clearb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ClearbMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ClearbMouseExited(evt);
            }
        });
        Clearb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearbActionPerformed(evt);
            }
        });
        jPanel2.add(Clearb, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 80, -1));

        DeleteB.setBackground(new java.awt.Color(198, 20, 17));
        DeleteB.setForeground(new java.awt.Color(255, 255, 255));
        DeleteB.setText("Delete");
        DeleteB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DeleteBMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DeleteBMouseExited(evt);
            }
        });
        DeleteB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBActionPerformed(evt);
            }
        });
        jPanel2.add(DeleteB, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 80, -1));

        UpdateB.setBackground(new java.awt.Color(198, 20, 17));
        UpdateB.setForeground(new java.awt.Color(255, 255, 255));
        UpdateB.setText("Update");
        UpdateB.setEnabled(false);
        UpdateB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                UpdateBMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                UpdateBMouseExited(evt);
            }
        });
        UpdateB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateBActionPerformed(evt);
            }
        });
        jPanel2.add(UpdateB, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 80, -1));

        Refresh.setBackground(new java.awt.Color(198, 20, 17));
        Refresh.setForeground(new java.awt.Color(255, 255, 255));
        Refresh.setText("Refresh");
        Refresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RefreshMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RefreshMouseExited(evt);
            }
        });
        Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshActionPerformed(evt);
            }
        });
        jPanel2.add(Refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 80, -1));

        TruckID.setBackground(new java.awt.Color(204, 204, 204));
        TruckID.setEnabled(false);
        jPanel2.add(TruckID, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 100, 30));

        description.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.add(description, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 130, 30));

        weight.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.add(weight, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 130, 30));

        start.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.add(start, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 200, 30));

        end.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.add(end, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 200, 30));

        depart.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.add(depart, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 130, 30));

        arrival.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.add(arrival, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 130, 30));

        distance.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.add(distance, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 130, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel3.setText("STATUS");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, 130, 10));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel6.setText("DESCRIPTION ");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 130, 10));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel7.setText("WEIGHT ");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 130, 10));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel10.setText("START LOCATION");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 150, 10));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel15.setText("END LOCATION ");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 140, 10));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel17.setText("DEPARTURE DATE ");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 160, 10));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel18.setText("ARRIVAL DATE ");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 130, 10));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel19.setText("DISTANCE");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 130, 10));

        TripStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SUCCESSFUL", "PENDING" }));
        jPanel2.add(TripStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 130, 30));

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-add-24.png"))); // NOI18N
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 110, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel21.setText("PLATE NUMBER");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 220, 10));

        DriverID.setBackground(new java.awt.Color(204, 204, 204));
        DriverID.setEnabled(false);
        jPanel2.add(DriverID, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 100, 30));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel16.setText("DRIVER'S NAME");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 220, 10));

        Drivertripadd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Drivertripadd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-add-24.png"))); // NOI18N
        Drivertripadd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DrivertripaddMouseClicked(evt);
            }
        });
        jPanel2.add(Drivertripadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 110, -1));

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-add-24.png"))); // NOI18N
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 110, -1));

        userID.setBackground(new java.awt.Color(204, 204, 204));
        userID.setEnabled(false);
        jPanel2.add(userID, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 100, 30));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel23.setText("USER'S ID ");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 220, 10));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 380, 430));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ADMIN CREATE/ADD DRIVER FORM");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 10));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBActionPerformed
      Session sess = Session.getInstance();
        if(TruckID.getText().isEmpty()||DriverID.getText().isEmpty()||userID.getText().isEmpty()
            ||description.getText().isEmpty()||weight.getText().isEmpty()||start.getText().isEmpty()
              ||end.getText().isEmpty()||depart.getText().isEmpty()
              ||arrival.getText().isEmpty()||distance.getText().isEmpty())

        {
            JOptionPane.showMessageDialog(null, "Fill apa ang wa na fill apan duh!");
        }else{
          dbConnector dbc=new dbConnector(); if(dbc.insertData("INSERT INTO tbl_trip(driver_id , truck_id , u_id , description, weight, start_location, end_location, departure_date, arrival_date, distance, status) "
                + "VALUES('"+DriverID.getText()+"', '"+TruckID.getText()+"','"+userID.getText()+"','"+description.getText()+"' '"+weight.getText()+"', '"+start.getText()+"',"
                        + "'"+end.getText()+"', '"+depart.getText()+"','"+arrival.getText()+"', '"+distance.getText()+"', '"+TripStatus.getSelectedItem()+"')"));
       
      }
        
       
       
    }//GEN-LAST:event_addBActionPerformed

    private void CancelbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelbuttonActionPerformed
        usersForm uf =new usersForm();
        uf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CancelbuttonActionPerformed

    private void CancelbuttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelbuttonMouseEntered
        Cancelbutton.setBackground(redd);
    }//GEN-LAST:event_CancelbuttonMouseEntered

    private void CancelbuttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelbuttonMouseExited
        Cancelbutton.setBackground(shok);
    }//GEN-LAST:event_CancelbuttonMouseExited

    private void addBMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBMouseEntered
        addB.setBackground(redd);
    }//GEN-LAST:event_addBMouseEntered

    private void addBMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBMouseExited
        addB.setBackground(shok);
    }//GEN-LAST:event_addBMouseExited

    private void ClearbMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearbMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_ClearbMouseEntered

    private void ClearbMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearbMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_ClearbMouseExited

    private void ClearbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ClearbActionPerformed

    private void DeleteBMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteBMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_DeleteBMouseEntered

    private void DeleteBMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteBMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_DeleteBMouseExited

    private void DeleteBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DeleteBActionPerformed

    private void UpdateBMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateBMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateBMouseEntered

    private void UpdateBMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateBMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateBMouseExited

    private void UpdateBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateBActionPerformed
        
    }//GEN-LAST:event_UpdateBActionPerformed

    private void RefreshMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RefreshMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_RefreshMouseEntered

    private void RefreshMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RefreshMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_RefreshMouseExited

    private void RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RefreshActionPerformed

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        this.dispose();
        truckTable tt = new truckTable();
        tt.setVisible(true);
    }//GEN-LAST:event_jLabel20MouseClicked

    private void DrivertripaddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DrivertripaddMouseClicked
        this.dispose();
        DriverTable dt = new DriverTable();
        dt.setVisible(true);
    }//GEN-LAST:event_DrivertripaddMouseClicked

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
       this.dispose();
        userTable uf = new userTable();
        uf.setVisible(true);
    }//GEN-LAST:event_jLabel22MouseClicked

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
            java.util.logging.Logger.getLogger(CreateTripsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateTripsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateTripsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateTripsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateTripsForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancelbutton;
    private javax.swing.JButton Clearb;
    private javax.swing.JButton DeleteB;
    public javax.swing.JTextField DriverID;
    private javax.swing.JLabel Drivertripadd;
    private javax.swing.JButton Refresh;
    private javax.swing.JComboBox<String> TripStatus;
    public javax.swing.JTextField TruckID;
    public javax.swing.JButton UpdateB;
    public javax.swing.JButton addB;
    private javax.swing.JTextField arrival;
    private javax.swing.JTextField depart;
    private javax.swing.JTextField description;
    private javax.swing.JTextField distance;
    private javax.swing.JTextField end;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField start;
    public javax.swing.JTextField userID;
    private javax.swing.JTextField weight;
    // End of variables declaration//GEN-END:variables
}
