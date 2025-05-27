/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DAO;

import Model.ConnectToSQLServer;
import Model.Sach;
import Model.Sach;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SachDAO {
    public List<Sach> getAllSachWithDetails() throws SQLException {
        List<Sach> sachList = new ArrayList<>();
        String query = "SELECT s.*, t.tentacgia, n.tennxb, tl.tentheloai " +
                       "FROM sach s " +
                       "LEFT JOIN tacgia t ON s.matacgia = t.matacgia " +
                       "LEFT JOIN nhaxuatban n ON s.manxb = n.manxb " +
                       "LEFT JOIN theloai tl ON s.matheloai = tl.matheloai";
        try (Connection conn = ConnectToSQLServer.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Sach sach = new Sach(
                    rs.getString("masach"),
                    rs.getString("tensach"),
                    rs.getInt("matacgia"),
                    rs.getInt("manxb"),
                    rs.getInt("matheloai"),
                    rs.getInt("namxb"),
                    rs.getInt("sotrang"),
                    rs.getInt("soluong")
                );
                sachList.add(sach);
            }
        }
        return sachList;
    }
    
    public boolean addSach(Sach sach) throws SQLException {
        String query = "INSERT INTO sach (masach, tensach, matacgia, manxb, matheloai, namxb, sotrang, soluong) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConnectToSQLServer.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, sach.getMasach());
            stmt.setString(2, sach.getTensach());
            stmt.setInt(3, sach.getMatacgia());
            stmt.setInt(4, sach.getManxb());
            stmt.setInt(5, sach.getMatheloai());
            stmt.setInt(6, sach.getNamxb());
            stmt.setInt(7, sach.getSotrang());
            stmt.setInt(8, sach.getSoluong());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean updateSach(Sach sach) throws SQLException {
        String query = "UPDATE sach SET tensach = ?, matacgia = ?, manxb = ?, matheloai = ?, namxb = ?, sotrang = ?, soluong = ? WHERE masach = ?";
        try (Connection conn = ConnectToSQLServer.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, sach.getTensach());
            stmt.setInt(2, sach.getMatacgia());
            stmt.setInt(3, sach.getManxb());
            stmt.setInt(4, sach.getMatheloai());
            stmt.setInt(5, sach.getNamxb());
            stmt.setInt(6, sach.getSotrang());
            stmt.setInt(7, sach.getSoluong());
            stmt.setString(8, sach.getMasach());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean deleteSach(String masach) throws SQLException {
        String query = "DELETE FROM sach WHERE masach = ?";
        try (Connection conn = ConnectToSQLServer.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, masach);
            return stmt.executeUpdate() > 0;
        }
    }
    
    public Sach getSachById(String masach) throws SQLException {
    String query = "SELECT masach, tensach, soluong FROM sach WHERE masach = ?";
        try (Connection conn = ConnectToSQLServer.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, masach);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Sach sach = new Sach();
                    sach.setMasach(rs.getString("masach"));
                    sach.setTensach(rs.getString("tensach"));
                    sach.setSoluong(rs.getInt("soluong")); // Thêm soluong
                    System.out.println("Found book: masach = " + rs.getString("masach") + ", tensach = " + rs.getString("tensach") + ", soluong = " + rs.getInt("soluong"));
                    return sach;
                } else {
                    System.out.println("No book found for masach = " + masach);
                }
            }
        } catch (SQLException e) {
            System.err.println("SQLException in getSachById: " + e.getMessage());
            throw e;
        }
        return null;
}
    
    public String getMaSachByTen(String tenSach) throws SQLException { // Thay int thành String
        String query = "SELECT masach FROM sach WHERE tensach = ?";
        try (Connection conn = ConnectToSQLServer.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, tenSach);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String masach = rs.getString("masach");
                    System.out.println("Found masach = " + masach + " for tensach = " + tenSach);
                    return masach;
                } else {
                    System.out.println("No masach found for tensach = " + tenSach);
                }
            }
        } catch (SQLException e) {
            System.err.println("SQLException in getMaSachByTen: " + e.getMessage());
            throw e;
        }
        return null; // Thay -1 bằng null vì masach giờ là String
    }
}
