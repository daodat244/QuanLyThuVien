/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.TheLoai;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TheLoaiDAO {
    public List<TheLoai> getAllTheLoai() throws SQLException {
        List<TheLoai> theLoaiList = new ArrayList<>();
        String query = "SELECT * FROM theloai";
        try (Connection conn = ConnectToSQLServer.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                TheLoai theLoai = new TheLoai(
                    rs.getInt("matheloai"),
                    rs.getString("tentheloai"),
                    rs.getString("mota")
                );
                theLoaiList.add(theLoai);
            }
        }
        return theLoaiList;
    }
}
