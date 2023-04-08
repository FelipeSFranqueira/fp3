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
        btnEdit = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();
        lblSearch = new javax.swing.JLabel();

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
                .addComponent(spProducts, javax.swing.GroupLayout.DEFAULT_SIZE, 832, Short.MAX_VALUE)
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
                .addComponent(spServices, javax.swing.GroupLayout.DEFAULT_SIZE, 832, Short.MAX_VALUE)
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
                .addComponent(spHosting, javax.swing.GroupLayout.DEFAULT_SIZE, 832, Short.MAX_VALUE)
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
        tfSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfSearchFocusLost(evt);
            }
        });
        tfSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tfSearchMouseReleased(evt);
            }
        });

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

        lblSearch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        lblSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(tfSearch)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblSearch)
                            .addGap(388, 388, 388)
                            .addComponent(btnCreate)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnEdit))
                        .addComponent(tpSelection, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 844, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblTitle)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCreate)
                        .addComponent(btnEdit))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(tpSelection, javax.swing.GroupLayout.PREFERRED_SIZE, 300, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    
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

    private void tfSearchMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfSearchMouseReleased
        if (tfSearch.getText().equals("Pesquisar..."))
            tfSearch.setText(null);
    }//GEN-LAST:event_tfSearchMouseReleased

    private void tfSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfSearchFocusLost
        if (tfSearch.getText().equals(""))
            tfSearch.setText("Pesquisar...");
    }//GEN-LAST:event_tfSearchFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnEdit;
    private javax.swing.JLabel lblSearch;
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
