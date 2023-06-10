package com.fp3.haras.view.screens.stable;

import com.fp3.haras.model.Animal;
import com.fp3.haras.model.Client;
import com.fp3.haras.model.Estadia;
import com.fp3.haras.utils.Colors;
import com.fp3.haras.utils.EntityUtils;
import com.fp3.haras.utils.GenericObserver;
import com.fp3.haras.utils.ReportGenerator;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class StableScreen extends javax.swing.JPanel implements GenericObserver {

    private final DefaultTableCellRenderer center = new DefaultTableCellRenderer();
    private final StableCreate creationModal;
    private final StableEdit editionModal;
    private final int maxResults = 15;
    private int currentProgressPage = 1;
    private int currentFuturePage = 1;
    private int currentEndPage = 1;
    private List<Estadia> tableProgressResults;
    private List<Estadia> tableFutureResults;
    private List<Estadia> tableEndResults;
    public static long selectedId;
    
    public StableScreen(StableCreate creationModal, StableEdit editionModal) {
        initComponents();
        this.creationModal = creationModal;
        this.editionModal = editionModal;
        this.setBackground(Colors.PRIMARYBG);
        lblTitle.putClientProperty("FlatLaf.styleClass", "h00");
        center.setHorizontalAlignment(JLabel.CENTER);
        pnlReports.setBackground(Colors.SECONDARYBG);
        lblReports.putClientProperty("FlatLaf.styleClass", "h4");
        this.updateTables();
        this.updateSuggestionBox();
    }
    
    public static Date setOnlyDay(Date date) {
        Calendar calendario = Calendar.getInstance();

        calendario.setTime(date);
        calendario.set(Calendar.HOUR_OF_DAY, 0);
        calendario.set(Calendar.MINUTE, 0);
        calendario.set(Calendar.SECOND, 0);
        calendario.set(Calendar.MILLISECOND, 0);

        return calendario.getTime();
    }
    
    private void updateTables() {
        DefaultTableModel progressModel = (DefaultTableModel) tableProgress.getModel();
        DefaultTableModel futureModel = (DefaultTableModel) tableFuture.getModel();
        DefaultTableModel endModel = (DefaultTableModel) tableFinished.getModel();
        
        progressModel.setRowCount(0);
        futureModel.setRowCount(0);
        endModel.setRowCount(0);
        
        fetchTableProgressResults(this.currentProgressPage, this.maxResults);
        for (Estadia e : tableProgressResults) {
            updateTableModel(e.getId(), progressModel);
        }
        
        fetchTableFutureResults(this.currentFuturePage, this.maxResults);
        for (Estadia e : tableFutureResults) {
            updateTableModel(e.getId(), futureModel);
        }
            
        fetchTableEndResults(this.currentEndPage, this.maxResults);
        for (Estadia e : tableEndResults) {
            updateTableModel(e.getId(), endModel);
        }
        
        allignTableCenterd(tableProgress);
        allignTableCenterd(tableFuture);
        allignTableCenterd(tableFinished);
    }
    
    private void fetchTableProgressResults(int page, int maxResults) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("haras");
        EntityManager em = emf.createEntityManager();
        Date now = new Date();
        Date n = new Date(now.getTime());
        
        int firstResult = page == 1 ? 0 : ((page - 1) * maxResults);
        
        String query = "SELECT p FROM Cocheiras p WHERE p.isCancelled = false AND p.entrada <= :n AND p.saida >= :n";
        TypedQuery<Estadia> stableQuery = em.createQuery(query, Estadia.class);
        stableQuery.setParameter("n", n);
        
        this.tableProgressResults = stableQuery.setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    private void fetchTableFutureResults(int page, int maxResults) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("haras");
        EntityManager em = emf.createEntityManager();
        Date now = new Date();
        Date n = new Date(now.getTime());
        
        int firstResult = page == 1 ? 0 : ((page - 1) * maxResults);
        
        String query = "SELECT p FROM Cocheiras p WHERE p.isCancelled = false AND p.entrada > :n";
        TypedQuery<Estadia> stableQuery = em.createQuery(query, Estadia.class);
        stableQuery.setParameter("n", n);
        
        this.tableFutureResults = stableQuery.setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    private void fetchTableEndResults(int page, int maxResults) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("haras");
        EntityManager em = emf.createEntityManager();
        Date now = new Date();
        Date n = new Date(now.getTime());
        
        int firstResult = page == 1 ? 0 : ((page - 1) * maxResults);
        
        String query = "SELECT p FROM Cocheiras p WHERE p.isCancelled = false AND p.entrada < :n AND p.saida < :n";
        TypedQuery<Estadia> stableQuery = em.createQuery(query, Estadia.class);
        stableQuery.setParameter("n", n);
        
        this.tableEndResults = stableQuery.setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

    private String getSelectedProgressCode() {
        if (tableProgress.getSelectedRow() != -1) {
            return String.valueOf(tableProgress.getModel().getValueAt(tableProgress.getSelectedRow(), 0));
        } else {
            return null;
        }
    }
    
    private String getSelectedEndCode() {
        if (tableFinished.getSelectedRow() != -1) {
            return String.valueOf(tableFinished.getModel().getValueAt(tableFinished.getSelectedRow(), 0));
        } else {
            return null;
        }
    }
    
    private String getSelectedFutureCode() {
        if (tableFuture.getSelectedRow() != -1) {
            return String.valueOf(tableFuture.getModel().getValueAt(tableFuture.getSelectedRow(), 0));
        } else {
            return null;
        }
    }
    
    private Object getSelectedFutureValue() {
        return tableFuture.getModel().getValueAt(tableFuture.getSelectedRow(), tableFuture.getSelectedColumn());
    }
    
    private Object getSelectedEndValue() {
        return tableFinished.getModel().getValueAt(tableFinished.getSelectedRow(), tableFinished.getSelectedColumn());
    }
    
    private Object getSelectedProgressValue() {
        return tableProgress.getModel().getValueAt(tableProgress.getSelectedRow(), tableProgress.getSelectedColumn());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tpaneInfo = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProgress = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableFuture = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableFinished = new javax.swing.JTable();
        btnCreate = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        lblSearch = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblSubtitle = new javax.swing.JLabel();
        boxSearch = new com.fp3.haras.components.ComboBoxSuggestion();
        pnlReports = new javax.swing.JPanel();
        lblReports = new javax.swing.JLabel();
        btnGenerateReport = new javax.swing.JButton();
        radioSelected = new javax.swing.JRadioButton();
        radioFull = new javax.swing.JRadioButton();
        btnBack = new javax.swing.JButton();
        btnNext2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(244, 244, 244));
        setPreferredSize(new java.awt.Dimension(900, 585));

        tpaneInfo.setBackground(new java.awt.Color(234, 234, 234));
        tpaneInfo.setForeground(new java.awt.Color(153, 153, 153));
        tpaneInfo.setOpaque(true);

        jScrollPane1.setViewportView(null);

        tableProgress.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CÓDIGO", "PROPRIETÁRIO", "ANIMAL", "TEMPO PREVISTO", "COCHEIRA", "SUBTOTAL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableProgress.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableProgress.getTableHeader().setResizingAllowed(false);
        tableProgress.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tableProgress);

        tpaneInfo.addTab("ATIVAS", jScrollPane1);

        tableFuture.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CÓDIGO", "PROPRIETÁRIO", "ANIMAL", "TEMPO PREVISTO", "COCHEIRA", "SUBTOTAL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableFuture.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableFuture.getTableHeader().setResizingAllowed(false);
        tableFuture.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tableFuture);

        tpaneInfo.addTab("FUTURAS", jScrollPane2);

        tableFinished.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CÓDIGO", "PROPRIETÁRIO", "ANIMAL", "TEMPO DECORRIDO", "COCHEIRA", "VALOR FINAL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableFinished.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableFinished.getTableHeader().setResizingAllowed(false);
        tableFinished.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tableFinished);

        tpaneInfo.addTab("FINALIZADAS", jScrollPane3);

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
        lblTitle.setText("COCHEIRAS");

        lblSubtitle.setText("STATUS DE SERVIÇO");

        boxSearch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));

        lblReports.setText("Relatórios");

        btnGenerateReport.setText("Gerar Relatório");
        btnGenerateReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateReportActionPerformed(evt);
            }
        });

        radioSelected.setSelected(true);
        radioSelected.setText("Página selecionada");
        radioSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioSelectedActionPerformed(evt);
            }
        });

        radioFull.setText("Todos os itens");
        radioFull.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioFullActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlReportsLayout = new javax.swing.GroupLayout(pnlReports);
        pnlReports.setLayout(pnlReportsLayout);
        pnlReportsLayout.setHorizontalGroup(
            pnlReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlReportsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(radioSelected, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(radioFull, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlReportsLayout.createSequentialGroup()
                        .addComponent(lblReports)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnGenerateReport, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlReportsLayout.setVerticalGroup(
            pnlReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlReportsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblReports)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(radioSelected)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioFull)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGenerateReport)
                .addContainerGap())
        );

        btnBack.setText("< Voltar");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnNext2.setText("Avançar >");
        btnNext2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNext2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tpaneInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNext2))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(50, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(boxSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblSearch))
                            .addComponent(lblTitle)
                            .addComponent(lblSubtitle))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(226, 226, 226)
                                .addComponent(pnlReports, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(lblTitle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblSubtitle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(boxSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 14, Short.MAX_VALUE)
                        .addComponent(pnlReports, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCreate)
                            .addComponent(btnEdit))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(tpaneInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNext2)
                    .addComponent(btnBack))
                .addGap(28, 28, 28))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        this.creationModal.clearFrame();
        this.creationModal.updateSuggestionBox();
        this.creationModal.setVisible(true);
        this.creationModal.toFront();
    }//GEN-LAST:event_btnCreateActionPerformed

    private void initEdit(Object tableSelectedCode) {
        selectedId = Integer.parseInt(String.valueOf(tableSelectedCode));
        this.editionModal.clearFrame();
        this.editionModal.updateSuggestionBox();
        this.editionModal.initData();
        this.editionModal.setVisible(true);
        this.editionModal.toFront();
    }
    
    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if (tpaneInfo.getTitleAt(tpaneInfo.getSelectedIndex()).equals("ATIVAS") 
                && getSelectedProgressCode() != null && getSelectedProgressValue() != null) {
                
                initEdit(getSelectedProgressCode());
                
            }else if (tpaneInfo.getTitleAt(tpaneInfo.getSelectedIndex()).equals("FINALIZADAS")
                && getSelectedEndCode() != null && getSelectedEndValue() != null) {
                
                initEdit(getSelectedEndCode());
                
            }else if (tpaneInfo.getTitleAt(tpaneInfo.getSelectedIndex()).equals("FUTURAS")
                && getSelectedFutureCode() != null && getSelectedFutureValue() != null) {
                
                initEdit(getSelectedFutureCode());
                
            } else {
                JOptionPane.showMessageDialog(null, "Nada foi selecionado.", null, JOptionPane.ERROR_MESSAGE, null);
            }
    }//GEN-LAST:event_btnEditActionPerformed

    private DefaultTableModel updateTableModel(long id, DefaultTableModel models) {
        long time = Estadia.getEstadia(id).getSaida().getTime() - Estadia.getEstadia(id).getEntrada().getTime();
        long stayDays = TimeUnit.MILLISECONDS.toDays(time);
        long stayHours = TimeUnit.MILLISECONDS.toHours(time);
        String remainTime;
        
        if (stayDays == 0)
            remainTime = stayHours + "h";
        else
            remainTime = stayDays + "d";
        
        updateSuggestionBox();
        long animalId = Estadia.getEstadia(id).getAnimal().getId();
        String animalName = Estadia.getEstadia(id).getAnimal().getName();
        String querySearch = "SELECT a FROM Animal a JOIN FETCH a.owners o WHERE a.id = '" + animalId + "'";
        Animal animal = EntityUtils.select(querySearch, Animal.class).get(0);
        Client owner = animal.getOwners().get(0);
        
        models.addRow(new Object[]{
            String.valueOf(Estadia.getEstadia(id).getId()),
            owner.getName(),
            animalName,
            remainTime,
            String.valueOf(Estadia.getEstadia(id).getCocheira()),
            Estadia.getEstadia(id).getConsumoTotal()
        });
                    
        return models;
    }
    
    private void updateSuggestionBox() {
        boxSearch.removeAllItems();
        boxSearch.addItem("");
        String query = "SELECT c FROM Cocheiras c";
        List<Estadia> estadia = EntityUtils.select(query, Estadia.class);
        for (Estadia item : estadia) {
            boxSearch.addItem(item.getId());
        }
    }
    
    private void lblSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSearchMouseClicked
        if (boxSearch.getSelectedItem() != null && String.valueOf(boxSearch.getSelectedItem()).matches("[0-9]+")) {
            long id = Long.parseLong(String.valueOf(boxSearch.getSelectedItem()));
            if (Estadia.getEstadia(id) != null) {
                if (Estadia.getState(id).equals("ATIVA")) {
                    insertSearchData(id, tableProgress);
                    tpaneInfo.setSelectedIndex(0);
                            
                } else if (Estadia.getState(id).equals("FUTURA")) {
                    insertSearchData(id, tableFuture);
                    tpaneInfo.setSelectedIndex(1);
                
                } else if (Estadia.getState(id).equals("FINALIZADA")) {
                    insertSearchData(id, tableFinished);
                    tpaneInfo.setSelectedIndex(2);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum resultado.", null, JOptionPane.ERROR_MESSAGE, null);
            }
        } else {
            updateTables();
        }
    }//GEN-LAST:event_lblSearchMouseClicked

    private void btnGenerateReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateReportActionPerformed
        ReportGenerator reportGenerator = new ReportGenerator();
        if (radioSelected.isSelected()) {
            switch (tpaneInfo.getSelectedIndex()) {
                case 0:
                    reportGenerator.generateReport(this,
                    "relatorio_estadia_completo",
                    "Relatório Parcial de Estadias em Progresso",
                    tableProgress);

                    this.updateTables();
                    break;

                case 1:
                    reportGenerator.generateReport(this,
                    "relatorio_estadia_completo",
                    "Relatório Parcial de Estadias Futuras",
                    tableFuture);

                    this.updateTables();
                    break;

                case 2:
                    reportGenerator.generateReport(this,
                    "relatorio_estadia_completo",
                    "Relatório Parcial de Estadias Finalizadas",
                    tableFinished);

                    this.updateTables();
                    break;
                    
                default: JOptionPane.showMessageDialog(null, "ERRO: Tabela não encontrada!", null, JOptionPane.ERROR_MESSAGE);
                break;
            }
        } else if (radioFull.isSelected()) {
                switch (tpaneInfo.getSelectedIndex()) {
                case 0:
                    JTable progressTable = generateAllProgressTable();
                    reportGenerator.generateReport(this,
                    "relatorio_estadia_completo",
                    "Relatório Completo de Estadias em Progresso",
                    progressTable);

                    this.updateTables();
                    break;

                case 1:
                    JTable futureTable = generateAllFutureTable();
                    reportGenerator.generateReport(this,
                    "relatorio_estadia_completo",
                    "Relatório Completo de Estadias Futuras",
                    futureTable);

                    this.updateTables();
                    break;

                case 2:
                    JTable endTable = generateAllEndTable();
                    reportGenerator.generateReport(this,
                    "relatorio_estadia_completo",
                    "Relatório Completo de Estadias Finalizadas",
                    endTable);

                    this.updateTables();
                    break;
                    
                default: JOptionPane.showMessageDialog(null, "ERRO: Tabela não encontrada!", null, JOptionPane.ERROR_MESSAGE);
                break;
                }
        } else {
            JOptionPane.showMessageDialog(null, "ERRO: Selecione uma Opção!", null, JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGenerateReportActionPerformed

    private void radioFullActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioFullActionPerformed
        radioSelected.setSelected(false);
    }//GEN-LAST:event_radioFullActionPerformed

    private void radioSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioSelectedActionPerformed
        radioFull.setSelected(false);
    }//GEN-LAST:event_radioSelectedActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        
        switch (tpaneInfo.getSelectedIndex()) {
            case 0:
                this.currentProgressPage--;
                break;
            case 1:
                this.currentFuturePage--;
                break;
            case 2:
                this.currentEndPage--;
                break;
        }
        this.updateTables();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnNext2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNext2ActionPerformed
        switch (tpaneInfo.getSelectedIndex()) {
            case 0:
                this.currentProgressPage++;
                break;
            case 1:
                this.currentFuturePage++;
                break;
            case 2:
                this.currentEndPage++;
                break;
        }
        this.updateTables();
    }//GEN-LAST:event_btnNext2ActionPerformed

    private JTable generateAllProgressTable() {
        JTable jtable = new JTable();
        jtable.setModel(tableProgress.getModel());
        Date now = new Date();
        Date n = new Date(now.getTime());
        DefaultTableModel progressModel = (DefaultTableModel) jtable.getModel();
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("haras");
        EntityManager em = emf.createEntityManager();
        
        String query = "SELECT p FROM Cocheiras p WHERE p.isCancelled = false AND p.entrada <= :n AND p.saida >= :n";
        Query stableQuery = em.createQuery(query, Estadia.class);
        stableQuery.setParameter("n", n);
        List<Estadia> std = stableQuery.getResultList();
        
        progressModel.setRowCount(0);
        
        for (Estadia e : std) {
            updateTableModel(e.getId(), progressModel);
        }
        allignTableCenterd(tableProgress);
        
        return jtable;
    }
    
    private JTable generateAllFutureTable() {
        JTable jtable = new JTable();
        jtable.setModel(tableFuture.getModel());
        Date now = new Date();
        Date n = new Date(now.getTime());
        DefaultTableModel progressModel = (DefaultTableModel) jtable.getModel();
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("haras");
        EntityManager em = emf.createEntityManager();
        
        String query = "SELECT p FROM Cocheiras p WHERE p.isCancelled = false AND p.entrada > :n";
        Query stableQuery = em.createQuery(query, Estadia.class);
        stableQuery.setParameter("n", n);
        List<Estadia> std = stableQuery.getResultList();
        
        progressModel.setRowCount(0);
        
        for (Estadia e : std) {
            updateTableModel(e.getId(), progressModel);
        }
        allignTableCenterd(tableFuture);
        
        return jtable;
    }
    
    private JTable generateAllEndTable() {
        JTable jtable = new JTable();
        jtable.setModel(tableFinished.getModel());
        Date now = new Date();
        Date n = new Date(now.getTime());
        DefaultTableModel progressModel = (DefaultTableModel) jtable.getModel();
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("haras");
        EntityManager em = emf.createEntityManager();
        
        String query = "SELECT p FROM Cocheiras p WHERE p.isCancelled = false AND p.entrada < :n AND p.saida < :n";
        Query stableQuery = em.createQuery(query, Estadia.class);
        stableQuery.setParameter("n", n);
        List<Estadia> std = stableQuery.getResultList();
        
        progressModel.setRowCount(0);
        
        for (Estadia e : std) {
            updateTableModel(e.getId(), progressModel);
        }
        allignTableCenterd(tableFinished);
        
        return jtable;
    }
    
    private void insertSearchData(long id, JTable table) {
        DefaultTableModel model;
        model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        table.setModel(updateTableModel(id, model));
    }
    
    private void allignTableCenterd(JTable t) {
        for (int i = 0; i < t.getColumnCount(); i++) {
            t.getColumnModel().getColumn(i).setCellRenderer(center);
        }
    }
    
    @Override
    public void update(Object o) {
        this.updateTables();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.fp3.haras.components.ComboBoxSuggestion boxSearch;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnGenerateReport;
    private javax.swing.JButton btnNext2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblReports;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lblSubtitle;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlReports;
    private javax.swing.JRadioButton radioFull;
    private javax.swing.JRadioButton radioSelected;
    private javax.swing.JTable tableFinished;
    private javax.swing.JTable tableFuture;
    private javax.swing.JTable tableProgress;
    private javax.swing.JTabbedPane tpaneInfo;
    // End of variables declaration//GEN-END:variables
}
