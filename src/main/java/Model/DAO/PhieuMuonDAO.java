/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DAO;

import Model.ConnectToSQLServer;
import Model.PhieuMuon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class PhieuMuonDAO {
    public List<PhieuMuon> getAllPhieuMuonWithDetails() throws SQLException {
        List<PhieuMuon> phieuMuonList = new ArrayList<>();
        String query = "SELECT pm.*, d.tendocgia, nv.tennv, s.tensach " +
                       "FROM phieumuon pm " +
                       "LEFT JOIN docgia d ON pm.madocgia = d.madocgia " +
                       "LEFT JOIN nhanvien nv ON pm.manv = nv.manv " +
                       "LEFT JOIN sach s ON pm.masach = s.masach";
        try (Connection conn = ConnectToSQLServer.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                PhieuMuon pm = new PhieuMuon(
                    rs.getInt("maphieu"),
                    rs.getInt("madocgia"),
                    rs.getInt("manv"),
                    rs.getInt("masach"),
                    rs.getObject("ngaymuon", LocalDateTime.class),
                    rs.getObject("ngaytradukien", LocalDateTime.class),
                    rs.getString("trangthai")
                );
                phieuMuonList.add(pm);
            }
        }
        return phieuMuonList;
    }
    
    public boolean addPhieuMuon(PhieuMuon pm) throws SQLException {
        String query = "INSERT INTO phieumuon (madocgia, manv, masach, ngaymuon, ngaytradukien,trangthai) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConnectToSQLServer.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, pm.getMadocgia());
            stmt.setInt(2, pm.getManv());
            stmt.setInt(3, pm.getMasach());
            stmt.setObject(4, pm.getNgaymuon());
            stmt.setObject(5, pm.getNgayTraDuKien());
            stmt.setString(6, "Chưa trả");
            return stmt.executeUpdate() > 0;
        }    
    }
        
    public boolean updatePhieuMuon(PhieuMuon pm) throws SQLException {
        String query = "UPDATE phieumuon SET madocgia = ?, manv = ?, masach = ?, ngaymuon = ?, ngaytradukien = ? WHERE maphieu = ?";
        try (Connection conn = ConnectToSQLServer.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, pm.getMadocgia());
            stmt.setInt(2, pm.getManv());
            stmt.setInt(3, pm.getMasach());
            stmt.setObject(4, pm.getNgaymuon());
            stmt.setObject(5, pm.getNgayTraDuKien());
            stmt.setInt(6, pm.getMaphieu());
            return stmt.executeUpdate() > 0;
        }
    }
        
    public boolean deletePhieuMuon(int maphieu) throws SQLException {
        String query = "DELETE FROM phieumuon WHERE maphieu = ?";
        try (Connection conn = ConnectToSQLServer.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, maphieu);
            return stmt.executeUpdate() > 0;
        }
    }
        
    public boolean updateTrangThai(int maphieu, String trangthai, Connection conn) throws SQLException {
        String query = "UPDATE phieumuon SET trangthai = ? WHERE maphieu = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, trangthai);
            stmt.setInt(2, maphieu);
            return stmt.executeUpdate() > 0;
        }
    }

}

    
