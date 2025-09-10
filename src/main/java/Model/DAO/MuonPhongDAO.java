/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DAO;


import Model.ConnectToSQLServer;
import Model.MuonPhong;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class MuonPhongDAO {
    // Phương thức tiện ích để chuyển đổi Timestamp thành LocalDateTime
        private LocalDateTime convertTimestampToLocalDateTime(Timestamp timestamp) {
        return timestamp != null ? timestamp.toLocalDateTime() : null;
        }
        
    // Lấy danh sách tất cả sự kiện từ cơ sở dữ liệu với JOIN để lấy tennxb
    public List<Object[]> getAllMuonPhongWithDetails() throws SQLException {
        List<Object[]> result = new ArrayList<>();
        String query = "SELECT mp.maphieump, ph.tenphong, dg.tendocgia, mp.tgianmuon, mp.tgiantra, mp.ghichu " +
                       "FROM muonphong mp " +
                       "LEFT JOIN docgia dg ON mp.madocgia = dg.madocgia " +
                       "LEFT JOIN phonghoc ph ON mp.maphong = ph.maphong";
        try (Connection conn = ConnectToSQLServer.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Object[] row = new Object[] {
                    rs.getInt("maphieump"),
                    rs.getString("tenphong"),
                    rs.getString("tendocgia"),
                    convertTimestampToLocalDateTime(rs.getTimestamp("tgianmuon")),
                    convertTimestampToLocalDateTime(rs.getTimestamp("tgiantra")),
                    rs.getString("ghichu")
                };
                result.add(row);
            }
        }
        return result;
    }

    // Thêm mới một sự kiện
    public boolean addMuonPhong(MuonPhong mp) throws SQLException {
        String query = "INSERT INTO muonphong (maphong, madocgia, tgianmuon, tgiantra, ghichu) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConnectToSQLServer.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, mp.getMaphong());
            stmt.setInt(2, mp.getMadocgia());
            LocalDateTime tgianmuon = mp.getTgianmuon();
            LocalDateTime tgiantra = mp.getTgiantra();
            stmt.setTimestamp(3, tgianmuon != null ? Timestamp.valueOf(tgianmuon) : null);
            stmt.setTimestamp(4, tgiantra != null ? Timestamp.valueOf(tgiantra) : null);            
            stmt.setString(5, mp.getGhichu());
            return stmt.executeUpdate() > 0;
        }
    }
    
    // Cập nhật thông tin sự kiện
    public boolean updateMuonPhong(MuonPhong mp) throws SQLException {
        String query = "UPDATE muonphong SET maphong = ?, madocgia = ?, tgianmuon = ?, tgiantra = ?, ghichu = ? WHERE maphieump = ?";
        try (Connection conn = ConnectToSQLServer.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, mp.getMaphong());
            stmt.setInt(2, mp.getMadocgia());
            LocalDateTime tgianmuon = mp.getTgianmuon();
            LocalDateTime tgiantra = mp.getTgiantra();
            stmt.setTimestamp(3, tgianmuon != null ? Timestamp.valueOf(tgianmuon) : null);
            stmt.setTimestamp(4, tgiantra != null ? Timestamp.valueOf(tgiantra) : null);            
            stmt.setString(5, mp.getGhichu());
            stmt.setInt(6, mp.getMaphieump());
            return stmt.executeUpdate() > 0;
        }
    }

//     Xóa sự kiện theo mã
    public boolean deleteMuonPhong(int maphieump) throws SQLException {
        String query = "DELETE FROM muonphong WHERE maphieump = ?";
        try (Connection conn = ConnectToSQLServer.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, maphieump);
            return stmt.executeUpdate() > 0;
        }
    }
}
