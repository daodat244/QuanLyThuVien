/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author PC
 */
public class ConnectToSQLServer {
        public static Connection getConnection() {
        Connection conn = null;
        try {
            // Bước 2: Nạp trình điều khiển JDBC
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Bước 3: Tạo URL kết nối
            String url = "jdbc:sqlserver://localhost:1433;databaseName=QLyThuVien;encrypt=true;trustServerCertificate=true";
            String username = "sa";
            String password = "123456";

            // Tạo kết nối
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("KET NOI THANH CONG");
        } catch (ClassNotFoundException e) {
            System.out.println("KHONG TIM THAY" + e.getMessage());
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("LOI KET NOI: " + e.getMessage());
            e.printStackTrace();
        }
        return conn;
    }
}
