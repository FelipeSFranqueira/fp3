package com.fp3.haras.view.screens.products;

import com.fp3.haras.utils.Colors;
import javax.swing.JOptionPane;

public class ProductsScreen extends javax.swing.JPanel {
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
    
    private String getSelectedHostingTypeID() {
        if (tableStable.getSelectedRow() != -1) {
            return String.valueOf(tableStable.getModel().getValueAt(tableStable.getSelectedRow(), 0));
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
    
    private Object getSelectedHostingTypeValue() {
        return tableStable.getModel().getValueAt(tableStable.getSelectedRow(), tableStable.getSelectedColumn());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tpSelection = new javax.swing.JTabbedPane();
        spProducts = new javax.swing.JScrollPane();
        tableProducts = new javax.swing.JTable();
        spStable = new javax.swing.JScrollPane();
        tableStable = new javax.swing.JTable();
        spServices = new javax.swing.JScrollPane();
        tableServices = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        btnEdit = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();
        lblSearch = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblSubtitle = new javax.swing.JLabel();

        setBackground(new java.awt.Color(244, 244, 244));
        setPreferredSize(new java.awt.Dimension(900, 585));

        tpSelection.setBackground(new java.awt.Color(234, 234, 234));
        tpSelection.setForeground(new java.awt.Color(153, 153, 153));
        tpSelection.setOpaque(true);

        spProducts.setToolTipText("");

        tableProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOME", "ESTOQUE", "PREÇO DE CUSTO", "PREÇO DE VENDA"
            }
        ));
        tableProducts.setToolTipText("");
        tableProducts.getTableHeader().setReorderingAllowed(false);
        spProducts.setViewportView(tableProducts);

        tpSelection.addTab("PRODUTOS", spProducts);

        spStable.setToolTipText("");

        tableStable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "ESTADIA", "PREÇO"
            }
        ));
        tableStable.setToolTipText("");
        tableStable.getTableHeader().setReorderingAllowed(false);
        spStable.setViewportView(tableStable);

        tpSelection.addTab("SERVIÇOS", spStable);

        spServices.setToolTipText("");

        tableServices.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "TIPO", "PREÇO"
            }
        ));
        tableServices.setToolTipText("");
        tableServices.getTableHeader().setReorderingAllowed(false);
        spServices.setViewportView(tableServices);

        tpSelection.addTab("ESTADIAS", spServices);

        txtSearch.setText("Pesquisar...");
        txtSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSearchFocusLost(evt);
            }
        });
        txtSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtSearchMouseReleased(evt);
            }
        });

        btnEdit.setText("EDITAR");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnCreate.setText("CRIAR");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        lblSearch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        lblSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblTitle.setText("PRODUTOS E SERVIÇOS");

        lblSubtitle.setText("DISPONIBILIDADE DE RECURSOS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSubtitle)
                    .addComponent(lblTitle)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblSearch)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(tpSelection, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSubtitle)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCreate)
                        .addComponent(btnEdit)))
                .addGap(18, 18, 18)
                .addComponent(tpSelection, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        // TODO add your handling code here:
        this.pm = new ProductsCreate();
        pm.setVisible(true);
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if (tpSelection.getTitleAt(tpSelection.getSelectedIndex()).equals("Produtos") 
                    && getSelectedProductID()!= null && getSelectedProductValue()!= null) {
                
                new ProductsEdit().setVisible(true);
                
            }else if (tpSelection.getTitleAt(tpSelection.getSelectedIndex()).equals("Serviços")
                    && getSelectedServiceID()!= null && getSelectedServiceValue()!= null) {
                
                new ProductsEdit().setVisible(true);
                
            }else if (tpSelection.getTitleAt(tpSelection.getSelectedIndex()).equals("Hospedagens")
                    && getSelectedHostingTypeID()!= null && getSelectedHostingTypeValue()!= null) {
                
                new ProductsEdit().setVisible(true);
                
            } else {
                JOptionPane.showMessageDialog(null, "Nada foi selecionado.", null, JOptionPane.ERROR_MESSAGE, null);
            }
    }//GEN-LAST:event_btnEditActionPerformed

    private void txtSearchMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchMouseReleased
        if (txtSearch.getText().equals("Pesquisar..."))
            txtSearch.setText(null);
    }//GEN-LAST:event_txtSearchMouseReleased

    private void txtSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusLost
        if (txtSearch.getText().equals(""))
            txtSearch.setText("Pesquisar...");
    }//GEN-LAST:event_txtSearchFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnEdit;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lblSubtitle;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JScrollPane spProducts;
    private javax.swing.JScrollPane spServices;
    private javax.swing.JScrollPane spStable;
    private javax.swing.JTable tableProducts;
    private javax.swing.JTable tableServices;
    private javax.swing.JTable tableStable;
    private javax.swing.JTabbedPane tpSelection;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
