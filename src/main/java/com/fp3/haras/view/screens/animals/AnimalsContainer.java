package com.fp3.haras.view.screens.animals;

import com.fp3.haras.utils.Colors;
import java.awt.GridBagLayout;
import javax.swing.JPanel;

public class AnimalsContainer extends JPanel{
    private AnimalsScreen screen;
    private AnimalsCreate creationModal;
    
    public AnimalsContainer() {
        initComponents();
    }
    
    public void initComponents() {
        this.setLayout(new GridBagLayout());
        this.creationModal = new AnimalsCreate();
        this.screen = new AnimalsScreen(creationModal);
        
        this.creationModal.addObserver(screen);
        
        this.add(screen);
    }
}
