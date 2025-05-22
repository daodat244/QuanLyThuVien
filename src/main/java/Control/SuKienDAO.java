/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;


import Model.SuKien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Asus
 */
public class SuKienDAO {
// Phương thức tiện ích để chuyển đổi Timestamp thành LocalDateTime
        private LocalDateTime convertTimestampToLocalDateTime(Timestamp timestamp) {
        return timestamp != null ? timestamp.toLocalDateTime() : null;
    }
// Lấy danh sách tất cả sự kiện từ cơ sở dữ liệu với JOIN để lấy tennxb
    public List<SuKien> getAllSuKien() throws SQLException {
        List<SuKien> skList = new ArrayList<>();
        String query = "SELECT sk.*, nxb.tennxb " +
                       "FROM sukien sk " +
                       "LEFT JOIN nhaxuatban nxb ON sk.manxb = nxb.manxb";
        try (Connection conn = ConnectToSQLServer.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {                
                SuKien sk = new SuKien(
                    rs.getInt("masukien"),
                    rs.getString("tensukien"),
                    rs.getInt("manxb"),
                    convertTimestampToLocalDateTime(rs.getTimestamp("tgiantochuc")),
                    rs.getString("mota")
                );
                skList.add(sk);
            }
        }
        return skList;
    }

    // Thêm mới một sự kiện
    public boolean themSuKien(SuKien sk) throws SQLException {
        String query = "INSERT INTO sukien (tensukien, manxb, tgiantochuc, mota) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnectToSQLServer.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, sk.getTensukien());
            stmt.setInt(2, sk.getManxb());
            LocalDateTime tgiantochuc = sk.getTgiantochuc();
            stmt.setTimestamp(3, tgiantochuc != null ? Timestamp.valueOf(tgiantochuc) : null);
            stmt.setString(4, sk.getMota());
            return stmt.executeUpdate() > 0;
        }
    }

    // Cập nhật thông tin sự kiện
    public boolean updateSuKien(SuKien sk) throws SQLException {
        String query = "UPDATE sukien SET tensukien = ?, manxb = ?, tgiantochuc = ?, mota = ? WHERE masukien = ?";
        try (Connection conn = ConnectToSQLServer.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, sk.getTensukien());          
            stmt.setInt(2, sk.getManxb());
            LocalDateTime tgiantochuc = sk.getTgiantochuc();
            stmt.setTimestamp(3, tgiantochuc != null ? Timestamp.valueOf(tgiantochuc) : null);
            stmt.setString(4, sk.getMota());
            stmt.setInt(5, sk.getMasukien());
            return stmt.executeUpdate() > 0;
        }
    }

    // Xóa sự kiện theo mã
    public boolean deleteSuKien(int masukien) throws SQLException {
        String query = "DELETE FROM sukien WHERE masukien = ?";
        try (Connection conn = ConnectToSQLServer.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, masukien);
            return stmt.executeUpdate() > 0;
        }
    }
}
