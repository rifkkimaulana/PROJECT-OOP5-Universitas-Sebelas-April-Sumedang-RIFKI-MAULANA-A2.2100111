/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rifkkimaulana.program;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rifki Maulana
 */
public class F_Import_Buku extends javax.swing.JFrame {
    //deklarasi koneksi, resulset, dan prepared statement.
    Connection koneksi = (Connection) KoneksiDatabase.getKoneksi();
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    // CODE IMPORT DATA KE TABLE DARI DATABASE
    public void loadData(){
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        try {
            Statement stm = koneksi.createStatement();
            
            String sql = "SELECT * FROM tb_buku";
            ResultSet rs = stm.executeQuery(sql);
            
            while (rs.next()) {
                Object[] o = new Object[6];
                o [0] = rs.getString("kode_buku");
                o [1] = rs.getString("judul_buku");
                o [2] = rs.getString("kategori_buku");
                o [3] = rs.getString("harga_beli");
                o [4] = rs.getString("harga_jual");
                o [5] = rs.getString("stok_buku");
                
                model.addRow(o);
            }
            rs.close();
            stm.close();
        } catch (Exception e) {
            System.out.println("GAGAL MENAMPILKAN DATA KE TABLE");
        }
    }
    
    // CODE MENCARI DATA DARI TABLE
    public void cariData(){
        DefaultTableModel tabel = new DefaultTableModel();
        
        tabel.addColumn("KODE BUKU");
        tabel.addColumn("JUDUL BUKU");
        tabel.addColumn("KATEGORI");
        tabel.addColumn("HARGA BELI");
        tabel.addColumn("HARGA JUAL");
        tabel.addColumn("STOK BUKU");
        
        try {
            String sql = "SELECT * FROM tb_buku WHERE kode_buku";
            Statement stm = koneksi.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {                
                tabel.addRow(new Object[]{
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                });
            }
            jTable1.setModel(tabel);
            loadData();
        } catch (Exception e) {
            System.out.println("Cari Data Error");
        }finally{
        }
    }
    
    private DefaultTableModel model;
    
    /**
     * Creates new form F_Tambah_Buku
     */
    
    public F_Import_Buku() {
        initComponents();
        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        model = new DefaultTableModel();
        
        jTable1.setModel(model);
        
        model.addColumn("KODE BUKU");
        model.addColumn("JUDUL BUKU");
        model.addColumn("KATEGORI");
        model.addColumn("HARGA BELI");
        model.addColumn("HARGA JUAL");
        model.addColumn("STOK BUKU");
        
        loadData();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txt_cariBuku = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btn_batal = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btn_pilihData = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(168, 194, 254));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("TAMBAH DATA BUKU");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(232, 232, 232)
                .addComponent(jLabel1)
                .addContainerGap(240, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt_cariBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cariBukuActionPerformed(evt);
            }
        });
        txt_cariBuku.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cariBukuKeyTyped(evt);
            }
        });

        jLabel2.setText("CARI BUKU");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_cariBuku)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_cariBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btn_batal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_batal.setText("BATAL");
        btn_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batalActionPerformed(evt);
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

        btn_pilihData.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_pilihData.setText("PILIH BUKU");
        btn_pilihData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pilihDataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_pilihData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_batal))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_batal)
                    .addComponent(btn_pilihData))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batalActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_batalActionPerformed

    private void txt_cariBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cariBukuActionPerformed
        cariData();
    }//GEN-LAST:event_txt_cariBukuActionPerformed

    private void txt_cariBukuKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cariBukuKeyTyped
        cariData();
    }//GEN-LAST:event_txt_cariBukuKeyTyped

    private void btn_pilihDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pilihDataActionPerformed
        int i = jTable1.getSelectedRow();
        
        String kode = jTable1.getValueAt(i, 0).toString();
        String judul = jTable1.getValueAt(i, 1).toString();
        String harga = jTable1.getValueAt(i, 4).toString();
        
        F_Utama.txt_kodeBuku.setText(kode);
        F_Utama.txt_judulBuku.setText(judul);
        F_Utama.txt_hargaBuku.setText(harga);
        
        dispose();
    }//GEN-LAST:event_btn_pilihDataActionPerformed

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
            java.util.logging.Logger.getLogger(F_Import_Buku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(F_Import_Buku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(F_Import_Buku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(F_Import_Buku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new F_Import_Buku().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_batal;
    private javax.swing.JButton btn_pilihData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txt_cariBuku;
    // End of variables declaration//GEN-END:variables
}
