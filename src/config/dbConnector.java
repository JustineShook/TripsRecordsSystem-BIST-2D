    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author mypc
 */
public class dbConnector {
    
    private Connection connect;
     
    public dbConnector(){
            try{
                connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/truckingtripsrecords", "root", "");
            }catch(SQLException ex){
                    System.out.println("Can't connect to database: "+ex.getMessage());
            }
        }
    
    //Function to retrieve data
        public ResultSet getData(String sql) throws SQLException{
            Statement stmt = connect.createStatement();
            ResultSet rst = stmt.executeQuery(sql);
            return rst;
        }
        
        //Function to save data
        public boolean insertData(String sql){
            try{
                PreparedStatement pst = connect.prepareStatement(sql);
                pst.executeUpdate();
                System.out.println("Inserted Successfully!");
                pst.close();
               return true;
            }catch(SQLException ex){
                System.out.println("Connection Error: "+ex);
               return false;
            }
        }
        
        
        public void updateData(String sql) {
        try {
            if (connect == null) {
                throw new SQLException("Database connection is null.");
            }
            PreparedStatement pst = connect.prepareStatement(sql);
            int rowsUpdated = pst.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Data Updated Successfully!");
            } else {
                System.out.println("Data Update Failed!");
            }
            pst.close();
        } catch (SQLException ex) {
            System.out.println("Connection Error: " + ex);
        }
    }
         public Connection getConnection() {
        return connect;
        
         }
         
         
         public boolean deleteData(String sql) {
    try {
        PreparedStatement pst = connect.prepareStatement(sql);
        int rowsDeleted = pst.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("Data Deleted Successfully!");
            return true;
        } else {
            System.out.println("No rows deleted.");
            return false;
        }
    } catch (SQLException ex) {
        System.out.println("Delete Error: " + ex.getMessage());
        return false;
    }
}
         public void close() {
    try {
        if (connect != null && !connect.isClosed()) {
            connect.close();
        }
    } catch (SQLException ex) {
        System.out.println("Error closing connection: " + ex.getMessage());
    }
}
         


   
        
    
}
