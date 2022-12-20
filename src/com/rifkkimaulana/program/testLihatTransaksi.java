package com.rifkkimaulana.program;

import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Rifki Maulana
 */

public class testLihatTransaksi {

    public static void main(String[] args) {
        
        fasilitasTransaksi perintah = new fasilitasTransaksi();
        List<transaksi> list = perintah.lihatTransaksi();
        for(transaksi tr : list){
            System.out.println("----------------------------");
            System.out.println("DAFTAR BUKU");
            System.out.println("----------------------------");
            System.out.println("KODE BUKU    :" + tr.getNo_transaksi());
            System.out.println("JUDUL BUKU   :" + tr.getKode_buku());
            System.out.println("KATEGORI     :" + tr.getJudul_buku());
            System.out.println("HARGA BELI   :" + tr.getStok_buku());
            System.out.println("HARGA JUAL   :" + tr.getHarga_buku());
            System.out.println("STOK BUKU    :" + tr.getTotal_pembelian());
            System.out.println("----------------------------");
        }
        
    } 
}
