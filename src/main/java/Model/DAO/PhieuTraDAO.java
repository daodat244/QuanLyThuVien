
package Model.DAO;

import Model.ConnectToSQLServer;
import Model.PhieuMuon;
import Model.PhieuTra;
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
public class PhieuTraDAO {

    public boolean addPhieuTra(PhieuTra pt, Connection conn) throws SQLException {
        String query = "INSERT INTO phieutra (maphieu, madocgia, manv, masach, ngaymuon, ngaytradukien, ngaytrathucte, phiphat, ghichu) " +
                      "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, pt.getMaphieu());
            stmt.setInt(2, pt.getMadocgia());
            stmt.setInt(3, pt.getManv());
            stmt.setInt(4, pt.getMasach());
            stmt.setObject(5, pt.getNgaymuon());
            stmt.setObject(6, pt.getNgaytradukien());
            stmt.setObject(7, pt.getNgaytrathucte());
            stmt.setDouble(8, pt.getPhiphat());
            stmt.setString(9, pt.getGhichu());
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        }
    }

    public PhieuMuon getPhieuMuonById(int maphieu) throws SQLException {
        String query = "SELECT * FROM phieumuon WHERE maphieu = ?";
        try (Connection conn = ConnectToSQLServer.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, maphieu);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new PhieuMuon(
                    rs.getInt("maphieu"),
                    rs.getInt("madocgia"),
                    rs.getInt("manv"),
                    rs.getInt("masach"),
                    rs.getObject("ngaymuon", LocalDateTime.class),
                    rs.getObject("ngaytradukien", LocalDateTime.class),
                    rs.getString("trangthai")
                );
            }
            return null;
        }
    }

    public List<PhieuTra> getAllPhieuTra() throws SQLException {
        List<PhieuTra> phieuTraList = new ArrayList<>();
        String query = "SELECT * FROM phieutra";
        try (Connection conn = ConnectToSQLServer.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                PhieuTra pt = new PhieuTra(
                    rs.getInt("maphieutra"),
                    rs.getInt("maphieu"),
                    rs.getInt("madocgia"),
                    rs.getInt("manv"),
                    rs.getInt("masach"),
                    rs.getObject("ngaymuon", LocalDateTime.class),
                    rs.getObject("ngaytradukien", LocalDateTime.class),
                    rs.getObject("ngaytrathucte", LocalDateTime.class),
                    rs.getDouble("phiphat"),
                    rs.getString("ghichu")
                );
                phieuTraList.add(pt);
            }
        }
        return phieuTraList;
    }

    public boolean deletePhieuMuon(int maphieu) throws SQLException {
        String query = "DELETE FROM phieumuon WHERE maphieu = ?";
        try (Connection conn = ConnectToSQLServer.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, maphieu);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        }
    }
}
