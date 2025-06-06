    
package admin;

import config.Logs;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import tripsrecordsystem.loginForm;
import static tripsrecordsystem.regForm.dbemail;


/**
 *
 * @author mypc
 */
public class CreateDriverForm extends javax.swing.JFrame {

    /**
     * Creates new form AdminRegForm
     */
    public CreateDriverForm() {
        initComponents();
    }
    
    public String destination = "";
    File selectedFile;
    public String oldpath;
    public String path;
    
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

    
    
    Color shok = new Color(160,3,0);
    Color redd = new Color(198,20,17);
    
    
    public boolean duplicateCheck(){
        dbConnector dbc = new dbConnector();
        
        String emaill = Lnum.getText();
        String contactnumber = cnumber.getText();
    
    // Validate that the email ends with @gmail.com
    
    
    if (!isValidContactNumber(contactnumber)) {
        JOptionPane.showMessageDialog(null, "Contact number must be an integer and only 11 digits.");
        cnumber.setText(""); // Clear the contact number field
       return true; // Return true to indicate a validation error
    }
    
        
        try{
            String query="SELECT*FROM tbl_driver  WHERE license_number = '"+Lnum.getText()+"'";
            ResultSet resultSet = dbc.getData(query);
            
            if(resultSet.next()){
                dbemail = resultSet.getString("license_number");
                if(dbemail.equals(Lnum.getText())){
                    JOptionPane.showMessageDialog(null, "License Number is already Used!");
                    Lnum.setText("");
                    
                }
                return true;  
            }else{
                return false;
            }
            
        }catch(SQLException ex){
            System.out.println(""+ex);
            return false;
        }
    }
    
    public boolean updateCheck(){
        dbConnector dbc = new dbConnector();
        
        String emaill = Lnum.getText();
        String contactnumber = cnumber.getText();
        
       if (!isValidContactNumber(contactnumber)) {
        JOptionPane.showMessageDialog(null, "Contact number must be an integer and only 11 digits.");
        cnumber.setText(""); // Clear the contact number field
        return true; // Return true to indicate a validation error
        }
        
        
        try{
            String query="SELECT*FROM tbl_driver  WHERE ( license_number = '"+Lnum.getText()+"')AND u_id != '"+DriverID.getText()+"'";
            ResultSet resultSet = dbc.getData(query);
            
            if(resultSet.next()){
                dbemail = resultSet.getString("license_number");
                if(dbemail.equals(Lnum.getText())){
                    JOptionPane.showMessageDialog(null, "License Number is already Used!");
                    Lnum.setText("");
                }
                
                return true;  
            }else{
                return false;
            }   
        }catch(SQLException ex){
            System.out.println(""+ex);
            return false;
        }
    }
   private boolean isValidContactNumber(String cnumber) {
    
     if (cnumber.length() == 11) {
        try {
            Long.parseLong(cnumber);
            return true; 
        } catch (NumberFormatException e) {
            return false; 
        }
    }
    return false;
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
        jLabel14 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        addB = new javax.swing.JButton();
        cnumber = new javax.swing.JTextField();
        Lnum = new javax.swing.JTextField();
        CompleteName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        Cancelbutton = new javax.swing.JButton();
        jDriverStatus = new javax.swing.JComboBox<>();
        DriverID = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        Clearb = new javax.swing.JButton();
        UpdateB = new javax.swing.JButton();
        Refresh = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        remove = new javax.swing.JButton();
        select = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

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
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 200, 350));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Complete Name");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 90, 10));

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
        jPanel2.add(addB, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 100, 30));

        cnumber.setBackground(new java.awt.Color(215, 215, 215));
        jPanel2.add(cnumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 140, 30));

        Lnum.setBackground(new java.awt.Color(215, 215, 215));
        jPanel2.add(Lnum, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 140, 30));

        CompleteName.setBackground(new java.awt.Color(215, 215, 215));
        jPanel2.add(CompleteName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 140, 30));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("License Number");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 130, 10));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Contact Number");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 90, 10));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Account Status");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, -1, 10));

        jLabel8.setBackground(new java.awt.Color(255, 102, 102));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/123.jpg"))); // NOI18N
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 60, 30));

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
        jPanel2.add(Cancelbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 80, -1));

        jDriverStatus.setBackground(new java.awt.Color(255, 51, 51));
        jDriverStatus.setForeground(new java.awt.Color(255, 255, 255));
        jDriverStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ACTIVE", "PENDING" }));
        jDriverStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDriverStatusActionPerformed(evt);
            }
        });
        jPanel2.add(jDriverStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 140, 30));

        DriverID.setBackground(new java.awt.Color(215, 215, 215));
        DriverID.setEnabled(false);
        jPanel2.add(DriverID, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 50, 20));

        jLabel16.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 102, 102));
        jLabel16.setText("ID");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 10, 10));

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
        jPanel2.add(Clearb, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 290, 100, 30));

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
        jPanel2.add(UpdateB, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, 100, 30));

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
        jPanel2.add(Refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 100, 30));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 260, 240));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 280, 260));

        remove.setBackground(new java.awt.Color(198, 20, 17));
        remove.setForeground(new java.awt.Color(255, 255, 255));
        remove.setText("REMOVE");
        remove.addMouseListener(new java.awt.event.MouseAdapter() {
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
        jPanel2.add(remove, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 290, 90, 40));

        select.setBackground(new java.awt.Color(198, 20, 17));
        select.setForeground(new java.awt.Color(255, 255, 255));
        select.setText("SELECT");
        select.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                selectMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                selectMouseExited(evt);
            }
        });
        select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectActionPerformed(evt);
            }
        });
        jPanel2.add(select, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 290, 90, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 660, 350));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ADMIN DRIVER FORM");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 10));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 862, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBActionPerformed
     
        if (CompleteName.getText().isEmpty() || Lnum.getText().isEmpty() || cnumber.getText().isEmpty() || image.getIcon() == null) {
    JOptionPane.showMessageDialog(null, "All Fields are Required!");
} else if (duplicateCheck()) {
    System.out.println("Duplicate Exist");
} else {
    try {
        dbConnector dbc = new dbConnector();
        if (dbc.insertData("INSERT INTO tbl_driver(full_name, license_number, contact_number, driver_image, driver_status) "
                + "VALUES('" + CompleteName.getText() + "','" + Lnum.getText() + "','" + cnumber.getText() + "','" + destination + "', '" + jDriverStatus.getSelectedItem() + "')")) {

            Files.copy(selectedFile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);

            // ✅ LOGGING THE ACTION AFTER SUCCESSFUL INSERT
            Session session = Session.getInstance();
            int userId = session.getUid();
            String userFullname = session.getCname();  // Make sure these method names are correct
            String action = "Admin Added a Driver successfully: " + CompleteName.getText();
            Logs.logFunctionCall(userId, userFullname, action);
            // 🔚 END LOGGING

            JOptionPane.showMessageDialog(null, "Inserted Successfully");

            DriverForm uf = new DriverForm();
            uf.setVisible(true);
            this.dispose();

        } else {
            JOptionPane.showMessageDialog(null, "Connection Error!");
        }
    } catch (IOException ex) {
        Logger.getLogger(CreateDriverForm.class.getName()).log(Level.SEVERE, null, ex);
    }
}

    }//GEN-LAST:event_addBActionPerformed

    private void CancelbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelbuttonActionPerformed
        DriverForm uf =new DriverForm();
        uf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CancelbuttonActionPerformed

    private void jDriverStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDriverStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jDriverStatusActionPerformed

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


    CompleteName.setText("");
    Lnum.setText("");
    cnumber.setText("");
    DriverID.setText("");

    // Clear image and reset image path
    image.setIcon(null);
    destination = "";
    oldpath = "";
    path = "";
    selectedFile = null;

    // Reset status dropdown
    jDriverStatus.setSelectedIndex(0);

    // Reset buttons: enable Add, disable Update
    addB.setEnabled(true);
    UpdateB.setEnabled(false);

    // Reset select/remove image buttons if you have them
    select.setEnabled(true);
    remove.setEnabled(false);

    }//GEN-LAST:event_ClearbActionPerformed

    private void UpdateBMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateBMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateBMouseEntered

    private void UpdateBMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateBMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateBMouseExited

    private void UpdateBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateBActionPerformed
        if(CompleteName.getText().isEmpty()||Lnum.getText().isEmpty()||cnumber.getText().isEmpty()
            )

        {
            JOptionPane.showMessageDialog(null, "All Fields are Required!");
        }
        
        else if(updateCheck()){
            

        }else{
        
        
        dbConnector dbc = new dbConnector();
        dbc.updateData("UPDATE tbl_driver SET full_name = '"+CompleteName.getText()+"',"
                + "license_number ='"+Lnum.getText()+"',"
                        + "contact_number = '"+cnumber.getText()+"', "
                                + "driver_status = '"+jDriverStatus.getSelectedItem()+"',"
                                        + "'driver_image = '"+destination+"' WHERE driver_id  = '"+DriverID.getText()+"'");
        if(destination.isEmpty()){
            File existingFile = new File(oldpath);
            if(existingFile.exists()){
                existingFile.delete();
            }
        }else{
            if(!(oldpath.equals(path))){
                imageUpdater(oldpath, path);
            }
        }
         Session session = Session.getInstance();
            int userId = session.getUid();
            String userFullname = session.getCname();
            String action = "Admin Update a Driver successfully: " + CompleteName.getText();
            Logs.logFunctionCall(userId, userFullname, action);
        
        DriverForm uf=new DriverForm();
        uf.setVisible(true);
        this.dispose(); 
        
        }
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

    private void removeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_removeMouseEntered

    private void removeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_removeMouseExited

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        remove.setEnabled(false);
        select.setEnabled(true);
        image.setIcon(null);
        destination = "";
        path = "";
    }//GEN-LAST:event_removeActionPerformed

    private void selectMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_selectMouseEntered

    private void selectMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_selectMouseExited

    private void selectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectActionPerformed
       JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    try {
                        selectedFile = fileChooser.getSelectedFile();
                        destination = "src/driverimage/" + selectedFile.getName();
                        path  = selectedFile.getAbsolutePath();
                        
                        
                        if(FileExistenceChecker(path) == 1){
                          JOptionPane.showMessageDialog(null, "File Already Exist, Rename or Choose another!");
                            destination = "";
                            path="";
                        }else{
                            image.setIcon(ResizeImage(path, null, image));
                            select.setEnabled(false);
                            remove.setEnabled(true);
                         
                        }
                    } catch (Exception ex) {
                        System.out.println("File Error!");
                    }
                }
    }//GEN-LAST:event_selectActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
      Session sess = Session.getInstance();
        if(sess.getUid()==0){ 
            JOptionPane.showMessageDialog(null, "No Account, Login First");
            loginForm lgf = new loginForm();
            lgf.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(CreateDriverForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateDriverForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateDriverForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateDriverForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateDriverForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancelbutton;
    private javax.swing.JButton Clearb;
    public javax.swing.JTextField CompleteName;
    public javax.swing.JTextField DriverID;
    public javax.swing.JTextField Lnum;
    private javax.swing.JButton Refresh;
    public javax.swing.JButton UpdateB;
    public javax.swing.JButton addB;
    public javax.swing.JTextField cnumber;
    public javax.swing.JLabel image;
    public javax.swing.JComboBox<String> jDriverStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JButton remove;
    public javax.swing.JButton select;
    // End of variables declaration//GEN-END:variables
}
