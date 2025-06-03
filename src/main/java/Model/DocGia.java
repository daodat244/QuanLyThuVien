
package Model;

/**
 *
 * @author TUF
 */
public class DocGia {
private int madocgia;
private String tendocgia;
private int sdt;
private String email;
private String diachi;

    public DocGia() {
    }

    public DocGia(int madocgia, String tendocgia, int sdt, String email, String diachi) {
        this.madocgia = madocgia;
        this.tendocgia = tendocgia;
        this.sdt = sdt;
        this.email = email;
        this.diachi = diachi;
    }

    public int getMadocgia() {
        return madocgia;
    }

    public void setMadocgia(int madocgia) {
        this.madocgia = madocgia;
    }

    public String getTendocgia() {
        return tendocgia;
    }

    public void setTendocgia(String tendocgia) {
        this.tendocgia = tendocgia;
    }

    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

}
