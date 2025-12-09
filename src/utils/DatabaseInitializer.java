/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author admin
 */
public class DatabaseInitializer {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/ExGroupJava";
    private static final String USER = "root";
    private static final String PASS = "123";
    
    public static void init() {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            conn = DriverManager.getConnection(URL, USER, PASS);
            stmt = conn.createStatement();
                    
            System.out.println("Đã kết nối vào database ExGroupJava thành công!");
            
//            for(String q : sql.split(";")) {
//                if(q.trim().length() > 0) {
//                    stmt.executeUpdate(q.trim());
//                }
//            }
            
            System.out.println("Tất cả bảng tạo xong.");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Lỗi kết nối db");
        } finally {
        try { if (stmt != null) stmt.close(); } catch (SQLException e) {}
        try { if (conn != null) conn.close(); } catch (SQLException e) {}
    }
    }
}
