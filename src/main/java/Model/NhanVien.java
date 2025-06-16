package Model;

import java.util.Date;

/**
 *
 * @author PC
 */
public class NhanVien {
    private int manhanvien;
    private String tennhanvien;
    private String sdt;
    private Date ngaysinh;    
    private String quequan;
    private String gioitinh;
    
    public NhanVien() {
    }

    public NhanVien(int manhanvien, String tennhanvien, String sdt, Date ngaysinh, String quequan, String gioitinh) {
        this.manhanvien = manhanvien;
        this.tennhanvien = tennhanvien;
        this.sdt = sdt;
        this.ngaysinh = ngaysinh;
        this.quequan = quequan;
        this.gioitinh = gioitinh;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public int getManhanvien() {
        return manhanvien;
    }

    public void setManhanvien(int manhanvien) {
        this.manhanvien = manhanvien;
    }

    public String getTennhanvien() {
        return tennhanvien;
    }

    public void setTennhanvien(String tennhanvien) {
        this.tennhanvien = tennhanvien;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getQuequan() {
        return quequan;
    }

    public void setQuequan(String quequan) {
        this.quequan = quequan;
    }
}