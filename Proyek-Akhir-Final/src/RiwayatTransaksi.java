/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER
 */
public class RiwayatTransaksi extends javax.swing.JFrame {

    /**
     * Creates new form RiwayatTransaksi
     */
    private DefaultTableModel model;

    public void loadData() {
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        String id_user = Session.get_id_user();
        String cek = Session.get_lvl();

        if (cek.equals("admin")) {
            txCari.setVisible(false);
            jLabel2.setVisible(false);
            try {
                Connection c = Konektor.getKoneksi();
                Statement s = c.createStatement();

                String sql = "SELECT * FROM pembelian";
                ResultSet r = s.executeQuery(sql);

                while (r.next()) {
                    Object[] o = new Object[5];
                    o[0] = r.getString("NoFaktur");
                    o[1] = r.getString("tanggal");
                    o[2] = r.getString("total_harga");
                    o[3] = r.getString("pembayaran");
                    o[4] = r.getString("delivery");

                    model.addRow(o);
                }
                r.close();
                s.close();
            } catch (Exception e) {
                System.out.println("terjadi kesalahan");
            }

        } else if (cek.equals("customer")) {
            txCari.setVisible(false);
            jLabel2.setVisible(false);
            try {
                Connection c = Konektor.getKoneksi();
                Statement s = c.createStatement();

                String sql = "SELECT * FROM pembelian WHERE id_user ='" + id_user + "'";
                ResultSet r = s.executeQuery(sql);

                while (r.next()) {
                    Object[] o = new Object[5];
                    o[0] = r.getString("NoFaktur");
                    o[1] = r.getString("tanggal");
                    o[2] = r.getString("total_harga");
                    o[3] = r.getString("pembayaran");
                    o[4] = r.getString("delivery");

                    model.addRow(o);
                }
                r.close();
                s.close();
            } catch (Exception e) {
                System.out.println("terjadi kesalahan");
            }
        }
    }

    public void hapusRincian() {
        int i = jTable1.getSelectedRow();
        if (i == -1) {
            return;
        }

        String NoFaktur = (String) model.getValueAt(i, 0);

        try {
            Connection c = Konektor.getKoneksi();
            String sql = "DELETE FROM pembelian_rinci WHERE NoFaktur = ?";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, NoFaktur);
            p.executeUpdate();
            p.close();
        } catch (Exception e) {
            System.out.println("Terjadi Kesalahan");
        }
    }
    
    public void cari(){
        DefaultTableModel tabel = new DefaultTableModel();
        
        tabel.addColumn("No Faktur");
        tabel.addColumn("Tanggal");
        tabel.addColumn("Total Harga");
        tabel.addColumn("Pembayaran");
        tabel.addColumn("Delivery");
        
        try {
            Connection c = Konektor.getKoneksi();
            String sql = "Select * from pembelian where NoFaktur like '%" + txCari.getText() + "%'";
//                    "or tanggal like '%" + txCari.getText() + "%'" + "or total_harga like '%" + txCari.getText() + "%'" +
//                    "or pembayaran like '%" + txCari.getText() + "%'" +
//                    "or delivery like '%" + txCari.getText() + "%'";
            Statement stat = c.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {                
                tabel.addRow(new Object[]{
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                });
            }
            jTable1.setModel(tabel);
            loadData();
        } catch (Exception e) {
            System.out.println("Cari Data Error");
        }finally{
        }
    }

    public RiwayatTransaksi() {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        model = new DefaultTableModel();

        jTable1.setModel(model);

        model.addColumn("No Faktur");
        model.addColumn("tanggal");
        model.addColumn("Total Harga");
        model.addColumn("Pembayaran");
        model.addColumn("Delivery");

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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txCari = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnRincian = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setText("RIWAYAT TRANSAKSI");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(208, 208, 208)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jLabel2.setText("Cari :");

        txCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txCariActionPerformed(evt);
            }
        });
        txCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txCariKeyTyped(evt);
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

        btnRincian.setText("Rincian");
        btnRincian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRincianActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txCari))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnRincian)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHapus)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRincian)
                    .addComponent(btnHapus))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRincianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRincianActionPerformed
        // TODO add your handling code here:
        int i = jTable1.getSelectedRow();
        if (i == -1) {
            return;
        }
        Session.set_NoFaktur((String) model.getValueAt(i, 0));

        RincianTransaksi a = new RincianTransaksi();
        a.show();
    }//GEN-LAST:event_btnRincianActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        int i = jTable1.getSelectedRow();
        if (i == -1) {
            return;
        }

        String NoFaktur = (String) model.getValueAt(i, 0);

        int pernyataan = JOptionPane.showConfirmDialog(null, "Yakin Riwayat Akan Dihapus", "Konfirmasi", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (pernyataan == JOptionPane.OK_OPTION) {
            try {
                Connection c = Konektor.getKoneksi();
                String sql = "DELETE FROM pembelian WHERE NoFaktur = ?";
                PreparedStatement p = c.prepareStatement(sql);
                p.setString(1, NoFaktur);
                p.executeUpdate();
                p.close();
                JOptionPane.showMessageDialog(null, "Data Terhapus");
            } catch (Exception e) {
                System.out.println("Terjadi Kesalahan");
            } finally {
                btnRincian.setEnabled(true);
                btnHapus.setEnabled(false);
                hapusRincian();
                loadData();
            }
        }
        if (pernyataan == JOptionPane.CANCEL_OPTION) {

        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void txCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txCariActionPerformed
        // TODO add your handling code here:
        cari();
    }//GEN-LAST:event_txCariActionPerformed

    private void txCariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txCariKeyTyped
        // TODO add your handling code here:
        cari();
    }//GEN-LAST:event_txCariKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnRincian;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txCari;
    // End of variables declaration//GEN-END:variables
}
