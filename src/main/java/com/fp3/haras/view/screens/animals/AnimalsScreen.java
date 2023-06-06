package com.fp3.haras.view.screens.animals;

import com.fp3.haras.model.Animal;
import com.fp3.haras.model.Cliente;
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

public class AnimalsScreen extends javax.swing.JPanel implements GenericObserver {
    private AnimalsCreate creationModal;
    private AnimalsEdit editionModal;
    private Animal animalSelected;
    private List<Animal> fetchedAnimals;
    private List<Animal> tableResults;
    private int currentPage = 1;
    private final int maxResults = 16;

    public AnimalsScreen(AnimalsCreate creationModal, AnimalsEdit editionModal) {
        initComponents();
        this.creationModal = creationModal;
        this.editionModal = editionModal;
        
        this.setBackground(Colors.PRIMARYBG);
        pnlReports.setBackground(Colors.SECONDARYBG);
        lblTitle.putClientProperty("FlatLaf.styleClass", "h00");
        lblReports.putClientProperty("FlatLaf.styleClass", "h4");
        radioGroupReports.add(radioSelectedPage);
        radioGroupReports.add(radioAllItems);
        radioSelectedPage.setSelected(true);
        
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
        btnNext = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
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
                "ID", "NOME", "PELAGEM", "CATEGORIA", "AIE", "MORMO", "GTA", "PROPRIETÁRIO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableProgress.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tableProgress.setShowGrid(true);
        tableProgress.getTableHeader().setResizingAllowed(false);
        tableProgress.getTableHeader().setReorderingAllowed(false);
        tableProgress.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProgressMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableProgress);
        if (tableProgress.getColumnModel().getColumnCount() > 0) {
            tableProgress.getColumnModel().getColumn(0).setPreferredWidth(41);
            tableProgress.getColumnModel().getColumn(1).setPreferredWidth(160);
            tableProgress.getColumnModel().getColumn(2).setPreferredWidth(110);
            tableProgress.getColumnModel().getColumn(3).setPreferredWidth(116);
            tableProgress.getColumnModel().getColumn(4).setPreferredWidth(65);
            tableProgress.getColumnModel().getColumn(6).setPreferredWidth(65);
            tableProgress.getColumnModel().getColumn(7).setPreferredWidth(166);
        }

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
        lblSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSearchMouseClicked(evt);
            }
        });

        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitle.setText("ANIMAIS");

        lblSubtitle.setText("PRINCIPAIS CARACTERÍSTICAS");

        btnNext.setText("Avançar >");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnBack.setText("< Voltar");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
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
                        .addGap(0, 0, Short.MAX_VALUE))))
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
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(boxSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblSearch))
                            .addComponent(lblTitle)
                            .addComponent(lblSubtitle))
                        .addGap(239, 239, 239)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(pnlReports, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(btnBack)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnNext))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(boxSearch, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(pnlReports, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCreate)
                            .addComponent(btnEdit))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNext)
                    .addComponent(btnBack))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        this.creationModal.setVisible(true);
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if (tableProgress.getSelectedColumnCount()!= 0
            && getSelectedProgressCode() != null && getSelectedProgressValue() != null) {
            this.editionModal.populateData(animalSelected);
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
            String querySearch = "SELECT a FROM Animal a JOIN FETCH a.owners o WHERE a.name = '" + (String) boxSearch.getSelectedItem() + "'";
            List<Animal> animal = EntityUtils.select(querySearch, Animal.class);
            String owner = "";
            for (Animal a : animal) {
                for (Cliente o : a.getOwners()) {
                    owner = o.getNome();
                }
                table.addRow(new Object[]{
                    a.getId(),
                    a.getName(),
                    a.getCoat(),
                    a.getCategory(),
                    a.getHasExameAie() ? "Sim" : "Não",
                    a.getHasExameMormo() ? "Sim" : "Não",
                    a.getHasGta() ? "Sim" : "Não",
                    owner
                });
            }
        }
    }//GEN-LAST:event_lblSearchMouseClicked

    private void tableProgressMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProgressMouseClicked
        DefaultTableModel table = (DefaultTableModel) tableProgress.getModel();
        
        int id = Integer.parseInt(table.getValueAt(tableProgress.getSelectedRow(), 0).toString());
        
        String queryAnimal = "SELECT a FROM Animal a JOIN FETCH a.owners o WHERE a.id = " + id;
        this.animalSelected = EntityUtils.select(queryAnimal, Animal.class).get(0);
    }//GEN-LAST:event_tableProgressMouseClicked

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        this.currentPage++;
        this.populateTable();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.currentPage--;
        this.populateTable();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnGenerateReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateReportActionPerformed
        ReportGenerator reportGenerator = new ReportGenerator();
        if (radioSelectedPage.isSelected()) {
            reportGenerator.generateReport(this, 
                    "relatorio_animais_parcial", 
                    "Relatório Parcial de Animais", 
                    tableProgress);
        } else {
            JTable fullTable = generateFullTable();
            
            reportGenerator.generateReport(this, 
                    "relatorio_animais_completo", 
                    "Relatório Completo de Animais", 
                    fullTable);
            
           this.populateTable();
        }
    }//GEN-LAST:event_btnGenerateReportActionPerformed
    
    private void updateBoxSearch(){
        boxSearch.addItem("");
        String queryAnimals = "SELECT a from Animal a JOIN FETCH a.owners o WHERE a.isDeleted = FALSE";
        fetchedAnimals = EntityUtils.select(queryAnimals, Animal.class);
        for (Animal animal : fetchedAnimals) {
            boxSearch.addItem(animal.getName());
        }
    }
    
    private void populateTable() {
        DefaultTableModel table = (DefaultTableModel) tableProgress.getModel();
        table.setRowCount(0);
        
        fetchTableResults(this.currentPage, this.maxResults);
        String owner = "";
        for (Animal a : this.tableResults) {
            for (Cliente o : a.getOwners()) {
                owner = o.getNome();
            }
            table.addRow(new Object[]{
                a.getId(),
                a.getName(),
                a.getCoat(),
                a.getCategory(),
                a.getHasExameAie() ? "Sim" : "Não",
                a.getHasExameMormo() ? "Sim" : "Não",
                a.getHasGta() ? "Sim" : "Não",
                owner
            });
        }
    }   
    
    private void fetchTableResults(int page, int maxResults) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("haras");
        EntityManager em = emf.createEntityManager();
        
        int firstResult = page == 1 ? 0 : ((page - 1) * maxResults);
        
        TypedQuery<Animal> animalsQuery = em.createQuery("SELECT a FROM Animal a JOIN FETCH a.owners o WHERE a.isDeleted = FALSE order by a.id asc", Animal.class);
        this.tableResults = animalsQuery.setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    private JTable generateFullTable() {
        JTable jtable = new JTable();
        jtable.setModel(tableProgress.getModel());
        
        List<Animal> allAnimals = EntityUtils.select(
                "SELECT a FROM Animal a JOIN FETCH a.owners o WHERE a.isDeleted = FALSE order by a.id asc", 
                Animal.class);
        
        DefaultTableModel model = (DefaultTableModel) jtable.getModel();
        model.setRowCount(0);
       
        String owner = "";
        for (Animal a : allAnimals) {
            for (Cliente o : a.getOwners()) {
                owner = o.getNome();
            }
            model.addRow(new Object[]{
                a.getId(),
                a.getName(),
                a.getCoat(),
                a.getCategory(),
                a.getHasExameAie() ? "Sim" : "Não",
                a.getHasExameMormo() ? "Sim" : "Não",
                a.getHasGta() ? "Sim" : "Não",
                owner
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
