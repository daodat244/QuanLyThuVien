/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.NhaXuatBan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NhaXuatBanDAO {
    public List<NhaXuatBan> getAllNhaXuatBan() throws SQLException {
        List<NhaXuatBan> nxbList = new ArrayList<>();
        String query = "SELECT * FROM nhaxuatban";
        try (Connection conn = ConnectToSQLServer.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                NhaXuatBan nxb = new NhaXuatBan(
                    rs.getInt("manxb"),
                    rs.getString("tennxb"),
                    rs.getString("sdt"),
                    rs.getString("email"),
                    rs.getString("diachi")
                );
                nxbList.add(nxb);
            }
        }
        return nxbList;
    }
    
        // Phương thức thêm mới tác giả
    public boolean addNXB(NhaXuatBan nxb) throws SQLException {
        String query = "INSERT INTO nhaxuatban (tennxb, sdt, email, diachi) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnectToSQLServer.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, nxb.getTennxb());
            stmt.setString(2, nxb.getSdt());
            stmt.setString(3, nxb.getEmail());
            stmt.setString(4, nxb.getDiachi());
            return stmt.executeUpdate() > 0;
        }
    }

    // Phương thức cập nhật thông tin tác giả
    public boolean updateNXB(NhaXuatBan nxb) throws SQLException {
        String query = "UPDATE nhaxuatban SET tennxb = ?, sdt = ?, email = ?, diachi = ? WHERE manxb = ?";
        try (Connection conn = ConnectToSQLServer.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nxb.getTennxb());
            stmt.setString(2, nxb.getSdt());
            stmt.setString(3, nxb.getEmail());
            stmt.setString(4, nxb.getDiachi());
            stmt.setInt(5, nxb.getManxb());
            return stmt.executeUpdate() > 0;
        }
    }

    // Phương thức xóa tác giả
    public boolean deleteNXB(int manxb) throws SQLException {
        String query = "DELETE FROM nhaxuatban WHERE manxb = ?";
        try (Connection conn = ConnectToSQLServer.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, manxb);
            return stmt.executeUpdate() > 0;
        }
    }
}
