/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Taikhoan;

/**
 *
 * @author trant
 */
public class DangKy extends DangNhap{

    private String hoVaTen;
    private String ngaySinh;
    private String gioiTinh;

    public DangKy() {
    }

    public DangKy(String hoVaTen, String ngaySinh, String gioiTinh) {
        this.hoVaTen = hoVaTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
    }

    public  DangKy(String hoVaTen, String ngaySinh, String soDienThoai, String gioiTinh, String matKhau)  {
        super(soDienThoai, matKhau);
        this.hoVaTen = hoVaTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
    }
    

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    
    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
    

}
