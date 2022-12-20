
package com.rifkkimaulana.program;

    //IMPORT LIB.
    import java.sql.PreparedStatement;
    import java.sql.Connection;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.util.ArrayList;
    import java.util.List;
    import javax.swing.JOptionPane;
    
    //LIB JASPERREPORT
    import net.sf.jasperreports.engine.*;
    import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Rifki Maulana
 */

public class fasilitas {
    
    // koneksi ke database
    private Connection koneksi;
    
    public fasilitas() {
      koneksi = KoneksiDatabase.getKoneksi();
    }
    
    //TAMBAH BUKU
    public void insert(buku buku){
        PreparedStatement pst = null;
    try {
        String sql = "INSERT INTO tb_buku(kode_buku, judul_buku, kategori_buku, harga_beli, harga_jual, stok_buku)VALUES(?,?,?,?,?,?)";
        pst = (PreparedStatement) koneksi.prepareStatement(sql);
        pst.setString(1, buku.getKode_buku());
        pst.setString(2, buku.getJudul_buku());
        pst.setString(3, buku.getKategori_buku());
        pst.setLong(4, buku.getHarga_beli());
        pst.setLong(5, buku.getHarga_jual());
        pst.setInt(6, buku.getStok_buku());
        pst.executeUpdate();
        System.out.println("Prepare statement berhasil dibuat");
 }catch(SQLException ex){
        System.out.println("Prepare statement gagal dibuat"); 
        System.out.println("Pesan : " + ex.getMessage());
 }finally{
    if (pst != null){
    try{
        pst.close();
        System.out.println("Prepare statemen berhasil ditutup");
 }catch(SQLException ex){
        System.out.println("Prepare statemen gagal ditutup"); 
        System.out.println("Pesan : " + ex.getMessage());
      }
    }
  }
}
  
    //UBAH BUKU
    public void update(buku buku){
        
    PreparedStatement pst = null;
    
    try {
        String sql ="UPDATE tb_buku barang SET judul_buku=?, kategori_buku=?, harga_beli=?, harga_jual=?, stok_buku=? WHERE kode_buku=?";
        pst = (PreparedStatement) koneksi.prepareStatement(sql);
        pst.setString(1, buku.getJudul_buku());
        pst.setString(2, buku.getKategori_buku());
        pst.setLong(3, buku.getHarga_beli());
        pst.setLong(4, buku.getHarga_jual());
        pst.setInt(5, buku.getStok_buku());
        pst.setString(6, buku.getKode_buku());
        pst.executeUpdate();
        System.out.println("Prepare statement berhasil dibuat");
 }catch(SQLException ex){        
            System.out.println("Prepare statement gagal dibuat"); 
            System.out.println("Pesan : " + ex.getMessage());
 }finally{
    if (pst != null){
 try{
    pst.close();
        System.out.println("Prepare statemen berhasil ditutup");
 }catch(SQLException ex){
        System.out.println("Prepare statemen gagal ditutup"); 
        System.out.println("Pesan : " + ex.getMessage());
       }
     }
   }
 }
    
    //HAPUS BUKU
public void delete(String kode_buku){
        PreparedStatement pst = null;
 try {
      String sql ="DELETE FROM tb_buku WHERE kode_buku=?";
      pst = (PreparedStatement) koneksi.prepareStatement(sql);
      pst.setString(1, kode_buku);
      pst.executeUpdate();
      System.out.println("Prepare statement berhasil dibuat");
 }catch(SQLException ex){
      System.out.println("Prepare statement gagal dibuat"); 
      System.out.println("Pesan : " + ex.getMessage());
 }finally{
    if (pst != null){
 try{
     pst.close();
     System.out.println("Prepare statemen berhasil ditutup");
 }catch(SQLException ex){
     System.out.println("Prepare statemen gagal ditutup"); 
        System.out.println("Pesan : " + ex.getMessage());
       }
     }
   }
 }

//LIHAT BUKU
 public List<buku> lihatBuku(){
    PreparedStatement pst = null;
    ResultSet rs = null;
    List<buku> list = new ArrayList<>();
 try {
      String sql ="SELECT * FROM tb_buku";
      pst = (PreparedStatement) koneksi.prepareStatement(sql);
      rs = pst.executeQuery();
 while(rs.next()){
      buku perintah = new buku();
      perintah.setKode_buku(rs.getString("kode_buku"));
      perintah.setJudul_buku(rs.getString("judul_buku"));
      perintah.setKategori_buku(rs.getString("kategori_buku"));
      perintah.setHarga_beli(rs.getLong("harga_beli"));
      perintah.setHarga_jual(rs.getLong("harga_jual"));
      perintah.setStok_buku(rs.getInt("stok_buku"));
      
      list.add(perintah);
 }
      System.out.println("Prepare statement berhasil dibuat");
 return list;
 
 }catch(SQLException ex){
      System.out.println("Prepare statement gagal dibuat"); 
      System.out.println("Pesan : " + ex.getMessage());
 return list;
 
 }finally{
    if (pst != null){
 try{
       pst.close();
       System.out.println("Prepare statemen berhasil ditutup");
 }catch(SQLException ex){
       System.out.println("Prepare statemen gagal ditutup"); 
       System.out.println("Pesan : " + ex.getMessage());
 }
 }
 if (rs != null){
     try{
        rs.close();
        System.out.println("Resultset berhasil ditutup");
 }catch(SQLException ex){
        System.out.println("Resultset gagal ditutup"); 
        System.out.println("Pesan : " + ex.getMessage());

        }
      }
    }
  }
 
 

 //report path
private String ReportPath="src/report/";
public void viewReport(String nm_report){
    String reportSource;
    String reportDest;
    reportSource = ReportPath+"laporan/"+nm_report+".jrxml";
    reportDest = ReportPath+"hasil/"+nm_report+".html";
    
    try {
        JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null,koneksi);
        JasperExportManager.exportReportToHtmlFile(jasperPrint, reportDest);
        JasperViewer.viewReport(jasperPrint, false);
        
    }
    catch (JRException e) {
        
        e.getStackTrace();
    }
} 
}
