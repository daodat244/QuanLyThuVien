/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

/**
 *
 * @author PC
 */
import Model.DocGia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DocGiaDAO {
     public List<DocGia> getAllDocGia() throws SQLException {
        List<DocGia> dgList = new ArrayList<>();
        String query = "SELECT * FROM docgia";
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
    
    // Phương thức thêm mới độc giả
    public boolean addDG(DocGia dg) throws SQLException {
        String query = "INSERT INTO docgia (tendocgia, sdt, email, diachi) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnectToSQLServer.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, dg.getTendocgia());
            stmt.setString(2, dg.getSdt());
            stmt.setString(3, dg.getEmail());
            stmt.setString(4, dg.getDiachi());
            return stmt.executeUpdate() > 0;
        }
    }
    // Phương thức cập nhật thông tin độc giả
    public boolean updateDG(DocGia dg) throws SQLException {
        String query = "UPDATE docgia SET tendocgia = ?, sdt = ?, email = ?, diachi = ? WHERE madocgia = ?";
        try (Connection conn = ConnectToSQLServer.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, dg.getTendocgia());
            stmt.setString(2, dg.getSdt());
            stmt.setString(3, dg.getEmail());
            stmt.setString(4, dg.getDiachi());
            stmt.setInt(5, dg.getMadocgia());
            return stmt.executeUpdate() > 0;
        }
    }
    // Phương thức xóa độc giả
    public boolean deleteDG(int madocgia) throws SQLException {
        String query = "DELETE FROM docgia WHERE madocgia = ?";
        try (Connection conn = ConnectToSQLServer.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, madocgia);
            return stmt.executeUpdate() > 0;
        }
    }
}
