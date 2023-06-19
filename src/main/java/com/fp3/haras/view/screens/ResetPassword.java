package com.fp3.haras.view.screens;

import com.fp3.haras.model.User;
import com.fp3.haras.utils.EntityUtils;
import java.util.Arrays;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

public class ResetPassword extends javax.swing.JPanel {

    public ResetPassword() {
        initComponents();
        
        lblTitle.putClientProperty("FlatLaf.styleClass", "h00");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCurrentPassword = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        txtNewPassword = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        txtNewPasswordConfirmation = new javax.swing.JPasswordField();
        btnResetPassword = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        lblTitle.setText("Alterar Senha");

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(24, 24, 24, 24));

        jLabel1.setText("Senha atual");

        jLabel2.setText("Nova senha");

        jLabel3.setText("Confirmação da nova senha");

        btnResetPassword.setText("Alterar Senha");
        btnResetPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetPasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnResetPassword)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1)
                        .addComponent(txtCurrentPassword)
                        .addComponent(jLabel2)
                        .addComponent(txtNewPassword)
                        .addComponent(jLabel3)
                        .addComponent(txtNewPasswordConfirmation, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCurrentPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNewPasswordConfirmation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnResetPassword)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(399, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addGap(36, 36, 36)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(171, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnResetPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetPasswordActionPerformed
        this.resetPassword();
    }//GEN-LAST:event_btnResetPasswordActionPerformed

    private void resetPassword() {
        String currentPassword = String.valueOf(txtCurrentPassword.getPassword());
        String newPassword = String.valueOf(txtNewPassword.getPassword());
        String newPasswordConfirmation = String.valueOf(txtNewPasswordConfirmation.getPassword());
        
        User user = EntityUtils.select("SELECT u FROM User u WHERE u.id = 1", User.class).get(0);
        
        if (currentPassword.equals("") || newPassword.equals("")) {
            JOptionPane.showMessageDialog(this, "Preencha os campos corretamente.", "Erro ao trocar de senha", ERROR_MESSAGE);
        } else if (!newPassword.equals(newPasswordConfirmation)) {
            JOptionPane.showMessageDialog(this, "A confirmação de senha deve ser igual à nova senha.", "Erro ao trocar de senha", ERROR_MESSAGE);
        } else if (!currentPassword.equals(user.getSenha())) {
            JOptionPane.showMessageDialog(this, "Sua senha atual está incorreta.", "Erro ao trocar de senha", ERROR_MESSAGE);
        } else {
            EntityUtils.update(new User(1, "admin", newPassword));
            JOptionPane.showMessageDialog(this, "Senha alterada com sucesso.");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnResetPassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPasswordField txtCurrentPassword;
    private javax.swing.JPasswordField txtNewPassword;
    private javax.swing.JPasswordField txtNewPasswordConfirmation;
    // End of variables declaration//GEN-END:variables
}
