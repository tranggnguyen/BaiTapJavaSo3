/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dieukhien;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 */
public class DieuKhien {

  public Connection ketNoiSQL(){
// Create datasource.
       SQLServerDataSource ds = new SQLServerDataSource();  
        ds.setUser("sa");  
        ds.setPassword("123");  
        ds.setServerName("LAPTOP-TS26SMTG\\TTRANG");  
        ds.setPortNumber(1433);
        ds.setDatabaseName("quanlytaikhoan");  
        ds.setEncrypt(false);
        ds.setTrustServerCertificate(false);
        try {
            return ds.getConnection();
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }   
}

