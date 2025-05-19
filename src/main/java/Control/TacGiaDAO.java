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
}
