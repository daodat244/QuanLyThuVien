/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.TacGia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TacGiaDAO {
    public List<TacGia> getAllTacGia() throws SQLException {
        List<TacGia> tacGiaList = new ArrayList<>();
        String query = "SELECT * FROM tacgia";
        try (Connection conn = ConnectToSQLServer.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                TacGia tacGia = new TacGia(
                    rs.getInt("matacgia"),
                    rs.getString("tentacgia"),
                    rs.getInt("namsinh"),
                    rs.getString("quequan"),
                    rs.getString("mota")
                );
                tacGiaList.add(tacGia);
            }
        }
        return tacGiaList;
    }
    
    // Phương thức thêm mới tác giả
    public boolean addTacGia(TacGia tacGia) throws SQLException {
        String query = "INSERT INTO tacgia (tentacgia, namsinh, quequan, mota) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnectToSQLServer.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, tacGia.getTentacgia());
            stmt.setInt(2, tacGia.getNamsinh());
            stmt.setString(3, tacGia.getQuequan());
            stmt.setString(4, tacGia.getMota());
            return stmt.executeUpdate() > 0;
        }
    }

    // Phương thức cập nhật thông tin tác giả
    public boolean updateTacGia(TacGia tacGia) throws SQLException {
        String query = "UPDATE tacgia SET tentacgia = ?, namsinh = ?, quequan = ?, mota = ? WHERE matacgia = ?";
        try (Connection conn = ConnectToSQLServer.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, tacGia.getTentacgia());
            stmt.setInt(2, tacGia.getNamsinh());
            stmt.setString(3, tacGia.getQuequan());
            stmt.setString(4, tacGia.getMota());
            stmt.setInt(5, tacGia.getMatacgia());
            return stmt.executeUpdate() > 0;
        }
    }

    // Phương thức xóa tác giả
    public boolean deleteTacGia(int matacgia) throws SQLException {
        String query = "DELETE FROM tacgia WHERE matacgia = ?";
        try (Connection conn = ConnectToSQLServer.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, matacgia);
            return stmt.executeUpdate() > 0;
        }
    }
}
