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
public class PhieuMuon {
    private int maphieu;
    private int madocgia;
    private int manv;
    private int masach;
    private LocalDateTime ngaymuon;
    private LocalDateTime ngaytra;
    private String trangthai;
    

    public PhieuMuon() {
    }

    public PhieuMuon(int maphieu, int madocgia, int manv, int masach, LocalDateTime ngaymuon, LocalDateTime ngaytra, String trangthai) {
        this.maphieu = maphieu;
        this.madocgia = madocgia;
        this.manv = manv;
        this.masach = masach;
        this.ngaymuon = ngaymuon;
        this.ngaytra = ngaytra;
        this.trangthai = trangthai;
        
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

    public int getMasach() {
        return masach;
    }

    public void setMasach(int masach) {
        this.masach = masach;
    }

    public LocalDateTime getNgaymuon() {
        return ngaymuon;
    }

    public void setNgaymuon(LocalDateTime ngaymuon) {
        this.ngaymuon = ngaymuon;
    }

    public LocalDateTime getNgaytra() {
        return ngaytra;
    }

    public void setNgaytra(LocalDateTime ngaytra) {
        this.ngaytra = ngaytra;
    }
        public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

}
