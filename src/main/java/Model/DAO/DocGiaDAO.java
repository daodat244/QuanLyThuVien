package Model.DAO;

import Model.ConnectToSQLServer;
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
        try (Connection conn = ConnectToSQLServer.getConnection(); PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
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
        try (Connection conn = ConnectToSQLServer.getConnection(); PreparedStatement stmt = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
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
        try (Connection conn = ConnectToSQLServer.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
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
        try (Connection conn = ConnectToSQLServer.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, madocgia);
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean isDuplicatePhoneOrEmail(String sdt, String email, int madocgia) throws SQLException {
        String query = "SELECT COUNT(*) FROM docgia WHERE (sdt = ? OR email = ?) AND madocgia != ?";
        try (Connection conn = ConnectToSQLServer.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, sdt);
            stmt.setString(2, email);
            stmt.setInt(3, madocgia);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
            return false;
        }
    }
    // Tìm độc giả theo mã

    public DocGia getDocGiaById(int madocgia) throws SQLException {
        String query = "SELECT madocgia, tendocgia FROM DocGia WHERE madocgia = ?";
        try (Connection conn = ConnectToSQLServer.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
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
        try (Connection conn = ConnectToSQLServer.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
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
        try (Connection conn = ConnectToSQLServer.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
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
