package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class Logs{

   
    private static final String DB_URL = "jdbc:mysql://localhost:3306/truckingtripsrecords";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    
    public static void logFunctionCall(int userId, String userFullname, String action) {
    String sql = "INSERT INTO user_action_logs (u_id, user_fullname, action) VALUES (?, ?, ?)";

    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, userId);
        stmt.setString(2, userFullname);
        stmt.setString(3, action);

        int rowsInserted = stmt.executeUpdate();
        System.out.println("Rows inserted: " + rowsInserted);

    } catch (SQLException e) {
        e.printStackTrace();
    }
}
}
