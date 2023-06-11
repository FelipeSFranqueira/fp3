package com.fp3.haras.view.screens.auth;

import com.formdev.flatlaf.FlatLightLaf;
import com.fp3.haras.model.User;
import com.fp3.haras.utils.Colors;
import com.fp3.haras.utils.EntityUtils;
import com.fp3.haras.view.container.Root;
import java.awt.Color;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class LoginScreen extends javax.swing.JFrame {
    private User user;

    static {
        try {
            UIManager.setLookAndFeel( new FlatLightLaf() );
        } catch( UnsupportedLookAndFeelException e ) {
            System.err.println( "Failed to initialize Flat LaF" );
            e.printStackTrace();
        }
    }
    
    public LoginScreen() {
        try {
            User user = EntityUtils.select("SELECT u FROM User u WHERE u.id = 1", User.class).get(0);
            this.user = user;
        } catch (Exception e) {
            if (user == null) {
                this.user = new User("admin", "admin");
                EntityUtils.insert(this.user);
            }
        }
        
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/images/taskbar.png")).getImage());
        lblTitle.putClientProperty("FlatLaf.styleClass", "h00");
        panelBack.setBackground(Colors.WHITEBG);
        panelCenter.setBackground(Colors.PRIMARYBG);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBack = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        panelCenter = new javax.swing.JPanel();
        txtUser = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        btnEnter = new javax.swing.JButton();
        lblLogo = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        lblPass = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        panelBack.setBackground(new java.awt.Color(255, 255, 255));
        panelBack.setPreferredSize(new java.awt.Dimension(900, 585));

        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("AUTENTICAÇÃO");

        panelCenter.setBackground(new java.awt.Color(233, 233, 233));

        txtUser.setBackground(new java.awt.Color(255, 255, 255));
        txtUser.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtUser.setForeground(java.awt.Color.lightGray);
        txtUser.setText("Administrador");
        txtUser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUserFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUserFocusLost(evt);
            }
        });

        txtPass.setBackground(new java.awt.Color(255, 255, 255));
        txtPass.setForeground(java.awt.Color.lightGray);
        txtPass.setText("Senha");
        txtPass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPassFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPassFocusLost(evt);
            }
        });

        btnEnter.setBackground(java.awt.Color.gray);
        btnEnter.setForeground(new java.awt.Color(255, 255, 255));
        btnEnter.setText("ENTRAR");
        btnEnter.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEnter.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btnEnterFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                btnEnterFocusLost(evt);
            }
        });
        btnEnter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEnterMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEnterMouseExited(evt);
            }
        });
        btnEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnterActionPerformed(evt);
            }
        });

        lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png"))); // NOI18N

        lblUser.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblUser.setForeground(new java.awt.Color(102, 102, 102));
        lblUser.setText("Usuário");

        lblPass.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPass.setForeground(new java.awt.Color(102, 102, 102));
        lblPass.setText("Senha");

        javax.swing.GroupLayout panelCenterLayout = new javax.swing.GroupLayout(panelCenter);
        panelCenter.setLayout(panelCenterLayout);
        panelCenterLayout.setHorizontalGroup(
            panelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCenterLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(249, 249, 249))
            .addGroup(panelCenterLayout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addGroup(panelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPass)
                    .addComponent(lblUser)
                    .addGroup(panelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtPass)
                        .addComponent(txtUser, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)))
                .addContainerGap(180, Short.MAX_VALUE))
        );
        panelCenterLayout.setVerticalGroup(
            panelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCenterLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lblLogo)
                .addGap(18, 18, 18)
                .addComponent(lblUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel1.setForeground(java.awt.Color.lightGray);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Extreme Go Horse");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel2.setForeground(java.awt.Color.lightGray);
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("alpha 0.0.1");

        javax.swing.GroupLayout panelBackLayout = new javax.swing.GroupLayout(panelBack);
        panelBack.setLayout(panelBackLayout);
        panelBackLayout.setHorizontalGroup(
            panelBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(panelBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelCenter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 40, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBackLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        panelBackLayout.setVerticalGroup(
            panelBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(lblTitle)
                .addGap(18, 18, 18)
                .addComponent(panelCenter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(0, 0, 0)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBack, javax.swing.GroupLayout.PREFERRED_SIZE, 674, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBack, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private String getPassword() {
        return String.valueOf(txtPass.getPassword());
    }
    
    private void btnEnterMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnterMouseEntered
        btnEnter.setBackground(Colors.ACCENTBLUE);
    }//GEN-LAST:event_btnEnterMouseEntered

    private void txtUserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserFocusGained
        if (txtUser.getText().equals("Administrador")) {
            txtUser.setText(null);
            txtUser.setForeground(Color.DARK_GRAY);
        }
    }//GEN-LAST:event_txtUserFocusGained

    private void txtPassFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPassFocusGained
        if (getPassword().equals("Senha")) {
            txtPass.setText(null);
            txtPass.setForeground(Color.DARK_GRAY);
        }
    }//GEN-LAST:event_txtPassFocusGained

    private void txtPassFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPassFocusLost
        if (getPassword().equals("")) {
            txtPass.setText("Senha");
            txtPass.setForeground(Color.LIGHT_GRAY);
        }
    }//GEN-LAST:event_txtPassFocusLost

    private void txtUserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserFocusLost
        if (txtUser.getText().equals("")) {
            txtUser.setText("Administrador");
            txtUser.setForeground(Color.LIGHT_GRAY);
        }
    }//GEN-LAST:event_txtUserFocusLost

    private void btnEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnterActionPerformed
        if (!user.getSenha().equals(getPassword()) || !user.getNome().equals(txtUser.getText())) {
            JOptionPane.showMessageDialog(this, "As credenciais inseridas estão incorretas.", null, JOptionPane.ERROR_MESSAGE);
        } else {
            dispose();
            new Root().setVisible(true);
        }
    }//GEN-LAST:event_btnEnterActionPerformed

    private void btnEnterMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnterMouseExited
        btnEnter.setBackground(Color.GRAY);
    }//GEN-LAST:event_btnEnterMouseExited

    private void btnEnterFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnEnterFocusGained
        btnEnter.setBackground(Colors.ACCENTBLUE);
    }//GEN-LAST:event_btnEnterFocusGained

    private void btnEnterFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnEnterFocusLost
        btnEnter.setBackground(Color.GRAY);
    }//GEN-LAST:event_btnEnterFocusLost
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblPass;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPanel panelBack;
    private javax.swing.JPanel panelCenter;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
