/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

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
                    rs.getInt("masach"),
                    rs.getString("tensach"),
                    rs.getInt("matacgia"),
                    rs.getInt("manxb"),
                    rs.getInt("matheloai"),
                    rs.getInt("namxb"),
                    rs.getInt("sotrang")
                );
                sachList.add(sach);
            }
        }
        return sachList;
    }
    
    public boolean addSach(Sach sach) throws SQLException {
        String query = "INSERT INTO sach (tensach, matacgia, manxb, matheloai, namxb, sotrang) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConnectToSQLServer.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, sach.getTensach());
            stmt.setInt(2, sach.getMatacgia());
            stmt.setInt(3, sach.getManxb());
            stmt.setInt(4, sach.getMatheloai());
            stmt.setInt(5, sach.getNamxb());
            stmt.setInt(6, sach.getSotrang());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean updateSach(Sach sach) throws SQLException {
        String query = "UPDATE sach SET tensach = ?, matacgia = ?, manxb = ?, matheloai = ?, namxb = ?, sotrang = ? WHERE masach = ?";
        try (Connection conn = ConnectToSQLServer.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, sach.getTensach());
            stmt.setInt(2, sach.getMatacgia());
            stmt.setInt(3, sach.getManxb());
            stmt.setInt(4, sach.getMatheloai());
            stmt.setInt(5, sach.getNamxb());
            stmt.setInt(6, sach.getSotrang());
            stmt.setInt(7, sach.getMasach());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean deleteSach(int masach) throws SQLException {
        String query = "DELETE FROM sach WHERE masach = ?";
        try (Connection conn = ConnectToSQLServer.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, masach);
            return stmt.executeUpdate() > 0;
        }
    }
}
