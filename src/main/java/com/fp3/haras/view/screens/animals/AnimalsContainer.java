package com.fp3.haras.view.screens.animals;

import java.awt.GridBagLayout;
import javax.swing.JPanel;

public class AnimalsContainer extends JPanel{
    private AnimalsScreen screen;
    private AnimalsCreate creationModal;
    private AnimalsEdit editionModal;
    
    public AnimalsContainer() {
        initComponents();
    }
    
    public void initComponents() {
        this.setLayout(new GridBagLayout());
        this.creationModal = new AnimalsCreate();
        this.editionModal = new AnimalsEdit();
        this.screen = new AnimalsScreen(creationModal, editionModal);
        
        this.creationModal.addObserver(screen);
        this.editionModal.addObserver(screen);
        
        this.add(screen);
    }
}
