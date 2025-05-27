/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author PC
 */
public class NhanVien {
    private int manhanvien;
    private String tennhanvien;
    private String sdt ;
    private int ngaysinh;    
    private String quequan;
    
    public NhanVien(){
    }

    public NhanVien(int manhanvien, String tennhanvien, String sdt, int ngaysinh, String quequan) {
        this.manhanvien = manhanvien;
        this.tennhanvien = tennhanvien;
        this.sdt = sdt;
        this.ngaysinh = ngaysinh;
        this.quequan = quequan;
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

    public int getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(int ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getQuequan() {
        return quequan;
    }

    public void setQuequan(String quequan) {
        this.quequan = quequan;
    }
    
}