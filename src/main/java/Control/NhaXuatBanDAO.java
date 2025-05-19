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
}
