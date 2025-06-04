/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author PC
 */
public class TacGia {
    private int matacgia;
    private String tentacgia;
    private int namsinh;
    private String quequan;    
    private String mota;
    private String sdt;
    private String email;

    public TacGia() {
    }

    public TacGia(int matacgia, String tentacgia, int namsinh, String quequan, String mota, String sdt, String email) {
        this.matacgia = matacgia;
        this.tentacgia = tentacgia;
        this.namsinh = namsinh;
        this.quequan = quequan;
        this.mota = mota;
        this.sdt = sdt;
        this.email = email;
    }

    public int getMatacgia() {
        return matacgia;
    }

    public void setMatacgia(int matacgia) {
        this.matacgia = matacgia;
    }

    public String getTentacgia() {
        return tentacgia;
    }

    public void setTentacgia(String tentacgia) {
        this.tentacgia = tentacgia;
    }

    public int getNamsinh() {
        return namsinh;
    }

    public void setNamsinh(int namsinh) {
        this.namsinh = namsinh;
    }

    public String getQuequan() {
        return quequan;
    }

    public void setQuequan(String quequan) {
        this.quequan = quequan;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    @Override
    public String toString() {
        return tentacgia; // Hiển thị trong JComboBox
    }
}
