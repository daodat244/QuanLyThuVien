/*
 * Click nbfs://.netbeans.org/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click https://netbeans.org/projects/templates to edit this template
 */
package Model.DAO;

import Model.ConnectToSQLServer;
import Model.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author TUF
 */
public class NhanVienDAO {

    public NhanVien getNhanVienById(int manv) throws SQLException {
        String query = "SELECT * FROM nhanvien WHERE manv = ?";
        try (Connection conn = ConnectToSQLServer.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setInt(1, manv);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    NhanVien nhanVien = new NhanVien();
                    nhanVien.setManv(rs.getInt("manv"));
                    nhanVien.setTennv(rs.getString("tennv"));
                    nhanVien.setSdt((int) rs.getLong("sdt"));
                    nhanVien.setNgaysinh(rs.getDate("ngaysinh").toLocalDate().atStartOfDay());
                    nhanVien.setQuequan(rs.getString("quequan"));
                    System.out.println("Found staff: manv = " + rs.getInt("manv") + ", tennv = " + rs.getString("tennv"));
                    return nhanVien;
                } else {
                    System.out.println("No staff found for manv = " + manv);
                }
            }
        } catch (SQLException e) {
            System.err.println("SQLException in getNhanVienById: " + e.getMessage());
            throw e;
        }
        return null;
    }
    public int getMaNhanVienByTen(String tenNhanVien) throws SQLException {
    String query = "SELECT manv FROM nhanvien WHERE tennv = ?";
    try (Connection conn = ConnectToSQLServer.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {
        stmt.setString(1, tenNhanVien);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                int manv = rs.getInt("manv");
                System.out.println("Found manv = " + manv + " for tennv = " + tenNhanVien);
                return manv;
            } else {
                System.out.println("No manv found for tennv = " + tenNhanVien);
            }
        }
    } catch (SQLException e) {
        System.err.println("SQLException in getMaNhanVienByTen: " + e.getMessage());
        throw e;
    }
    return -1; // Trả về -1 nếu không tìm thấy
}
}