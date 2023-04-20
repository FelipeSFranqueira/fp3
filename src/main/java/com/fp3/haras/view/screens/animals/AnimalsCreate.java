package com.fp3.haras.view.screens.animals;

import com.fp3.haras.utils.Colors;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AnimalsCreate extends javax.swing.JFrame {

    public AnimalsCreate() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        panelBack.setBackground(Colors.WHITEBG);
        panelForm.setBackground(Colors.PRIMARYBG);
        lblTitle.putClientProperty("FlatLaf.styleClass", "h00");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBack = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        panelForm = new javax.swing.JPanel();
        txtNome = new javax.swing.JTextField();
        txtEstadia = new javax.swing.JTextField();
        txtCategoria = new javax.swing.JTextField();
        txtProprietario = new javax.swing.JTextField();
        txtCondominio = new javax.swing.JTextField();
        txtPelagem = new javax.swing.JTextField();
        txtOrigem = new javax.swing.JTextField();
        boxSexF = new javax.swing.JCheckBox();
        boxSexM = new javax.swing.JCheckBox();
        boxAieS = new javax.swing.JCheckBox();
        boxAieN = new javax.swing.JCheckBox();
        boxGtaS = new javax.swing.JCheckBox();
        boxGtaN = new javax.swing.JCheckBox();
        boxMormoS = new javax.swing.JCheckBox();
        boxMormoN = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAutoRequestFocus(false);
        setResizable(false);

        panelBack.setBackground(new java.awt.Color(244, 244, 244));
        panelBack.setPreferredSize(new java.awt.Dimension(900, 434));
        panelBack.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitle.setText("CRIAÇÃO");
        panelBack.add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        btnCancel.setText("CANCELAR");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        panelBack.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 370, 120, 45));

        btnSave.setText("SALVAR");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        panelBack.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 370, 120, 45));

        panelForm.setMinimumSize(new java.awt.Dimension(570, 290));
        panelForm.setPreferredSize(new java.awt.Dimension(570, 290));
        panelForm.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelForm.add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 47, 160, -1));

        txtEstadia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstadiaActionPerformed(evt);
            }
        });
        panelForm.add(txtEstadia, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 120, 160, -1));

        txtCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCategoriaActionPerformed(evt);
            }
        });
        panelForm.add(txtCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 154, -1));

        txtProprietario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProprietarioActionPerformed(evt);
            }
        });
        panelForm.add(txtProprietario, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 243, 187, -1));

        txtCondominio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCondominioActionPerformed(evt);
            }
        });
        panelForm.add(txtCondominio, new org.netbeans.lib.awtextra.AbsoluteConstraints(287, 243, 247, -1));
        panelForm.add(txtPelagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 47, 152, -1));
        panelForm.add(txtOrigem, new org.netbeans.lib.awtextra.AbsoluteConstraints(374, 47, 160, -1));

        boxSexF.setText("F");
        boxSexF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxSexFActionPerformed(evt);
            }
        });
        panelForm.add(boxSexF, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, -1, -1));

        boxSexM.setText("M");
        boxSexM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxSexMActionPerformed(evt);
            }
        });
        panelForm.add(boxSexM, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 100, -1, -1));

        boxAieS.setText("S");
        boxAieS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxAieSActionPerformed(evt);
            }
        });
        panelForm.add(boxAieS, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, -1, -1));

        boxAieN.setText("N");
        boxAieN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxAieNActionPerformed(evt);
            }
        });
        panelForm.add(boxAieN, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, -1, -1));

        boxGtaS.setText("S");
        boxGtaS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxGtaSActionPerformed(evt);
            }
        });
        panelForm.add(boxGtaS, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, -1, -1));

        boxGtaN.setText("N");
        boxGtaN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxGtaNActionPerformed(evt);
            }
        });
        panelForm.add(boxGtaN, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, -1, -1));

        boxMormoS.setText("S");
        boxMormoS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxMormoSActionPerformed(evt);
            }
        });
        panelForm.add(boxMormoS, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 160, -1, -1));

        boxMormoN.setText("N");
        boxMormoN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxMormoNActionPerformed(evt);
            }
        });
        panelForm.add(boxMormoN, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 180, -1, -1));

        jLabel2.setText("CATEGORIA");
        panelForm.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 146, -1));

        jLabel3.setText("NOME");
        panelForm.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 25, 146, -1));

        jLabel8.setText("ESTADIA");
        panelForm.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 100, 85, -1));

        jLabel9.setText("CONDOMÍNIO");
        panelForm.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(287, 221, 86, -1));

        jLabel10.setText("PROPRIETÁRIO");
        panelForm.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 221, 146, -1));

        jLabel4.setText("PELAGEM");
        panelForm.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 25, 146, -1));

        jLabel5.setText("ORIGEM");
        panelForm.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(374, 25, 146, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("SEXO:");
        panelForm.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("AIE:");
        panelForm.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 50, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("GTA:");
        panelForm.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("EXAME");
        panelForm.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("EXAME");
        panelForm.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 160, 60, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("MORMO:");
        panelForm.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, -1, -1));
        panelForm.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 93, 152, 10));
        panelForm.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, 152, 10));
        panelForm.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 210, 152, 10));
        panelForm.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 152, 10));
        panelForm.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 152, 10));
        panelForm.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 155, 10));
        panelForm.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 155, 10));

        panelBack.add(panelForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBack, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelBack, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        JOptionPane.showMessageDialog(null, "Registro #{CODE} atualizado!", "Cadastro Realizado", JOptionPane.INFORMATION_MESSAGE, null);
        dispose();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtEstadiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstadiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEstadiaActionPerformed

    private void txtCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCategoriaActionPerformed

    private void txtCondominioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCondominioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCondominioActionPerformed

    private void txtProprietarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProprietarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProprietarioActionPerformed

    private void boxSexMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxSexMActionPerformed
        boxSexF.setSelected(false);
    }//GEN-LAST:event_boxSexMActionPerformed

    private void boxSexFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxSexFActionPerformed
        boxSexM.setSelected(false);
    }//GEN-LAST:event_boxSexFActionPerformed

    private void boxAieSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxAieSActionPerformed
        boxAieN.setSelected(false);
    }//GEN-LAST:event_boxAieSActionPerformed

    private void boxAieNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxAieNActionPerformed
        boxAieS.setSelected(false);
    }//GEN-LAST:event_boxAieNActionPerformed

    private void boxGtaSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxGtaSActionPerformed
        boxGtaN.setSelected(false);
    }//GEN-LAST:event_boxGtaSActionPerformed

    private void boxGtaNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxGtaNActionPerformed
        boxGtaS.setSelected(false);
    }//GEN-LAST:event_boxGtaNActionPerformed

    private void boxMormoSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxMormoSActionPerformed
        boxMormoN.setSelected(false);
    }//GEN-LAST:event_boxMormoSActionPerformed

    private void boxMormoNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxMormoNActionPerformed
        boxMormoS.setSelected(false);
    }//GEN-LAST:event_boxMormoNActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox boxAieN;
    private javax.swing.JCheckBox boxAieS;
    private javax.swing.JCheckBox boxGtaN;
    private javax.swing.JCheckBox boxGtaS;
    private javax.swing.JCheckBox boxMormoN;
    private javax.swing.JCheckBox boxMormoS;
    private javax.swing.JCheckBox boxSexF;
    private javax.swing.JCheckBox boxSexM;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel panelBack;
    private javax.swing.JPanel panelForm;
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JTextField txtCondominio;
    private javax.swing.JTextField txtEstadia;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtOrigem;
    private javax.swing.JTextField txtPelagem;
    private javax.swing.JTextField txtProprietario;
    // End of variables declaration//GEN-END:variables
}
