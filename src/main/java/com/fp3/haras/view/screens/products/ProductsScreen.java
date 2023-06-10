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
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import static org.hibernate.criterion.Projections.id;

public class ProductsScreen extends javax.swing.JPanel implements GenericObserver{
    private final ProductsCreate CreateModal;
    private final ProductsEdit   EditModal;
    private Produto       productSelected;
    private Servico       serviceSelected;
    private TipoEstadia   stableTypeSelected;
    private List<Produto> ProductsTableResults;
    private List<Servico> ServicesTableResults;
    private List<TipoEstadia> StableTypeTableResults;
    
    public static long selectedId;
    DefaultTableCellRenderer center = new DefaultTableCellRenderer();

    public ProductsScreen(ProductsCreate creationModal, ProductsEdit editionModal){
        initComponents();
        this.CreateModal = creationModal;
        this.EditModal = editionModal;
        this.setBackground(Colors.PRIMARYBG);
        lblTitle.putClientProperty("FlatLaf.styleClass", "h00");
        
        this.populateTable();
        
        this.updateBoxSearch();
    }
    
    private String getSelectedProductCode() {
        if (tableProducts.getSelectedRow() != -1) {
            return String.valueOf(tableProducts.getModel().getValueAt(tableProducts.getSelectedRow(), 0));
        } else {
            return null;
        }
    }
    
    private String getSelectedServiceCode() {
        if (tableServices.getSelectedRow() != -1) {
            return String.valueOf(tableServices.getModel().getValueAt(tableServices.getSelectedRow(), 0));
        } else {
            return null;
        }
    }
    
    private String getSelectedStableTypeCode() {
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
    
    private Object getSelectedStableTypeValue() {
        return tableStable.getModel().getValueAt(tableStable.getSelectedRow(), tableStable.getSelectedColumn());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        boxSearch = new com.fp3.haras.components.ComboBoxSuggestion();
        tpSelection = new javax.swing.JTabbedPane();
        spProducts = new javax.swing.JScrollPane();
        tableProducts = new javax.swing.JTable();
        spServices = new javax.swing.JScrollPane();
        tableServices = new javax.swing.JTable();
        spStable = new javax.swing.JScrollPane();
        tableStable = new javax.swing.JTable();
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
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableProducts.setToolTipText("");
        tableProducts.getTableHeader().setReorderingAllowed(false);
        tableProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProductsMouseClicked(evt);
            }
        });
        spProducts.setViewportView(tableProducts);

        tpSelection.addTab("PRODUTOS", spProducts);

        spServices.setToolTipText("");

        tableServices.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOME", "PREÇO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableServices.setToolTipText("");
        tableServices.getTableHeader().setReorderingAllowed(false);
        tableServices.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableServicesMouseClicked(evt);
            }
        });
        spServices.setViewportView(tableServices);

        tpSelection.addTab("SERVIÇOS", spServices);

        spStable.setToolTipText("");

        tableStable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "TIPO", "PREÇO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableStable.setToolTipText("");
        tableStable.getTableHeader().setReorderingAllowed(false);
        tableStable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableStableMouseClicked(evt);
            }
        });
        spStable.setViewportView(tableStable);

        tpSelection.addTab("ESTADIAS", spStable);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
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
                .addContainerGap(80, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        // TODO add your handling code here:
        this.CreateModal.setVisible(true);
    }//GEN-LAST:event_btnCreateActionPerformed

    private void initEdit(Object tableSelectedCode, int y) {
        selectedId = Integer.parseInt(String.valueOf(tableSelectedCode));
        this.EditModal.initData(y);
        this.EditModal.setVisible(true);
        this.EditModal.toFront();
    }
    
    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        String selectedTab = tpSelection.getTitleAt(tpSelection.getSelectedIndex());
        if (selectedTab.equals("PRODUTOS")
                && getSelectedProductCode() != null && getSelectedProductValue() != null) {

            initEdit(getSelectedProductCode(), 1);

        } else if (selectedTab.equals("SERVIÇOS")
                && getSelectedServiceCode() != null && getSelectedServiceValue() != null) {

            initEdit(getSelectedServiceCode(), 2);

        } else if (selectedTab.equals("ESTADIAS")
                && getSelectedStableTypeCode() != null && getSelectedStableTypeValue() != null) {

            initEdit(getSelectedStableTypeCode(), 3);

        } else {
            JOptionPane.showMessageDialog(null, "Nada foi selecionado.", null, JOptionPane.ERROR_MESSAGE, null);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void lblSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSearchMouseClicked
        // TODO add your handling code here:
        String selectedTab = tpSelection.getTitleAt(tpSelection.getSelectedIndex());
        long id;
        
        if (boxSearch.getSelectedItem() != null && String.valueOf(boxSearch.getSelectedItem()).matches("[0-9]+")) {
            id = Long.parseLong(String.valueOf(boxSearch.getSelectedItem()));
            switch (selectedTab) {
                case "PRODUTOS":
                    insertSearchData(id, tpSelection);
                    break;
                case "SERVIÇOS":
                    insertSearchData(id, tpSelection);
                    break;
                case "ESTADIAS":
                    insertSearchData(id, tpSelection);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Nada foi selecionado.", null, JOptionPane.ERROR_MESSAGE, null);
                    break;
            }
        }
        
    }//GEN-LAST:event_lblSearchMouseClicked

    private void insertSearchData(long id, JTabbedPane tabbedPane) {
        int selectedTab = tabbedPane.getSelectedIndex();
        JTable table;
        int x;
        
        switch (selectedTab) {
            case 0:
                table = tableProducts;
                x = 0;
                break;
            case 1:
                table = tableServices;
                x = 1;
                break;
            case 2:
                table = tableStable;
                x = 2;
                break;
            default:
                return;
        }
        
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        
        switch (x) {
            case 0:
                table.setModel(updateProductTableModel(id, model));
                break;
            case 1:
                table.setModel(updateServiceTableModel(id, model));
                break;
            case 2:
                table.setModel(updateStableTypeTableModel(id, model));
                break;
            default:
                return;
        }
    }
    
    private void tableProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProductsMouseClicked
        // TODO add your handling code here:
        DefaultTableModel table = (DefaultTableModel) tableProducts.getModel();
        
        int id = Integer.parseInt(table.getValueAt(tableProducts.getSelectedRow(), 0).toString());
        
        String queryProduto = "SELECT a FROM Produto a WHERE a.id = '" + id + "'";
        this.productSelected = EntityUtils.select(queryProduto, Produto.class).get(0);
    }//GEN-LAST:event_tableProductsMouseClicked

    private void tableServicesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableServicesMouseClicked
        // TODO add your handling code here:
        DefaultTableModel table = (DefaultTableModel) tableServices.getModel();
        
        int id = Integer.parseInt(table.getValueAt(tableServices.getSelectedRow(), 0).toString());
        
        String queryServico = "SELECT a FROM Servico a WHERE a.Id = '" + id + "'";
        this.serviceSelected = EntityUtils.select(queryServico, Servico.class).get(0);
    }//GEN-LAST:event_tableServicesMouseClicked

    private void tableStableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableStableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel table = (DefaultTableModel) tableStable.getModel();
        
        int id = Integer.parseInt(table.getValueAt(tableStable.getSelectedRow(), 0).toString());
        
        String queryStableType = "SELECT a FROM TipoEstadia a WHERE a.Id = '" + id + "'";
        this.stableTypeSelected = EntityUtils.select(queryStableType, TipoEstadia.class).get(0);
    }//GEN-LAST:event_tableStableMouseClicked

    private void updateBoxSearch(){
        this.boxSearch.removeAllItems();
        boxSearch.addItem("");
        
        String selectedTab = tpSelection.getTitleAt(tpSelection.getSelectedIndex());
        
        if (selectedTab.equals("PRODUTOS")) {
            String pQuerySearch = "SELECT a FROM Produto a WHERE a.isDeleted = false";
            List<Produto> produto = EntityUtils.select(pQuerySearch, Produto.class);
            for (Produto p: produto) {
                boxSearch.addItem(p.getName());
            }
        } else if (selectedTab.equals("SERVIÇOS")) {
            String sQuerySearch = "SELECT a FROM Servico a WHERE a.isDeleted = false";
            List<Servico> servico = EntityUtils.select(sQuerySearch, Servico.class);
            for (Servico s: servico) {
                boxSearch.addItem(s.getName());
            }
        } else if (selectedTab.equals("ESTADIAS")) {
            String eQuerySearch = "SELECT a FROM TipoEstadia a WHERE a.isDeleted = false";
            List<TipoEstadia> tipoEstadia = EntityUtils.select(eQuerySearch, TipoEstadia.class);
            for (TipoEstadia e: tipoEstadia) {
                boxSearch.addItem(e.getType());
            }
        }
    }
    
    private void populateTable() {
        DefaultTableModel pModel = (DefaultTableModel) tableProducts.getModel();
        DefaultTableModel sModel = (DefaultTableModel) tableServices.getModel();
        DefaultTableModel eModel = (DefaultTableModel) tableStable.getModel();
        List<Produto> produtos = EntityUtils.select("SELECT c FROM Produto c", Produto.class);
        List<Servico> servicos = EntityUtils.select("SELECT c FROM Servico c", Servico.class);
        List<TipoEstadia> tiposEstadia = EntityUtils.select("SELECT c FROM TipoEstadia c", TipoEstadia.class);
        
        pModel.setRowCount(0);
        sModel.setRowCount(0);
        eModel.setRowCount(0);
        
        for (Produto p : produtos) {
            
            if (!p.isIsDeleted()) {
                updateProductTableModel(p.getId(), pModel);     
            } 
        }
        
        for (Servico s : servicos) {
            
            if (!s.isIsDeleted()) {
                updateServiceTableModel(s.getId(), sModel);     
            } 
        }
        
        for (TipoEstadia e : tiposEstadia) {
            
            if (!e.isIsDeleted()) {
                updateStableTypeTableModel(e.getId(), eModel);     
            } 
        }
    }
    
    private DefaultTableModel updateProductTableModel(long id, DefaultTableModel models) {
        
        updateBoxSearch();
        
        Produto p = new Produto();
        long produtoId = p.getProduto(id).getId();
        String produtoNome = p.getProduto(id).getName();
        
        String PquerySearch = "SELECT a FROM Produto a WHERE a.Id = '" + produtoId + "'";
        
        models.addRow(new Object[]{
            String.valueOf(p.getProduto(id).getId()),
            produtoNome,
            String.valueOf(p.getProduto(id).getStock()),
            String.valueOf(p.getProduto(id).getPdc()),
            String.valueOf(p.getProduto(id).getPdv())
        });
                    
        return models;
    }
    
    private DefaultTableModel updateServiceTableModel(long id, DefaultTableModel models) {
        
        updateBoxSearch();
        
        Servico s = new Servico();
        long servicoId = s.getServico(id).getId();
        String servicoNome = s.getServico(id).getName();
        
        String SquerySearch = "SELECT a FROM Servico a WHERE a.Id = '" + servicoId + "'";
        
        models.addRow(new Object[]{
            String.valueOf(s.getServico(id).getId()),
            servicoNome,
            String.valueOf(s.getServico(id).getPrice())
        });
                    
        return models;
    }
    
    private DefaultTableModel updateStableTypeTableModel(long id, DefaultTableModel models) {
        
        updateBoxSearch();
        
        TipoEstadia e = new TipoEstadia();
        long tipoEstadiaId = e.getTipoEstadia(id).getId();
        String tipoEstadiaNome = e.getTipoEstadia(id).getType();
        
        String EquerySearch = "SELECT a FROM TipoEstadia a WHERE a.Id = '" + tipoEstadiaId + "'";
        
        models.addRow(new Object[]{
            String.valueOf(e.getTipoEstadia(id).getId()),
            tipoEstadiaNome,
            String.valueOf(e.getTipoEstadia(id).getPrice())
        });
                    
        return models;
    }
    @Override
    public void update(Object o) {
        this.updateBoxSearch();
        this.populateTable();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.fp3.haras.components.ComboBoxSuggestion boxSearch;
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
    // End of variables declaration//GEN-END:variables
}
