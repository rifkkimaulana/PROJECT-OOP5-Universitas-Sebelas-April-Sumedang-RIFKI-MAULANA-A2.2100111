
package com.rifkkimaulana.program;
//import library
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
//import java.sql.Statement;
//import javax.swing.JOptionPane;

/**
 *
 * @author Rifki Maulana
 */

public class KoneksiDatabase {
    
    //Statement stm;
    static Connection koneksi;
    public static Connection getKoneksi() {
        if (koneksi == null) {
        try {
            String url = "jdbc:mysql://localhost:3306/db_penjualanBukuOnline";
            String user="root";
            String pass="";
            koneksi = DriverManager.getConnection(url, user, pass);
            System.out.println("Koneksi ke database berhasil.");
            System.out.println("Koneksi Statement berhasil dibuat.");
            
        }
        catch(SQLException ex) {
            System.out.println("Koneksi ke database gagal");
            System.out.println("Pesan : " +ex.getMessage());
            JOptionPane.showMessageDialog(null, "Koneksi ke database gagal");
        }
    }
        return koneksi;
  } 
    public static void main(String[] args) {
        KoneksiDatabase.getKoneksi();
    }
  
}


