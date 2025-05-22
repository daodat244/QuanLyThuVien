/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDateTime;

/**
 *  TIENDAT2
 * @author Asus
 */
public class SuKien {
    private int masukien;
    private String tensukien;
    private int manxb;
    private LocalDateTime tgiantochuc;
    private String mota;

    public SuKien() {
    }

    public SuKien(int masukien, String tensukien, int manxb, LocalDateTime tgiantochuc, String mota) {
        this.masukien = masukien;
        this.tensukien = tensukien;
        this.manxb = manxb;
        this.tgiantochuc = tgiantochuc;
        this.mota = mota;
    }

    public int getMasukien() {
        return masukien;
    }

    public void setMasukien(int masukien) {
        this.masukien = masukien;
    }

    public String getTensukien() {
        return tensukien;
    }

    public void setTensukien(String tensukien) {
        this.tensukien = tensukien;
    }

    public int getManxb() {
        return manxb;
    }

    public void setManxb(int manxb) {
        this.manxb = manxb;
    }

    public LocalDateTime getTgiantochuc() {
        return tgiantochuc;
    }

    public void setTgiantochuc(LocalDateTime tgiantochuc) {
        this.tgiantochuc = tgiantochuc;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }


}
