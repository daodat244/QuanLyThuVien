/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
    
    public NhanVien() {
    }

    public NhanVien(int manhanvien, String tennhanvien, String sdt, Date ngaysinh, String quequan) {
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