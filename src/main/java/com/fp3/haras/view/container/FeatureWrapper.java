package view.container;

import java.awt.CardLayout;
import javax.swing.JPanel;
import utils.Screens;
import view.welcome.Welcome;

public class FeatureWrapper extends javax.swing.JPanel {
    private CardLayout cardLayout;
    private JPanel welcomePanel;
    
    public FeatureWrapper() {
        initComponents();
    }
    
    private void initComponents() {
        this.cardLayout = new CardLayout();
        this.setLayout(this.cardLayout);
        
        /* Declare here the screens */
        this.welcomePanel = new Welcome();
                
        /* Add here the external classes to the layout */
        this.add(welcomePanel, Screens.WELCOME.toString());
        
        this.toggleScreen(Screens.WELCOME);
    }
    
    public void toggleScreen(Screens screen) {
        this.cardLayout.show(this, screen.toString());
    }
}
