/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dieukhien;

import Taikhoan.DangKy;
import Taikhoan.DangNhap;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author trant
 */
public class DieuKhienDK {

    ketnoi kn = new ketnoi();

    public List<DangKy> layDuLieu() throws SQLException {
        try {
            Connection con = kn.connectSQL();
            String sql = "select * from THONGTINTK ";
            ResultSet rs = null;
            Statement stm = con.createStatement();
            rs = stm.executeQuery(sql);
            List<DangKy> layDL = new ArrayList<>();

            while (rs.next()) {
                DangKy dk = new DangKy(rs.getString(3), rs.getString(4), rs.getString(1), rs.getString(5), rs.getString(2));
                layDL.add(dk);
            }

            return layDL;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void themTK(DangKy dk) {
        try {
            Connection con = kn.connectSQL();
            String sql = "insert into THONGTINTK values (?,?,?,?,?)";
            ResultSet rs = null;
            PreparedStatement smt = null;// statement tạo truy vấn
            smt = con.prepareStatement(sql);//TẠO TRUY VẤN
            smt.setString(1, dk.getSoDienThoai());
            smt.setString(2, dk.getMatKhau());
            smt.setString(3, dk.getHoVaTen());
            smt.setString(4, dk.getNgaySinh());
            smt.setString(5, dk.getGioiTinh());

            smt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public DangKy kiemTraTK(DangKy dk) throws SQLException {
        List<DangKy> layDL = new ArrayList<>();
        layDL = layDuLieu();
        for (DangKy s : layDL) {
            if (dk.getSoDienThoai().equals(s.getSoDienThoai())) {
                return s;
            }
        }
        return null;
    }
}
