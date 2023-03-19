package com.fp3.haras.view.container;

import com.fp3.haras.utils.GenericObserver;
import java.awt.CardLayout;
import javax.swing.JPanel;

import com.fp3.haras.utils.Screens;
import com.fp3.haras.view.welcome.CustomersScreen;
import com.fp3.haras.view.welcome.Welcome;

public class FeatureWrapper extends javax.swing.JPanel implements GenericObserver {
    private CardLayout cardLayout;
    private Welcome welcomePanel;
    private CustomersScreen customersPanel;
    
    public FeatureWrapper() {
        initComponents();
    }
    
    private void initComponents() {
        this.cardLayout = new CardLayout();
        this.setLayout(this.cardLayout);
        
        /* Declare here the screens */
        this.welcomePanel = new Welcome();
        this.customersPanel = new CustomersScreen();
                
        /* Add here the external classes to the layout */
        this.add(welcomePanel, Screens.WELCOME.toString());
        this.add(customersPanel, Screens.CUSTOMERS.toString());
        
        this.toggleScreen(Screens.WELCOME);
    }
    
    public void toggleScreen(Screens screen) {
        this.cardLayout.show(this, screen.toString());
    }

    @Override
    public void update(Object o) {
        toggleScreen(Screens.CUSTOMERS);
    }
}
