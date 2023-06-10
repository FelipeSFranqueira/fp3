package com.fp3.haras.view.screens.stable;

import com.fp3.haras.model.Animal;
import com.fp3.haras.model.Consumo;
import com.fp3.haras.model.Estadia;
import com.fp3.haras.model.Produto;
import com.fp3.haras.model.Servico;
import com.fp3.haras.model.TipoEstadia;
import com.fp3.haras.utils.Colors;
import com.fp3.haras.utils.EntityUtils;
import com.fp3.haras.utils.GenericObservable;
import com.fp3.haras.utils.GenericObserver;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SpinnerDateModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class StableCreate extends javax.swing.JFrame implements GenericObservable {

    private final List<GenericObserver> observers = new ArrayList<>();
    private final List consumoGeral = new ArrayList<>();
    private final List<TipoEstadia> tipoEstadias = new ArrayList<>();
    private final List<Consumo> novoConsumo = new ArrayList<>();
    private final DefaultTableCellRenderer center = new DefaultTableCellRenderer();
    private final String unicType = "Tipo Único";
    private Estadia novaEstadia;
    private DefaultTableModel prodModel;
    private TipoEstadia getTipoEstadia;
    
    public StableCreate() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        panelBack.setBackground(Colors.WHITEBG);
        panelForm.setBackground(Colors.PRIMARYBG);
        lblTitle.putClientProperty("FlatLaf.styleClass", "h00");
        center.setHorizontalAlignment(JLabel.CENTER);
        updateSuggestionBox();
    }
    
    private void allignTableCenterd(JTable t) {
        for (int i = 0; i < t.getColumnCount(); i++) {
            t.getColumnModel().getColumn(i).setCellRenderer(center);
        }
    }
    
    private Timestamp getEntrada() {
        Date date = (Date) spnEnter.getValue();  
        Timestamp tp = new Timestamp(date.getTime());
        return tp;
    }
    
    private Timestamp getSaida() {
        Date date = (Date) spnLeave.getValue();  
        Timestamp tp = new Timestamp(date.getTime());
        return tp;
    }
   
    private String getCocheira() {
        return String.valueOf(boxStable.getSelectedItem()) + spnStable.getValue();
    }
    
    public void clearFrame() {
        spnEnter.setModel(new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_YEAR));
        spnLeave.setModel(new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_YEAR));
        DefaultTableModel tm = (DefaultTableModel) tableProds.getModel();
        novaEstadia = new Estadia();
        txtFullValue.setText("");
        txtIndividualValue.setText("");
        boxStable.setSelectedItem("A");
        txtTotalValue.setText("");
        tableProds.setModel(tm);
        spnStable.setValue(1);
        novoConsumo.clear();
        getTipoEstadia = null;
        tm.setRowCount(0);
    }

    public final void updateSuggestionBox() {
        boxAnimal.removeAllItems();
        String queryAnimal = "SELECT c FROM Animal c WHERE c.isDeleted = false";
        List<Animal> animal = EntityUtils.select(queryAnimal, Animal.class);
        for (Animal item : animal) {
            boxAnimal.addItem(item.getName());
        }
        
        boxConsumo.removeAllItems();
        boxConsumo.addItem("");
        consumoGeral.clear();
        consumoGeral.add("");
        
        String queryConsumo = "SELECT c FROM Produto c WHERE c.isDeleted = false";
        List<Produto> produto = EntityUtils.select(queryConsumo, Produto.class);
        for (Produto item : produto) {
            boxConsumo.addItem(item.getName());
            consumoGeral.add(item);
        }
        
        String queryServicos = "SELECT c FROM Servico c WHERE c.isDeleted = false";
        List<Servico> servico = EntityUtils.select(queryServicos, Servico.class);
        for (Servico item : servico) {
            boxConsumo.addItem(item.getName());
            consumoGeral.add(item);
        }
        
        boxTipo.removeAllItems();
        String queryTipo = "SELECT c FROM TipoEstadia c WHERE c.isDeleted = false";
        List<TipoEstadia> tipo = EntityUtils.select(queryTipo, TipoEstadia.class);
        for (TipoEstadia item : tipo) {
            boxTipo.addItem(item.getType());
            tipoEstadias.add(item);
        }
        
        if (!tipoEstadias.isEmpty() && boxTipo.getSelectedIndex() != -1) {
            TipoEstadia e = tipoEstadias.get(boxTipo.getSelectedIndex());
            txtTotalValue.setText(String.valueOf(e.getPrice()));
        }
    }
    
    private void updateProduto(Produto p) {
        prodModel = (DefaultTableModel) tableProds.getModel();
        
        boolean exists = false;
        
        for (int i = 0; i < prodModel.getRowCount(); i++) {
            if ((int)spnProdUsed.getValue() == 0) {
                if (prodModel.getValueAt(i, 0).equals(p.getName()) 
                && !prodModel.getValueAt(i, 1).equals(unicType)) {
                    prodModel.removeRow(i);
                    exists = true;
                    break;
                }
            } else if (prodModel.getValueAt(i, 0).equals(p.getName()) 
                && !prodModel.getValueAt(i, 1).equals(unicType)) {
                    prodModel.setValueAt(spnProdUsed.getValue(), i, 1);
                    prodModel.setValueAt(txtFullValue.getText(), i, 2);
                    exists = true;
                    break;
                }
            }
        
        if (!exists) {
            prodModel.addRow(new Object[]{
            p.getName(),
            spnProdUsed.getValue(),
            p.getPdv() * (int)spnProdUsed.getValue(),
            });
        }

        tableProds.setModel(prodModel);
        allignTableCenterd(tableProds);
    }
    
    private void updateServico(Servico s) {
        prodModel = (DefaultTableModel) tableProds.getModel();
        
        boolean exists = false;
        
        for (int i = 0; i < prodModel.getRowCount(); i++) {
            if ((int)spnProdUsed.getValue() == 0) {
                if (prodModel.getValueAt(i, 0).equals(s.getName()) 
                && !prodModel.getValueAt(i, 1).equals("Tipo Único")) {
                    prodModel.removeRow(i);
                    exists = true;
                    break;
                }
            } else if (prodModel.getValueAt(i, 0).equals(s.getName()) 
                && !prodModel.getValueAt(i, 1).equals("Tipo Único")) {
                    prodModel.setValueAt(spnProdUsed.getValue(), i, 1);
                    prodModel.setValueAt(txtFullValue.getText(), i, 2);
                    exists = true;
                    break;
            }
        }
        
        if (!exists) {
            prodModel.addRow(new Object[]{
            s.getName(),
            spnProdUsed.getValue(),
            s.getPrice() * (int)spnProdUsed.getValue(),
            });
        }
        
        tableProds.setModel(prodModel);
        allignTableCenterd(tableProds);
    }
    
    private void updateTipoEstadia() {
    prodModel = (DefaultTableModel) tableProds.getModel();
        
        if (prodModel.getRowCount() <= 0)
            prodModel.addRow(new Object[]{null,null,null});
    
        prodModel.setValueAt(getTipoEstadia.getType(), 0, 0);
        prodModel.setValueAt("Tipo Único", 0, 1);
        prodModel.setValueAt(getTipoEstadia.getPrice(), 0, 2);
        
        tableProds.setModel(prodModel);
        allignTableCenterd(tableProds);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBack = new javax.swing.JPanel();
        btnCancel = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        panelForm = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProds = new javax.swing.JTable();
        txtTotalValue = new javax.swing.JFormattedTextField();
        txtIndividualValue = new javax.swing.JFormattedTextField();
        txtFullValue = new javax.swing.JFormattedTextField();
        btnApply = new javax.swing.JButton();
        spnEnter = new javax.swing.JSpinner();
        spnLeave = new javax.swing.JSpinner();
        spnStable = new javax.swing.JSpinner();
        spnProdUsed = new javax.swing.JSpinner();
        boxStable = new javax.swing.JComboBox<>();
        boxAnimal = new com.fp3.haras.components.ComboBoxSuggestion();
        boxConsumo = new com.fp3.haras.components.ComboBoxSuggestion();
        boxTipo = new com.fp3.haras.components.ComboBoxSuggestion();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setResizable(false);

        panelBack.setBackground(new java.awt.Color(244, 244, 244));
        panelBack.setPreferredSize(new java.awt.Dimension(900, 585));

        btnCancel.setText("CANCELAR");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnSave.setText("SALVAR");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        tableProds.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PRODUTO", "CONSUMO", "VALOR"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableProds.getTableHeader().setResizingAllowed(false);
        tableProds.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tableProds);

        txtTotalValue.setEditable(false);

        txtIndividualValue.setEditable(false);

        txtFullValue.setEditable(false);

        btnApply.setText("APLICAR");
        btnApply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApplyActionPerformed(evt);
            }
        });

        spnEnter.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.DAY_OF_YEAR));

        spnLeave.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.DAY_OF_YEAR));

        spnStable.setModel(new javax.swing.SpinnerNumberModel(1, null, 20, 1));

        spnProdUsed.setModel(new javax.swing.SpinnerNumberModel(1, 0, null, 1));
        spnProdUsed.setEnabled(false);
        spnProdUsed.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnProdUsedStateChanged(evt);
            }
        });

        boxStable.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C", "D", "E", "F" }));

        boxConsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxConsumoActionPerformed(evt);
            }
        });

        boxTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxTipoActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("VALOR DA ESTADIA");

        jLabel3.setText("ENTRADA");

        jLabel5.setText("ANIMAL");

        jLabel6.setText("COCHEIRA");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("EDIÇÃO DE CONSUMO");

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("CONSUMO INICIAL");

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("VALOR POR UNIDADE");

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("TIPO DE ESTADIA");

        jLabel14.setText("SAÍDA");

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("VALOR EM QUANTIDADE");

        jLabel1.setText("R$");

        jLabel2.setText("R$");

        jLabel4.setText("R$");

        javax.swing.GroupLayout panelFormLayout = new javax.swing.GroupLayout(panelForm);
        panelForm.setLayout(panelFormLayout);
        panelFormLayout.setHorizontalGroup(
            panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3)
                        .addComponent(spnEnter, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                        .addComponent(jLabel14)
                        .addComponent(spnLeave))
                    .addComponent(jLabel5)
                    .addComponent(boxAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFormLayout.createSequentialGroup()
                            .addComponent(boxStable, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(spnStable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel6)))
                .addGap(53, 53, 53)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelFormLayout.createSequentialGroup()
                        .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(boxConsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelFormLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFullValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelFormLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spnProdUsed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(87, 87, 87)
                                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                                    .addComponent(boxTipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(panelFormLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnApply, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28))))
                    .addGroup(panelFormLayout.createSequentialGroup()
                        .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelFormLayout.createSequentialGroup()
                                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelFormLayout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtIndividualValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(189, 189, 189)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotalValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(28, 28, 28))))
        );
        panelFormLayout.setVerticalGroup(
            panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormLayout.createSequentialGroup()
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFormLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelFormLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelFormLayout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(boxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtTotalValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4))
                                        .addGap(34, 34, 34)
                                        .addComponent(btnApply, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelFormLayout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(boxConsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(spnProdUsed, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtIndividualValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2))
                                        .addGap(25, 25, 25)
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtFullValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel1)))))))
                    .addGroup(panelFormLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boxAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(boxStable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spnStable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spnEnter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spnLeave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitle.setText("CRIAÇÃO");

        javax.swing.GroupLayout panelBackLayout = new javax.swing.GroupLayout(panelBack);
        panelBack.setLayout(panelBackLayout);
        panelBackLayout.setHorizontalGroup(
            panelBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(panelBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBackLayout.createSequentialGroup()
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblTitle)
                        .addComponent(panelForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40))
        );
        panelBackLayout.setVerticalGroup(
            panelBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(panelBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 585, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed
    
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (StableScreen.setOnlyDay(getEntrada()).before(StableScreen.setOnlyDay(getSaida()))) {
            if (getTipoEstadia != null) {
                String querySelect = "SELECT c FROM Animal c WHERE c.name = '" + (String) boxAnimal.getSelectedItem() + "'";
                Animal a = EntityUtils.select(querySelect, Animal.class).get(0);
                
                novaEstadia.setAnimal(a);
                novaEstadia.setEntrada(getEntrada());
                novaEstadia.setSaida(getSaida());
                novaEstadia.setCocheira(getCocheira());
                novaEstadia.setTipoEstadia(getTipoEstadia);
                novaEstadia.setIsCancelled(false);
                EntityUtils.insert(novaEstadia);
                
                for (int i = 0; i < novoConsumo.size(); i++) {
                    Consumo c = novoConsumo.get(i);
                    
                    if (c.getProduto() != null) {
                        Produto p = c.getProduto();
                        p.setStock(c.getProduto().getStock() - c.getQtd());
                        EntityUtils.update(p);
                    }
                    
                    EntityUtils.insert(c);
                }
                
                this.notifyObservers("");
                JOptionPane.showMessageDialog(null, "Código de registro: #"+novaEstadia.getId(), "Cadastro Realizado", JOptionPane.INFORMATION_MESSAGE, null);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Selecione o tipo da estadia", null, JOptionPane.WARNING_MESSAGE, null);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Dia de saída não pode ser igual ou anterior a entrada", null, JOptionPane.WARNING_MESSAGE, null);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApplyActionPerformed
        if (boxTipo.getSelectedItem() != null) {  
            this.notifyObservers("");
            TipoEstadia stableType = tipoEstadias.get(boxTipo.getSelectedIndex());
            getTipoEstadia = stableType;
            boolean alreadyExists = false;
            int existsIndex = -1;
            updateTipoEstadia();
            
            if (boxConsumo.getSelectedItem() != "" && boxConsumo.getSelectedIndex() > 0) {
                if (consumoGeral.get(boxConsumo.getSelectedIndex()).getClass() == Produto.class) {
                    Produto prod = (Produto) consumoGeral.get(boxConsumo.getSelectedIndex());
                    
                    if (prod.getStock() >= (int)spnProdUsed.getValue()) {
                        
                        for (int i = 0; i < novoConsumo.size(); i++) {
                            Consumo c = novoConsumo.get(i);
                            if (c.getProduto()!= null && c.getProduto().equals(prod)) {
                                alreadyExists = true;
                                existsIndex = i;
                                break;
                            }
                        }

                        if (!alreadyExists && (int)spnProdUsed.getValue() > 0) {
                            novoConsumo.add(new Consumo(novaEstadia, prod, (int)spnProdUsed.getValue()));
                            updateProduto(prod);

                        } else if (alreadyExists && (int)spnProdUsed.getValue() != 0) {
                            novoConsumo.get(existsIndex).setQtd((int)spnProdUsed.getValue());
                            updateProduto(prod);

                        } else if (alreadyExists && (int)spnProdUsed.getValue() == 0) {
                            novoConsumo.remove(existsIndex);
                            updateProduto(prod);

                        } else if (!alreadyExists && (int)spnProdUsed.getValue() == 0) {
                            JOptionPane.showMessageDialog(null, "Use '0' apenas para apagar itens ativos", null, JOptionPane.WARNING_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Estoque Insuficiente", null, JOptionPane.WARNING_MESSAGE);
                        }
                } else {
                    Servico prod = (Servico) consumoGeral.get(boxConsumo.getSelectedIndex());
                    
                    for (int i = 0; i < novoConsumo.size(); i++) {
                        Consumo c = novoConsumo.get(i);
                        if (c.getServico() != null && c.getServico().equals(prod)) {
                            alreadyExists = true;
                            existsIndex = i;
                            break;
                        }
                    }
                    
                    if (!alreadyExists && (int)spnProdUsed.getValue() > 0) {
                        novoConsumo.add(new Consumo(novaEstadia, prod, (int)spnProdUsed.getValue()));
                        updateServico(prod);
                    
                    } else if (alreadyExists && (int)spnProdUsed.getValue() != 0){
                        novoConsumo.get(existsIndex).setQtd((int)spnProdUsed.getValue());
                        updateServico(prod);
                    
                    } else if (alreadyExists && (int)spnProdUsed.getValue() == 0) {
                        novoConsumo.remove(existsIndex);
                        updateServico(prod);
                    
                    } else if (!alreadyExists && (int)spnProdUsed.getValue() == 0) {
                        JOptionPane.showMessageDialog(null, "Use '0' apenas para apagar itens ativos", null, JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione o tipo da estadia!", null, JOptionPane.ERROR_MESSAGE, null);
        }
    }//GEN-LAST:event_btnApplyActionPerformed

    private void boxConsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxConsumoActionPerformed
        if (boxConsumo.getSelectedItem() != "" && boxConsumo.getSelectedIndex() > 0) {
            spnProdUsed.setEnabled(true);
            double total;
            if (consumoGeral.get(boxConsumo.getSelectedIndex()).getClass() == Produto.class) {
                Produto prod = (Produto) consumoGeral.get(boxConsumo.getSelectedIndex());
                txtIndividualValue.setText(String.valueOf(prod.getPdv()));
                total = prod.getPdv()*(int)spnProdUsed.getValue();
                txtFullValue.setText(String.valueOf(total));
                spnProdUsed.setValue(1);
            } else if (consumoGeral.get(boxConsumo.getSelectedIndex()).getClass() == Servico.class){
                Servico prod = (Servico) consumoGeral.get(boxConsumo.getSelectedIndex());
                txtIndividualValue.setText(String.valueOf(prod.getPrice()));
                total = prod.getPrice()*(int)spnProdUsed.getValue();
                txtFullValue.setText(String.valueOf(total));
                spnProdUsed.setValue(1);
            } else {
                JOptionPane.showMessageDialog(null, "ERRO AO DEFINIR TIPO DE CONSUMO", null, JOptionPane.ERROR_MESSAGE);
            }
        } else {
            spnProdUsed.setEnabled(false);
            spnProdUsed.setValue(1);
            txtIndividualValue.setText("");
            txtFullValue.setText("");
        }
    }//GEN-LAST:event_boxConsumoActionPerformed

    private void boxTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxTipoActionPerformed
        if (!tipoEstadias.isEmpty() && boxTipo.getSelectedIndex() != -1) {
            TipoEstadia estadia = tipoEstadias.get(boxTipo.getSelectedIndex());
            txtTotalValue.setText(String.valueOf(estadia.getPrice()));
        }
    }//GEN-LAST:event_boxTipoActionPerformed

    private void spnProdUsedStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnProdUsedStateChanged
        if (!txtIndividualValue.getText().equals("") && spnProdUsed.getValue() != null)
            txtFullValue.setText(String.valueOf(Double.parseDouble(txtIndividualValue.getText())*(int)spnProdUsed.getValue()));
    }//GEN-LAST:event_spnProdUsedStateChanged

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
    private com.fp3.haras.components.ComboBoxSuggestion boxAnimal;
    private com.fp3.haras.components.ComboBoxSuggestion boxConsumo;
    private javax.swing.JComboBox<String> boxStable;
    private com.fp3.haras.components.ComboBoxSuggestion boxTipo;
    private javax.swing.JButton btnApply;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel panelBack;
    private javax.swing.JPanel panelForm;
    private javax.swing.JSpinner spnEnter;
    private javax.swing.JSpinner spnLeave;
    private javax.swing.JSpinner spnProdUsed;
    private javax.swing.JSpinner spnStable;
    private javax.swing.JTable tableProds;
    private javax.swing.JFormattedTextField txtFullValue;
    private javax.swing.JFormattedTextField txtIndividualValue;
    private javax.swing.JFormattedTextField txtTotalValue;
    // End of variables declaration//GEN-END:variables
}
