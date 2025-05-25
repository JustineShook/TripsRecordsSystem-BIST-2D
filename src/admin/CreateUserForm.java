    
package admin;

import config.Logs;
import config.Session;
import config.dbConnector;
import config.passwordHasher;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.NoSuchAlgorithmException;
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
import static tripsrecordsystem.regForm.dbusername;

/**
 *
 * @author mypc
 */
public class CreateUserForm extends javax.swing.JFrame {

    /**
     * Creates new form AdminRegForm
     */
    public CreateUserForm() {
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
        
        String emaill = email.getText();
        String contactnumber = cnumber.getText();
    
    // Validate that the email ends with @gmail.com
    if (!emaill.endsWith("@gmail.com")) {
        JOptionPane.showMessageDialog(null, "Email must end with @gmail.com");
        email.setText(""); // Clear the email field
        return true; // Return true to indicate a validation error
    }
    if (!isValidContactNumber(contactnumber)) {
        JOptionPane.showMessageDialog(null, "Contact number must be an integer and only 11 digits.");
        cnumber.setText(""); // Clear the contact number field
       return true; // Return true to indicate a validation error
    }
    
        
        try{
            String query="SELECT*FROM tbl_user  WHERE u_username ='"+uname.getText()+"'OR u_email = '"+email.getText()+"'";
            ResultSet resultSet = dbc.getData(query);
            
            if(resultSet.next()){
                dbemail = resultSet.getString("u_email");
                if(dbemail.equals(email.getText())){
                    JOptionPane.showMessageDialog(null, "Email is already Used!");
                    email.setText("");
                    
                }
                
               
                dbusername = resultSet.getString("u_username");
                if(dbusername.equals(uname.getText())){
                    JOptionPane.showMessageDialog(null, "Username is already Used!");
                    uname.setText("");
                    
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
        
        String emaill = email.getText();
        String contactnumber = cnumber.getText();
        
        if (!emaill.endsWith("@gmail.com")) {
        JOptionPane.showMessageDialog(null, "Email must end with @gmail.com");
        email.setText(""); // Clear the email field
        return true;
        
        }if (!isValidContactNumber(contactnumber)) {
        JOptionPane.showMessageDialog(null, "Contact number must be an integer and only 11 digits.");
        cnumber.setText(""); // Clear the contact number field
        return true; // Return true to indicate a validation error
        }
        
        
        try{
            String query="SELECT*FROM tbl_user  WHERE (u_username ='"+uname.getText()+"'OR u_email = '"+email.getText()+"')AND u_id != '"+uID.getText()+"'";
            ResultSet resultSet = dbc.getData(query);
            
            if(resultSet.next()){
                dbemail = resultSet.getString("u_email");
                if(dbemail.equals(email.getText())){
                    JOptionPane.showMessageDialog(null, "Email is already Used!");
                    email.setText("");
                }
                dbusername = resultSet.getString("u_username");
                if(dbusername.equals(uname.getText())){
                    JOptionPane.showMessageDialog(null, "Username is already Used!");
                    uname.setText("");   
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
        jUserType = new javax.swing.JComboBox<>();
        uname = new javax.swing.JTextField();
        cnumber = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        CompleteName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        Cancelbutton = new javax.swing.JButton();
        jUserStatus = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        uID = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        Clearb = new javax.swing.JButton();
        UpdateB = new javax.swing.JButton();
        Refresh = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        pword = new javax.swing.JPasswordField();
        pword1 = new javax.swing.JPasswordField();
        jPanel3 = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        remove = new javax.swing.JButton();
        select = new javax.swing.JButton();
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
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 200, 400));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Complete Name");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 90, 10));

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
        jPanel2.add(addB, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 80, 30));

        jUserType.setBackground(new java.awt.Color(255, 51, 51));
        jUserType.setForeground(new java.awt.Color(255, 255, 255));
        jUserType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "USER", "ADMIN" }));
        jUserType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jUserTypeActionPerformed(evt);
            }
        });
        jPanel2.add(jUserType, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, 140, 30));

        uname.setBackground(new java.awt.Color(215, 215, 215));
        jPanel2.add(uname, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 140, 30));

        cnumber.setBackground(new java.awt.Color(215, 215, 215));
        jPanel2.add(cnumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 140, 30));

        email.setBackground(new java.awt.Color(215, 215, 215));
        jPanel2.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 140, 30));

        CompleteName.setBackground(new java.awt.Color(215, 215, 215));
        jPanel2.add(CompleteName, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 140, 30));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Email");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 30, 10));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Contact Number");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 90, 10));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Username");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, 10));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Account Status");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, 10));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Password");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 60, 10));

        jLabel8.setBackground(new java.awt.Color(255, 102, 102));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/123.jpg"))); // NOI18N
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 360, 60, 30));

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
        jPanel2.add(Cancelbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 80, -1));

        jUserStatus.setBackground(new java.awt.Color(255, 51, 51));
        jUserStatus.setForeground(new java.awt.Color(255, 255, 255));
        jUserStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ACTIVE", "PENDING" }));
        jUserStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jUserStatusActionPerformed(evt);
            }
        });
        jPanel2.add(jUserStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 140, 30));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("User Type");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, -1, 10));

        uID.setBackground(new java.awt.Color(215, 215, 215));
        uID.setEnabled(false);
        jPanel2.add(uID, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 50, 20));

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
        jPanel2.add(Clearb, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 360, 80, -1));

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
        jPanel2.add(UpdateB, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 300, 80, 30));

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
        jPanel2.add(Refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 80, -1));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setText("Confirm Password");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 110, 10));

        pword.setBackground(new java.awt.Color(215, 215, 215));
        jPanel2.add(pword, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 140, 30));

        pword1.setBackground(new java.awt.Color(215, 215, 215));
        jPanel2.add(pword1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 140, 30));

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

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 660, 400));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CREATE/ADD USER FORM");
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBActionPerformed

        if(CompleteName.getText().isEmpty()||email.getText().isEmpty()||cnumber.getText().isEmpty()
            ||uname.getText().isEmpty()||pword.getText().isEmpty()|| image.getIcon() == null)

        {
            JOptionPane.showMessageDialog(null, "All Fields are Required!");
        }else if(pword.getText().length()< 8){
            JOptionPane.showMessageDialog(null, "Password character should be 8 above");
            pword.setText("");

        }else if (!pword.getText().equals(pword1.getText())) {
            JOptionPane.showMessageDialog(null, "Passwords do not match.");
            pword.setText("");
            pword1.setText("");
        }

        
        
        
        
        else if(duplicateCheck()){
            System.out.println("Duplicate Exist");

        }

        else{
            try{
            dbConnector dbc=new dbConnector();
            String pass = passwordHasher.hashPassword(pword.getText());
            if(dbc.insertData("INSERT INTO tbl_user(u_name, u_email, u_number, u_username, u_password, u_image, u_status, u_type) "
                + "VALUES('"+CompleteName.getText()+"','"+email.getText()+"','"+cnumber.getText()+"','"+uname.getText()+"','"+ pass +"','"+destination+"', '"+jUserStatus.getSelectedItem()+"','"+jUserType.getSelectedItem()+"')"))
        {
            
            
            Files.copy(selectedFile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);
            
            Session session = Session.getInstance();
            int userId = session.getUid();
            String userFullname = session.getCname();  // Make sure these method names are correct
            String action = "Admin Added a User Account successfully: " + CompleteName.getText();
            Logs.logFunctionCall(userId, userFullname, action);
            
            JOptionPane.showMessageDialog(null, "Inserted Successfully");
            usersForm uf=new usersForm();
            uf.setVisible(true);
            this.dispose();

        }else{
            JOptionPane.showMessageDialog(null, "Connection Error!");

        }
        }catch(NoSuchAlgorithmException ex){
            System.out.println("Insert Image Error" +ex);
        }   catch (IOException ex) {
                Logger.getLogger(CreateUserForm.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
    }//GEN-LAST:event_addBActionPerformed

    private void jUserTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jUserTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jUserTypeActionPerformed

    private void CancelbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelbuttonActionPerformed
        usersForm uf =new usersForm();
        uf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CancelbuttonActionPerformed

    private void jUserStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jUserStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jUserStatusActionPerformed

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
    email.setText("");
    cnumber.setText("");
    uname.setText("");
    pword.setText("");
    pword1.setText("");

    }//GEN-LAST:event_ClearbActionPerformed

    private void UpdateBMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateBMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateBMouseEntered

    private void UpdateBMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateBMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateBMouseExited

    private void UpdateBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateBActionPerformed
        if(CompleteName.getText().isEmpty()||email.getText().isEmpty()||cnumber.getText().isEmpty()
            ||pword.getText().isEmpty())

        {
            JOptionPane.showMessageDialog(null, "Fill apa ang wa na fill apan duh!");
        }else if(pword.getText().length()< 8){
            JOptionPane.showMessageDialog(null, "Password character should be 8 above");
            pword.setText("");

        }else if (!pword.getText().equals(pword1.getText())) {
            JOptionPane.showMessageDialog(null, "Passwords do not match.");
            pword.setText("");
            pword1.setText("");
        }
        
        else if(updateCheck()){
            

        }else{
        
        
        dbConnector dbc = new dbConnector();
        try{
            
        String pass = passwordHasher.hashPassword(pword.getText());
        dbc.updateData("UPDATE tbl_user SET u_name = '"+CompleteName.getText()+"',"
                + "u_email ='"+email.getText()+"',"
                + "u_number = '"+cnumber.getText()+"', "
                + "u_password = '"+ pass +"',"
                + "u_status = '"+jUserStatus.getSelectedItem()+"',"
                + "u_type = '"+jUserType.getSelectedItem()+"'u_image = '"+destination+"'WHERE u_id = '"+uID.getText()+"'");
        
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
            String action = "Admin Upadted a User Account successfully: " + CompleteName.getText();
            Logs.logFunctionCall(userId, userFullname, action);
            usersForm uf=new usersForm();
            uf.setVisible(true);
            this.dispose();
            
        }catch(NoSuchAlgorithmException ex){
            System.out.println(""+ex);
        
        } 
        
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
                        destination = "src/userimages/" + selectedFile.getName();
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
            java.util.logging.Logger.getLogger(CreateUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateUserForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancelbutton;
    private javax.swing.JButton Clearb;
    public javax.swing.JTextField CompleteName;
    private javax.swing.JButton Refresh;
    public javax.swing.JButton UpdateB;
    public javax.swing.JButton addB;
    public javax.swing.JTextField cnumber;
    public javax.swing.JTextField email;
    public javax.swing.JLabel image;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JComboBox<String> jUserStatus;
    public javax.swing.JComboBox<String> jUserType;
    public javax.swing.JPasswordField pword;
    public javax.swing.JPasswordField pword1;
    public javax.swing.JButton remove;
    public javax.swing.JButton select;
    public javax.swing.JTextField uID;
    public javax.swing.JTextField uname;
    // End of variables declaration//GEN-END:variables
}
