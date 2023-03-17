package view.container;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.border.EmptyBorder;

public class MainContainer extends javax.swing.JPanel {
    private FeatureWrapper wrapper;
    
    public MainContainer() {
        initComponents();
    }
    
    private void initComponents() {
        this.setLayout(new GridBagLayout());
        this.wrapper = new FeatureWrapper();
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.weighty = 1;
        
        this.setBorder(new EmptyBorder(24, 0, 0, 0));
        
        this.add(wrapper, gbc);
    }
}
