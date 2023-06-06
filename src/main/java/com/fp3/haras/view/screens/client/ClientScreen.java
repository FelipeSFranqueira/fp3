package com.fp3.haras.view.screens.client;

import com.fp3.haras.model.Cliente;
import com.fp3.haras.utils.Colors;
import com.fp3.haras.utils.EntityUtils;
import com.fp3.haras.utils.GenericObserver;
import com.mysql.cj.xdevapi.Client;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class ClientScreen extends javax.swing.JPanel implements GenericObserver{
    
        private final ClientCreate CreateModal;
        //private final ClientEdit   EditModal;
        private Client       productSelected;
        
        
    public static long selectedId;
    DefaultTableCellRenderer center = new DefaultTableCellRenderer();

    public ClientScreen(ClientCreate creationModal) {
        initComponents();
        this.setBackground(Colors.PRIMARYBG);
        this.CreateModal = creationModal;
        lblTitle.putClientProperty("FlatLaf.styleClass", "h00");
        this.populateTable();
    }
    
    private String getSelectedProgressCode() {
        if (tableProgress.getSelectedRow() != -1) {
            return String.valueOf(tableProgress.getModel().getValueAt(tableProgress.getSelectedRow(), 0));
        } else {
            return null;
        }
    }
    
    private Object getSelectedProgressValue() {
        return tableProgress.getModel().getValueAt(tableProgress.getSelectedRow(), tableProgress.getSelectedColumn());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableProgress = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        btnCreate = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        lblSearch = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblSubtitle = new javax.swing.JLabel();

        setBackground(new java.awt.Color(244, 244, 244));
        setPreferredSize(new java.awt.Dimension(900, 585));

        tableProgress.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOME", "TELEFONE", "EMAIL", "DOCUMENTO", "ENDEREÇO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableProgress.getTableHeader().setResizingAllowed(false);
        tableProgress.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tableProgress);

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

        btnCreate.setText("CRIAR");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnEdit.setText("EDITAR");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        lblSearch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        lblSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitle.setText("CLIENTES");

        lblSubtitle.setText("INFORMAÇÕES PESSOAIS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitle)
                    .addComponent(lblSubtitle)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSearch)
                        .addGap(230, 230, 230)
                        .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSubtitle)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCreate)
                        .addComponent(btnEdit))
                    .addComponent(lblSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchMouseReleased
        if (txtSearch.getText().equals("Pesquisar..."))
            txtSearch.setText(null);
    }//GEN-LAST:event_txtSearchMouseReleased

    private void txtSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusLost
        if (txtSearch.getText().equals(""))
            txtSearch.setText("Pesquisar...");
    }//GEN-LAST:event_txtSearchFocusLost

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        this.CreateModal.setVisible(true);
    }//GEN-LAST:event_btnCreateActionPerformed
    
    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if (tableProgress.getSelectedColumnCount()!= 0
            && getSelectedProgressCode() != null && getSelectedProgressValue() != null) {
                
                new ClientEdit().setVisible(true);
                
            } else {
                JOptionPane.showMessageDialog(null, "Nada foi selecionado.", null, JOptionPane.ERROR_MESSAGE, null);
            }
    }//GEN-LAST:event_btnEditActionPerformed
    private String getSelectedClientTypeCode() {
        if (tableProgress.getSelectedRow() != -1) {
            return String.valueOf(tableProgress.getModel().getValueAt(tableProgress.getSelectedRow(), 0));
        } else {
            return null;
        }
    }
    
    private Object getSelectedProductValue() {
        return tableProgress.getModel().getValueAt(tableProgress.getSelectedRow(), tableProgress.getSelectedColumn());
    }
    private void populateTable() {
        DefaultTableModel cModel = (DefaultTableModel) tableProgress.getModel();
        List<Cliente> clientes = EntityUtils.select("SELECT c FROM Cliente c", Cliente.class);
       
        cModel.setRowCount(0);
        
        for (Cliente c : clientes) {
            
            if (!c.isIsDeleted()) {
                updateProductTableModel(c.getId(), cModel);     
            } 
        }
    }
    
    private DefaultTableModel updateProductTableModel(long id, DefaultTableModel models) {
        
        //updateBoxSearch();
        
        Cliente c = new Cliente();
        long clienteId = c.getCliente(id).getId();
        String clienteNome = c.getCliente(id).getNome();
        
        String PquerySearch = "SELECT a FROM Cliente a WHERE a.Id = '" + clienteId + "'";
        
        models.addRow(new Object[]{
            String.valueOf(c.getCliente(id).getId()),
            clienteNome,
            String.valueOf(c.getCliente(id).getTelefone()),
            String.valueOf(c.getCliente(id).getEmail()),
            String.valueOf(c.getCliente(id).getDocumento()),
            String.valueOf(c.getCliente(id).getEndereco())
        });
                    
        return models;
    }
    
    @Override
    public void update(Object o) {
        //this.updateBoxSearch();
        this.populateTable();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnEdit;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lblSubtitle;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tableProgress;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
