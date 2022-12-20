
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

public class fasilitasTransaksi {
    
    // koneksi ke database
    private Connection koneksi;
    
    public fasilitasTransaksi() {
      koneksi = KoneksiDatabase.getKoneksi();
    }
//DELETE 1
    public void delete1(String no_transaksi){
        PreparedStatement pst = null;
 try {
      String sql ="DELETE FROM tb_detail_transaksi WHERE no_transaksi=?";
      pst = (PreparedStatement) koneksi.prepareStatement(sql);
      pst.setString(1, no_transaksi);
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
    //DELETE 2
    public void delete2(String no_transaksi){
        PreparedStatement pst = null;
 try {
      String sql ="DELETE FROM tb_transaksi WHERE no_transaksi=?";
      pst = (PreparedStatement) koneksi.prepareStatement(sql);
      pst.setString(1, no_transaksi);
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
 public List<transaksi> lihatTransaksi(){
    PreparedStatement pst = null;
    ResultSet rs = null;
    List<transaksi> list = new ArrayList<>();
 try {
      String sql ="SELECT * FROM tb_detail_transaksi";
      pst = (PreparedStatement) koneksi.prepareStatement(sql);
      rs = pst.executeQuery();
 while(rs.next()){
      transaksi perintah = new transaksi();
      perintah.setNo_transaksi(rs.getString("no_transaksi"));
      perintah.setJudul_buku(rs.getString("kode_buku"));
      perintah.setJudul_buku(rs.getString("judul_buku"));
      perintah.setStok_buku(rs.getInt("stok_buku"));
      perintah.setHarga_buku(rs.getLong("harga_buku"));
      perintah.setTotal_pembelian(rs.getInt("total_pembelian"));
      
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
public void viewReportTR(String nm_report){
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
