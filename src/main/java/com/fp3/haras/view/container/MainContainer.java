package com.fp3.haras.view.container;

import com.fp3.haras.utils.Colors;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.border.EmptyBorder;

public class MainContainer extends javax.swing.JPanel {
    private FeatureWrapper wrapper;
    
    public MainContainer() {
        initComponents();
        this.setBackground(new java.awt.Color(
                Colors.WHITEBG.getColor()[0],
                Colors.WHITEBG.getColor()[1],
                Colors.WHITEBG.getColor()[2]
        ));
    }
    
    private void initComponents() {
        this.setLayout(new GridBagLayout());
        this.wrapper = new FeatureWrapper();
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.weighty = 1;
        
        this.setBorder(new EmptyBorder(36, 36, 0, 36));
        
        this.add(wrapper, gbc);
    }
    
    public FeatureWrapper getFeatureWrapper() {
        return this.wrapper;
    }
}
