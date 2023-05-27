package com.fp3.haras.view.screens.products;

import com.fp3.haras.model.Produto;
import com.fp3.haras.model.Servico;
import com.fp3.haras.model.TipoEstadia;
import javax.swing.JOptionPane;
import com.fp3.haras.utils.Colors;
import com.fp3.haras.utils.EntityUtils;
import javax.persistence.Entity;

public class ProductsCreate extends javax.swing.JFrame {

    public ProductsCreate() {
        initComponents();
        lblTitle.putClientProperty("FlatLaf.styleClass", "h00");
        pnlBack.setBackground(Colors.WHITEBG);
        pnlStableTypeCreate.setBackground(Colors.PRIMARYBG);
        pnlProductsCreate.setBackground(Colors.PRIMARYBG);
        pnlServicesCreate.setBackground(Colors.PRIMARYBG);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBack = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        pnlForm = new javax.swing.JPanel();
        tpProducts = new javax.swing.JTabbedPane();
        pnlProductsCreate = new javax.swing.JPanel();
        txtProductName = new javax.swing.JTextField();
        txtProductStock = new javax.swing.JTextField();
        txtPurchasePrice = new javax.swing.JTextField();
        txtSalePrice = new javax.swing.JTextField();
        btnCancelProduct = new javax.swing.JButton();
        btnSaveProduct = new javax.swing.JButton();
        lblProductName = new javax.swing.JLabel();
        lblProductStock = new javax.swing.JLabel();
        lblUnit = new javax.swing.JLabel();
        lblPurchasePrice = new javax.swing.JLabel();
        lblUnit1 = new javax.swing.JLabel();
        lblSalePrice = new javax.swing.JLabel();
        lblUnit2 = new javax.swing.JLabel();
        pnlServicesCreate = new javax.swing.JPanel();
        txtServiceType = new javax.swing.JTextField();
        txtServicePrice = new javax.swing.JTextField();
        btnCancelService = new javax.swing.JButton();
        btnSaveService = new javax.swing.JButton();
        lblServiceType = new javax.swing.JLabel();
        lblServicePrice = new javax.swing.JLabel();
        lblUnit3 = new javax.swing.JLabel();
        pnlStableTypeCreate = new javax.swing.JPanel();
        txtStableType = new javax.swing.JTextField();
        txtStablePrice = new javax.swing.JTextField();
        btnCancelStable = new javax.swing.JButton();
        btnSaveStable = new javax.swing.JButton();
        lblStableType = new javax.swing.JLabel();
        lblStablePrice = new javax.swing.JLabel();
        lblUnit4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(605, 405));
        setResizable(false);

        lblTitle.setText("CRIAÇÃO");

        tpProducts.setBackground(new java.awt.Color(234, 234, 234));
        tpProducts.setForeground(new java.awt.Color(153, 153, 153));
        tpProducts.setOpaque(true);
        tpProducts.setPreferredSize(new java.awt.Dimension(530, 245));

        txtProductName.setMaximumSize(new java.awt.Dimension(64, 22));

        txtProductStock.setMaximumSize(new java.awt.Dimension(64, 22));

        txtPurchasePrice.setMaximumSize(new java.awt.Dimension(64, 22));

        txtSalePrice.setMaximumSize(new java.awt.Dimension(64, 22));

        btnCancelProduct.setText("CANCELAR");
        btnCancelProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelProductActionPerformed(evt);
            }
        });

        btnSaveProduct.setText("SALVAR");
        btnSaveProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveProductActionPerformed(evt);
            }
        });

        lblProductName.setText("NOME DO PRODUTO");

        lblProductStock.setText("ESTOQUE");

        lblUnit.setText("Unidades");

        lblPurchasePrice.setText("PREÇO DE CUSTO");

        lblUnit1.setText("R$");

        lblSalePrice.setText("PREÇO DE VENDA");

        lblUnit2.setText("R$");

        javax.swing.GroupLayout pnlProductsCreateLayout = new javax.swing.GroupLayout(pnlProductsCreate);
        pnlProductsCreate.setLayout(pnlProductsCreateLayout);
        pnlProductsCreateLayout.setHorizontalGroup(
            pnlProductsCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductsCreateLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(pnlProductsCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblProductName)
                    .addComponent(lblProductStock)
                    .addGroup(pnlProductsCreateLayout.createSequentialGroup()
                        .addComponent(txtProductStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblUnit))
                    .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlProductsCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSalePrice)
                    .addGroup(pnlProductsCreateLayout.createSequentialGroup()
                        .addComponent(lblUnit1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPurchasePrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblPurchasePrice)
                    .addGroup(pnlProductsCreateLayout.createSequentialGroup()
                        .addComponent(lblUnit2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSalePrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(69, 69, 69))
            .addGroup(pnlProductsCreateLayout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(btnCancelProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSaveProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(136, Short.MAX_VALUE))
        );
        pnlProductsCreateLayout.setVerticalGroup(
            pnlProductsCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductsCreateLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(pnlProductsCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlProductsCreateLayout.createSequentialGroup()
                        .addComponent(lblProductName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlProductsCreateLayout.createSequentialGroup()
                        .addComponent(lblPurchasePrice)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlProductsCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPurchasePrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblUnit1))))
                .addGap(18, 18, 18)
                .addGroup(pnlProductsCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlProductsCreateLayout.createSequentialGroup()
                        .addComponent(lblProductStock)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlProductsCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtProductStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblUnit)))
                    .addGroup(pnlProductsCreateLayout.createSequentialGroup()
                        .addComponent(lblSalePrice)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlProductsCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSalePrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblUnit2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(pnlProductsCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaveProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        tpProducts.addTab("Produtos", pnlProductsCreate);

        txtServiceType.setMaximumSize(new java.awt.Dimension(64, 22));

        txtServicePrice.setMaximumSize(new java.awt.Dimension(64, 22));

        btnCancelService.setText("CANCELAR");
        btnCancelService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelServiceActionPerformed(evt);
            }
        });

        btnSaveService.setText("SALVAR");
        btnSaveService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveServiceActionPerformed(evt);
            }
        });

        lblServiceType.setText("TIPO DE SERVIÇO");

        lblServicePrice.setText("VALOR");

        lblUnit3.setText("R$");

        javax.swing.GroupLayout pnlServicesCreateLayout = new javax.swing.GroupLayout(pnlServicesCreate);
        pnlServicesCreate.setLayout(pnlServicesCreateLayout);
        pnlServicesCreateLayout.setHorizontalGroup(
            pnlServicesCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlServicesCreateLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(pnlServicesCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtServiceType, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblServiceType)
                    .addComponent(lblServicePrice, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlServicesCreateLayout.createSequentialGroup()
                        .addComponent(lblUnit3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtServicePrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(344, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlServicesCreateLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelService, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSaveService, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        pnlServicesCreateLayout.setVerticalGroup(
            pnlServicesCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlServicesCreateLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblServiceType)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtServiceType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(lblServicePrice)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlServicesCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtServicePrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUnit3))
                .addGap(18, 18, 18)
                .addGroup(pnlServicesCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelService, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSaveService, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        tpProducts.addTab("Serviços", pnlServicesCreate);

        txtStableType.setMaximumSize(new java.awt.Dimension(64, 22));

        txtStablePrice.setMaximumSize(new java.awt.Dimension(64, 22));

        btnCancelStable.setText("CANCELAR");
        btnCancelStable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelStableActionPerformed(evt);
            }
        });

        btnSaveStable.setText("SALVAR");
        btnSaveStable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveStableActionPerformed(evt);
            }
        });

        lblStableType.setText("TIPO DE ESTADIA");

        lblStablePrice.setText("PREÇO DA ESTADIA");

        lblUnit4.setText("R$");

        javax.swing.GroupLayout pnlStableTypeCreateLayout = new javax.swing.GroupLayout(pnlStableTypeCreate);
        pnlStableTypeCreate.setLayout(pnlStableTypeCreateLayout);
        pnlStableTypeCreateLayout.setHorizontalGroup(
            pnlStableTypeCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStableTypeCreateLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(pnlStableTypeCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtStableType, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStableType)
                    .addGroup(pnlStableTypeCreateLayout.createSequentialGroup()
                        .addComponent(lblUnit4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtStablePrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblStablePrice))
                .addContainerGap(344, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlStableTypeCreateLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelStable, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSaveStable, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        pnlStableTypeCreateLayout.setVerticalGroup(
            pnlStableTypeCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStableTypeCreateLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblStableType)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtStableType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(lblStablePrice)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlStableTypeCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStablePrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUnit4))
                .addGap(18, 18, 18)
                .addGroup(pnlStableTypeCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaveStable, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelStable, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tpProducts.addTab("Hospedagens", pnlStableTypeCreate);

        javax.swing.GroupLayout pnlFormLayout = new javax.swing.GroupLayout(pnlForm);
        pnlForm.setLayout(pnlFormLayout);
        pnlFormLayout.setHorizontalGroup(
            pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnlFormLayout.setVerticalGroup(
            pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpProducts, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlBackLayout = new javax.swing.GroupLayout(pnlBack);
        pnlBack.setLayout(pnlBackLayout);
        pnlBackLayout.setHorizontalGroup(
            pnlBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(pnlBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle)
                    .addComponent(pnlForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );
        pnlBackLayout.setVerticalGroup(
            pnlBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelProductActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelProductActionPerformed

    private void btnSaveProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveProductActionPerformed
        Produto p = new Produto(txtProductName.getText(), 
                Integer.parseInt(txtProductStock.getText()), 
                Integer.parseInt(txtPurchasePrice.getText()), 
                Integer.parseInt(txtSalePrice.getText()));
        
        EntityUtils.insert(p);
        
        JOptionPane.showMessageDialog(null, "Código de registro: #{CODE}", "Cadastro Realizado", JOptionPane.INFORMATION_MESSAGE, null);
        dispose();
    }//GEN-LAST:event_btnSaveProductActionPerformed

    private void btnCancelServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelServiceActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelServiceActionPerformed

    private void btnSaveServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveServiceActionPerformed
        Servico s = new Servico(txtServiceType.getText(), Integer.parseInt(txtServicePrice.getText()));
        
        EntityUtils.insert(s);
        
        JOptionPane.showMessageDialog(null, "Código de registro: #{CODE}", "Cadastro Realizado", JOptionPane.INFORMATION_MESSAGE, null);
        dispose();
    }//GEN-LAST:event_btnSaveServiceActionPerformed

    private void btnCancelStableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelStableActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelStableActionPerformed

    private void btnSaveStableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveStableActionPerformed
        TipoEstadia te = new TipoEstadia(txtStableType.getText(), Integer.parseInt(txtStablePrice.getText()));
        
        EntityUtils.insert(te);
        
        JOptionPane.showMessageDialog(null, "Código de registro: #{CODE}", "Cadastro Realizado", JOptionPane.INFORMATION_MESSAGE, null);
        dispose();
    }//GEN-LAST:event_btnSaveStableActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelProduct;
    private javax.swing.JButton btnCancelService;
    private javax.swing.JButton btnCancelStable;
    private javax.swing.JButton btnSaveProduct;
    private javax.swing.JButton btnSaveService;
    private javax.swing.JButton btnSaveStable;
    private javax.swing.JLabel lblProductName;
    private javax.swing.JLabel lblProductStock;
    private javax.swing.JLabel lblPurchasePrice;
    private javax.swing.JLabel lblSalePrice;
    private javax.swing.JLabel lblServicePrice;
    private javax.swing.JLabel lblServiceType;
    private javax.swing.JLabel lblStablePrice;
    private javax.swing.JLabel lblStableType;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUnit;
    private javax.swing.JLabel lblUnit1;
    private javax.swing.JLabel lblUnit2;
    private javax.swing.JLabel lblUnit3;
    private javax.swing.JLabel lblUnit4;
    private javax.swing.JPanel pnlBack;
    private javax.swing.JPanel pnlForm;
    private javax.swing.JPanel pnlProductsCreate;
    private javax.swing.JPanel pnlServicesCreate;
    private javax.swing.JPanel pnlStableTypeCreate;
    private javax.swing.JTabbedPane tpProducts;
    private javax.swing.JTextField txtProductName;
    private javax.swing.JTextField txtProductStock;
    private javax.swing.JTextField txtPurchasePrice;
    private javax.swing.JTextField txtSalePrice;
    private javax.swing.JTextField txtServicePrice;
    private javax.swing.JTextField txtServiceType;
    private javax.swing.JTextField txtStablePrice;
    private javax.swing.JTextField txtStableType;
    // End of variables declaration//GEN-END:variables
}
