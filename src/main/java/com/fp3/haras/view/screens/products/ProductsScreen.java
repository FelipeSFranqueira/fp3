package com.fp3.haras.view.screens.products;

import com.formdev.flatlaf.FlatLaf;
import com.fp3.haras.utils.Colors;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

public class ProductsScreen extends javax.swing.JPanel {
    private JPanel selectedPanel;
    ProductsCreate pm;
    
    public ProductsScreen() {
        initComponents();
        
        this.setBackground(Colors.PRIMARYBG);
        
        lblTitle.putClientProperty("FlatLaf.styleClass", "h00");    
        
    }
    
    private String getSelectedProductID() {
        if (tableProducts.getSelectedRow() != -1) {
            return String.valueOf(tableProducts.getModel().getValueAt(tableProducts.getSelectedRow(), 0));
        } else {
            return null;
        }
    }
    
    private String getSelectedServiceID() {
        if (tableServices.getSelectedRow() != -1) {
            return String.valueOf(tableServices.getModel().getValueAt(tableServices.getSelectedRow(), 0));
        } else {
            return null;
        }
    }
    
    private Object getSelectedProductValue() {
        return tableProducts.getModel().getValueAt(tableProducts.getSelectedRow(), tableProducts.getSelectedColumn());
    }
    
    private Object getSelectedServiceValue() {
        return tableServices.getModel().getValueAt(tableServices.getSelectedRow(), tableServices.getSelectedColumn());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tpSelection = new javax.swing.JTabbedPane();
        pnlProducts = new javax.swing.JPanel();
        spProducts = new javax.swing.JScrollPane();
        tableProducts = new javax.swing.JTable();
        pnlServices = new javax.swing.JPanel();
        spServices = new javax.swing.JScrollPane();
        tableServices = new javax.swing.JTable();
        pnlHostingTypes = new javax.swing.JPanel();
        spHosting = new javax.swing.JScrollPane();
        tableHosting = new javax.swing.JTable();
        lblTitle = new javax.swing.JLabel();
        tfSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();

        setBackground(new java.awt.Color(200, 225, 100));
        setPreferredSize(new java.awt.Dimension(900, 400));

        spProducts.setToolTipText("");

        tableProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Estoque", "Preço de Custo", "Preço de Venda"
            }
        ));
        tableProducts.setToolTipText("");
        spProducts.setViewportView(tableProducts);

        javax.swing.GroupLayout pnlProductsLayout = new javax.swing.GroupLayout(pnlProducts);
        pnlProducts.setLayout(pnlProductsLayout);
        pnlProductsLayout.setHorizontalGroup(
            pnlProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spProducts, javax.swing.GroupLayout.DEFAULT_SIZE, 876, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlProductsLayout.setVerticalGroup(
            pnlProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlProductsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(spProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tpSelection.addTab("Produtos", pnlProducts);

        spServices.setToolTipText("");

        tableServices.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Tipo", "Preço"
            }
        ));
        tableServices.setToolTipText("");
        spServices.setViewportView(tableServices);

        javax.swing.GroupLayout pnlServicesLayout = new javax.swing.GroupLayout(pnlServices);
        pnlServices.setLayout(pnlServicesLayout);
        pnlServicesLayout.setHorizontalGroup(
            pnlServicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlServicesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spServices, javax.swing.GroupLayout.DEFAULT_SIZE, 876, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlServicesLayout.setVerticalGroup(
            pnlServicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlServicesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(spServices, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tpSelection.addTab("Serviços", pnlServices);

        spHosting.setToolTipText("");

        tableHosting.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Entrada", "Saida", "Tipo de estadia", "Cocheira"
            }
        ));
        tableHosting.setToolTipText("");
        spHosting.setViewportView(tableHosting);

        javax.swing.GroupLayout pnlHostingTypesLayout = new javax.swing.GroupLayout(pnlHostingTypes);
        pnlHostingTypes.setLayout(pnlHostingTypesLayout);
        pnlHostingTypesLayout.setHorizontalGroup(
            pnlHostingTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHostingTypesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spHosting, javax.swing.GroupLayout.DEFAULT_SIZE, 876, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlHostingTypesLayout.setVerticalGroup(
            pnlHostingTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHostingTypesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(spHosting, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tpSelection.addTab("Hospedagens", pnlHostingTypes);

        lblTitle.setText("PRODUTOS E SERVIÇOS");

        tfSearch.setText("Pesquisar...");
        tfSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSearchActionPerformed(evt);
            }
        });

        btnSearch.setText("Pesquisar");

        btnEdit.setText("Editar");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnCreate.setText("Criar");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tpSelection)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitle)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCreate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEdit)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch)
                    .addComponent(btnEdit)
                    .addComponent(btnCreate))
                .addGap(18, 18, 18)
                .addComponent(tpSelection, javax.swing.GroupLayout.PREFERRED_SIZE, 300, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tfSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSearchActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        // TODO add your handling code here:
        this.pm = new ProductsCreate();
        pm.setVisible(true);
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if (tpSelection.getTitleAt(tpSelection.getSelectedIndex()).equals("ATIVAS") 
                    && getSelectedProgressCode() != null && getSelectedProgressValue() != null) {
                
                new StableEdit().setVisible(true);
                
            }else if (tpSelection.getTitleAt(tpSelection.getSelectedIndex()).equals("FINALIZADAS")
                    && getSelectedEndCode() != null && getSelectedEndValue() != null) {
                
                new StableEdit().setVisible(true);
                
            }else if (tpSelection.getTitleAt(tpSelection.getSelectedIndex()).equals("FUTURAS")
                    && getSelectedFutureCode() != null && getSelectedFutureValue() != null) {
                
                new StableEdit().setVisible(true);
                
            } else {
                JOptionPane.showMessageDialog(null, "Nada foi selecionado.", null, JOptionPane.ERROR_MESSAGE, null);
            }
    }//GEN-LAST:event_btnEditActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlHostingTypes;
    private javax.swing.JPanel pnlProducts;
    private javax.swing.JPanel pnlServices;
    private javax.swing.JScrollPane spHosting;
    private javax.swing.JScrollPane spProducts;
    private javax.swing.JScrollPane spServices;
    private javax.swing.JTable tableHosting;
    private javax.swing.JTable tableProducts;
    private javax.swing.JTable tableServices;
    private javax.swing.JTextField tfSearch;
    private javax.swing.JTabbedPane tpSelection;
    // End of variables declaration//GEN-END:variables
}
