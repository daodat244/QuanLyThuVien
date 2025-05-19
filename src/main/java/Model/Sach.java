/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author PC
 */
public class Sach {
    private int masach;
    private String tensach;
    private int matacgia;
    private int manxb;    
    private int matheloai;
    private int namxb;
    private int sotrang;

    public Sach() {
    }

    public Sach(int masach, String tensach, int matacgia, int manxb, int matheloai, int namxb, int sotrang) {
        this.masach = masach;
        this.tensach = tensach;
        this.matacgia = matacgia;
        this.manxb = manxb;
        this.matheloai = matheloai;
        this.namxb = namxb;
        this.sotrang = sotrang;
    }

    public int getMasach() {
        return masach;
    }

    public void setMasach(int masach) {
        this.masach = masach;
    }

    public String getTensach() {
        return tensach;
    }

    public void setTensach(String tensach) {
        this.tensach = tensach;
    }

    public int getMatacgia() {
        return matacgia;
    }

    public void setMatacgia(int matacgia) {
        this.matacgia = matacgia;
    }

    public int getManxb() {
        return manxb;
    }

    public void setManxb(int manxb) {
        this.manxb = manxb;
    }

    public int getMatheloai() {
        return matheloai;
    }

    public void setMatheloai(int matheloai) {
        this.matheloai = matheloai;
    }

    public int getNamxb() {
        return namxb;
    }

    public void setNamxb(int namxb) {
        this.namxb = namxb;
    }

    public int getSotrang() {
        return sotrang;
    }

    public void setSotrang(int sotrang) {
        this.sotrang = sotrang;
    }
    
}
