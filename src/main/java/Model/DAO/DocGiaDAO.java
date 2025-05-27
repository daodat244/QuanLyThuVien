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

/**
 *
 * @author TUF
 */
public class DocGiaDAO {

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
