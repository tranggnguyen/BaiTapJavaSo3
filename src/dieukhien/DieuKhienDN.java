/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dieukhien;

import Taikhoan.DangNhap;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author trant
 */
public class DieuKhienDN {

    ketnoi kn = new ketnoi();

    public List<DangNhap> layDuLieu() throws SQLException {
        try {
            Connection con = kn.connectSQL();
            String sql = "select SDT,matKhau from THONGTINTK ";
            ResultSet rs = null;
            Statement stm = con.createStatement();
            rs = stm.executeQuery(sql);
            List<DangNhap> layDL = new ArrayList<>();

            while (rs.next()) {
                DangNhap dn = new DangNhap(rs.getString(1), rs.getString(2));
                layDL.add(dn);
            }

            return layDL;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public DangNhap kiemTraTK(DangNhap dn) throws SQLException {
        List<DangNhap> layDL = new ArrayList<>();
        layDL = layDuLieu();
        for (DangNhap s : layDL) {
            if (dn.getSoDienThoai().equals(s.getSoDienThoai()) && dn.getMatKhau().equals(s.getMatKhau())) {
                return s;
            }
        }
        return null;
    }
}
