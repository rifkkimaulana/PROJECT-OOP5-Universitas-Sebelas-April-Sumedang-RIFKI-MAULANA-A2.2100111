package com.rifkkimaulana.program;

import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Rifki Maulana
 */

public class testLihatBuku {

    public static void main(String[] args) {
        
        fasilitas perintah = new fasilitas();
        List<buku> list = perintah.lihatBuku();
        for(buku buku : list){
            System.out.println("----------------------------");
            System.out.println("DAFTAR BUKU");
            System.out.println("----------------------------");
            System.out.println("KODE BUKU    :" + buku.getKode_buku());
            System.out.println("JUDUL BUKU   :" + buku.getJudul_buku());
            System.out.println("KATEGORI     :" + buku.getKategori_buku());
            System.out.println("HARGA BELI   :" + buku.getHarga_beli());
            System.out.println("HARGA JUAL   :" + buku.getHarga_jual());
            System.out.println("STOK BUKU    :" + buku.getStok_buku());
            System.out.println("----------------------------");
        }
        
    } 
}
