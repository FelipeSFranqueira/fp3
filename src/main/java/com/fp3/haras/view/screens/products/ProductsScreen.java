package com.fp3.haras.view.screens.products;

import com.fp3.haras.model.Produto;
import com.fp3.haras.model.Servico;
import com.fp3.haras.model.TipoEstadia;
import com.fp3.haras.utils.Colors;
import com.fp3.haras.utils.EntityUtils;
import com.fp3.haras.utils.GenericObserver;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ProductsScreen extends javax.swing.JPanel implements GenericObserver{
    private ProductsCreate CreateModal;
    private ProductsEdit   EditModal;
    private Produto       productSelected;
    private Servico       serviceSelected;
    private TipoEstadia   stableTypeSelected;
    private List<Produto> fetchedProducts;
    private List<Produto> ProductsTableResults;
    private List<Servico> fetchedServices;
    private List<Servico> ServicesTableResults;
    private List<TipoEstadia> fetchedStableType;
    private List<TipoEstadia> StableTypeTableResults;
    private int currentPage = 1;
    private final int maxResults = 16;
    
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

        boxSearch = new com.fp3.haras.components.ComboBoxSuggestion();
        tpSelection = new javax.swing.JTabbedPane();
        spProducts = new javax.swing.JScrollPane();
        tableProducts = new javax.swing.JTable();
        spStable = new javax.swing.JScrollPane();
        tableStable = new javax.swing.JTable();
        spServices = new javax.swing.JScrollPane();
        tableServices = new javax.swing.JTable();
        btnEdit = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();
        lblSearch = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblSubtitle = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();

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
        tableProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProductsMouseClicked(evt);
            }
        });
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
        tableStable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableStableMouseClicked(evt);
            }
        });
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
        tableServices.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableServicesMouseClicked(evt);
            }
        });
        spServices.setViewportView(tableServices);

        tpSelection.addTab("ESTADIAS", spServices);

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
        lblSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSearchMouseClicked(evt);
            }
        });

        lblTitle.setText("PRODUTOS E SERVIÇOS");

        lblSubtitle.setText("DISPONIBILIDADE DE RECURSOS");

        btnBack.setText("< Voltar");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnNext.setText("Avançar >");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSubtitle)
                            .addComponent(lblTitle)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(boxSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblSearch)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(tpSelection, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(50, 50, 50))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addGap(18, 18, 18)
                        .addComponent(btnNext)
                        .addGap(41, 41, 41))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSubtitle)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCreate)
                        .addComponent(btnEdit))
                    .addComponent(boxSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(tpSelection, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnNext))
                .addContainerGap(40, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        // TODO add your handling code here:
        this.CreateModal = new ProductsCreate();
        CreateModal.setVisible(true);
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if (tpSelection.getTitleAt(tpSelection.getSelectedIndex()).equals("PRODUTOS") 
                    && getSelectedProductID()!= null && getSelectedProductValue()!= null) {
                
                this.EditModal.populateData(productSelected);
                new ProductsEdit().setVisible(true);
                
            }else if (tpSelection.getTitleAt(tpSelection.getSelectedIndex()).equals("SERVIÇOS")
                    && getSelectedServiceID()!= null && getSelectedServiceValue()!= null) {
                
                this.EditModal.populateData(serviceSelected);
                new ProductsEdit().setVisible(true);
                
            }else if (tpSelection.getTitleAt(tpSelection.getSelectedIndex()).equals("ESTADIAS")
                    && getSelectedHostingTypeID()!= null && getSelectedHostingTypeValue()!= null) {
                
                this.EditModal.populateData(stableTypeSelected);
                new ProductsEdit().setVisible(true);
                
            } else {
                JOptionPane.showMessageDialog(null, "Nada foi selecionado.", null, JOptionPane.ERROR_MESSAGE, null);
            }
    }//GEN-LAST:event_btnEditActionPerformed

    private void lblSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSearchMouseClicked
        // TODO add your handling code here:
        if (tpSelection.getTitleAt(tpSelection.getSelectedIndex()).equals("PRODUTOS")) {
            DefaultTableModel tableP = (DefaultTableModel) tableProducts.getModel();
            tableP.setRowCount(0);
            String pQuerySearch = "SELECT a FROM Products WHERE a.nome = '" + (String) boxSearch.getSelectedItem() + "'";
            List<Produto> produto = EntityUtils.select(pQuerySearch, Produto.class);
            for (Produto a : produto) {
                tableP.addRow(new Object[]{
                    a.getId(),
                    a.getNome(),
                    a.getEstoque(),
                    a.getPdc(),
                    a.getPdv()
                });
            }
        } else if (tpSelection.getTitleAt(tpSelection.getSelectedIndex()).equals("SERVIÇOS")) {
            DefaultTableModel tableS = (DefaultTableModel) tableServices.getModel();
            tableS.setRowCount(0);
            String sQuerySearch = "SELECT a FROM Services WHERE a.nome = '" + (String) boxSearch.getSelectedItem() + "'";
            List<Servico> servico = EntityUtils.select(sQuerySearch, Servico.class);
            for (Servico a: servico) {
                tableS.addRow(new Object[]{
                    a.getId(),
                    a.getNome(),
                    a.getPreco()
                });
            }
        } else if (tpSelection.getTitleAt(tpSelection.getSelectedIndex()).equals("ESTADIAS")) {
            DefaultTableModel tableE = (DefaultTableModel) tableStable.getModel();
            tableE.setRowCount(0);
            String eQuerySearch = "SELECT a FROM StablesType WHERE a.tipo = '" + (String) boxSearch.getSelectedItem() + "'";
            List<TipoEstadia> tipoEstadia = EntityUtils.select(eQuerySearch, TipoEstadia.class);
            for (TipoEstadia a: tipoEstadia) {
                tableE.addRow(new Object[]{
                    a.getId(),
                    a.getTipo(),
                    a.getPreco()
                });
            }
        }
        
    }//GEN-LAST:event_lblSearchMouseClicked

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.currentPage--;
        this.populateTable();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        this.currentPage++;
        this.populateTable();
    }//GEN-LAST:event_btnNextActionPerformed

    private void tableProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProductsMouseClicked
        // TODO add your handling code here:
        DefaultTableModel table = (DefaultTableModel) tableProducts.getModel();
        
        int id = Integer.parseInt(table.getValueAt(tableProducts.getSelectedRow(), 0).toString());
        
        String queryProduto = "SELECT a FROM Produto WHERE a.id = " + id;
        this.productSelected = EntityUtils.select(queryProduto, Produto.class).get(0);
    }//GEN-LAST:event_tableProductsMouseClicked

    private void tableStableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableStableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel table = (DefaultTableModel) tableServices.getModel();
        
        int id = Integer.parseInt(table.getValueAt(tableServices.getSelectedRow(), 0).toString());
        
        String queryServico = "SELECT a FROM Services WHERE a.id = " + id;
        this.serviceSelected = EntityUtils.select(queryServico, Servico.class).get(0);
    }//GEN-LAST:event_tableStableMouseClicked

    private void tableServicesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableServicesMouseClicked
        // TODO add your handling code here:
        DefaultTableModel table = (DefaultTableModel) tableStable.getModel();
        
        int id = Integer.parseInt(table.getValueAt(tableStable.getSelectedRow(), 0).toString());
        
        String queryStableType = "SELECT a FROM StablesType WHERE a.id = " + id;
        this.stableTypeSelected = EntityUtils.select(queryStableType, TipoEstadia.class).get(0);
    }//GEN-LAST:event_tableServicesMouseClicked

    private void updateBoxSearch(){
        boxSearch.addItem("");
        
        if (tpSelection.getTitleAt(tpSelection.getSelectedIndex()).equals("PRODUTOS")) {
            String pQuerySearch = "SELECT a FROM Products WHERE a.nome WHERE a.isDeleted = FALSE";
            fetchedProducts = EntityUtils.select(pQuerySearch, Produto.class);
            for (Produto produto: fetchedProducts) {
                boxSearch.addItem(produto.getNome());
            }
        } else if (tpSelection.getTitleAt(tpSelection.getSelectedIndex()).equals("SERVIÇOS")) {
            String sQuerySearch = "SELECT a FROM Services WHERE a.nome WHERE a.isDeleted = FALSE";
            fetchedServices = EntityUtils.select(sQuerySearch, Servico.class);
            for (Servico servico: fetchedServices) {
                boxSearch.addItem(servico.getNome());
            }
        } else if (tpSelection.getTitleAt(tpSelection.getSelectedIndex()).equals("ESTADIAS")) {
            String eQuerySearch = "SELECT a FROM StablesType WHERE a.tipo WHERE a.isDeleted = FALSE";
            fetchedStableType = EntityUtils.select(eQuerySearch, TipoEstadia.class);
            for (TipoEstadia tipoEstadia: fetchedStableType) {
                boxSearch.addItem(tipoEstadia.getTipo());
            }
        }
    }
    
    private void populateTable() {
        if (tpSelection.getTitleAt(tpSelection.getSelectedIndex()).equals("PRODUTOS")) {
            DefaultTableModel table = (DefaultTableModel) tableProducts.getModel();
            table.setRowCount(0);
            fetchTableResults(this.currentPage, this.maxResults);
            for (Produto a : this.ProductsTableResults) {
                table.addRow(new Object[]{
                    a.getId(),
                    a.getNome(),
                    a.getEstoque(),
                    a.getPdc(),
                    a.getPdv()
                });
            }
            
            
        } else if (tpSelection.getTitleAt(tpSelection.getSelectedIndex()).equals("SERVIÇOS")) {
            DefaultTableModel table = (DefaultTableModel) tableServices.getModel();
            table.setRowCount(0);
            fetchTableResults(this.currentPage, this.maxResults);
            for (Servico a : this.ServicesTableResults) {
                table.addRow(new Object[]{
                    a.getId(),
                    a.getNome(),
                    a.getPreco()
                });
            }
            
            
        } else if (tpSelection.getTitleAt(tpSelection.getSelectedIndex()).equals("ESTADIAS")) {
            DefaultTableModel table = (DefaultTableModel) tableStable.getModel();
            table.setRowCount(0);
            fetchTableResults(this.currentPage, this.maxResults);
            for (TipoEstadia a : this.StableTypeTableResults) {
                table.addRow(new Object[]{
                    a.getId(),
                    a.getTipo(),
                    a.getPreco()
                });
            }
            
            
        }
    }
    
    private void fetchTableResults(int page, int maxResults) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("haras");
        EntityManager em = emf.createEntityManager();
        
        int firstResult = page == 1 ? 0 : ((page - 1) * maxResults);
        
        if (tpSelection.getTitleAt(tpSelection.getSelectedIndex()).equals("PRODUTOS")) {
            TypedQuery<Produto> productsQuery = em.createQuery("SELECT a FROM Products WHERE a.nome WHERE a.isDeleted = FALSE", Produto.class);
            this.tableProducts = (JTable) productsQuery.setFirstResult(firstResult).setMaxResults(maxResults).getResultList();

        } else if (tpSelection.getTitleAt(tpSelection.getSelectedIndex()).equals("SERVIÇOS")) {
            TypedQuery<Servico> servicoQuery = em.createQuery("SELECT a FROM Services WHERE a.nome WHERE a.isDeleted = FALSE", Servico.class);
            this.tableServices = (JTable) servicoQuery.setFirstResult(firstResult).setMaxResults(maxResults).getResultList();

        } else if (tpSelection.getTitleAt(tpSelection.getSelectedIndex()).equals("ESTADIAS")) {
            TypedQuery<TipoEstadia> stableTypeQuery = em.createQuery("SSELECT a FROM StablesType WHERE a.tipo WHERE a.isDeleted = FALSE", TipoEstadia.class);
            this.tableStable = (JTable) stableTypeQuery.setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
  
        }
    }
    
    @Override
    public void update(Object o) {
        this.boxSearch.removeAllItems();
        this.updateBoxSearch();
        this.populateTable();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.fp3.haras.components.ComboBoxSuggestion boxSearch;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnNext;
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
    // End of variables declaration//GEN-END:variables
}
