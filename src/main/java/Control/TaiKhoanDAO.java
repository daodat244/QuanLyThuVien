/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.TaiKhoan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaiKhoanDAO {
    public List<TaiKhoan> getAllTaiKhoan() throws SQLException {
        List<TaiKhoan> taikhoanList = new ArrayList<>();
        String query = "SELECT tk.*, n.tennv " +
                       "FROM taikhoan tk " +
                       "LEFT JOIN nhanvien n ON tk.manv = n.manv ";
        try (Connection conn = ConnectToSQLServer.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                TaiKhoan tk = new TaiKhoan(
                    rs.getInt("matk"),
                    rs.getInt("manv"),
                    rs.getString("tendangnhap"),
                    rs.getString("matkhau"),
                    rs.getString("role")
                );
                taikhoanList.add(tk);
            }
        }
        return taikhoanList;
    }
    
    public boolean addTK(TaiKhoan tk) throws SQLException {
        String query = "INSERT INTO taikhoan (manv, tendangnhap, matkhau, role) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnectToSQLServer.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, tk.getManhanvien());
            stmt.setString(2, tk.getTendangnhap());
            stmt.setString(3, tk.getMatkhau());
            stmt.setString(4, tk.getRole());
            
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean updateTK(TaiKhoan tk) throws SQLException {
        String query = "UPDATE taikhoan SET manv = ?, tendangnhap = ?, matkhau = ?, role = ? WHERE matk = ?";
        try (Connection conn = ConnectToSQLServer.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, tk.getManhanvien());
            stmt.setString(2, tk.getTendangnhap());
            stmt.setString(3, tk.getMatkhau());
            stmt.setString(4, tk.getRole());
            stmt.setInt(5, tk.getMataikhoan());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean deleteTK(int mataikhoan) throws SQLException {
        String query = "DELETE FROM taikhoan WHERE matk = ?";
        try (Connection conn = ConnectToSQLServer.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, mataikhoan);
            return stmt.executeUpdate() > 0;
        }
    }
    public TaiKhoan authenticate(String username, String password) throws SQLException {
        String query = "SELECT * FROM taikhoan WHERE tendangnhap = ? AND matkhau = ?";
        try (Connection conn = ConnectToSQLServer.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new TaiKhoan(
                        rs.getInt("matk"),
                        rs.getInt("manv"),
                        rs.getString("tendangnhap"),
                        rs.getString("matkhau"),
                        rs.getString("role")
                    );
                }
            }
        }
        return null;
    }
}
