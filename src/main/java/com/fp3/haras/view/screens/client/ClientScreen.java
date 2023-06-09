package com.fp3.haras.view.screens.client;

import com.fp3.haras.model.Client;
import com.fp3.haras.utils.Colors;
import com.fp3.haras.utils.EntityUtils;
import com.fp3.haras.utils.GenericObserver;
import com.fp3.haras.utils.ReportGenerator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ClientScreen extends javax.swing.JPanel implements GenericObserver {
    private ClientCreate creationModal;
    private ClientEdit editionModal;
    private Client clientSelected;
    private List<Client> fetchedClients;
    private List<Client> tableResults;
    private int currentPage = 1;
    private final int maxResults = 16;

    public ClientScreen(ClientCreate creationModal, ClientEdit editionModal) {
        initComponents();
        this.setBackground(Colors.PRIMARYBG);
        pnlReports.setBackground(Colors.SECONDARYBG);
        lblTitle.putClientProperty("FlatLaf.styleClass", "h00");
        lblReports.putClientProperty("FlatLaf.styleClass", "h4");
        radioGroupReports.add(radioSelectedPage);
        radioGroupReports.add(radioAllItems);
        radioSelectedPage.setSelected(true);
        
        this.creationModal = creationModal;
        this.editionModal = editionModal;
        
        this.populateTable();
        this.updateBoxSearch();
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

        radioGroupReports = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProgress = new javax.swing.JTable();
        btnCreate = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        lblSearch = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblSubtitle = new javax.swing.JLabel();
        boxSearch = new com.fp3.haras.components.ComboBoxSuggestion();
        btnBack = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        pnlReports = new javax.swing.JPanel();
        lblReports = new javax.swing.JLabel();
        btnGenerateReport = new javax.swing.JButton();
        radioSelectedPage = new javax.swing.JRadioButton();
        radioAllItems = new javax.swing.JRadioButton();

        setBackground(new java.awt.Color(244, 244, 244));
        setPreferredSize(new java.awt.Dimension(900, 585));

        tableProgress.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Telefone", "E-mail", "CPF", "Endereço"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableProgress.setShowGrid(true);
        tableProgress.getTableHeader().setResizingAllowed(false);
        tableProgress.getTableHeader().setReorderingAllowed(false);
        tableProgress.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProgressMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableProgress);

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
        lblSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSearchMouseClicked(evt);
            }
        });

        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitle.setText("CLIENTES");

        lblSubtitle.setText("INFORMAÇÕES PESSOAIS");

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

        lblReports.setText("Relatórios");

        btnGenerateReport.setText("Gerar Relatório");
        btnGenerateReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateReportActionPerformed(evt);
            }
        });

        radioSelectedPage.setText("Página selecionada");

        radioAllItems.setText("Todos os itens");

        javax.swing.GroupLayout pnlReportsLayout = new javax.swing.GroupLayout(pnlReports);
        pnlReports.setLayout(pnlReportsLayout);
        pnlReportsLayout.setHorizontalGroup(
            pnlReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlReportsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlReportsLayout.createSequentialGroup()
                        .addGroup(pnlReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlReportsLayout.createSequentialGroup()
                                .addComponent(lblReports)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(btnGenerateReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(pnlReportsLayout.createSequentialGroup()
                        .addGroup(pnlReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radioAllItems)
                            .addComponent(radioSelectedPage))
                        .addGap(0, 128, Short.MAX_VALUE))))
        );
        pnlReportsLayout.setVerticalGroup(
            pnlReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlReportsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblReports)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(radioSelectedPage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioAllItems)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGenerateReport)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(boxSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblSearch)
                                        .addGap(238, 238, 238))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblTitle)
                                            .addComponent(lblSubtitle))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(pnlReports, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(638, 638, 638)
                                .addComponent(btnBack)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNext)))))
                .addGap(0, 48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(lblTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSubtitle)
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boxSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(9, Short.MAX_VALUE)
                        .addComponent(pnlReports, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCreate)
                            .addComponent(btnEdit))
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNext)
                    .addComponent(btnBack))
                .addContainerGap(37, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        this.creationModal.setVisible(true);
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if (tableProgress.getSelectedColumnCount()!= 0
            && getSelectedProgressCode() != null 
            && getSelectedProgressValue() != null) {
            
            this.editionModal.populateData(this.clientSelected);
            this.editionModal.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Nada foi selecionado.", null, JOptionPane.ERROR_MESSAGE, null);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void lblSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSearchMouseClicked
        DefaultTableModel table = (DefaultTableModel) tableProgress.getModel();
        table.setRowCount(0);
        
        if (boxSearch.getSelectedItem() == null) {
            this.populateTable();
        } else {
            String querySearch = "SELECT c FROM Client c WHERE c.name = '" + (String) boxSearch.getSelectedItem() + "'";
            List<Client> clients = EntityUtils.select(querySearch, Client.class);
            String owner = "";
            for (Client c : clients) {
                table.addRow(new Object[]{
                    c.getId(),
                    c.getName(),
                    c.getPhoneNumber(),
                    c.getEmail(),
                    c.getDocument(),
                    c.getAddress(),
                });
            }
        }
    }//GEN-LAST:event_lblSearchMouseClicked

    private void tableProgressMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProgressMouseClicked
        DefaultTableModel table = (DefaultTableModel) tableProgress.getModel();
        
        long id = Long.parseLong(table.getValueAt(tableProgress.getSelectedRow(), 0).toString());
        
        String queryClient = "SELECT c FROM Client c WHERE c.id = " + id;
        this.clientSelected = EntityUtils.select(queryClient, Client.class).get(0);
    }//GEN-LAST:event_tableProgressMouseClicked

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.currentPage--;
        this.populateTable();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        this.currentPage++;
        this.populateTable();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnGenerateReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateReportActionPerformed
        ReportGenerator reportGenerator = new ReportGenerator();
        if (radioSelectedPage.isSelected()) {
            reportGenerator.generateReport(this,
                "relatorio_clientes_parcial",
                "Relatório Parcial de Clientes",
                tableProgress);
        } else {
            JTable fullTable = generateFullTable();

            reportGenerator.generateReport(this,
                "relatorio_clientes_completo",
                "Relatório Completo de Clientes",
                fullTable);

            this.populateTable();
        }
    }//GEN-LAST:event_btnGenerateReportActionPerformed

    private void updateBoxSearch(){
        boxSearch.addItem("");
        String queryClients = "SELECT c from Client c WHERE c.isDeleted = FALSE";
        fetchedClients = EntityUtils.select(queryClients, Client.class);
        for (Client client : fetchedClients) {
            boxSearch.addItem(client.getName());
        }
    }
    
    private void populateTable() {
        DefaultTableModel table = (DefaultTableModel) tableProgress.getModel();
        table.setRowCount(0);
        
        fetchTableResults(this.currentPage, this.maxResults);
        String owner = "";
        for (Client c : this.tableResults) {
            table.addRow(new Object[]{
                c.getId(),
                c.getName(),
                c.getPhoneNumber(),
                c.getEmail(),
                c.getDocument(),
                c.getAddress(),
            });
        }
    }   
    
    private void fetchTableResults(int page, int maxResults) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("haras");
        EntityManager em = emf.createEntityManager();
        
        int firstResult = page == 1 ? 0 : ((page - 1) * maxResults);
        
        TypedQuery<Client> clientsQuery = em.createQuery(
                "SELECT c FROM Client c WHERE c.isDeleted = FALSE order by c.id asc", 
                Client.class);
        this.tableResults = clientsQuery.setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    private JTable generateFullTable() {
        JTable jtable = new JTable();
        jtable.setModel(tableProgress.getModel());
        
        List<Client> allClients = EntityUtils.select(
                "SELECT c FROM Client c WHERE c.isDeleted = FALSE order by c.id asc", 
                Client.class);
        
        DefaultTableModel model = (DefaultTableModel) jtable.getModel();
        model.setRowCount(0);
       
        String owner = "";
        for (Client c : allClients) {
            model.addRow(new Object[]{
                c.getId(),
                c.getName(),
                c.getPhoneNumber(),
                c.getEmail(),
                c.getDocument(),
                c.getAddress(),
            });
        }
        
        return jtable;
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
    private javax.swing.JButton btnGenerateReport;
    private javax.swing.JButton btnNext;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblReports;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lblSubtitle;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlReports;
    private javax.swing.JRadioButton radioAllItems;
    private javax.swing.ButtonGroup radioGroupReports;
    private javax.swing.JRadioButton radioSelectedPage;
    private javax.swing.JTable tableProgress;
    // End of variables declaration//GEN-END:variables
}
