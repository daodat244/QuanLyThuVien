/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DAO;

import Model.ConnectToSQLServer;
import Model.DocGia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class DocGiaDAO {

    // Lấy toàn bộ danh sách độc giả
    public List<DocGia> getAllDocGia() throws SQLException {
        List<DocGia> dgList = new ArrayList<>();
        String query = "SELECT madocgia, tendocgia, sdt, email, diachi FROM docgia";
        try (Connection conn = ConnectToSQLServer.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                DocGia dg = new DocGia(
                    rs.getInt("madocgia"),
                    rs.getString("tendocgia"),
                    rs.getString("sdt"),
                    rs.getString("email"),
                    rs.getString("diachi")
                );
                dgList.add(dg);
            }
        }
        return dgList;
    }

    // Tìm độc giả theo mã
    public DocGia getDocGiaById(int madocgia) throws SQLException {
    String query = "SELECT madocgia, tendocgia FROM DocGia WHERE madocgia = ?";
    try (Connection conn = ConnectToSQLServer.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {
        stmt.setInt(1, madocgia);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                DocGia docGia = new DocGia();
                docGia.setMadocgia(rs.getInt("madocgia"));
                docGia.setTendocgia(rs.getString("tendocgia"));
                System.out.println("Found reader: madocgia = " + rs.getInt("madocgia") + ", tendocgia = " + rs.getString("tendocgia"));
                return docGia;
            } else {
                System.out.println("No reader found for madocgia = " + madocgia);
            }
        }
    } catch (SQLException e) {
        System.err.println("SQLException in getDocGiaById: " + e.getMessage());
        throw e;
    }
    return null;
}
    public DocGia getDocGiaByTen(String tenDocGia) throws SQLException {
    String sql = "SELECT * FROM DocGia WHERE TenDocGia = ?";
        try (Connection conn = ConnectToSQLServer.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, tenDocGia);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new DocGia(
                        rs.getInt("madocgia"), 
                        rs.getString("tendocgia"),
                        rs.getString("sdt"),
                        rs.getString("email"),
                        rs.getString("diachi")
                    );
                }
        }
        return null;
    }
    
    public int getMaDocGiaByTen(String tenDocGia) throws SQLException {
    String query = "SELECT madocgia FROM DocGia WHERE tendocgia = ?";
    try (Connection conn = ConnectToSQLServer.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {
        stmt.setString(1, tenDocGia);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                int madocgia = rs.getInt("madocgia");
                System.out.println("Found madocgia = " + madocgia + " for tendocgia = " + tenDocGia);
                return madocgia;
            } else {
                System.out.println("No madocgia found for tendocgia = " + tenDocGia);
            }
        }
    } catch (SQLException e) {
        System.err.println("SQLException in getMaDocGiaByTen: " + e.getMessage());
        throw e;
    }
    return -1; // Trả về -1 nếu không tìm thấy
    }
}

