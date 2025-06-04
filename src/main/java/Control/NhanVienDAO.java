/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NhanVienDAO {
    public List<NhanVien> getAllNhanVien() throws SQLException {
        List<NhanVien> nvList = new ArrayList<>();
        String query = "SELECT * FROM nhanvien";
        try (Connection conn = ConnectToSQLServer.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                NhanVien nv = new NhanVien(
                    rs.getInt("manv"),
                    rs.getString("tennv"),
                    rs.getString("sdt"),
                    rs.getDate("ngaysinh"),
                    rs.getString("quequan")
                );
                nvList.add(nv);
            }
        }
        return nvList;
    }

    // Phương thức thêm mới nhân viên
    public boolean addNV(NhanVien nv) throws SQLException {
        String query = "INSERT INTO nhanvien (tennv, sdt, ngaysinh, quequan) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnectToSQLServer.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, nv.getTennhanvien());
            stmt.setString(2, nv.getSdt());
            stmt.setDate(3, nv.getNgaysinh() != null ? new java.sql.Date(nv.getNgaysinh().getTime()) : null);
            stmt.setString(4, nv.getQuequan());
            return stmt.executeUpdate() > 0;
        }
    }

    // Phương thức cập nhật thông tin nhân viên
    public boolean updateNV(NhanVien nv) throws SQLException {
        String query = "UPDATE nhanvien SET tennv = ?, sdt = ?, ngaysinh = ?, quequan = ? WHERE manv = ?";
        try (Connection conn = ConnectToSQLServer.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nv.getTennhanvien());
            stmt.setString(2, nv.getSdt());
            stmt.setDate(3, nv.getNgaysinh() != null ? new java.sql.Date(nv.getNgaysinh().getTime()) : null);
            stmt.setString(4, nv.getQuequan());
            stmt.setInt(5, nv.getManhanvien());
            return stmt.executeUpdate() > 0;
        }
    }

    // Phương thức xóa nhân viên
    public boolean deleteNV(int manhanvien) throws SQLException {
        String query = "DELETE FROM nhanvien WHERE manv = ?";
        try (Connection conn = ConnectToSQLServer.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, manhanvien);
            return stmt.executeUpdate() > 0;
        }
    }
}