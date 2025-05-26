package Control;

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
 * @author TUF
 */
public class PhieuMuonDAO {
    public List<PhieuMuon> getAllPhieuMuonWithDetails() throws SQLException {
        List<PhieuMuon> phieuMuonList = new ArrayList<>();
        String query = "SELECT pm.maphieu, pm.madocgia, pm.manv, cpm.masach, pm.ngaymuon, pm.ngaytra, pm.trangthai, d.tendocgia, nv.tennv, s.tensach " +
                       "FROM phieumuon pm " +
                       "LEFT JOIN docgia d ON pm.madocgia = d.madocgia " +
                       "LEFT JOIN nhanvien nv ON pm.manv = nv.manv " +
                       "LEFT JOIN chitietphieumuon cpm ON pm.maphieu = cpm.maphieu " +
                       "LEFT JOIN sach s ON cpm.masach = s.masach";
        try (Connection conn = ConnectToSQLServer.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int masach = rs.getInt("masach");
                if (rs.wasNull()) {
                    masach = -1; // Giá trị mặc định nếu masach null
                }
                PhieuMuon pm = new PhieuMuon(
                    rs.getInt("maphieu"),
                    rs.getInt("madocgia"),
                    rs.getInt("manv"),
                    masach,
                    rs.getObject("ngaymuon", LocalDateTime.class),
                    rs.getObject("ngaytra", LocalDateTime.class),
                    rs.getString("trangthai")
                );
                phieuMuonList.add(pm);
            }
        }
        return phieuMuonList;
    }

    public boolean addPhieuMuon(PhieuMuon pm) throws SQLException {
        String query = "INSERT INTO phieumuon (madocgia, manv, masach, ngaymuon, ngaytra, trangthai) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConnectToSQLServer.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, pm.getMadocgia());
            stmt.setInt(2, pm.getManv());
            stmt.setInt(3, pm.getMasach());
            stmt.setObject(4, pm.getNgaymuon());
            stmt.setObject(5, pm.getNgaytra());
            stmt.setString(6, "Chưa trả"); // Tự động đặt trạng thái là "Chưa trả"
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    int maphieu = rs.getInt(1);
                    String queryChiTiet = "INSERT INTO chitietphieumuon (maphieu, masach) VALUES (?, ?)";
                    try (PreparedStatement stmtChiTiet = conn.prepareStatement(queryChiTiet)) {
                        stmtChiTiet.setInt(1, maphieu);
                        stmtChiTiet.setInt(2, pm.getMasach());
                        stmtChiTiet.executeUpdate();
                    }
                }
                return true;
            }
            return false;
        }
    }

    public boolean updatePhieuMuon(PhieuMuon pm) throws SQLException {
        Connection conn = null;
        try {
            conn = ConnectToSQLServer.getConnection();
            conn.setAutoCommit(false);

            // Cập nhật bảng phieumuon
            String queryPhieuMuon = "UPDATE phieumuon SET madocgia = ?, manv = ?, masach = ?, ngaymuon = ?, ngaytra = ?, trangthai = ? WHERE maphieu = ?";
            try (PreparedStatement stmtPhieuMuon = conn.prepareStatement(queryPhieuMuon)) {
                stmtPhieuMuon.setInt(1, pm.getMadocgia());
                stmtPhieuMuon.setInt(2, pm.getManv());
                stmtPhieuMuon.setInt(3, pm.getMasach());
                stmtPhieuMuon.setObject(4, pm.getNgaymuon());
                stmtPhieuMuon.setObject(5, pm.getNgaytra());
                stmtPhieuMuon.setString(6, pm.getTrangthai() != null ? pm.getTrangthai() : "Chưa trả"); // Giữ trạng thái hiện tại hoặc đặt "Chưa trả" nếu null
                stmtPhieuMuon.setInt(7, pm.getMaphieu());
                int rowsAffectedPhieuMuon = stmtPhieuMuon.executeUpdate();
                if (rowsAffectedPhieuMuon == 0) {
                    System.err.println("No rows updated in phieumuon for maphieu = " + pm.getMaphieu());
                    conn.rollback();
                    return false;
                }
            }

            // Cập nhật bảng chitietphieumuon
            String queryChiTiet = "UPDATE chitietphieumuon SET masach = ? WHERE maphieu = ?";
            try (PreparedStatement stmtChiTiet = conn.prepareStatement(queryChiTiet)) {
                stmtChiTiet.setInt(1, pm.getMasach());
                stmtChiTiet.setInt(2, pm.getMaphieu());
                int rowsAffectedChiTiet = stmtChiTiet.executeUpdate();
                if (rowsAffectedChiTiet == 0) {
                    System.err.println("No rows updated in chitietphieumuon for maphieu = " + pm.getMaphieu());
                    conn.rollback();
                    return false;
                }
            }

            conn.commit();
            System.out.println("Successfully updated phieu mượn with maphieu = " + pm.getMaphieu());
            return true;
        } catch (SQLException ex) {
            if (conn != null) {
                conn.rollback();
                System.err.println("SQLException in updatePhieuMuon: " + ex.getMessage());
            }
            throw ex;
        } finally {
            if (conn != null) {
                conn.setAutoCommit(true);
                conn.close();
            }
        }
    }

    public boolean deletePhieuMuon(int maphieu) throws SQLException {
        String queryChiTiet = "DELETE FROM chitietphieumuon WHERE maphieu = ?";
        String queryPhieuMuon = "DELETE FROM phieumuon WHERE maphieu = ?";
        
        try (Connection conn = ConnectToSQLServer.getConnection();
             PreparedStatement stmtChiTiet = conn.prepareStatement(queryChiTiet);
             PreparedStatement stmtPhieuMuon = conn.prepareStatement(queryPhieuMuon)) {
            
            conn.setAutoCommit(false);
            
            stmtChiTiet.setInt(1, maphieu);
            stmtChiTiet.executeUpdate();
            
            stmtPhieuMuon.setInt(1, maphieu);
            int rowsAffected = stmtPhieuMuon.executeUpdate();
            
            conn.commit();
            
            return rowsAffected > 0;
        } catch (SQLException ex) {
            try (Connection conn = ConnectToSQLServer.getConnection()) {
                conn.rollback();
            }
            throw ex;
        } finally {
            try (Connection conn = ConnectToSQLServer.getConnection()) {
                conn.setAutoCommit(true);
            }
        }
    }
    public boolean returnBook(int maphieu) throws SQLException {
        String query = "UPDATE phieumuon SET trangthai = ? WHERE maphieu = ?";
        try (Connection conn = ConnectToSQLServer.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, "Đã trả");
            stmt.setInt(2, maphieu);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        }
    }

    public List<PhieuMuon> searchPhieuMuon(String keyword) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}