package com.fp3.haras.view.screens.products;

import com.fp3.haras.model.Product;
import com.fp3.haras.model.Service;
import com.fp3.haras.model.StableType;
import com.fp3.haras.utils.Colors;
import com.fp3.haras.utils.EntityUtils;
import com.fp3.haras.utils.GenericObservable;
import com.fp3.haras.utils.GenericObserver;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ProductsEdit extends javax.swing.JFrame implements GenericObservable {
    
    private Product selectedProducts;
    private Service selectedService;
    private StableType selectedStableType;
    private List<GenericObserver> observers = new ArrayList<>();

    public ProductsEdit() {
        initComponents();
        lblTitle.putClientProperty("FlatLaf.styleClass", "h00");
        pnlBack.setBackground(Colors.WHITEBG);
        pnlStableTypeEdit.setBackground(Colors.PRIMARYBG);
        pnlProductsEdit.setBackground(Colors.PRIMARYBG);
        pnlServicesEdit.setBackground(Colors.PRIMARYBG);
    }
    
    public void populateData(Product produto) {
        this.selectedProducts = produto;
        
        this.txtProductName.setText(produto.getName());
        this.txtProductStock.setText(String.valueOf(produto.getStock()));
        this.txtSalePrice.setText(String.valueOf(produto.getPdv()));
        this.txtPurchasePrice.setText(String.valueOf(produto.getPdc()));
    }
    
    public void populateData(Service servico) {
        this.selectedService = servico;
        
        this.txtServiceType.setText(servico.getName());
        this.txtServicePrice.setText(String.valueOf(servico.getPrice()));
    }
    
    public void populateData(StableType tipoEstadia) {
        this.selectedStableType = tipoEstadia;
        
        this.txtStableType.setText(tipoEstadia.getType());
        this.txtStablePrice.setText(String.valueOf(tipoEstadia.getPrice()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBack = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        tpProduct = new javax.swing.JTabbedPane();
        pnlProductsEdit = new javax.swing.JPanel();
        txtProductName = new javax.swing.JTextField();
        txtProductStock = new javax.swing.JTextField();
        txtPurchasePrice = new javax.swing.JTextField();
        txtSalePrice = new javax.swing.JTextField();
        btnCancelProduct = new javax.swing.JButton();
        btnSaveProduct = new javax.swing.JButton();
        btnDeleteProduct = new javax.swing.JButton();
        lblProductName = new javax.swing.JLabel();
        lblProductStock = new javax.swing.JLabel();
        lblUnit = new javax.swing.JLabel();
        lblPurchasePrice = new javax.swing.JLabel();
        lblUnit1 = new javax.swing.JLabel();
        lblSalePrice = new javax.swing.JLabel();
        lblUnit2 = new javax.swing.JLabel();
        pnlServicesEdit = new javax.swing.JPanel();
        txtServiceType = new javax.swing.JTextField();
        txtServicePrice = new javax.swing.JTextField();
        btnCancelService = new javax.swing.JButton();
        btnSaveService = new javax.swing.JButton();
        btnDeleteService = new javax.swing.JButton();
        lblServiceType = new javax.swing.JLabel();
        lblServicePrice = new javax.swing.JLabel();
        lblUnit3 = new javax.swing.JLabel();
        pnlStableTypeEdit = new javax.swing.JPanel();
        txtStableType = new javax.swing.JTextField();
        txtStablePrice = new javax.swing.JTextField();
        btnCancelStable = new javax.swing.JButton();
        btnSaveStable = new javax.swing.JButton();
        btnDeleteStable = new javax.swing.JButton();
        lblStableType = new javax.swing.JLabel();
        lblStablePrice = new javax.swing.JLabel();
        lblUnit4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(605, 405));
        setResizable(false);

        pnlBack.setPreferredSize(new java.awt.Dimension(590, 323));

        lblTitle.setText("EDIÇÃO");

        tpProduct.setBackground(new java.awt.Color(234, 234, 234));
        tpProduct.setForeground(new java.awt.Color(153, 153, 153));
        tpProduct.setMaximumSize(new java.awt.Dimension(530, 245));
        tpProduct.setMinimumSize(new java.awt.Dimension(530, 245));
        tpProduct.setOpaque(true);
        tpProduct.setPreferredSize(new java.awt.Dimension(530, 245));

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

        btnDeleteProduct.setText("EXCLUIR");
        btnDeleteProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteProductActionPerformed(evt);
            }
        });

        lblProductName.setText("NOME DO PRODUTO");

        lblProductStock.setText("ESTOQUE");

        lblUnit.setText("Unidades");

        lblPurchasePrice.setText("PREÇO DE VENDA");

        lblUnit1.setText("R$");

        lblSalePrice.setText("PREÇO DE CUSTO");

        lblUnit2.setText("R$");

        javax.swing.GroupLayout pnlProductsEditLayout = new javax.swing.GroupLayout(pnlProductsEdit);
        pnlProductsEdit.setLayout(pnlProductsEditLayout);
        pnlProductsEditLayout.setHorizontalGroup(
            pnlProductsEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductsEditLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(pnlProductsEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlProductsEditLayout.createSequentialGroup()
                        .addGroup(pnlProductsEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblProductName)
                            .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblProductStock)
                            .addGroup(pnlProductsEditLayout.createSequentialGroup()
                                .addComponent(txtProductStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblUnit)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 180, Short.MAX_VALUE)
                        .addGroup(pnlProductsEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlProductsEditLayout.createSequentialGroup()
                                .addComponent(lblUnit2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSalePrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblSalePrice)
                            .addComponent(lblPurchasePrice)
                            .addGroup(pnlProductsEditLayout.createSequentialGroup()
                                .addComponent(lblUnit1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPurchasePrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(69, 69, 69))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlProductsEditLayout.createSequentialGroup()
                        .addComponent(btnDeleteProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSaveProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))))
        );
        pnlProductsEditLayout.setVerticalGroup(
            pnlProductsEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductsEditLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(pnlProductsEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProductName)
                    .addComponent(lblSalePrice))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlProductsEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlProductsEditLayout.createSequentialGroup()
                        .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblProductStock)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlProductsEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtProductStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblUnit)))
                    .addGroup(pnlProductsEditLayout.createSequentialGroup()
                        .addGroup(pnlProductsEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSalePrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblUnit2))
                        .addGap(18, 18, 18)
                        .addComponent(lblPurchasePrice)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlProductsEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPurchasePrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblUnit1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(pnlProductsEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSaveProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        tpProduct.addTab("Produtos", pnlProductsEdit);

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

        btnDeleteService.setText("EXCLUIR");
        btnDeleteService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteServiceActionPerformed(evt);
            }
        });

        lblServiceType.setText("TIPO DE SERVIÇO");

        lblServicePrice.setText("PREÇO DO SERVIÇO");

        lblUnit3.setText("R$");

        javax.swing.GroupLayout pnlServicesEditLayout = new javax.swing.GroupLayout(pnlServicesEdit);
        pnlServicesEdit.setLayout(pnlServicesEditLayout);
        pnlServicesEditLayout.setHorizontalGroup(
            pnlServicesEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlServicesEditLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(pnlServicesEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtServiceType, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblServiceType)
                    .addGroup(pnlServicesEditLayout.createSequentialGroup()
                        .addComponent(btnDeleteService, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelService, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSaveService, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlServicesEditLayout.createSequentialGroup()
                        .addComponent(lblUnit3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtServicePrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblServicePrice))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        pnlServicesEditLayout.setVerticalGroup(
            pnlServicesEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlServicesEditLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblServiceType)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtServiceType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(lblServicePrice)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlServicesEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtServicePrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUnit3))
                .addGap(32, 32, 32)
                .addGroup(pnlServicesEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelService, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSaveService, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteService, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        tpProduct.addTab("Serviços", pnlServicesEdit);

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

        btnDeleteStable.setText("EXCLUIR");
        btnDeleteStable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteStableActionPerformed(evt);
            }
        });

        lblStableType.setText("TIPO DE ESTADIA");

        lblStablePrice.setText("PREÇO DA ESTADIA");

        lblUnit4.setText("R$");

        javax.swing.GroupLayout pnlStableTypeEditLayout = new javax.swing.GroupLayout(pnlStableTypeEdit);
        pnlStableTypeEdit.setLayout(pnlStableTypeEditLayout);
        pnlStableTypeEditLayout.setHorizontalGroup(
            pnlStableTypeEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStableTypeEditLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(pnlStableTypeEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlStableTypeEditLayout.createSequentialGroup()
                        .addComponent(btnDeleteStable, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelStable, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSaveStable, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblStablePrice)
                    .addComponent(txtStableType, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStableType)
                    .addGroup(pnlStableTypeEditLayout.createSequentialGroup()
                        .addComponent(lblUnit4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtStablePrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        pnlStableTypeEditLayout.setVerticalGroup(
            pnlStableTypeEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStableTypeEditLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblStableType)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtStableType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(lblStablePrice)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlStableTypeEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStablePrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUnit4))
                .addGap(32, 32, 32)
                .addGroup(pnlStableTypeEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelStable, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSaveStable, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteStable, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        tpProduct.addTab("Hospedagens", pnlStableTypeEdit);

        javax.swing.GroupLayout pnlBackLayout = new javax.swing.GroupLayout(pnlBack);
        pnlBack.setLayout(pnlBackLayout);
        pnlBackLayout.setHorizontalGroup(
            pnlBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(pnlBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tpProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitle))
                .addGap(30, 30, 30))
        );
        pnlBackLayout.setVerticalGroup(
            pnlBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tpProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    public void initData(int y) {
        switch (y){
                case 1:
                    Product p = Product.getProduto(ProductsScreen.selectedId);
                    populateData(p);
                    break;

                case 2:
                    Service s = Service.getServico(ProductsScreen.selectedId);
                    populateData(s);
                    break;
                    
                case 3:
                    StableType e = StableType.getTipoEstadia(ProductsScreen.selectedId);
                    populateData(e);
                    break;
                default:
        System.out.println("!");
        break;
        }
    }
    
    private void btnDeleteServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteServiceActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(null, "Realmente deseja apagar este cadastro?", "ATENÇÃO", JOptionPane.WARNING_MESSAGE) == 0) {
            Service s = Service.getServico(ProductsScreen.selectedId);
            s.setIsDeleted(true);
            EntityUtils.update(s);
            JOptionPane.showMessageDialog(null, "Registro #" + ProductsScreen.selectedId + " atualizado!", "Cadastro Realizado", JOptionPane.INFORMATION_MESSAGE, null);
            dispose();
            this.notifyObservers("");
            }
    }//GEN-LAST:event_btnDeleteServiceActionPerformed

    private void btnSaveServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveServiceActionPerformed
        Service s = Service.getServico(ProductsScreen.selectedId);
        s.setName(txtServiceType.getText());
        s.setPrice(Double.parseDouble(txtSalePrice.getText()));
        EntityUtils.update(s);
        JOptionPane.showMessageDialog(null, "Registro #"+ProductsScreen.selectedId+" atualizado!", "Cadastro Realizado", JOptionPane.INFORMATION_MESSAGE, null);
        dispose();
        this.notifyObservers("");
    }//GEN-LAST:event_btnSaveServiceActionPerformed

    private void btnCancelServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelServiceActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelServiceActionPerformed

    private void btnDeleteProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteProductActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Realmente deseja apagar este cadastro?", "ATENÇÃO", JOptionPane.WARNING_MESSAGE) == 0) {
            Product p = Product.getProduto(ProductsScreen.selectedId);
            p.setIsDeleted(true);
            EntityUtils.update(p);
            JOptionPane.showMessageDialog(null, "Registro #" + ProductsScreen.selectedId + " atualizado!", "Cadastro Realizado", JOptionPane.INFORMATION_MESSAGE, null);
            dispose();
            this.notifyObservers("");
            }
    }//GEN-LAST:event_btnDeleteProductActionPerformed

    private void btnSaveProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveProductActionPerformed
        Product p = Product.getProduto(ProductsScreen.selectedId);
        p.setName(txtProductName.getText());
        p.setStock(Integer.parseInt(txtProductStock.getText()));
        p.setPdc(Double.parseDouble(txtPurchasePrice.getText()));
        p.setPdv(Double.parseDouble(txtSalePrice.getText()));
        EntityUtils.update(p);
        JOptionPane.showMessageDialog(null, "Registro #"+ProductsScreen.selectedId+" atualizado!", "Cadastro Realizado", JOptionPane.INFORMATION_MESSAGE, null);
        dispose();
        this.notifyObservers("");
    }//GEN-LAST:event_btnSaveProductActionPerformed

    private void btnCancelProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelProductActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelProductActionPerformed

    private void btnCancelStableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelStableActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelStableActionPerformed

    private void btnSaveStableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveStableActionPerformed
        StableType e = StableType.getTipoEstadia(ProductsScreen.selectedId);
        e.setType(txtStableType.getText());
        e.setPrice(Double.parseDouble(txtStablePrice.getText()));
        EntityUtils.update(e);
        JOptionPane.showMessageDialog(null, "Registro #"+ProductsScreen.selectedId+" atualizado!", "Cadastro Realizado", JOptionPane.INFORMATION_MESSAGE, null);
        dispose();
        this.notifyObservers("");
    }//GEN-LAST:event_btnSaveStableActionPerformed

    private void btnDeleteStableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteStableActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Realmente deseja apagar este cadastro?", "ATENÇÃO", JOptionPane.WARNING_MESSAGE) == 0) {
            StableType e = StableType.getTipoEstadia(ProductsScreen.selectedId);
            e.setIsDeleted(true);
            EntityUtils.update(e);
            JOptionPane.showMessageDialog(null, "Registro #" + ProductsScreen.selectedId + " atualizado!", "Cadastro Realizado", JOptionPane.INFORMATION_MESSAGE, null);
            dispose();
            this.notifyObservers("");
            }
    }//GEN-LAST:event_btnDeleteStableActionPerformed

    @Override
    public void addObserver(GenericObserver o) {
        this.observers.add(o);
    }

    @Override
    public void removeObserver(GenericObserver o) {
        this.observers.remove(o);
    }
    
    @Override
    public void notifyObservers(Object o) {
        for (GenericObserver observer: this.observers) {
            observer.update(o);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelProduct;
    private javax.swing.JButton btnCancelService;
    private javax.swing.JButton btnCancelStable;
    private javax.swing.JButton btnDeleteProduct;
    private javax.swing.JButton btnDeleteService;
    private javax.swing.JButton btnDeleteStable;
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
    private javax.swing.JPanel pnlProductsEdit;
    private javax.swing.JPanel pnlServicesEdit;
    private javax.swing.JPanel pnlStableTypeEdit;
    private javax.swing.JTabbedPane tpProduct;
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
