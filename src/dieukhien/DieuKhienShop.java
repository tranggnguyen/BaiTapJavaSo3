/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dieukhien;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import quanlyquanao.shop;

/**
 *
 * @author trant
 */
public class DieuKhienShop {

    DieuKhien dk = new DieuKhien();//khai báo phương thức lớp 

    public List<shop> layDuLieu(String loaiShop) throws SQLException {
        String sql = "select * from " + loaiShop;// lấy từ sql
        Statement smt = null;// statement tạo truy vấn
        ResultSet rs = null;//ResultSet lấy dl từ truy vấn
        List<shop> listshop = new ArrayList<>();//tạo ra danh sách list
        try {
            Connection con = dk.ketNoiSQL();
            smt = con.createStatement();//TẠO TRUY VẤN
            rs = smt.executeQuery(sql);// lấy dl từ truy vấn
            while (rs.next()) {//chạy từng dlieu
                shop s = new shop(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));//gán từng dlieu vào sach
                listshop.add(s);// thêm sách vào danh sách
            }
            return listshop;// trả về dsach 
        } catch (SQLException ex) {//lấy lỗi
            System.out.println(ex);
        }
        return null;//trả về rỗng
    }

    public void themshop(String loaiShop, shop sach) {
        String sql = "insert into " + loaiShop + " values (?,?,?,?)";// lấy từ sql
        PreparedStatement smt = null;// statement tạo truy vấn

        try {
            Connection con = dk.ketNoiSQL();
            smt = con.prepareStatement(sql);//TẠO TRUY VẤN
            smt.setString(1, sach.getMaHang());
            smt.setString(2, sach.getTenHang());
            smt.setString(3, sach.getGia());
            smt.setString(4, sach.getSize());
            smt.execute();

        } catch (SQLException ex) {//lấy lỗi
            System.out.println(ex);
        }

    }

    public void xoashop(String loaiShop, shop sach) throws SQLException {
        String sql = "delete from " + loaiShop + " where maHang=?";
        Connection con;
        PreparedStatement smt = null;
        try {
            con = dk.ketNoiSQL();
            smt = con.prepareCall(sql);
            smt.setString(1, sach.getMaHang());
            smt.execute();
            JOptionPane.showMessageDialog(null, "Đã xóa thành công");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public shop timkimshop(String loaiShop,shop s) throws SQLException {
        List<shop> listshop = new ArrayList<>();
        listshop = layDuLieu(loaiShop);
        for (shop sach : listshop) {
            if (sach.getMaHang().equals(s.getMaHang())) {
                return sach;
            }
        }
        return null;

    }

}
