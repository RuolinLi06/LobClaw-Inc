/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.customer;

import dao.GoodsDao;
import dao.InventoryDao;
import dao.StoreDao;
import static java.lang.Boolean.FALSE;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Goods;
import model.Inventory;
import model.Store;

/**
 *
 * @author Ruolin
 */
public class Shopping extends javax.swing.JPanel {

    /**
     * Creates new form HomePage
     */
    int customerId;
    StoreDao sDao;
    InventoryDao iDao;
    GoodsDao gDao;
    public Shopping(int customerId) {
        initComponents();
        this.customerId = customerId;
        this.sDao = new StoreDao();
        this.iDao = new InventoryDao();
        this.gDao = new GoodsDao();
        try {
            showTableStore();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    private Object[] addTableRowStore(Object[] row,Store s){
        row[0] = s.getStoreName();

        return row;
    }
    private void showTableStore() throws Exception{
        DefaultTableModel model = (DefaultTableModel)jTableStore.getModel();
        model.setRowCount(0);
        
        ArrayList<Store> sList = sDao.getAllStore();
        for(Store s:sList){
            Object[] row = new Object[5];
            addTableRowStore(row,s);
            model.addRow(row);      
        }
    }
    
    private Object[] addTableRowGoods (Object[] row,Inventory inventory) throws Exception{
        row[0] = gDao.getGoodsById(inventory.getGoodsId()).getGoodsName();
        row[1] = inventory.getSellingPrice();

        return row;
    }
    private void showTableGoods(int storeId) throws Exception{
        DefaultTableModel model = (DefaultTableModel)jTableGoods.getModel();
        model.setRowCount(0);
        
        ArrayList<Inventory> ilist = iDao.getInventoryByStoreId(storeId);
        for(Inventory i:ilist){
            Object[] row = new Object[5];
            addTableRowGoods(row,i);
            model.addRow(row);      
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTableStore = new javax.swing.JTable();
        jButtonChooseStore = new javax.swing.JButton();
        jButtonSubmit = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableGoods = new javax.swing.JTable();
        jButtonChooseGoods = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(968, 429));

        jTableStore.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Store"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableStore);

        jButtonChooseStore.setText("Choose Store");
        jButtonChooseStore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonChooseStoreActionPerformed(evt);
            }
        });

        jButtonSubmit.setText("Submit");
        jButtonSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSubmitActionPerformed(evt);
            }
        });

        jTableGoods.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Goods Name", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTableGoods);

        jButtonChooseGoods.setText("Choose Goods");
        jButtonChooseGoods.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonChooseGoodsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonChooseStore))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonChooseGoods))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 272, Short.MAX_VALUE)
                .addComponent(jButtonSubmit)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonChooseStore)
                    .addComponent(jButtonSubmit)
                    .addComponent(jButtonChooseGoods))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonChooseStoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChooseStoreActionPerformed
        // TODO add your handling code here:
        int selectedIndex = jTableStore.getSelectedRow();
        if(selectedIndex < 0){
            JOptionPane.showMessageDialog(this,"Please select a row");
            return;
        }
        DefaultTableModel model = (DefaultTableModel)jTableStore.getModel();
        //int storeId = Integer.parseInt(model.getValueAt(selectedIndex,0).toString());
        String storeName = model.getValueAt(selectedIndex,0).toString();
        try {
            Store s = sDao.getStoreByName(storeName);
            showTableGoods(s.getStoreId());
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButtonChooseStoreActionPerformed

    private void jButtonSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSubmitActionPerformed
        // TODO add your handling code here:
//        if(jLabelDoctorId.getText().isBlank()){
//            JOptionPane.showMessageDialog(this,"Please choose one doctor.");
//            return;
//        }
//        try {
//            eDao.createEncounter(patientId,Integer.parseInt(jLabelDoctorId.getText()),0,LocalDate.now(),jTextArea.getText());
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        JOptionPane.showMessageDialog(this,"Successfully.");
        
    }//GEN-LAST:event_jButtonSubmitActionPerformed

    private void jButtonChooseGoodsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChooseGoodsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonChooseGoodsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonChooseGoods;
    private javax.swing.JButton jButtonChooseStore;
    private javax.swing.JButton jButtonSubmit;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableGoods;
    private javax.swing.JTable jTableStore;
    // End of variables declaration//GEN-END:variables
}
