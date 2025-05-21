/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Asus
 */
public class MuonPhong {
    private int maphong;
    private String tenphong;
    private String mota;
    
    
    public MuonPhong(){
    }
    public MuonPhong(int maphong, String tenphong, String mota) {
        this.maphong = maphong;
        this.tenphong = tenphong;
        this.mota = mota;
    }
    
    public int getMaphong() {
        return maphong;
    }

    public void setMaphong(int maphong) {
        this.maphong = maphong;
    }

    public String getTenphong() {
        return tenphong;
    }

    public void setTenphong(String tenphong) {
        this.tenphong = tenphong;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
}
