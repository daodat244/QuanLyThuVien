/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


import java.time.LocalDateTime;

/**
 *
 * @author Asus
 */
public class MuonPhong {
    private int maphieump;
    private int maphong;
    private int madocgia;
    private LocalDateTime tgianmuon;
    private LocalDateTime tgiantra;
    private String ghichu;

    public MuonPhong() {
    }
    
    public MuonPhong(int maphieump, int maphong, int madocgia, LocalDateTime tgianmuon, LocalDateTime tgiantra, String ghichu) {
        this.maphieump = maphieump;
        this.maphong = maphong;
        this.madocgia = madocgia;
        this.tgianmuon = tgianmuon;
        this.tgiantra = tgiantra;
        this.ghichu = ghichu;
    }
    
    
    public int getMaphieump() {
        return maphieump;
    }
    
    public void setMaphieump(int maphieump) {
        this.maphieump = maphieump;
    }
    
    public int getMaphong() {
        return maphong;
    }

    public void setMaphong(int maphong) {
        this.maphong = maphong;
    }

    public int getMadocgia() {
        return madocgia;
    }

    public void setMadocgia(int madocgia) {
        this.madocgia = madocgia;
    }

    public LocalDateTime getTgianmuon() {
        return tgianmuon;
    }

    public void setTgianmuon(LocalDateTime tgianmuon) {
        this.tgianmuon = tgianmuon;
    }
    
    public LocalDateTime getTgiantra() {
        return tgiantra;
    }

    public void setTgiantra(LocalDateTime tgiantra) {
        this.tgiantra = tgiantra;
    }
    
    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }
}
