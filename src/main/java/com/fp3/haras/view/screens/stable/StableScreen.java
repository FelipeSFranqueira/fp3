package com.fp3.haras.view.screens.stable;

import com.fp3.haras.model.Animal;
import com.fp3.haras.model.Client;
import com.fp3.haras.model.Stable;
import com.fp3.haras.utils.Colors;
import com.fp3.haras.utils.EntityUtils;
import com.fp3.haras.utils.GenericObserver;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class StableScreen extends javax.swing.JPanel implements GenericObserver {

    private final StableCreate creationModal;
    private final StableEdit editionModal;
    
    public static long selectedId;
    DefaultTableCellRenderer center = new DefaultTableCellRenderer();
    
    public StableScreen(StableCreate creationModal, StableEdit editionModal) {
        initComponents();
        this.creationModal = creationModal;
        this.editionModal = editionModal;
        this.setBackground(Colors.PRIMARYBG);
        lblTitle.putClientProperty("FlatLaf.styleClass", "h00");
        center.setHorizontalAlignment(JLabel.CENTER);
        this.updateTables();
        this.updateSuggestionBox();
    }
    
    private Date setOnlyDay(Date date) {
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
        List<Stable> estadias = EntityUtils.select("SELECT c FROM Cocheiras c", Stable.class);
        
        Date now = new Date();
        Date n = setOnlyDay(new Date(now.getTime()));
        Date entrada, saida;
        
        progressModel.setRowCount(0);
        futureModel.setRowCount(0);
        endModel.setRowCount(0);
        
        for (Stable e : estadias) {
            entrada = setOnlyDay(e.getEntrada());
            saida = setOnlyDay(e.getSaida());
            
            if (!e.getIsCancelled() && saida.after(n) && (entrada.before(n) || entrada.equals(n))) {
                updateTableModel(e.getId(), progressModel);
            
            } else if (!e.getIsCancelled() && entrada.after(n) && entrada.after(n)) {
                    updateTableModel(e.getId(), futureModel);
            
            } else if (!e.getIsCancelled() && entrada.before(n) && saida.before(n)) {
                updateTableModel(e.getId(), endModel);
            }
        }
        
        allignTableCenterd(tableProgress);
        allignTableCenterd(tableFuture);
        allignTableCenterd(tableFinished);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(boxSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTitle)
                    .addComponent(lblSubtitle)
                    .addComponent(tpaneInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSubtitle)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCreate)
                        .addComponent(btnEdit))
                    .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(tpaneInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        this.creationModal.clearFrameModel();
        this.creationModal.updateSuggestionBox();
        this.creationModal.setVisible(true);
        this.creationModal.toFront();
    }//GEN-LAST:event_btnCreateActionPerformed

    private void initEdit(Object tableSelectedCode) {
        selectedId = Integer.parseInt(String.valueOf(tableSelectedCode));
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
        long time = Stable.getEstadia(id).getSaida().getTime() - Stable.getEstadia(id).getEntrada().getTime();
        long stayDays = TimeUnit.MILLISECONDS.toDays(time);
        long stayHours = TimeUnit.MILLISECONDS.toHours(time);
        String remainTime;
        
        if (stayDays == 0)
            remainTime = stayHours + "h";
        else
            remainTime = stayDays + "d";
        
        updateSuggestionBox();
        long animalId = Stable.getEstadia(id).getAnimal().getId();
        String animalName = Stable.getEstadia(id).getAnimal().getName();
        String querySearch = "SELECT a FROM Animal a JOIN FETCH a.owners o WHERE a.id = '" + animalId + "'";
        Animal animal = EntityUtils.select(querySearch, Animal.class).get(0);
        Client owner = animal.getOwners().get(0);
        
        models.addRow(new Object[]{
            String.valueOf(Stable.getEstadia(id).getId()),
            owner.getNome(),
            animalName,
            remainTime,
            String.valueOf(Stable.getEstadia(id).getCocheira()),
            "---"
        });
                    
        return models;
    }
    
    private void updateSuggestionBox() {
        boxSearch.removeAllItems();
        boxSearch.addItem("");
        String query = "SELECT c FROM Cocheiras c";
        List<Stable> estadia = EntityUtils.select(query, Stable.class);
        for (Stable item : estadia) {
            boxSearch.addItem(item.getId());
        }
    }
    
    private void lblSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSearchMouseClicked
        String selectedTab = tpaneInfo.getTitleAt(tpaneInfo.getSelectedIndex());
        long id; 
        
        if (boxSearch.getSelectedItem() != null && String.valueOf(boxSearch.getSelectedItem()).matches("[0-9]+")) {
            id = Long.parseLong(String.valueOf(boxSearch.getSelectedItem()));
            if (Stable.getEstadia(id) != null) {
                switch(selectedTab) {
                    case "ATIVAS":
                        if(Stable.getState(id).equals("ATIVA")) {
                            insertSearchData(id, tableProgress);
                        } else {
                            JOptionPane.showMessageDialog(null, "Status da estadia: " + Stable.getState(id), null, JOptionPane.WARNING_MESSAGE, null);
                        }
                        break;
                    case "FINALIZADAS":
                        if(Stable.getState(id).equals("FINALIZADA")) {
                            insertSearchData(id, tableFinished);
                        } else {
                            JOptionPane.showMessageDialog(null, "Status da estadia: " + Stable.getState(id), null, JOptionPane.WARNING_MESSAGE, null);
                        }
                        break;
                    case "FUTURAS":
                        if(Stable.getState(id).equals("FUTURA")) {
                            insertSearchData(id, tableFuture);
                        } else {
                            JOptionPane.showMessageDialog(null, "Status da estadia: " + Stable.getState(id), null, JOptionPane.WARNING_MESSAGE, null);
                        }
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Nada foi selecionado.", null, JOptionPane.ERROR_MESSAGE, null);
                        break;
                    }
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum resultado.", null, JOptionPane.ERROR_MESSAGE, null);
            }
        }
    }//GEN-LAST:event_lblSearchMouseClicked

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
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnEdit;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lblSubtitle;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tableFinished;
    private javax.swing.JTable tableFuture;
    private javax.swing.JTable tableProgress;
    private javax.swing.JTabbedPane tpaneInfo;
    // End of variables declaration//GEN-END:variables
}
