/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author PC
 */
public class TaiKhoan {
    private int mataikhoan;
    private int manhanvien;
    private String tendangnhap;
    private String matkhau;
    private String role;

    public TaiKhoan() {
    }

    public TaiKhoan(int mataikhoan, int manhanvien, String tendangnhap, String matkhau, String role) {
        this.mataikhoan = mataikhoan;
        this.manhanvien = manhanvien;
        this.tendangnhap = tendangnhap;
        this.matkhau = matkhau;
        this.role = role;
    }

    public int getMataikhoan() {
        return mataikhoan;
    }

    public void setMataikhoan(int mataikhoan) {
        this.mataikhoan = mataikhoan;
    }

    public int getManhanvien() {
        return manhanvien;
    }

    public void setManhanvien(int manhanvien) {
        this.manhanvien = manhanvien;
    }

    public String getTendangnhap() {
        return tendangnhap;
    }

    public void setTendangnhap(String tendangnhap) {
        this.tendangnhap = tendangnhap;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
}
