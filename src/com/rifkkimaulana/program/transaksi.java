/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rifkkimaulana.program;

import com.stripbandunk.jwidget.annotation.TableColumn;
import groovy.model.DefaultTableModel;

/**
 *
 * @author Rifki Maulana
 */
public class transaksi {
    @TableColumn(number=1, name="NO TRANSAKSI")private String no_transaksi;
    @TableColumn(number=2, name="ID BARANG")private String kode_buku;
    @TableColumn(number=3, name="NAMA BARANG")private String judul_buku;
    @TableColumn(number=4, name="JUMLAH")private int stok_buku;
    @TableColumn(number=5, name="HARGA SATUAN")private Long harga_buku;
    @TableColumn(number=6, name="TOTAL")private int total_pembelian;

    public String getNo_transaksi() {
        return no_transaksi;
    }

    public void setNo_transaksi(String no_transaksi) {
        this.no_transaksi = no_transaksi;
    }

    public String getKode_buku() {
        return kode_buku;
    }

    public void setKode_buku(String kode_buku) {
        this.kode_buku = kode_buku;
    }

    public String getJudul_buku() {
        return judul_buku;
    }

    public void setJudul_buku(String judul_buku) {
        this.judul_buku = judul_buku;
    }

    public int getStok_buku() {
        return stok_buku;
    }

    public void setStok_buku(int stok_buku) {
        this.stok_buku = stok_buku;
    }

    public Long getHarga_buku() {
        return harga_buku;
    }

    public void setHarga_buku(Long harga_buku) {
        this.harga_buku = harga_buku;
    }

    public int getTotal_pembelian() {
        return total_pembelian;
    }

    public void setTotal_pembelian(int total_pembelian) {
        this.total_pembelian = total_pembelian;
    }
}
