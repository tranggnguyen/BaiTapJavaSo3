/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyquanao;

/**
 *
 * @author trant
 */
public class shop {

    private String maHang;
    private String tenHang;
    private String gia;
    private String size;

    public shop() {
    }

    public shop(String maHang, String tenHang, String gia, String size) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.gia = gia;
        this.size = size;
    }

    public String getMaHang() {
        return maHang;
    }

    public void setMaHang(String maHang) {
        this.maHang = maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    
}
