/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rifkkimaulana.program;

// IMPORT LIB
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rifki Maulana
 */
public class F_Utama extends javax.swing.JFrame {
    //deklarasi koneksi, resulset, dan prepared statement.
    Connection koneksi = (Connection) KoneksiDatabase.getKoneksi();
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    String Tanggal;
    private DefaultTableModel model;
    
    //MENGHITUNG BIAYA DARI JUMLAH BARIS, TOTAL BIAYA, JUMLAH BUKU, DAN HARGA BUKU.
    public void totalBiaya(){
        int jumlahBaris = jTable1.getRowCount();
        int totalBiaya = 0;
        int jumlahBuku, hargaBuku;
        for (int i = 0; i < jumlahBaris; i++) {
            jumlahBuku = Integer.parseInt(jTable1.getValueAt(i, 3).toString());
            hargaBuku = Integer.parseInt(jTable1.getValueAt(i, 4).toString());
            totalBiaya = totalBiaya + (jumlahBuku * hargaBuku);
        }
        txt_TotalBayar.setText(String.valueOf(totalBiaya));
        txt_Tampil.setText("IDR. "+ totalBiaya +",00");
    }
    
    //CREATE AUTONUMBER UNTUK NUMBER TRANSAKSI PENJUALAN BUKU
    private void autonumber(){
        try {
            Statement stm = koneksi.createStatement();
            String sql = "SELECT * FROM tb_transaksi ORDER BY no_transaksi DESC";
            ResultSet rs = stm.executeQuery(sql);
            
            if (rs.next()) {
                String noTransaksi = rs.getString("no_transaksi").substring(2);
                String TR = "" +(Integer.parseInt(noTransaksi)+1);
                String Nol = "";
                
                if(TR.length()==1)
                {Nol = "000";}
                else if(TR.length()==2)
                {Nol = "00";}
                else if(TR.length()==3)
                {Nol = "0";}
                else if(TR.length()==4)
                {Nol = "";}
                txt_noTransaksi.setText("TR" + Nol + TR);
            } else {
                txt_noTransaksi.setText("TR0001");
            }
            rs.close();
            stm.close();
        } catch (Exception e) {
            System.out.println("autonumber error");
        }
    }
    
    //LOAD DATA BUKU
    public void loadData(){
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[]{
            txt_noTransaksi.getText(),
            txt_kodeBuku.getText(),
            txt_judulBuku.getText(),
            txt_jumlahBuku.getText(),
            txt_hargaBuku.getText(),
            txt_TotalBayar.getText()
        });
    }
    
    public void kosong(){
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        while (model.getRowCount()>0) {
            model.removeRow(0);
        }
    }
    
    public void utama(){
        txt_noTransaksi.setText("");
        txt_kodeBuku.setText("");
        txt_judulBuku.setText("");
        txt_hargaBuku.setText("");
        txt_jumlahBuku.setText("");
        autonumber();
    }
    
    public void clear(){
        txt_namaPembeli.setText("");
        txt_TotalBayar.setText("0");
        txt_Bayar.setText("0");
        txt_Kembalian.setText("0");
        txt_Tampil.setText("0");
    }
    
    public void clear2(){
        txt_kodeBuku.setText("");
        txt_judulBuku.setText("");
        txt_hargaBuku.setText("");
        txt_jumlahBuku.setText("");
    }
    
    public void tambahTransaksi(){
        int jumlah, harga, total;
        jumlah = Integer.valueOf(txt_jumlahBuku.getText());
        harga = Integer.valueOf(txt_hargaBuku.getText());
        total = jumlah * harga;
        txt_TotalBayar.setText(String.valueOf(total));
        loadData();
        totalBiaya();
        clear2();
        txt_kodeBuku.requestFocus();
    }

    /**
     * Creates new form F_Login
     */
    public F_Utama() {
        initComponents();
        
        //Create Table
        model = new DefaultTableModel();
        jTable1.setModel(model);
        model.addColumn("NO TRANSAKSI");
        model.addColumn("KODE BUKU");
        model.addColumn("JUDUL BUKU");
        model.addColumn("JUMLAH");
        model.addColumn("HARGA SATUAN");
        model.addColumn("TOTAL");
        
        utama();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        
        txt_Tanggal.setText(sdf.format(date));
        txt_TotalBayar.setText("0");
        txt_Bayar.setText("0");
        txt_Kembalian.setText("0");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        btn_help = new javax.swing.JButton();
        btn_keluar = new javax.swing.JButton();
        btn_menage = new javax.swing.JButton();
        btn_dataTransaksi = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_noTransaksi = new javax.swing.JTextField();
        txt_namaPembeli = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_Tanggal = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_kodeBuku = new javax.swing.JTextField();
        txt_judulBuku = new javax.swing.JTextField();
        txt_hargaBuku = new javax.swing.JTextField();
        txt_jumlahBuku = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btn_Tambah = new javax.swing.JButton();
        btn_Hapus = new javax.swing.JButton();
        btn_Simpan = new javax.swing.JButton();
        txt_Tampil = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btn_importBuku = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_TotalBayar = new javax.swing.JTextField();
        txt_Bayar = new javax.swing.JTextField();
        txt_Kembalian = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("APLIKASI ONLINE PENJUALAN BUKU - A22100111 - RIFKI MAULANA");
        setBackground(new java.awt.Color(0, 102, 204));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel3.setBackground(new java.awt.Color(168, 194, 254));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btn_help.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_help.setText("HELP");
        btn_help.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_helpActionPerformed(evt);
            }
        });

        btn_keluar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_keluar.setText("KELUAR");
        btn_keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_keluarActionPerformed(evt);
            }
        });

        btn_menage.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_menage.setText("MANAGE DATA BUKU");
        btn_menage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_menageActionPerformed(evt);
            }
        });

        btn_dataTransaksi.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_dataTransaksi.setText("MANAGE DATA TRANSAKSI");
        btn_dataTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dataTransaksiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_menage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_dataTransaksi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_help)
                .addGap(7, 7, 7)
                .addComponent(btn_keluar)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_help)
                    .addComponent(btn_keluar)
                    .addComponent(btn_menage)
                    .addComponent(btn_dataTransaksi))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jLabel1.setText("NO TRANSAKSI");

        jLabel3.setText("NAMA PEMBELI");

        txt_noTransaksi.setEnabled(false);

        jLabel4.setText("Tanggal");

        txt_Tanggal.setEnabled(false);

        jLabel5.setText("KODE BUKU");

        jLabel6.setText("JUDUL BUKU");

        jLabel7.setText("HARGA SATUAN");

        jLabel8.setText("Jumlah");

        txt_jumlahBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_jumlahBukuActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btn_Tambah.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_Tambah.setText("TAMBAH PESANAN");
        btn_Tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TambahActionPerformed(evt);
            }
        });

        btn_Hapus.setText("Hapus Data Yang Dipilih");
        btn_Hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_HapusActionPerformed(evt);
            }
        });

        btn_Simpan.setText("Bayar Pesanan");
        btn_Simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SimpanActionPerformed(evt);
            }
        });

        txt_Tampil.setBackground(new java.awt.Color(255, 204, 204));
        txt_Tampil.setEnabled(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("HALAMAN UTAMA - APLIKASI PENJUALAN ONLINE PENJUALAN BUKU");

        jLabel13.setBackground(new java.awt.Color(51, 51, 51));
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Project 1 - RIFKI MAULANA - A2.2100111");

        btn_importBuku.setText("IMPORT BUKU DARI STOK TERSEDIA");
        btn_importBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_importBukuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_importBuku)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(btn_importBuku))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel14.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jLabel14.setText("Menampilkan detail pesanan yang baru saja ditambahkan");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14)
        );

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setText("Total Pesanan :");

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setText("Total Bayar");

        jLabel10.setText("Bayar");

        jLabel11.setText("Kembalian");

        txt_TotalBayar.setEnabled(false);

        txt_Bayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_BayarActionPerformed(evt);
            }
        });

        txt_Kembalian.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_TotalBayar, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                    .addComponent(txt_Bayar)
                    .addComponent(txt_Kembalian))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_TotalBayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_Bayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txt_Kembalian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_namaPembeli)
                            .addComponent(txt_noTransaksi, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE))
                        .addGap(107, 107, 107)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_kodeBuku)
                            .addComponent(txt_judulBuku)
                            .addComponent(txt_hargaBuku)
                            .addComponent(txt_jumlahBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_Tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btn_Tambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_Tampil, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_Hapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_Simpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txt_kodeBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_judulBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_hargaBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_jumlahBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txt_noTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txt_Tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(txt_namaPembeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btn_Tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel15)
                        .addGap(15, 15, 15)
                        .addComponent(txt_Tampil, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btn_Hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_Simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_keluarActionPerformed
        dispose();
        F_Login perintah = new F_Login();
        perintah.setVisible(true);
    }//GEN-LAST:event_btn_keluarActionPerformed

    private void txt_jumlahBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_jumlahBukuActionPerformed
        tambahTransaksi();
    }//GEN-LAST:event_txt_jumlahBukuActionPerformed

    private void btn_TambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TambahActionPerformed
        tambahTransaksi();
    }//GEN-LAST:event_btn_TambahActionPerformed

    private void btn_HapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_HapusActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int row = jTable1.getSelectedRow();
        model.removeRow(row);
        totalBiaya();
        txt_Bayar.setText("0");
        txt_Kembalian.setText("0");
    }//GEN-LAST:event_btn_HapusActionPerformed

    private void txt_BayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_BayarActionPerformed
        int total, bayar, kembalian;
        total = Integer.valueOf(txt_TotalBayar.getText());
        bayar = Integer.valueOf(txt_Bayar.getText());
        if (total > bayar) {
            JOptionPane.showMessageDialog(null, "Uang tidak cukup untuk membeli buku ini.");
        } else {
            kembalian = bayar - total;
            txt_Kembalian.setText(String.valueOf(kembalian));
        }
    }//GEN-LAST:event_txt_BayarActionPerformed

    private void btn_SimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SimpanActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        String no_transaksi = txt_noTransaksi.getText();
        String tanggal_transaksi = txt_Tanggal.getText();
        String nama_pembeli = txt_namaPembeli.getText();
        String total_pembelian = txt_TotalBayar.getText();
        try {
            String sql = "INSERT INTO tb_transaksi VALUES (?, ?, ?, ?)";
            PreparedStatement pst = koneksi.prepareStatement(sql);
            pst.setString(1, no_transaksi);
            pst.setString(2, tanggal_transaksi);
            pst.setString(3, nama_pembeli);
            pst.setString(4, total_pembelian);
            pst.executeUpdate();
            pst.close();
        } catch (Exception e) {
            System.out.println("Pembayaran GAGAL.");
            System.out.println("Pesan : "+e.getMessage());
        }
        try {
            int baris = jTable1.getRowCount();
            
            for (int i = 0; i < baris; i++) {
                String sql = "INSERT INTO tb_detail_transaksi(no_transaksi, kode_buku, judul_buku, stok_buku, harga_buku, total_pembelian) VALUES('"
                        + jTable1.getValueAt(i, 0) +"','"+ jTable1.getValueAt(i, 1) +"','"+ jTable1.getValueAt(i, 2) 
                        +"','"+ jTable1.getValueAt(i, 3) +"','"+ jTable1.getValueAt(i, 4) +"','"+ jTable1.getValueAt(i, 5) 
                        +"')";
                PreparedStatement pst = koneksi.prepareStatement(sql);
                pst.executeUpdate();
                pst.close();
                JOptionPane.showMessageDialog(null, "Pembayaran sukses, data transaksi disimpan di database");
            }
        } catch (Exception e) {
            System.out.println("Gagal Menyimpan Pesanan.");
        }
        
        clear();
        utama();
        autonumber();
        kosong();
        txt_Tampil.setText("IDR. 0");
    }//GEN-LAST:event_btn_SimpanActionPerformed

    private void btn_menageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_menageActionPerformed
        F_Data_Buku next = new F_Data_Buku();
        next.setVisible(true);
    }//GEN-LAST:event_btn_menageActionPerformed

    private void btn_importBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_importBukuActionPerformed
        F_Import_Buku perintah = new F_Import_Buku();
        perintah.setVisible(true);
    }//GEN-LAST:event_btn_importBukuActionPerformed

    private void btn_helpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_helpActionPerformed
        JD_Help buka = new JD_Help();
        buka.setVisible(true);
    }//GEN-LAST:event_btn_helpActionPerformed

    private void btn_dataTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dataTransaksiActionPerformed
        F_Data_Transaksi buka= new F_Data_Transaksi();
        buka.setVisible(true);
    }//GEN-LAST:event_btn_dataTransaksiActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(F_Utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(F_Utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(F_Utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(F_Utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new F_Utama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Hapus;
    private javax.swing.JButton btn_Simpan;
    private javax.swing.JButton btn_Tambah;
    private javax.swing.JButton btn_dataTransaksi;
    private javax.swing.JButton btn_help;
    private javax.swing.JButton btn_importBuku;
    private javax.swing.JButton btn_keluar;
    private javax.swing.JButton btn_menage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txt_Bayar;
    private javax.swing.JTextField txt_Kembalian;
    private javax.swing.JTextField txt_Tampil;
    private javax.swing.JTextField txt_Tanggal;
    private javax.swing.JTextField txt_TotalBayar;
    public static javax.swing.JTextField txt_hargaBuku;
    public static javax.swing.JTextField txt_judulBuku;
    private javax.swing.JTextField txt_jumlahBuku;
    public static javax.swing.JTextField txt_kodeBuku;
    private javax.swing.JTextField txt_namaPembeli;
    private javax.swing.JTextField txt_noTransaksi;
    // End of variables declaration//GEN-END:variables
}
