/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDateTime;

/**
 *
 * @author TUF
 */
public class NhanVien {
private int manv;
private String tennv;
private int sdt;
private LocalDateTime ngaysinh;
private String quequan;

    public NhanVien() {
    }

    public NhanVien(int manv, String tennv, int sdt, LocalDateTime ngaysinh, String quequan) {
        this.manv = manv;
        this.tennv = tennv;
        this.sdt = sdt;
        this.ngaysinh = ngaysinh;
        this.quequan = quequan;
    }

    public int getManv() {
        return manv;
    }

    public void setManv(int manv) {
        this.manv = manv;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    public LocalDateTime getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(LocalDateTime ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getQuequan() {
        return quequan;
    }

    public void setQuequan(String quequan) {
        this.quequan = quequan;
    }

    
}
