package com.fp3.haras.view.screens.home;

import com.fp3.haras.model.Animal;
import com.fp3.haras.model.Client;
import com.fp3.haras.model.Estadia;
import com.fp3.haras.utils.Colors;
import com.fp3.haras.utils.EntityUtils;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

public class HomeScreen extends javax.swing.JPanel {
    
    public HomeScreen() {
        initComponents();
        
        lblHeader.putClientProperty("FlatLaf.styleClass", "h00");
        
        pnlAnimalsToArrive.setBackground(Colors.PRIMARYBG);
        lblAnimalsToArriveTitle.putClientProperty("FlatLaf.styleClass", "h2");
        lblAnimalsToArriveAmount.putClientProperty("FlatLaf.styleClass", "h3");
        
        pnlAnimalsToGo.setBackground(Colors.PRIMARYBG);
        lblAnimalsToGoTitle.putClientProperty("FlatLaf.styleClass", "h2");
        lblAnimalsToGoAmount.putClientProperty("FlatLaf.styleClass", "h3");
        
        pnlActivityClients.setBackground(Colors.PRIMARYBG);
        lblActivityClientsTitle.putClientProperty("FlatLaf.styleClass", "h2");
        lblActivityClientsAmount.putClientProperty("FlatLaf.styleClass", "h3");
        
        pnlActivityAnimals.setBackground(Colors.PRIMARYBG);
        lblActivityAnimalsTitle.putClientProperty("FlatLaf.styleClass", "h2");
        lblActivityAnimalsAmount.putClientProperty("FlatLaf.styleClass", "h3");
        
        this.activityAnimals();
        this.activityClient();
        this.getAnimalsToArrive();
        this.getAnimalsToLeave();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pnlHeader = new javax.swing.JPanel();
        lblHeader = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pnlContent = new javax.swing.JPanel();
        pnlAnimalsBalance = new javax.swing.JPanel();
        pnlAnimalsToArrive = new javax.swing.JPanel();
        lblAnimalsToArriveTitle = new javax.swing.JLabel();
        lblAnimalsToArriveAmount = new javax.swing.JLabel();
        pnlAnimalsBalanceSeparator = new javax.swing.JPanel();
        pnlAnimalsToGo = new javax.swing.JPanel();
        lblAnimalsToGoTitle = new javax.swing.JLabel();
        lblAnimalsToGoAmount = new javax.swing.JLabel();
        pnlActivityClients = new javax.swing.JPanel();
        lblActivityClientsTitle = new javax.swing.JLabel();
        lblActivityClientsAmount = new javax.swing.JLabel();
        pnlSeparator3 = new javax.swing.JPanel();
        pnlActivityAnimals = new javax.swing.JPanel();
        lblActivityAnimalsTitle = new javax.swing.JLabel();
        lblActivityAnimalsAmount = new javax.swing.JLabel();
        btnAnimalsToGo2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(900, 0));

        pnlHeader.setOpaque(false);

        lblHeader.setText("Bem vindo!");

        jLabel2.setText("Veja abaixo alguns dados sobre o seu Haras");

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHeader)
            .addComponent(jLabel2)
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addComponent(lblHeader)
                .addGap(0, 0, 0)
                .addComponent(jLabel2))
        );

        pnlContent.setOpaque(false);

        pnlAnimalsBalance.setOpaque(false);

        pnlAnimalsToArrive.setBorder(javax.swing.BorderFactory.createEmptyBorder(16, 16, 16, 16));
        pnlAnimalsToArrive.setLayout(new java.awt.GridBagLayout());

        lblAnimalsToArriveTitle.setText("Animais a chegar hoje");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlAnimalsToArrive.add(lblAnimalsToArriveTitle, gridBagConstraints);

        lblAnimalsToArriveAmount.setForeground(new java.awt.Color(40, 167, 69));
        lblAnimalsToArriveAmount.setText("+7");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlAnimalsToArrive.add(lblAnimalsToArriveAmount, gridBagConstraints);

        pnlAnimalsBalanceSeparator.setFocusable(false);
        pnlAnimalsBalanceSeparator.setOpaque(false);
        pnlAnimalsBalanceSeparator.setPreferredSize(new java.awt.Dimension(16, 0));

        javax.swing.GroupLayout pnlAnimalsBalanceSeparatorLayout = new javax.swing.GroupLayout(pnlAnimalsBalanceSeparator);
        pnlAnimalsBalanceSeparator.setLayout(pnlAnimalsBalanceSeparatorLayout);
        pnlAnimalsBalanceSeparatorLayout.setHorizontalGroup(
            pnlAnimalsBalanceSeparatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );
        pnlAnimalsBalanceSeparatorLayout.setVerticalGroup(
            pnlAnimalsBalanceSeparatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlAnimalsToGo.setBorder(javax.swing.BorderFactory.createEmptyBorder(16, 16, 16, 16));
        pnlAnimalsToGo.setLayout(new java.awt.GridBagLayout());

        lblAnimalsToGoTitle.setText("Animais a sair hoje");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlAnimalsToGo.add(lblAnimalsToGoTitle, gridBagConstraints);

        lblAnimalsToGoAmount.setForeground(new java.awt.Color(255, 193, 7));
        lblAnimalsToGoAmount.setText("-4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlAnimalsToGo.add(lblAnimalsToGoAmount, gridBagConstraints);

        pnlActivityClients.setBorder(javax.swing.BorderFactory.createEmptyBorder(16, 16, 16, 16));
        pnlActivityClients.setLayout(new java.awt.GridBagLayout());

        lblActivityClientsTitle.setText("Clientes em atividade");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlActivityClients.add(lblActivityClientsTitle, gridBagConstraints);

        lblActivityClientsAmount.setForeground(new java.awt.Color(0, 153, 255));
        lblActivityClientsAmount.setText("0");
        lblActivityClientsAmount.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlActivityClients.add(lblActivityClientsAmount, gridBagConstraints);

        pnlSeparator3.setPreferredSize(new java.awt.Dimension(16, 0));

        javax.swing.GroupLayout pnlSeparator3Layout = new javax.swing.GroupLayout(pnlSeparator3);
        pnlSeparator3.setLayout(pnlSeparator3Layout);
        pnlSeparator3Layout.setHorizontalGroup(
            pnlSeparator3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );
        pnlSeparator3Layout.setVerticalGroup(
            pnlSeparator3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlActivityAnimals.setBorder(javax.swing.BorderFactory.createEmptyBorder(16, 16, 16, 16));
        pnlActivityAnimals.setLayout(new java.awt.GridBagLayout());

        lblActivityAnimalsTitle.setText("Animais em atividade");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlActivityAnimals.add(lblActivityAnimalsTitle, gridBagConstraints);

        lblActivityAnimalsAmount.setForeground(new java.awt.Color(255, 153, 0));
        lblActivityAnimalsAmount.setText("0");
        lblActivityAnimalsAmount.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlActivityAnimals.add(lblActivityAnimalsAmount, gridBagConstraints);

        btnAnimalsToGo2.setText("Atualizar dados");
        btnAnimalsToGo2.setFocusPainted(false);
        btnAnimalsToGo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnimalsToGo2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlAnimalsBalanceLayout = new javax.swing.GroupLayout(pnlAnimalsBalance);
        pnlAnimalsBalance.setLayout(pnlAnimalsBalanceLayout);
        pnlAnimalsBalanceLayout.setHorizontalGroup(
            pnlAnimalsBalanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAnimalsBalanceLayout.createSequentialGroup()
                .addGroup(pnlAnimalsBalanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAnimalsBalanceLayout.createSequentialGroup()
                        .addComponent(pnlAnimalsToArrive, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(pnlAnimalsBalanceSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(pnlAnimalsToGo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlAnimalsBalanceLayout.createSequentialGroup()
                        .addComponent(pnlActivityClients, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(pnlSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(pnlActivityAnimals, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAnimalsToGo2))
                .addGap(334, 334, 334))
        );
        pnlAnimalsBalanceLayout.setVerticalGroup(
            pnlAnimalsBalanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAnimalsBalanceLayout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(btnAnimalsToGo2)
                .addGap(18, 18, 18)
                .addGroup(pnlAnimalsBalanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlAnimalsToArrive, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlAnimalsBalanceLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(pnlAnimalsBalanceSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlAnimalsToGo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlAnimalsBalanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlActivityClients, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlAnimalsBalanceLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(pnlSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlActivityAnimals, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlContentLayout = new javax.swing.GroupLayout(pnlContent);
        pnlContent.setLayout(pnlContentLayout);
        pnlContentLayout.setHorizontalGroup(
            pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlAnimalsBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnlContentLayout.setVerticalGroup(
            pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlAnimalsBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlContent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(233, 233, 233))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlContent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(118, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnimalsToGo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnimalsToGo2ActionPerformed
        this.activityClient();
        this.activityAnimals();
        this.getAnimalsToArrive();
        this.getAnimalsToLeave();
    }//GEN-LAST:event_btnAnimalsToGo2ActionPerformed

    private void activityAnimals() {
        String totalAnimalsQuery = "SELECT a FROM Animal a JOIN FETCH a.owners o";
        List<Animal> totalAnimals = EntityUtils.select(totalAnimalsQuery, Animal.class);
        
        String actitvityAnimalsQuery = "SELECT a FROM Animal a JOIN FETCH a.owners o WHERE a.isDeleted = FALSE";
        List<Animal> activityAnimals = EntityUtils.select(actitvityAnimalsQuery, Animal.class);
        
        double total = totalAnimals.size();
        double activity = activityAnimals.size();
        
        double percentage = 100.00 * activity / total;
        
        lblActivityAnimalsAmount.setText(String.format("%.2f %%", percentage));
    }
    
    private void activityClient() {
        String totalClientQuery = "SELECT c FROM Client c";
        List<Client> totalClient = EntityUtils.select(totalClientQuery, Client.class);
        
        String activityClientQuery = "SELECT c FROM Client c WHERE c.isDeleted = FALSE";
        List<Client> activityClient = EntityUtils.select(activityClientQuery, Client.class);
        
        double total = totalClient.size();
        double activity = activityClient.size();
        
        double percentage = 100.00 * activity / total;
        
        lblActivityClientsAmount.setText(String.format("%.2f %%", percentage));
    }
    
    private void getAnimalsToArrive() {
        String query = "SELECT e FROM Cocheiras e WHERE e.isCancelled = FALSE";
        List<Estadia> estadias = EntityUtils.select(query, Estadia.class);
        
        int animalsToArrive = 0;
        LocalDate now = LocalDate.now();
        
        for (Estadia e: estadias) {
            if (e.getEntrada().toLocalDateTime().toLocalDate().toString().equals(now.toString())) {
                animalsToArrive++;                
            }
        }
        
        this.lblAnimalsToArriveAmount.setText("" + animalsToArrive);
    }
    
    private void getAnimalsToLeave() {
        String query = "SELECT e FROM Cocheiras e WHERE e.isCancelled = FALSE";
        List<Estadia> estadias = EntityUtils.select(query, Estadia.class);
        
        int animalsToLeave = 0;
        LocalDate now = LocalDate.now();
        
        for (Estadia e: estadias) {
            if (e.getSaida().toLocalDateTime().toLocalDate().toString().equals(now.toString())) {
                animalsToLeave++;
            }
        }
        
        this.lblAnimalsToGoAmount.setText("" + animalsToLeave);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnimalsToGo2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblActivityAnimalsAmount;
    private javax.swing.JLabel lblActivityAnimalsTitle;
    private javax.swing.JLabel lblActivityClientsAmount;
    private javax.swing.JLabel lblActivityClientsTitle;
    private javax.swing.JLabel lblAnimalsToArriveAmount;
    private javax.swing.JLabel lblAnimalsToArriveTitle;
    private javax.swing.JLabel lblAnimalsToGoAmount;
    private javax.swing.JLabel lblAnimalsToGoTitle;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JPanel pnlActivityAnimals;
    private javax.swing.JPanel pnlActivityClients;
    private javax.swing.JPanel pnlAnimalsBalance;
    private javax.swing.JPanel pnlAnimalsBalanceSeparator;
    private javax.swing.JPanel pnlAnimalsToArrive;
    private javax.swing.JPanel pnlAnimalsToGo;
    private javax.swing.JPanel pnlContent;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlSeparator3;
    // End of variables declaration//GEN-END:variables
}
