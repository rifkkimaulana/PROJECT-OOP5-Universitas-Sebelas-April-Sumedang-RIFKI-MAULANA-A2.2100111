/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rifkkimaulana.program;

/**
 *
 * @author Rifki Maulana
 */
public class testUpdateBuku {
    public static void main(String[] args) {
        fasilitas perintah = new fasilitas();
        buku bk = new buku();
        bk.setKode_buku("B001");
        bk.setJudul_buku("BUKU TULIS A4");
        bk.setKategori_buku("BUKU");
        bk.setHarga_beli(3000);
        bk.setHarga_jual(4000);
        bk.setStok_buku(5);
        perintah.update(bk);
    }
}
