/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDateTime;

/**
 *
 * @author PC
 */
public class PhieuTra {
    private int maphieutra;    
    private int maphieu;
    private int madocgia;
    private int manv;
    private String masach;
    private LocalDateTime ngaymuon;
    private LocalDateTime ngaytradukien;
    private LocalDateTime ngaytrathucte;
    private double phiphat;
    private String ghichu;

    public PhieuTra() {
    }

    public PhieuTra(int maphieutra, int maphieu, int madocgia, int manv, String masach, LocalDateTime ngaymuon, LocalDateTime ngaytradukien, LocalDateTime ngaytrathucte, double phiphat, String ghichu) {
        this.maphieutra = maphieutra;
        this.maphieu = maphieu;
        this.madocgia = madocgia;
        this.manv = manv;
        this.masach = masach;
        this.ngaymuon = ngaymuon;
        this.ngaytradukien = ngaytradukien;
        this.ngaytrathucte = ngaytrathucte;
        this.phiphat = phiphat;
        this.ghichu = ghichu;
    }

    public int getMaphieutra() {
        return maphieutra;
    }

    public void setMaphieutra(int maphieutra) {
        this.maphieutra = maphieutra;
    }

    public int getMaphieu() {
        return maphieu;
    }

    public void setMaphieu(int maphieu) {
        this.maphieu = maphieu;
    }

    public int getMadocgia() {
        return madocgia;
    }

    public void setMadocgia(int madocgia) {
        this.madocgia = madocgia;
    }

    public int getManv() {
        return manv;
    }

    public void setManv(int manv) {
        this.manv = manv;
    }

    public String getMasach() {
        return masach;
    }

    public void setMasach(String masach) {
        this.masach = masach;
    }

    public LocalDateTime getNgaymuon() {
        return ngaymuon;
    }

    public void setNgaymuon(LocalDateTime ngaymuon) {
        this.ngaymuon = ngaymuon;
    }

    public LocalDateTime getNgaytradukien() {
        return ngaytradukien;
    }

    public void setNgaytradukien(LocalDateTime ngaytradukien) {
        this.ngaytradukien = ngaytradukien;
    }

    public LocalDateTime getNgaytrathucte() {
        return ngaytrathucte;
    }

    public void setNgaytrathucte(LocalDateTime ngaytrathucte) {
        this.ngaytrathucte = ngaytrathucte;
    }

    public double getPhiphat() {
        return phiphat;
    }

    public void setPhiphat(double phiphat) {
        this.phiphat = phiphat;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }


}
