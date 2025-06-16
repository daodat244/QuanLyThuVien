
package Model.DAO;


import Model.ConnectToSQLServer;
import java.sql.*;

public class ThongKeDAO {
    private Connection conn;

    

    // Hàm lấy số lượng sách từ bảng SACH
    public int getSoLuongSach() {
        String sql = "SELECT COUNT(*) FROM sach";
        try (Connection conn = ConnectToSQLServer.getConnection(); 
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Log lỗi nếu có
        }
        return 0;  // Nếu không có sách, trả về 0
    }
    
    public int getSoLuongNXB() {
        String sql = "SELECT COUNT(*) FROM nhaxuatban";
        try (Connection conn = ConnectToSQLServer.getConnection(); 
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Log lỗi nếu có
        }
        return 0;  // Nếu không có sách, trả về 0
    }
    
    public int getSoLuongTG() {
        String sql = "SELECT COUNT(*) FROM tacgia";
        try (Connection conn = ConnectToSQLServer.getConnection(); 
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Log lỗi nếu có
        }
        return 0;  // Nếu không có sách, trả về 0
    }
    
    public int getSoLuongSK() {
        String sql = "SELECT COUNT(*) FROM sukien";
        try (Connection conn = ConnectToSQLServer.getConnection(); 
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Log lỗi nếu có
        }
        return 0;  // Nếu không có sách, trả về 0
    }
    
    public int getSoLuongDocGia() {
        String sql = "SELECT COUNT(*) FROM docgia";
        try (Connection conn = ConnectToSQLServer.getConnection(); 
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Log lỗi nếu có
        }
        return 0;  // Nếu không có sách, trả về 0
    }
    
    public int getSoLuongTheLoai() {
        String sql = "SELECT COUNT(*) FROM theloai";
        try (Connection conn = ConnectToSQLServer.getConnection(); 
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Log lỗi nếu có
        }
        return 0;  // Nếu không có sách, trả về 0
    }
    
    public int getSoLuongMuonPhong() {
        String sql = "SELECT COUNT(*) FROM muonphong";
        try (Connection conn = ConnectToSQLServer.getConnection(); 
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Log lỗi nếu có
        }
        return 0;  // Nếu không có sách, trả về 0
    }
    
    public int getSoLuongPhieuMuon() {
        String sql = "SELECT COUNT(*) FROM phieumuon";
        try (Connection conn = ConnectToSQLServer.getConnection(); 
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Log lỗi nếu có
        }
        return 0;  // Nếu không có sách, trả về 0
    }
    
    public int getSoLuongPhieuTra() {
        String sql = "SELECT COUNT(*) FROM phieutra";
        try (Connection conn = ConnectToSQLServer.getConnection(); 
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Log lỗi nếu có
        }
        return 0;  // Nếu không có sách, trả về 0
    }
    
    public int getSoLuongNhanVien() {
        String sql = "SELECT COUNT(*) FROM nhanvien";
        try (Connection conn = ConnectToSQLServer.getConnection(); 
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Log lỗi nếu có
        }
        return 0;  // Nếu không có sách, trả về 0
    }
    
    public int getSoLuongTaiKhoan() {
        String sql = "SELECT COUNT(*) FROM taikhoan";
        try (Connection conn = ConnectToSQLServer.getConnection(); 
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Log lỗi nếu có
        }
        return 0;  // Nếu không có sách, trả về 0
    }
    
    public int getTongPhiPhat() {
        String sql = "SELECT SUM(phiphat) AS tongphiphat " +
                     "FROM phieutra;";
        try (Connection conn = ConnectToSQLServer.getConnection(); 
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Log lỗi nếu có
        }
        return 0;  // Nếu không có sách, trả về 0
    }
}
