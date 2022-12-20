
package com.rifkkimaulana.program;

import com.stripbandunk.jwidget.annotation.TableColumn;
import groovy.model.DefaultTableModel;
import javax.swing.JTextField;

/**
 *
 * @author Rifki Maulana
 */
public class buku {
    @TableColumn(number=1, name="KODF BUKU") private String kode_buku;
    @TableColumn(number=2, name="JUDUL BUKU") private String judul_buku;
    @TableColumn(number=3, name="JUDUL BUKU") private String kategori_buku;
    @TableColumn(number=4, name="HARGA BELI") private long harga_beli;
    @TableColumn(number=5, name="HARGA JUAL") private long harga_jual;
    @TableColumn(number=6, name="STOK") private int stok_buku;

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

    public String getKategori_buku() {
        return kategori_buku;
    }

    public void setKategori_buku(String kategori_buku) {
        this.kategori_buku = kategori_buku;
    }

    public long getHarga_beli() {
        return harga_beli;
    }

    public void setHarga_beli(long harga_beli) {
        this.harga_beli = harga_beli;
    }

    public long getHarga_jual() {
        return harga_jual;
    }

    public void setHarga_jual(long harga_jual) {
        this.harga_jual = harga_jual;
    }

    public int getStok_buku() {
        return stok_buku;
    }

    public void setStok_buku(int stok_buku) {
        this.stok_buku = stok_buku;
    }
}